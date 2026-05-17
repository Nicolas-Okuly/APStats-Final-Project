#!/usr/bin/env python3

import os
import subprocess
import tempfile
import re
from pathlib import Path

BASE_DIR = Path("languages")
README_PATH = BASE_DIR / "DATA.md"

LANGUAGE_COMMANDS = {
    "python": lambda file: ["python3", str(file)],
    "javascript": lambda file: ["node", str(file)],
    "cpp": lambda file: compile_and_run_cpp(file),
    "csharp": lambda file: compile_and_run_csharp(file),
    "java": lambda file: compile_and_run_java(file),
    "go": lambda file: ["go", "run", str(file)],
    "rust": lambda file: compile_and_run_rust(file),
}


def compile_and_run_cpp(file):
    binary = tempfile.NamedTemporaryFile(delete=False).name

    subprocess.run(
        ["g++", str(file), "-O2", "-o", binary],
        check=True
    )

    return [binary]


def compile_and_run_rust(file):
    binary = tempfile.NamedTemporaryFile(delete=False).name

    subprocess.run(
        ["rustc", str(file), "-O", "-o", binary],
        check=True
    )

    return [binary]


def compile_and_run_java(file):
    temp_dir = tempfile.mkdtemp()
    java_sources = sorted(str(source) for source in file.parent.glob("*.java"))

    subprocess.run(
        ["javac", "-d", temp_dir, *java_sources],
        check=True
    )

    class_name = file.stem

    return ["java", "-cp", temp_dir, class_name]

def compile_and_run_csharp(file):
    output = tempfile.NamedTemporaryFile(suffix=".exe", delete=False).name

    subprocess.run(
        ["mcs", str(file), "-out:" + output],
        check=True
    )

    return ["mono", output]


def get_description_and_time(file):
    with open(file, "r", encoding="utf8", errors="ignore") as f:
        lines = f.readlines()

    first = lines[0].strip() if len(lines) > 0 else ""
    second = lines[1].strip() if len(lines) > 1 else ""

    return clean_comment(first), clean_comment(second)


def clean_comment(line):
    patterns = [
        r"^#\s?",
        r"^//\s?",
        r"^/\*\s?",
        r"^\*\s?",
        r"^<!--\s?",
    ]

    for pattern in patterns:
        line = re.sub(pattern, "", line)

    line = line.replace("-->", "").replace("*/", "")
    return line.strip()


def extract_time_output(stderr):
    elapsed = ""
    rss = ""

    for line in stderr.splitlines():
        if "Elapsed (wall clock) time" in line:
            elapsed = line.strip()

        if "Maximum resident set size" in line:
            rss = line.strip()

    return elapsed, rss


def run_with_time(command):
    full_command = ["/usr/bin/time", "-v"] + command

    result = subprocess.run(
        full_command,
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE,
        text=True
    )

    return extract_time_output(result.stderr)


def main():
    output = ["# Benchmark Results\n"]

    for language_dir in sorted(BASE_DIR.iterdir()):
        if not language_dir.is_dir():
            continue

        language = language_dir.name

        if language not in LANGUAGE_COMMANDS:
            print(f"Skipping unsupported language: {language}")
            continue

        output.append(f"## {language}\n")

        for file in sorted(language_dir.iterdir()):
            if not file.is_file():
                continue

            print(f"Running {file}")

            try:
                description, time_comment = get_description_and_time(file)

                command_builder = LANGUAGE_COMMANDS[language]
                command = command_builder(file)

                elapsed, rss = run_with_time(command)

                output.append(f"#### {file.name}")
                output.append(f"{description} <br>")
                output.append(f"{time_comment} <br>")
                output.append("```txt")
                output.append(elapsed)
                output.append(rss)
                output.append("```\n")

                for item in command:
                    try:
                        if os.path.isfile(item) and "/tmp/" in item:
                            os.remove(item)
                    except:
                        pass

            except Exception as e:
                output.append(f"#### {file.name}")
                output.append("```txt")
                output.append(f"ERROR: {e}")
                output.append("```\n")

    README_PATH.write_text("\n".join(output), encoding="utf8")

    print(f"Done. README written to {README_PATH}")


if __name__ == "__main__":
    main()
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DatasetReader {
    public static int[] readDataset(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String content = reader.readLine();
        reader.close();
        
        String[] parts = content.split(",");
        int[] data = new int[parts.length];
        
        for (int i = 0; i < parts.length; i++) {
            data[i] = Integer.parseInt(parts[i]);
        }
        
        return data;
    }
}
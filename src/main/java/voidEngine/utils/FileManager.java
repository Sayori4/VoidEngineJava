package voidEngine.utils;

import java.io.*;

public class FileManager {
    public static String readFile(String file) {
        StringBuilder fileI = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) !=null) {
                fileI.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileI.toString();
    }

    public static void writeFile(String file, String[] data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String line: data) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

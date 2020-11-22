package util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class fileUtils {
    public static void changeFile(String fileName, String value) throws IOException {
        FileWriter fileWriter = new FileWriter("src\\main\\resources\\"+fileName+".txt");
        fileWriter.write(value);
        fileWriter.close();
    }
    public static String getFileValue(String fileName) throws IOException {
        String res;
        FileReader fileReader = new FileReader("src\\main\\resources\\"+fileName+".txt");
        Scanner scanner = new Scanner(fileReader);
        res = scanner.nextLine();
        fileReader.close();
        return res;

    }
}

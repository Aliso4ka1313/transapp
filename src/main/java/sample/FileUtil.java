package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.jar.Pack200;

/**
 * Created by mit_OK! on 23.03.2015.
 */
public class FileUtil {
    public static String readFromFile(){
        String FilePath = "/home/dm/IdeaProjects/transapp/src/main/resources/texttotranslate.txt";
        StringBuilder sb = new StringBuilder();
        File file = new File(FilePath);
        FileReader reader = null;
        try {
            reader = new FileReader(file);

            BufferedReader buffer = new BufferedReader(reader);

            String line;
            while ((line = buffer.readLine()) != null) {

                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String readFromFile(String filePath){
        StringBuilder sb = new StringBuilder();
        File file = new File(filePath);
        FileReader reader = null;
        try {
            reader = new FileReader(file);

            BufferedReader buffer = new BufferedReader(reader);

            String line;
            while ((line = buffer.readLine()) != null) {

                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static ArrayList<String[]> readFromFile(String FilePath, String RegExp) {
        ArrayList<String[]> fileStrings = new ArrayList<>();
        File file = new File(FilePath);
        FileReader reader = null;
        try {
            reader = new FileReader(file);

            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] preEntity = line.split(RegExp);
                fileStrings.add(preEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileStrings;
    }

    public static  void writeToFile(String textToWrite){
        String filePath = "/home/dm/IdeaProjects/transapp/src/main/resources/translatedtext.txt";
        Boolean addToEnd = true;
        try {
            FileWriter writer = new FileWriter(filePath, addToEnd);
            writer.write(textToWrite);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeToFile(String txt, String FilePath, Boolean AddToEnd) {
        // AddToEnd:::::: TRUE - дописывать в конец, FALSE - перезаписать всё
        try {
            FileWriter writer = new FileWriter(FilePath, AddToEnd);
            writer.write(txt);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

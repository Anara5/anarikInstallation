import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // creating directory to the folders "Games"
        createDirection("/Users/anarazhunusova/Desktop/Games");

        // creating folders in "Games": src, res, savegames, temp
        // folders of the 1st level for "Games"
        createDirection("/Users/anarazhunusova/Desktop/Games/src");
        createDirection("/Users/anarazhunusova/Desktop/Games/res");
        createDirection("/Users/anarazhunusova/Desktop/Games/savegames");
        createDirection("/Users/anarazhunusova/Desktop/Games/temp");

        // creating folders "res" and "src" as parents and "main", "test", drawable", vectors", "icons" as children
        // folders of the 2d level for "src"
        createDirection("/Users/anarazhunusova/Desktop/Games/src/main");
        createDirection("/Users/anarazhunusova/Desktop/Games/src/test");

        // folders of the 2d level for "res"
        createDirection("/Users/anarazhunusova/Desktop/Games/res/drawable");
        createDirection("/Users/anarazhunusova/Desktop/Games/res/vectors");
        createDirection("/Users/anarazhunusova/Desktop/Games/res/icons");

        // creating files Main.java and Utils.java in folder "main"
        createFile("/Users/anarazhunusova/Desktop/Games/src/main/Main.java");
        createFile("/Users/anarazhunusova/Desktop/Games/src/main/Utils.java");

        // creating file temp.txt in folder "temp"
        createFile("/Users/anarazhunusova/Desktop/Games/temp/temp.txt");

        // writing text in file temp.txt
        writeFile(new File("/Users/anarazhunusova/Desktop/Games/temp/temp.txt"));
    }

    public static void createDirection(String way) {
        File direction = new File(way);
        if (!direction.exists()) {
            System.out.println(direction.mkdir() ? (direction.getName() + " is created") : "Failed");
        } else {
            System.out.println(way + " exists");
        }
    }

    public static void createFile(String way) {
        File file = new File(way);
        try {
            if (file.createNewFile())
                System.out.println(file.getName() + " is created");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writeFile(File fileName) {
        StringBuilder sb = new StringBuilder();
        try(FileWriter writer = new FileWriter(fileName, false)) {
            if (fileName.exists()) {
                sb.append("Files are successfully created. Folders: Games, src, main, test, res, savegames, temp, drawables, vectors, icons. Files: Main.java, Utils.java, temp.txt");
                // writing the text to the file temp.txt
                writer.write(sb.toString());
                System.out.println("Successfully written");
                writer.flush();
                writer.close();
            } else {
                System.out.println("Error");
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
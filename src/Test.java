import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {

        File dir = new File("/Users/anarazhunusova/Desktop/Games");
        // checking if the directory to the folder "Games" is established
        if (dir.mkdir()) {
            System.out.println("Folder has been created");
        }

        // creating folders in "Games": src, res, savegames, temp
        createFolder("src");
        createFolder("res");
        createFolder("savegames");
        createFolder("temp");

        // creating folders "res" and "src" as parents and "main", "test", drawable", vectors", "icons" aa children
        createFolder2("main");
        createFolder2("test");
        createFolder22("drawable");
        createFolder22("vectors");
        createFolder22("icons");

        // creating files Main.java and Utils.java in folder "main"
        // file temp.txt in folder "temp"
        createFile("Main.java");
        createFile("Utils.java");
        createTextFile("temp.txt");

        // writing text in file temp.txt
        StringBuilder sb = new StringBuilder();
        try(FileWriter writer = new FileWriter("/Users/anarazhunusova/Desktop/Games/temp/temp.txt", false)) {
            if (dir.exists()) {
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

    // folders of the 1st level for "Games"
    public static void createFolder(String dir1) {
        File subDir1 = new File("/Users/anarazhunusova/Desktop/Games/" + dir1);
        if (subDir1.mkdir()) {
            System.out.println(dir1 + " is created");
        }
    }
    // folders of the 2d level for "src"
    public static void createFolder2(String dir2) {
        File subDir2 = new File("/Users/anarazhunusova/Desktop/Games/src/" + dir2);
        if (subDir2.mkdir()) {
            System.out.println(dir2 + " is created");
        }

    }
    // folders of the 2d level for "res"
    public static void createFolder22(String dir22) {
        File subDir22 = new File("/Users/anarazhunusova/Desktop/Games/res/" + dir22);
        if (subDir22.mkdir()) {
            System.out.println(dir22 + " is created");
        }
    }

    // files for folder "main"
    public static void createFile(String fileName) {
        File file = new File("/Users/anarazhunusova/Desktop/Games/src/main/" + fileName);
        try {
            if (file.createNewFile() && file.createNewFile())
                System.out.println(file.getName() + ", " + file.getName() + " are created");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // text file for "temp"
    public static void createTextFile(String fileName2) {
        File textFile = new File("/Users/anarazhunusova/Desktop/Games/temp/" + fileName2);
        try {
            if (textFile.createNewFile())
                System.out.println(textFile.getName() + " is created");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
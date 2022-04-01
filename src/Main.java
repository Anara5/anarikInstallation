import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File dir = new File("/Users/anarazhunusova/Desktop/Games");
        // checking if the directory to the folder "Games" is established
        if (dir.mkdir()) {
            System.out.println("Folder Games is created");
        }

        // creating folders in "Games": src, res, savegames, temp
        // folders of the 1st level for "Games"
        File parent1 = new File("/Users/anarazhunusova/Desktop/Games/");
        File src = new File(parent1, "src");
        File res = new File(parent1, "res");
        File savegames = new File(parent1, "savegames");
        File temp = new File(parent1, "temp");

        if (src.mkdir() && res.mkdir() && savegames.mkdir() && temp.mkdir()) {
            System.out.println("Folders are created: src, rs, savegames, temp");
        }

        // creating folders "res" and "src" as parents and "main", "test", drawable", vectors", "icons" as children
        // folders of the 2d level for "src"
        File parent21 = new File("/Users/anarazhunusova/Desktop/Games/src/");
        File main = new File(parent21, "main");
        File test = new File(parent21, "test");

        // folders of the 2d level for "res"
        File parent22 = new File("/Users/anarazhunusova/Desktop/Games/res/");
        File drawable = new File(parent22, "drawable");
        File vectors = new File(parent22, "vectors");
        File icons = new File(parent22, "icons");

        if (main.mkdir() && test.mkdir() && drawable.mkdir() && vectors.mkdir() && icons.mkdir()) {
            System.out.println("Folders are created: main, test, drawable, vectors, icons");
        }

        // creating files Main.java and Utils.java in folder "main"
        File mainJava = new File("/Users/anarazhunusova/Desktop/Games/src/main/Main.java");
        File mainUtils = new File("/Users/anarazhunusova/Desktop/Games/src/main/Utils.java");
        try {
            if (mainJava.createNewFile() && mainUtils.createNewFile())
                System.out.println(mainJava.getName() + ", " + mainUtils.getName() + " are created");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        // file temp.txt in folder "temp"
        File tempTxt = new File("/Users/anarazhunusova/Desktop/Games/temp/temp.txt");
        try {
            if (tempTxt.createNewFile())
                System.out.println(tempTxt.getName() + " is created");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

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
}
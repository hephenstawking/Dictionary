package sample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

public class IncreaseDictionary {

    public IncreaseDictionary() {
        super();
    }

    public void addNewWord (String en, String ua) {
        try(FileWriter fileWriter = new FileWriter("dict.txt", true);
            PrintWriter pw = new PrintWriter(fileWriter);) {
            pw.print("," + en + "-" + ua);
        }  catch (IOException e) {
            e.printStackTrace();
        }

    }
}

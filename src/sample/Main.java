package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        IncreaseDictionary increaseDictionary = new IncreaseDictionary();
        Translate tr = new Translate();

        System.out.println("If you want to translate text type \"T\", if you want to add new word type \"A\": ");
        String option = sc.next();

        if (option.equals("A")) {
            System.out.println("Type English word:");
            String en = sc.next();
            System.out.println("Type Ukrainian word:");
            String ua = sc.next();
            increaseDictionary.addNewWord(en, ua);
        } else if (option.equals("T")) {
            tr.translate();
        }

    }


}

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

        System.out.println("If you want to translate text type \"T\", if you want to add new word type \"A\": ");
        String option = sc.next();

        if (option.equals("A")) {
            System.out.println("Type English word:");
            String en = sc.next();
            System.out.println("Type Ukrainian word:");
            String ua = sc.next();
            increaseDictionary.addNewWord(en, ua);
        } else if (option.equals("T")) {
            translate ();
        }

    }

    public static void translate() {
        String dictString = "";
        Map<String, String> dictionary = new HashMap<>();

        File dictFile = new File("dict.txt");
        Map<String, String> map = new HashMap<String, String>();

        try (Scanner sc = new Scanner(dictFile)) {
            while (sc.hasNextLine()) {
                dictString += sc.nextLine().toLowerCase();
            }
            List<String> dictList = new ArrayList<>(Arrays.asList(dictString.split(",")));
            for ( String elem : dictList) {
                String[] parts = elem.split("-");
                for (int i = 0; i < parts.length; i += 2) {
                    dictionary.put(parts[i], parts[i + 1]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        File enFile = new File("English.in");
        String str = "";
        List<String> translated = new ArrayList<>();

        try (Scanner sc = new Scanner(enFile)) {
            while (sc.hasNextLine()) {
                str += sc.nextLine().toLowerCase();
            }
            List<String> list = new ArrayList<>(Arrays.asList(str.split(" ")));

            for ( String elem : list) {
                if (dictionary.containsKey(elem)) {
                    translated.add(dictionary.get(elem));
                }
            }

            try (PrintWriter pw = new PrintWriter(new File("Ukrainian.out"))) {
                for ( String elem : translated) {
                    pw.println(elem);
                }
                System.out.println("Text was successfully translated!");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

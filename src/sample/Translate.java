package sample;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Translate {

    private File dictFile = new File("dict.txt");
    private File enFile = new File("English.in");
    private File uaFile = new File("Ukrainian.out");

    public File getUaFile() {
        return uaFile;
    }

    public void setUaFile(File uaFile) {
        this.uaFile = uaFile;
    }

    public File getDictFile() {
        return dictFile;
    }

    public void setDictFile(File dictFile) {
        this.dictFile = dictFile;
    }

    public File getEnFile() {
        return enFile;
    }

    public void setEnFile(File enFile) {
        this.enFile = enFile;
    }

    public Map getDictionary() {

        String dictString = "";
        Map<String, String> dictionary = new HashMap<>();

        try (Scanner sc = new Scanner(getDictFile())) {
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
        return dictionary;
    }

    public void translate() {
        Map<String, String> dictionary = getDictionary();
        String str = "";
        List<String> translated = new ArrayList<>();

        try (Scanner sc = new Scanner(getEnFile())) {
            while (sc.hasNextLine()) {
                str += sc.nextLine().toLowerCase();
            }
            List<String> list = new ArrayList<>(Arrays.asList(str.split(",")));

            for ( String elem : list) {
                if (dictionary.containsKey(elem)) {
                    translated.add(dictionary.get(elem));
                }
            }

            try (PrintWriter pw = new PrintWriter(getUaFile())) {
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

    @Override
    public String toString() {
        return "Translate{" +
                "dictFile=" + dictFile +
                ", enFile=" + enFile +
                ", uaFile=" + uaFile +
                '}';
    }
}

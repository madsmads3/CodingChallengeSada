import java.io.*;
import java.util.*;

public class codingChallenge {

    public static void main(String a[]) {
        List<String> wordlist = new ArrayList<String>();
        readWords(wordlist);
        int indexLargest = 0;
        int indexCompare = 1;
        wordCompare(wordlist, indexLargest, indexCompare);

    }

    public static void readWords(List<String> wordlist) {
        // read words using buffer
        StringBuilder sb = new StringBuilder();
        String strLine = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/students/test.txt"));
            while (strLine != null) {
                strLine = br.readLine();
                sb.append(strLine);
                sb.append(System.lineSeparator());
                strLine = br.readLine();
                if (strLine == null)
                    break;
                wordlist.add(strLine);
            }
            System.out.println(Arrays.toString(wordlist.toArray()));
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        // sort array list by string length (ascending order)
        Collections.sort(wordlist, Comparator.comparing(String::length));
        // switch to desending order
        Collections.reverse(wordlist);

    }

    // compare characters
    public static String wordCompare(List<String> wordlist, int indexLargest, int indexCompare) {
        String myWord = wordlist.get(indexLargest);
        String compareWord = wordlist.get(indexCompare);
        String myNewWord = "";
        while (!(isFound(myWord))) {
            // if longest word myWord contains subset compareWord then remove the subset
            // from the longest word
            if (myWord.contains(compareWord)) {
                myNewWord = myWord.replaceAll(compareWord, "");

            }
            // else go to next
            else {
                indexCompare = indexCompare + 1;
            }
        }
        return myNewWord;

    }

    public static boolean isFound(String element) {
        if (element.length() < 1) {
            return true;
        } else {
            return false;
        }

    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TaskThree {
    public static void countWords() throws FileNotFoundException {
        File inputFile = new File("file3.txt");
        Scanner inpFromFile = new Scanner(inputFile);
        Map<String, Integer> words = new HashMap();

        while (inpFromFile.hasNextLine()) {
            String input = inpFromFile.nextLine();
            String[] arr = input.split(" ");
            for (int i = 0; i < arr.length; i++) {
                if (!words.containsKey(arr[i])) {
                    words.put(arr[i], 1);
                } else words.put(arr[i], words.get(arr[i]) + 1);
            }
        }
        String[] sortedOut = words.keySet().toArray(new String[0]);
        for (int i = 0; i < sortedOut.length - 1; i++) {
            for (int j = sortedOut.length - 1; j > 0; j--) {
                if (words.get(sortedOut[j - 1]) < words.get(sortedOut[j])) {
                    String s = sortedOut[j - 1];
                    sortedOut[j - 1] = sortedOut[j];
                    sortedOut[j] = s;
                }
            }
        }
        for (int i = 0; i < sortedOut.length; i++) {
            System.out.println(sortedOut[i] + "  " + words.get(sortedOut[i]));
        }
    }
}

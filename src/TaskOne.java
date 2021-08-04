import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class TaskOne {
    public static void returnValidNumbers() {
        try (FileInputStream numbers = new FileInputStream("file.txt")) {
            Scanner phoneNumber = new Scanner(numbers);
            while (phoneNumber.hasNextLine()) {
                String number = phoneNumber.nextLine();
                if (number.matches("\\d{3}[-]\\d{3}[-]\\d{4}") || number.matches("\\(\\d{3}\\)\\s\\d{3}-?\\d{4}"))
                    System.out.println(number);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}


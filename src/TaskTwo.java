import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskTwo {

    public static void jsonToFile() throws IOException {
        Gson jsonFile = new GsonBuilder().setPrettyPrinting().create();
        File inputFile = new File("file2.txt");
        Scanner inpFromFile = new Scanner(inputFile);
        int i = 0;
        ArrayList<Person> persons = new ArrayList<Person>();
        try (FileWriter writer = new FileWriter("namesJson.txt")) {
            while (inpFromFile.hasNextLine()) {
                Person person = new Person();
                String input = inpFromFile.nextLine();
                String[] arr;
                if (input.length() > 2) {
                    arr = input.split(" ");
                } else continue;
                if (!arr[1].matches("^-?\\d+$")) continue;
                person.setName(arr[0]);
                person.setAge(Integer.parseInt(arr[1]));
                persons.add(person);
                i++;
            }
            writer.append(jsonFile.toJson(persons));
            writer.flush();
        }
    }
}


class Person {

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
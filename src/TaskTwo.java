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
        String s = new String();
        while (inpFromFile.hasNextLine()) {
            String input = inpFromFile.nextLine();
            String[] arr;
            if (input.length() > 2) {
                arr = input.split(" ");
            } else continue;
            if (!arr[1].matches("^-?\\d+$")) continue;
            Person person = new Person();
            person.setName(arr[0]);
            person.setAge(Integer.parseInt(arr[1]));

             s = s + jsonFile.toJson(person) + "\n";
            try (FileWriter writer = new FileWriter("namesJson.txt")){
                writer.write(s);
                writer.flush();
            }

        }


    }
}

class Person {
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
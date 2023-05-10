package lk.ijse.dep10;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.ijse.dep10.model.Student;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadJSON {

    public static void main(String[] args) throws FileNotFoundException {
        Jsonb jsonb = JsonbBuilder.create();

        /* JavaObject = fromJson(json, convert type class object) */

        /* Generics */
        ArrayList<Student> studentList = jsonb.fromJson(new FileReader("student-list.json"),
                new ArrayList<Student>(){}.getClass().getGenericSuperclass());
        studentList.forEach(System.out::println);
    }
}

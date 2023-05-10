package lk.ijse.dep10;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import jakarta.json.bind.config.PropertyOrderStrategy;
import lk.ijse.dep10.model.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteJSON {

    public static void main(String[] args) throws IOException {
        Student s1 = new Student(1, "Kasun Sampath", "abc", List.of("077-1234567", "055-1234567"));
        Student s2 = new Student(2, "Nuwan Ramindu", "edf", List.of("078-1234567", "055-1234567"));
        Student s3 = new Student(3, "Ruwan Rathanayke","ijse", List.of("078-1234567", "055-1234567"));
        List<Student> studentList = List.of(s1, s2, s3);

//        JsonObject json = Json.createObjectBuilder()
//                .add("id", s1.getId())
//                .add("name", s1.getName())
//                .add("contacts", Json.createArrayBuilder()
//                        .add(s1.getContacts().get(0)).add(s1.getContacts().get(1)))
//                .build();

        JsonbConfig config = new JsonbConfig();
        config.withFormatting(true);
        config.withPropertyOrderStrategy(PropertyOrderStrategy.REVERSE);

        Jsonb jsonb = JsonbBuilder.create(config);
//        String json = jsonb.toJson(studentList);
//        System.out.println(json);
//
//        jsonb.toJson(studentList, new FileWriter("student-list.json"));

        String json = jsonb.toJson(s1);
//        String json2 = jsonb.toJson(s2);
        System.out.println(json);
//        System.out.println(json2);
    }
}

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import java.io.*;

public class ReadJSON2 {

    public static void main(String[] args) throws FileNotFoundException {
        JsonReader reader = Json.createReader(new FileReader("jakarta-ee-jsonp-2.json"));
        JsonObject jsonObject = reader.readObject();
        String name = jsonObject.getString("name");
        int age = jsonObject.getInt("age");
        String id = jsonObject.getString("id");
        String city = jsonObject.getJsonObject("address").getString("city");
        System.out.printf("id=%s, name=%s, age=%s, city=%s \n", id ,name, age, city);
        JsonArray contacts = jsonObject.getJsonArray("contacts");
        System.out.println(contacts);
    }
}

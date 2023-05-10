import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import java.io.*;

public class ReadJSON {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("jakarta-ee-jsonp.json"))) {
            String line;
            String json = "";
            while ((line = br.readLine()) != null) {
                json += line + "\n";
            }
            /* ---------------------------  */
            JsonReader reader = Json.createReader(new StringReader(json));
//            String name = reader.readObject()
//                    .getString("name");
//            System.out.println(name);
//            String contact = Json.createReader(new StringReader(json)).readObject()
//                    .getJsonArray("contacts").getString(0);
//            System.out.println(contact);

            JsonObject jsonObject = reader.readObject();
            String name = jsonObject.getString("name");
            int age = jsonObject.getInt("age");
            String id = jsonObject.getString("id");
            String city = jsonObject.getJsonObject("address").getString("city");
            System.out.printf("id=%s, name=%s, age=%s, city=%s \n", id ,name, age, city);
            JsonArray contacts = jsonObject.getJsonArray("contacts");
            System.out.println(contacts);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

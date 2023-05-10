import jakarta.json.Json;
import jakarta.json.JsonObject;

import java.io.*;

public class WriteJSON {

    public static void main(String[] args) {
        /*
        *   {
        *       "id":"C001",
        *       "name":"Kasun Sampath",
        *       "address": {
        *                   "no": 15,
        *                   "street": "Grace Peries Road",
        *                   "city": "Panadura
        *                   },
        *       "age":17,
        *       "contacts": ["077-1234567", "022-1234567"]
        *   }
        *
        * */

        JsonObject json = Json.createObjectBuilder()
                .add("id", "C001")
                .add("name", "Kasun Sampath")
                .add("address", Json.createObjectBuilder()
                        .add("no", 15)
                        .add("street", "Grace Peries Road")
                        .add("city", "Panadura").build())
                .add("age", 17)
                .add("contacts", Json.createArrayBuilder()
                                .add("077-12345678")
                                .add("022-12345677").build())
                .build();
        System.out.println(json);
        File file = new File("jakarta-ee-jsonp.json");
        try(FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(json.toString());
            System.out.println("File Saved!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

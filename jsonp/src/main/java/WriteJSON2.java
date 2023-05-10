import jakarta.json.*;
import jakarta.json.stream.JsonGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class WriteJSON2 {

    public static void main(String[] args) throws IOException {
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

        HashMap<String, Object> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        Json.createWriterFactory(config).createWriter(System.out).write(json);

        JsonWriter writer = Json.createWriterFactory(config)
                .createWriter(new FileWriter("jakarta-ee-jsonp-2.json"));
//        JsonWriter writer = Json.createWriter(new FileWriter("jakarta-ee-jsonp-2.json"));
        writer.write(json);
        writer.close();
    }
}

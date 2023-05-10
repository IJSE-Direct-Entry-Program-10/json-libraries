package lk.ijse.dep10.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lk.ijse.dep10.json.model.Customer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteJSON {

    public static void main(String[] args) throws IOException {
        Customer c1 = new Customer(1, "Kasun", "Galle", "ijse");
        Customer c2 = new Customer(2, "Nuwan", "Rathanpura", "dep");
        Customer c3 = new Customer(3, "Supun", "Galle", "dep10");
        List<Customer> customerList = List.of(c1, c2, c3);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(c1);
        System.out.println(json);

        String jsonArray = gson.toJson(customerList);
        System.out.println(jsonArray);

        FileWriter fw = new FileWriter("customer.json");
        gson.toJson(c1, Customer.class,fw);
        fw.close();

        FileWriter fw2 = new FileWriter("customer-list.json");
        gson.toJson(customerList, List.class, fw2);
        fw2.close();
    }
}

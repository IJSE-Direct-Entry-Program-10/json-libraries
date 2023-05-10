package lk.ijse.dep10.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lk.ijse.dep10.json.model.Customer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReadJSON {

    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();

        Customer customer = gson.fromJson(new FileReader("customer.json"), Customer.class);
        System.out.println(customer);

        Type customerListType = new TypeToken<List<Customer>>() {}.getType();

        List<Customer> customerList = gson.fromJson(new FileReader("customer-list.json"),
                customerListType);

        List<Customer> customerList2 = gson.fromJson(new FileReader("customer-list.json"),
                new ArrayList<Customer>(){}.getClass().getGenericSuperclass());
        customerList.forEach(System.out::println);
        customerList2.forEach(System.out::println);
    }
}

package lk.ijse.dep10.json.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @SerializedName("customer_id")
    private int id;
    private String name;
    private String address;
    private transient String secretKey;
}

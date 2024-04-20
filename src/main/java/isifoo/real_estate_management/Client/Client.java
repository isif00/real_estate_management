package isifoo.real_estate_management.Client;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Client {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String city;
    private ClientType clientType;
    private List<String> realEstateIds;
    private List<String> transactionIds;
}

package isifoo.real_estate_management.Transaction;

import isifoo.real_estate_management.Client.Client;
import isifoo.real_estate_management.RealEstate.RealEstate;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Transaction {
    @Id
    private String id;
    private RealEstate realEstate;
    private Client client;
    private TransactionType transactionType;
    private int transactionFee;
}

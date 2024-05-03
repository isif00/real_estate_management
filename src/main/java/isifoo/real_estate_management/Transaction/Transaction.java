package isifoo.real_estate_management.Transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Transaction {
    @Id
    private String id;
    private String realEstateId;
    private String buyerId;
    private TransactionType transactionType;
    private int transactionFee;
}

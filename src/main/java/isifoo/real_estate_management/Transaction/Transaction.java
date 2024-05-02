package isifoo.real_estate_management.Transaction;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Transaction {
    @Id
    private String id;
    private String realEstateId;
    private String buyerId;
    private TransactionType transactionType;
    private int transactionFee;
}

package isifoo.real_estate_management.History;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class History {
    private Operation operation;
    private Integer numberOfTransactions;
}

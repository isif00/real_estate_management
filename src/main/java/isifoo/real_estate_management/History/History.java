package isifoo.real_estate_management.History;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class History {
    @Id
    private String id;
    private Operation operation;
    private List<Integer> numberOfTransactionsPerMonth;
}

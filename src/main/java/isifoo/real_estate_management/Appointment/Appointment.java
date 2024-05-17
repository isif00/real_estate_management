package isifoo.real_estate_management.Appointment;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Appointment {
    @Id
    private String id;
    private String clientId;
    private String date;
}

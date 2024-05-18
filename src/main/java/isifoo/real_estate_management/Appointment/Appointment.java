package isifoo.real_estate_management.Appointment;

import isifoo.real_estate_management.Client.Client;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Appointment {
    @Id
    private String id;
    private Client client;
    private String date;
}

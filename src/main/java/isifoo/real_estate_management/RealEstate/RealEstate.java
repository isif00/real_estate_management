package isifoo.real_estate_management.RealEstate;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class RealEstate {
    @Id
    private String id;
    private String name;
    private String address;
    private String description;
    private String city;
    private String state;
    private Integer price;
    private PropertyAvailability availability;
    private ListingType listingType;
    private String ownerId;
}

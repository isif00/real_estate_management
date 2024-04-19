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
    private int price;
    private PropertyAvailability availability;
    private ListingType listingType;

    public RealEstate(String name, String address, String description, String city, String state, int price, PropertyAvailability availability, ListingType listingType) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.city = city;
        this.state = state;
        this.price = price;
        this.availability = availability;
        this.listingType = listingType;
    }
}

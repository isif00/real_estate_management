package isifoo.real_estate_management.RealEstate;

public class RealEstate {
    private long id;
    private String name;
    private String address;
    private String description;
    private String city;
    private String state;
    private int price;
    private PropertyAvailability availability;
    private ListingType listingType;


    public RealEstate(long id, String name, String address, String description, String city, String state, int price, PropertyAvailability availability, ListingType listingType) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.city = city;
        this.state = state;
        this.price = price;
        this.availability = availability;
        this.listingType = listingType;
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PropertyAvailability getAvailability() {
        return availability;
    }

    public void setAvailability(PropertyAvailability availability) {
        this.availability = availability;
    }

    public ListingType getListingType() {
        return listingType;
    }

    public void setListingType(ListingType listingType) {
        this.listingType = listingType;
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", price=" + price +
                ", availability=" + availability +
                ", listingType=" + listingType +
                '}';
    }
}

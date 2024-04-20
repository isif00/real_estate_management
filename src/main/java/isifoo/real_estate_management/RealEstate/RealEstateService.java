package isifoo.real_estate_management.RealEstate;

import com.mongodb.MongoException;
import isifoo.real_estate_management.utils.RegexParser;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
@Service
public class RealEstateService {
    private final RealEstateRepository realEstateRepository;

    public List<RealEstate> getRealEstates() {
        try {
            return realEstateRepository.findAll();
        } catch (MongoException e) {
            throw new RuntimeException("Failed to get real estates", e);
        }
    }

    public void addRealEstate(RealEstate realEstate){
        try {
            realEstateRepository.insert(realEstate);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to insert real estate", e);
        }
    }

    public void deleteRealEstate(String id){
        try {
            realEstateRepository.deleteById(id);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to delete real estate", e);
        }
    }

    public void updateRealEstate(String id, String newRealEstate){
        try {
            RealEstate realEstate = realEstateRepository.findById(id);

            realEstate.setName(RegexParser.parse("\"name\":\\s*\"([^\"]+)\"", newRealEstate));
            realEstate.setAddress(RegexParser.parse("\"address\":\\s*\"([^\"]+)\"", newRealEstate));
            realEstate.setDescription(RegexParser.parse("\"description\":\\s*\"([^\"]+)\"", newRealEstate));
            realEstate.setCity(RegexParser.parse("\"city\":\\s*\"([^\"]+)\"", newRealEstate));
            realEstate.setState(RegexParser.parse("\"state\":\\s*\"([^\"]+)\"", newRealEstate));
            realEstate.setPrice(Integer.parseInt(Objects.requireNonNull(RegexParser.parse("\"price\":\\s*(\\d+)", newRealEstate))));
            realEstate.setAvailability(Objects.equals(RegexParser.parse("\"availability\":\\s*\"([^\"]+)\"", newRealEstate), "AVAILABLE") ? PropertyAvailability.AVAILABLE : PropertyAvailability.NOT_AVAILABLE);
            realEstate.setListingType(Objects.equals(RegexParser.parse("\"listingType\":\\s*\"([^\"]+)\"", newRealEstate), "RENT") ? ListingType.FOR_RENT : ListingType.FOR_SALE);

            realEstateRepository.save(realEstate);

        } catch (MongoException e) {
            throw new RuntimeException("Failed to update real estate", e);
        }

    }

}

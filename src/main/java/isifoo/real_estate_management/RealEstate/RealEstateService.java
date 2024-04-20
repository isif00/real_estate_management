package isifoo.real_estate_management.RealEstate;

import com.mongodb.MongoException;
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

            Pattern namePattern = Pattern.compile("\"name\":\\s*\"([^\"]+)\"");
            Matcher nameMatcher = namePattern.matcher(newRealEstate);
            if (nameMatcher.find()) {
                String nameValue = nameMatcher.group(1);
                realEstate.setName(nameValue);
            }

            Pattern addressPattern = Pattern.compile("\"address\":\\s*\"([^\"]+)\"");
            Matcher addressMatcher = addressPattern.matcher(newRealEstate);
            if (addressMatcher.find()) {
                String addressValue = addressMatcher.group(1);
                realEstate.setAddress(addressValue);
            }

            Pattern pattern = Pattern.compile("\"description\":\\s*\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(newRealEstate);

            if (matcher.find()) {
                String descriptionValue = matcher.group(1);
                realEstate.setDescription(descriptionValue);
            }

            Pattern descriptionPattern = Pattern.compile("\"description\":\\s*\"([^\"]+)\"");
            Matcher descriptionMatcher = descriptionPattern.matcher(newRealEstate);
            if (descriptionMatcher.find()) {
                String descriptionValue = descriptionMatcher.group(1);
                realEstate.setDescription(descriptionValue);
            }

            Pattern cityPattern = Pattern.compile("\"city\":\\s*\"([^\"]+)\"");
            Matcher cityMatcher = cityPattern.matcher(newRealEstate);
            if (cityMatcher.find()) {
                String cityValue = cityMatcher.group(1);
                realEstate.setCity(cityValue);
            }

            Pattern statePattern = Pattern.compile("\"state\":\\s*\"([^\"]+)\"");
            Matcher stateMatcher = statePattern.matcher(newRealEstate);
            if (stateMatcher.find()) {
                String stateValue = stateMatcher.group(1);
                realEstate.setState(stateValue);
            }

            Pattern pricePattern = Pattern.compile("\"price\":\\s*(\\d+)");
            Matcher priceMatcher = pricePattern.matcher(newRealEstate);
            if (priceMatcher.find()) {
                int priceValue = Integer.parseInt(priceMatcher.group(1));
                realEstate.setPrice(priceValue);
            }

            Pattern availabilityPattern = Pattern.compile("\"availability\":\\s*\"([^\"]+)\"");
            Matcher availabilityMatcher = availabilityPattern.matcher(newRealEstate);
            if (availabilityMatcher.find()) {
                String availabilityValue = availabilityMatcher.group(1);
                realEstate.setAvailability(Objects.equals(availabilityValue, "AVAILABLE") ? PropertyAvailability.AVAILABLE : PropertyAvailability.NOT_AVAILABLE);
            }

            Pattern listingTypePattern = Pattern.compile("\"listingType\":\\s*\"([^\"]+)\"");
            Matcher listingTypeMatcher = listingTypePattern.matcher(newRealEstate);
            if (listingTypeMatcher.find()) {
                String listingTypeValue = listingTypeMatcher.group(1);
                realEstate.setListingType(Objects.equals(listingTypeValue, "FOR_SALE") ? ListingType.FOR_SALE : ListingType.FOR_RENT);
            }

            realEstateRepository.save(realEstate);

        } catch (MongoException e) {
            throw new RuntimeException("Failed to update real estate", e);
        }

    }

}

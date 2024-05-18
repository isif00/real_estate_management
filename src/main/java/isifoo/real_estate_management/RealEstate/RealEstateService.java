package isifoo.real_estate_management.RealEstate;

import com.mongodb.MongoException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void updateRealEstate(String id, RealEstate newRealEstate) {
        try {
            RealEstate realEstate = realEstateRepository.findById(id);

            if (realEstate == null) {
                throw new RuntimeException("Real estate not found");
            }

            if (newRealEstate.getName() != null) {
                realEstate.setName(newRealEstate.getName());
            }
            if (newRealEstate.getAddress() != null) {
                realEstate.setAddress(newRealEstate.getAddress());
            }
            if (newRealEstate.getDescription() != null) {
                realEstate.setDescription(newRealEstate.getDescription());
            }
            if (newRealEstate.getCity() != null) {
                realEstate.setCity(newRealEstate.getCity());
            }
            if (newRealEstate.getState() != null) {
                realEstate.setState(newRealEstate.getState());
            }
            if (newRealEstate.getPrice() != null) {
                realEstate.setPrice(newRealEstate.getPrice());
            }
            if (newRealEstate.getAvailability() != null) {
                realEstate.setAvailability(newRealEstate.getAvailability());
            }
            if (newRealEstate.getListingType() != null) {
                realEstate.setListingType(newRealEstate.getListingType());
            }
            if (newRealEstate.getOwnerId() != null) {
                realEstate.setOwnerId(newRealEstate.getOwnerId());
            }

            realEstateRepository.save(realEstate);

        } catch (MongoException e) {
            throw new RuntimeException("Failed to update real estate", e);
        }
    }

    public RealEstate getRealEstate(String id) {
        try {
            return realEstateRepository.findById(id);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to get real estate", e);
        }
    }
}

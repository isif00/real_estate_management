package isifoo.real_estate_management.RealEstate;

import com.mongodb.MongoException;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
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

}

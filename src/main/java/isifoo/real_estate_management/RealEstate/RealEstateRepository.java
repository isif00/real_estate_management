package isifoo.real_estate_management.RealEstate;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RealEstateRepository extends MongoRepository<RealEstate, Long>{
    RealEstate findById(String id);
    void deleteById(String id);
}

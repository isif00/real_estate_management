package isifoo.real_estate_management.RealEstate;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface RealEstateRepository extends MongoRepository<RealEstate, Long>{
    RealEstate findById(String id);
    void deleteById(String id);
}

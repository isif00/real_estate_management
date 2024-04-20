package isifoo.real_estate_management.RealEstate;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RealEstateRepository extends MongoRepository<RealEstate, Long>{
    RealEstate findById(String id);
    void deleteById(String id);
}

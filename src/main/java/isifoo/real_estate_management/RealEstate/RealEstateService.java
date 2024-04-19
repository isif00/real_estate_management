package isifoo.real_estate_management.RealEstate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RealEstateService {
    private final RealEstateRepository realEstateRepository;

    public List<RealEstate> getRealEstates() {
        return realEstateRepository.findAll();
    }

}

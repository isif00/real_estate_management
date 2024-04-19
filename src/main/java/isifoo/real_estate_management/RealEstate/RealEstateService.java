package isifoo.real_estate_management.RealEstate;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateService {
    public List<RealEstateModel> getRealEstates() {
        return List.of(new RealEstateModel(
                1,
                "House",
                "123 Main St",
                "Beautiful house",
                "Springfield",
                "IL",
                100000,
                PropertyAvailability.Available,
                ListingType.forSale
        ), new RealEstateModel(
                1,
                "House",
                "123 Main St",
                "Beautiful house",
                "Springfield",
                "IL",
                100000,
                PropertyAvailability.Available,
                ListingType.forSale
        ));
    }
}

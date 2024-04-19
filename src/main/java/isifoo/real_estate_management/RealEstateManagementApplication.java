package isifoo.real_estate_management;

import isifoo.real_estate_management.RealEstate.ListingType;
import isifoo.real_estate_management.RealEstate.PropertyAvailability;
import isifoo.real_estate_management.RealEstate.RealEstate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class RealEstateManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealEstateManagementApplication.class, args);
	}

	@GetMapping("/")
	public List<RealEstate> home() {
		return List.of(new RealEstate(
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

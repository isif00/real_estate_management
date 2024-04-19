package isifoo.real_estate_management;

import isifoo.real_estate_management.RealEstate.ListingType;
import isifoo.real_estate_management.RealEstate.PropertyAvailability;
import isifoo.real_estate_management.RealEstate.RealEstate;
import isifoo.real_estate_management.RealEstate.RealEstateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class RealEstateManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealEstateManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner runner (RealEstateRepository realEstateRepository){
		return args -> {
			realEstateRepository.save(new RealEstate("House1", "1234 Main St", "A beautiful house", "San Francisco", "CA", 1000000, PropertyAvailability.Available, ListingType.forSale));
			realEstateRepository.save(new RealEstate("House2", "5678 Main St", "A beautiful house", "San Francisco", "CA", 2000000, PropertyAvailability.Available, ListingType.forSale));
			realEstateRepository.save(new RealEstate("House3", "91011 Main St", "A beautiful house", "San Francisco", "CA", 3000000, PropertyAvailability.Available, ListingType.forSale));
		};
	}

}

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

}

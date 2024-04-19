package isifoo.real_estate_management;

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
	public List<String> home() {
		return List.of("Welcome", "sifo");
	}

}

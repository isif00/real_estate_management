package isifoo.real_estate_management.RealEstate;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/real-estate")
@AllArgsConstructor
public class RealEstateController {
    private final RealEstateService realEstateService;

    @GetMapping("/all")
    public List<RealEstate> getRealEstates() {
        return realEstateService.getRealEstates();
    }

}

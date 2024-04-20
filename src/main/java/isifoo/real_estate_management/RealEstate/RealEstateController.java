package isifoo.real_estate_management.RealEstate;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/get-real-estate/{id}")
    public RealEstate getRealEstate(@PathVariable String id){
        return realEstateService.getRealEstate(id);
    }

    @PostMapping(value = "/add")
    public String addUser(@RequestBody RealEstate realEstate){
        realEstateService.addRealEstate(realEstate);
        return "User created successfully";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable String id){
        realEstateService.deleteRealEstate(id);
        return "User deleted successfully";
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable String id, @RequestBody String newRealEstate){
        realEstateService.updateRealEstate(id, newRealEstate);
        return "User updated successfully";
    }
}

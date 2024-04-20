package isifoo.real_estate_management.Client;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/all")
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping(value = "/get-client/{id}")
    public Client getClient(@PathVariable String id) {
        return clientService.getClient(id);
    }

    @PostMapping(value = "/add")
    public String addClient(@RequestBody Client client) {
        clientService.addClient(client);
        return "User created successfully";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
        return "User deleted successfully";
    }

    @PutMapping(value = "/update/{id}")
    public String updateClient(@PathVariable String id, @RequestBody String newClient) {
        clientService.updateClient(id, newClient);
        return "User updated successfully";
    }

    @PutMapping(value = "/add-real-estate/{id}")
    public String addRealEstate(@PathVariable String id, @RequestBody String realEstateId) {
        clientService.addRealEstate(id, realEstateId);
        return "Real estate added successfully";
    }

}

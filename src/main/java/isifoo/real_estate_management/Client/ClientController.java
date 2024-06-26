package isifoo.real_estate_management.Client;

import isifoo.real_estate_management.utils.RealEstateIdDTO;
import isifoo.real_estate_management.utils.TransactionDTO;
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
        return "Client created successfully";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
        return "Client deleted successfully";
    }

    @PutMapping(value = "/update/{id}")
    public String updateClient(@PathVariable String id, @RequestBody Client newClient) {
        clientService.updateClient(id, newClient);
        return "Client updated successfully";
    }

    @PutMapping(value = "/add-real-estate/{id}")
    public String addRealEstate(@PathVariable String id, @RequestBody RealEstateIdDTO realEstateIdDTO) {
        clientService.addRealEstate(id, realEstateIdDTO.getRealEstateId());
        return "Client estate added successfully";
    }

    @PutMapping(value = "/add-transaction/{id}")
    public String addTransaction(@PathVariable String id, @RequestBody TransactionDTO transactionId) {
        clientService.addTransaction(id, transactionId.getTransactionId());
        return "Client transaction added successfully";
    }

}

package isifoo.real_estate_management.Client;

import com.mongodb.MongoException;
import isifoo.real_estate_management.utils.RegexParser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class ClientService {

    private final ClientRepository ClientRepository;

    public List<Client> getClients() {
        try {
            return ClientRepository.findAll();
        } catch (MongoException e) {
            throw new RuntimeException("Failed to get clients", e);
        }
    }

    public Client getClient(String id) {
        try {
            return ClientRepository.findById(id);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to get client", e);
        }
    }

    public void addClient(Client client) {
        try {
            ClientRepository.insert(client);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to insert client", e);
        }
    }

    public void deleteClient(String id) {
        try {
            ClientRepository.deleteById(id);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to delete client", e);
        }
    }

    public void updateClient(String id, String newClient) {
        try {
            Client client = ClientRepository.findById(id);
            client.setName(RegexParser.parse("\"name\":\\s*\"([^\"]+)\"", newClient));
            client.setEmail(RegexParser.parse("\"email\":\\s*\"([^\"]+)\"", newClient));
            client.setPhone(RegexParser.parse("\"phone\":\\s*\"([^\"]+)\"", newClient));
            client.setCity(RegexParser.parse("\"city\":\\s*\"([^\"]+)\"", newClient));
            client.setClientType(Objects.equals(RegexParser.parse("\"clientType\":\\s*\"([^\"]+)\"", newClient), "BUYER") ? ClientType.BUYER : ClientType.SELLER);

            ClientRepository.save(client);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to update client", e);
        }
    }

    public void addRealEstate(String id, String realEstateId) {
        try {
            Client client = ClientRepository.findById(id);
            client.getRealEstateIds().add(RegexParser.parse("\"realEstateId\" : \"([^\\\"]+)\"\n", realEstateId));
            ClientRepository.save(client);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to add real estate", e);
        }
    }

}

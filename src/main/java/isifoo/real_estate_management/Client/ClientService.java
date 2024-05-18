package isifoo.real_estate_management.Client;

import com.mongodb.MongoException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void updateClient(String id, Client newClient) {
        try {
            Client client = ClientRepository.findById(id);

            if (client == null) {
                throw new RuntimeException("Client not found");
            }

            if (newClient.getName() != null) {
                client.setName(newClient.getName());
            }
            if (newClient.getEmail() != null) {
                client.setEmail(newClient.getEmail());
            }
            if (newClient.getPhone() != null) {
                client.setPhone(newClient.getPhone());
            }
            if (newClient.getCity() != null) {
                client.setCity(newClient.getCity());
            }
            if (newClient.getClientType() != null) {
                client.setClientType(newClient.getClientType());
            }

            ClientRepository.save(client);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to update client", e);
        }
    }

    public void addRealEstate(String id, String realEstateId) {
        try {
            Client client = ClientRepository.findById(id);
            client.getRealEstateIds().add(realEstateId);
            ClientRepository.save(client);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to add real estate", e);
        }
    }

    public void addTransaction(String id, String transactionId) {
        try {
            Client client = ClientRepository.findById(id);
            client.getTransactionIds().add(transactionId);
            ClientRepository.save(client);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to add transaction", e);
        }
    }

}

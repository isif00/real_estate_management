package isifoo.real_estate_management.Client;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, Long> {
    Client findById(String id);
    void deleteById(String id);
}

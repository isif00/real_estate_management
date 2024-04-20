package isifoo.real_estate_management.Transaction;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository  extends MongoRepository<Transaction, Long>{
}

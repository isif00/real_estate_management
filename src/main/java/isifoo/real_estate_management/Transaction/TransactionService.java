package isifoo.real_estate_management.Transaction;

import com.mongodb.MongoException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository TransactionRepository;

    public List<Transaction> getTransactions() {
        try {
            return TransactionRepository.findAll();
        } catch (MongoException e) {
            throw new RuntimeException("Failed to get real estates", e);
        }
    }

    public void addTransaction(Transaction transaction) {
        try {
            TransactionRepository.insert(transaction);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to add transaction", e);
        }
    }

    public void deleteTransaction(String id) {
        try {
            TransactionRepository.deleteById(id);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to delete transaction", e);
        }
    }

    public Transaction getTransaction(String id) {
        try {
            return TransactionRepository.findById(id);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to get transaction", e);
        }
    }

}

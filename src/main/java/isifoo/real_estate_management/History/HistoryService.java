package isifoo.real_estate_management.History;


import com.mongodb.MongoException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;

    public void saveHistory(History history) {
        historyRepository.save(history);
    }

    public List<History> getHistories() {
        return historyRepository.findAll();
    }

    public void deleteHistories() {
        historyRepository.deleteAll();
    }

    public History getHistory(String id) {
        return historyRepository.findById(id);
    }

    public void updateClientHistory(String id, History newHistory) {
        try {
            History history = historyRepository.findById(id);

            if (newHistory.getNumberOfTransactionsPerMonth() != null && !newHistory.getNumberOfTransactionsPerMonth().isEmpty()) {
                history.setNumberOfTransactionsPerMonth(newHistory.getNumberOfTransactionsPerMonth());
            }
            historyRepository.save(history);

        } catch (MongoException e) {
            throw new RuntimeException("Failed to update history", e);
        }
    }
}

package isifoo.real_estate_management.History;


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

    public void updateHistory(History history) {
        historyRepository.save(history);
    }
}

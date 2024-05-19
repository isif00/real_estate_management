package isifoo.real_estate_management.History;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/history")
@AllArgsConstructor
public class HistoryController {
    private final HistoryService historyService;

    @GetMapping("/all")
    public List<History> getHistories() {
        return historyService.getHistories();
    }

    @PostMapping(value = "/add")
    public String addHistory(@RequestBody History history) {
        historyService.saveHistory(history);
        return history.toString();
    }

    @PutMapping(value = "/update")
    public String updateHistory(@RequestBody History history) {
        historyService.updateHistory(history);
        return history.toString();
    }

    @DeleteMapping(value = "/delete")
    public String deleteHistories() {
        historyService.deleteHistories();
        return "Histories deleted successfully";
    }

}

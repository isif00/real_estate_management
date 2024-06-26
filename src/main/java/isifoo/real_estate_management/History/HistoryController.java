package isifoo.real_estate_management.History;


import isifoo.real_estate_management.RealEstate.RealEstate;
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

    @PutMapping(value = "/update/{id}")
    public String updateClientHistory(@PathVariable String id, @RequestBody History newHistory) {
        historyService.updateClientHistory(id, newHistory);
        return "Client History updated successfully";
    }

    @GetMapping(value = "/get-history/{id}")
    public History getHistory(@PathVariable String id) {
        return historyService.getHistory(id);
    }

    @DeleteMapping(value = "/delete")
    public String deleteHistories() {
        historyService.deleteHistories();
        return "Histories deleted successfully";
    }
}

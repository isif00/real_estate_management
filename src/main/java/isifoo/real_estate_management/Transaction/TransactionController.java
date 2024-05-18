package isifoo.real_estate_management.Transaction;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
@AllArgsConstructor
public class TransactionController {
    private final TransactionService TransactionService;

    @GetMapping("/all")
    public List<Transaction> getTransactions() {
        return TransactionService.getTransactions();
    }

    @PostMapping(value = "/add")
    public String addTransaction(@RequestBody Transaction transaction) {
        TransactionService.addTransaction(transaction);
        return transaction.getId();
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTransaction(@PathVariable String id) {
        TransactionService.deleteTransaction(id);
        return "Transaction deleted successfully";
    }

    @GetMapping(value = "/get-transaction/{id}")
    public Transaction getTransaction(@PathVariable String id) {
        return TransactionService.getTransaction(id);
    }
}

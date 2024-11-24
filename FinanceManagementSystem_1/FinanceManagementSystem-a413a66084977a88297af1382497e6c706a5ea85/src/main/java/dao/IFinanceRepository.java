package dao;

import entity.User;
import entity.Expense;
import entity.ExpenseCategory;

import java.util.List;

public interface IFinanceRepository {
    boolean createUser(User user);
    boolean createExpense(Expense expense);
    boolean deleteUser(int userId);
    boolean deleteExpense(int expenseId);
    List<Expense> getAllExpenses(int userId);
    boolean updateExpense(int expenseId, Expense expense);

}

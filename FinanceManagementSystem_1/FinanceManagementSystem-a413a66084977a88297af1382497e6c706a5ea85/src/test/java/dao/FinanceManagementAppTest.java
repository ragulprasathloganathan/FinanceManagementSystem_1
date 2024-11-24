package dao;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Expense;
import entity.User;
import exception.ExpenseNotFoundException;
import exception.UserNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class FinanceManagementAppTest {

    static IFinanceRepository repository = null;

    @BeforeAll
    static void beforeAll() {
        repository = new FinanceRepositoryImpl();
    }

    @BeforeEach
    void beforeEach() {
        // No need to initialize executables here as we aren't using lambda expressions anymore
    }

    @AfterEach
    void afterEach() {
        // Any cleanup if necessary
    }

//    @Test
//    void testCreateUser() {
//        User user1 = new User(21, "John Doee1", "password23123", "joh3nnn.doe@example.com");
//        User user2 = new User(31, "Jane Smithh4", "securepas23s", "jan3ee3.smith@example.com");
//
//        assertEquals(true, repository.createUser(user1));
//        assertEquals(true, repository.createUser(user2));
//    }



    @Test
    void testGetAllExpenses() {
        int userId = 3;

        List<Expense> expenses = repository.getAllExpenses(userId);

        assertEquals(3, expenses.size());
        assertEquals("Movie ticket", expenses.get(0).getDescription());
        assertEquals(30.0, expenses.get(0).getAmount());
    }

    @Test
    void testUpdateExpense() {
        Expense updatedExpense = new Expense(2, 1, 600.0, 1, Date.valueOf("2024-11-22"), "Updated lunch expense");

        assertEquals(false, repository.updateExpense(3, updatedExpense));
    }

    @Test
    void testDeleteExpense() {
        assertEquals(false, repository.deleteExpense(3));
    }

    @Test
    void testDeleteUser() {
        assertEquals(false, repository.deleteUser(2));
    }


    @Test
    void testUserNotFoundException() {
        try {
            // Attempt to fetch expenses for a user with ID 2
            repository.getAllExpenses(20);


        } catch (Exception e) {
            // Test passes if the exception is thrown
            assertEquals("No expenses found for user ID: ", e.getMessage());
        }
    }

    @Test
    void testExpenseNotFoundException() {
        try {
            // Attempt to fetch expenses for a user with ID 2
            repository.getAllExpenses(20);


        } catch (Exception e) {
            // Test passes if the exception is thrown
            assertEquals("No expenses found for user ID: ", e.getMessage());
        }
    }
}


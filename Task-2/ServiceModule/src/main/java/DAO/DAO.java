package DAO;

import java.util.ArrayList;

public interface DAO {
    Receiver getReceiver (int id);
    ArrayList<Receiver> getReceivers();
    Expense getExpense (int id);
    ArrayList<Expense> getExpenses();
    int addReceiver (Receiver receiver);
    void addExpense (Expense expense);
}

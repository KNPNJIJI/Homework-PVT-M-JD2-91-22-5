package mainModule;

import DAO.DAOImpl;
import DAO.Expense;
import DAO.Receiver;
import dbService.DbSerice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        int receiverId;
        // args[0] - date, args[1]) - paymentReceiver, args[2] - amount
        checkInteger(args[0]);
        checkLengthData(args[0]);
        receiverId = checkReceiver(args[1]);
        checkDouble(args[2]);

        // задание 7
        Expense expense = new Expense();
        expense.setPay_date(args[0]);
        expense.setReceiver(receiverId);
        expense.setAmount(Double.parseDouble(args[2]));

        DAOImpl daoImpl = DAOImpl.getInstance();
        daoImpl.addExpense(expense);

        DbSerice dbService = new DbSerice();
        try {
            // Вывод вставленных строк (задание 4, 5)
            ResultSet result = dbService.GetExpenditure();
            System.out.println("|" + "id" +"  |\t"
                    + "pay_date" +"\t|\t"
                    + "payment_receiver" +"|\t"
                    + "amount");

            while (result.next()) {
                System.out.println("|\t" + result.getString("id") +"|\t"
                        + result.getString("pay_date") +"\t|\t\t\t"
                        + result.getString("payment_receiver") +"\t\t|\t"
                        + result.getString("amount"));
            }


            // Вывод список получателей платежей, и сумму платежей по каждому из них;
            System.out.println("Вывод список получателей платежей, и сумму платежей по каждому из них");
            result = dbService.GetSumToReceivers();
            System.out.println("|" + "payment_receiver" +"|\t"
                    + "Sum");

            while (result.next()) {
                System.out.println("|\t" +  result.getString("payment_receiver") +"\t\t\t |\t"
                        + result.getString("Sum"));
            }

            // вывести сумму платежей за тот день, когда был наибольший платеж;
            System.out.println("Вывести сумму платежей за тот день, когда был наибольший платеж");
            result = dbService.GetMaxSumFromDay();
            System.out.println("|" + "pay_date" +"\t\t|\t"
                    + "Sum");

            while (result.next()) {
                System.out.println("|\t" +  result.getString("pay_date") +"\t|\t"
                        + result.getString("Sum"));
            }

            // вывести наибольший платеж за тот день, когда сумма платежей была наибольшей.
            System.out.println("Вывести наибольший платеж за тот день, когда сумма платежей была наибольшей.");
            result = dbService.GetDayMaxPay();
            System.out.println("|" + "pay_date" +"\t\t|\t"
                    + "MAX amount");

            while (result.next()) {
                System.out.println("|\t" +  result.getString("pay_date") +"\t|\t"
                        + result.getString("AmMAX"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkLengthData(String pay_date) {
        char[] ch = pay_date.toCharArray();
        if (ch.length != 8) {
            System.out.println("Некорректно задана дата платежа, " +
                    "введите корректную дату в формате ггггммдд: ");
            String payDate = new Scanner(System.in).nextLine();
            checkInteger(payDate);

            return checkLengthData(payDate);
        } else {
            return true;
        }
    }

    public static void checkInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Некорректно задана дата платежа (" + input +
                    "). Введите корректную дату в формате ггггммдд: ");
            String pay_date = new Scanner(System.in).nextLine();
            checkInteger(pay_date);
        }
    }

    public static void checkDouble(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Некорректно задана сумма платежа (" + input +
                    "). Введите корректную сумму: ");
            String pay_date = new Scanner(System.in).nextLine();
            checkDouble(pay_date);
        }
    }

    public static int checkReceiver(String inputReceiver) {
        // проверить в bd наличие такого receiver
        // если нет такого receiver.id будет = -1
        DAOImpl daoImpl = DAOImpl.getInstance();
        Receiver receiver = daoImpl.getReceiver(inputReceiver);   // args[1]
        if (receiver.getId() == -1){
            return daoImpl.addReceiver(receiver);
        }
        return receiver.getId();
    }
}

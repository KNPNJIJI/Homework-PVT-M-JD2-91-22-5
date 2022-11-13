package DAO;

import dbService.MysqlJdbcDataSource;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOImpl implements DAO {
    private static DAOImpl instance;
    static Connection mysqlConnection;
    static MysqlJdbcDataSource mysqlJdbcDataSource = new MysqlJdbcDataSource();
    private DAOImpl() {}

    public static DAOImpl getInstance() {
        if (instance == null){
            instance = new DAOImpl();
        }
        return instance;
    }

    @SneakyThrows
    @Override
    public Receiver getReceiver(int id) {
        mysqlConnection = mysqlJdbcDataSource.getConnection();
        Receiver receiver = new Receiver();

        ResultSet resultSet = mysqlConnection.createStatement().executeQuery(
                "SELECT * FROM accounting.receiver" +
                        "WHERE id='" + id + "' "
        );

        if (!resultSet.next()) {
            receiver.setId(-1);
            return receiver;
        };

        receiver.setId(resultSet.getInt("id"));
        receiver.setName(resultSet.getString("name"));
        return  receiver;
    }

    @SneakyThrows
    static public Receiver getReceiver(String name) {
        mysqlConnection = mysqlJdbcDataSource.getConnection();
        Receiver receiver = new Receiver();

        ResultSet resultSet = mysqlConnection.createStatement().executeQuery(
                "SELECT * " +
                        "FROM accounting.receiver " +
                        "WHERE name='" +name+ "'"
        );

        if (!resultSet.next()) {
            receiver.setId(-1);
            receiver.setName(name);
            return receiver;
        };

        receiver.setId(resultSet.getInt("id"));
        receiver.setName(resultSet.getString("name"));
        return  receiver;
    }

    @SneakyThrows
    @Override
    public ArrayList<Receiver> getReceivers() {
        mysqlConnection = mysqlJdbcDataSource.getConnection();
        ArrayList<Receiver> receivers = new ArrayList<>();

        ResultSet resultSet = mysqlConnection.createStatement().executeQuery(
                "SELECT * FROM accounting.receiver");

        while (resultSet.next()) {
            Receiver receiver = new Receiver();
            receiver.setId(resultSet.getInt("id"));
            receiver.setName(resultSet.getString("name"));
            receivers.add(receiver);
        }

        return receivers;
    }

    @SneakyThrows
    @Override
    public Expense getExpense(int id) {
        mysqlConnection = mysqlJdbcDataSource.getConnection();
        Expense expense = new Expense();

        ResultSet resultSet = mysqlConnection.createStatement().executeQuery(
                "SELECT * FROM accounting.expenditure" +
                        "WHERE id='" + id + "' "
        );

        expense.setId(resultSet.getInt("id"));
        expense.setPay_date(resultSet.getString("pay_date"));
        expense.setReceiver(resultSet.getInt("payment_receiver"));
        expense.setAmount(resultSet.getDouble("amount"));

        return expense;
    }

    @SneakyThrows
    @Override
    public ArrayList<Expense> getExpenses() {
        mysqlConnection = mysqlJdbcDataSource.getConnection();
        ArrayList<Expense> expenses = new ArrayList<>();

        ResultSet resultSet = mysqlConnection.createStatement().executeQuery(
                "SELECT * FROM accounting.expenditure");

        while (resultSet.next()) { //args[0] - date, args[1]) - paymentReceiver, args[2] - amount
            Expense expense = new Expense();
            expense.setId(resultSet.getInt("id"));
            expense.setPay_date(resultSet.getString("pay_date"));
            expense.setReceiver(resultSet.getInt("payment_receiver"));
            expense.setAmount(resultSet.getDouble("amount"));

            expenses.add(expense);
        }

        return expenses;
    }

    @SneakyThrows
    @Override
    public void addExpense(Expense expense) {
        mysqlConnection = mysqlJdbcDataSource.getConnection();

        String sql = "INSERT INTO `expenditure`" +
                "(`id`," +
                "`pay_date`," +
                "`payment_receiver`," +
                "`amount`)" +
                "VALUES" +
                "(null," +
                "?," + // date
                "?," + // paymentReceiver
                "?)";  // amount

        PreparedStatement preparedStatement = mysqlConnection.prepareStatement(sql);
        preparedStatement.setString(1, expense.getPay_date());
        preparedStatement.setString(2, Integer.toString(expense.getReceiver()));
        preparedStatement.setString(3, Double.toString(expense.getAmount()));

        preparedStatement.executeUpdate();
    }

    @SneakyThrows
    @Override
    public int addReceiver(Receiver receiver) {
        mysqlConnection = mysqlJdbcDataSource.getConnection();

        String sql = "INSERT INTO `receiver`" +
                "(`id`, " +
                "`name`) " +
                "VALUES " +
                "(null," +
                "?)";  // name

        PreparedStatement preparedStatement = mysqlConnection.prepareStatement(sql);
        preparedStatement.setString(1, receiver.getName());
        preparedStatement.executeUpdate();

        receiver = getReceiver(receiver.getName());
        return receiver.getId();
    }
}

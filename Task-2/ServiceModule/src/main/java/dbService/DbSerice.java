package dbService;

import lombok.SneakyThrows;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbSerice {

    static Connection mysqlConnection;

    static MysqlJdbcDataSource mysqlJdbcDataSource = new MysqlJdbcDataSource();

    @SneakyThrows
    public static void setExpenditure( String date, String paymentReceiver, String amount) {

        mysqlConnection = mysqlJdbcDataSource.getConnection();
// задание 5
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
        preparedStatement.setString(1, date);
        preparedStatement.setString(2, paymentReceiver);
        preparedStatement.setString(3, amount);

        preparedStatement.executeUpdate();
    }

    @SneakyThrows
    public static ResultSet GetExpenditure(){
        mysqlConnection = mysqlJdbcDataSource.getConnection();

        return  mysqlConnection.createStatement().executeQuery(
                "SELECT * FROM accounting.expenditure"
        );
    }

    @SneakyThrows
    public static ResultSet GetSumToReceivers(){
        mysqlConnection = mysqlJdbcDataSource.getConnection();

        return  mysqlConnection.createStatement().executeQuery(
                "SELECT `payment_receiver`, sum(accounting.expenditure.amount) AS Sum " +
                        "FROM accounting.expenditure " +
                        "group by `payment_receiver`"
        );
    }

    @SneakyThrows
    public static ResultSet GetMaxSumFromDay(){
        mysqlConnection = mysqlJdbcDataSource.getConnection();

        return  mysqlConnection.createStatement().executeQuery(
                "SELECT `pay_date`, sum(accounting.expenditure.amount) AS Sum " +
                    "FROM accounting.expenditure " +
                    "WHERE `pay_date` IN (SELECT `pay_date` FROM accounting.expenditure " +
                                        "WHERE `amount` IN (SELECT MAX(`amount`) FROM accounting.expenditure)) " +
                    "group by `pay_date`;"
        );
    }

    @SneakyThrows
    public static ResultSet GetDayMaxPay(){
        mysqlConnection = mysqlJdbcDataSource.getConnection();

        return  mysqlConnection.createStatement().executeQuery(
                "SELECT pay1.`pay_date`, MAX(`amount`) AS AmMAX " +
                    "FROM accounting.expenditure AS pay1 " +
                    "WHERE pay1.`pay_date` = " +
                    "(" +
                        "SELECT `pay_date` " +
                        "FROM accounting.expenditure " +
                        "group by `pay_date` " +
                        "    order by sum(amount) desc " +
                        "    limit 1 " +
                    ")"
        );
    }
}

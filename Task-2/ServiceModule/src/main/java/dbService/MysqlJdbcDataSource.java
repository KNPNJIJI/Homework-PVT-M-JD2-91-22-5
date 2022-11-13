package dbService;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static dbService.DataConfig.JDBC_PROPERTIES_FILE_NAME;

public class MysqlJdbcDataSource {

    private final String propertyFileName;

    @SneakyThrows
    public MysqlJdbcDataSource() {
        this(JDBC_PROPERTIES_FILE_NAME);
    }

    @SneakyThrows
    public MysqlJdbcDataSource(String propertyFileName) {
        this.propertyFileName = propertyFileName;
        Class.forName(DataConfig.getJdbcProperties(propertyFileName).getProperty("driver"));
    }

    @SneakyThrows
    public Connection getConnection() {
        Properties jdbcProperties = DataConfig.getJdbcProperties(propertyFileName);
        Connection connection = DriverManager.getConnection(
                jdbcProperties.getProperty("url"),
                jdbcProperties.getProperty("username"),
                jdbcProperties.getProperty("password"));

        connection.createStatement().executeUpdate(
                "CREATE TABLE if not exists `expenditure` (" +
                        "`id` INT NOT NULL AUTO_INCREMENT, " +
                        "`pay_date` DATE NULL, " +
                        "`payment_receiver` INT NULL, " +
                        "`amount` DECIMAL NULL, " +
                        " PRIMARY KEY (`id`)) "
        );
        connection.createStatement().executeUpdate(
                "CREATE TABLE if not exists `receiver` ( " +
                        "  `id` INT NOT NULL AUTO_INCREMENT, " +
                        "  `name` VARCHAR(255) NULL, " +
                        "  PRIMARY KEY (`id`)); "
        );
        return connection;
    }
}

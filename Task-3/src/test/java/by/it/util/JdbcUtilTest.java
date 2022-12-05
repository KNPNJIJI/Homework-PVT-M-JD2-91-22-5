package by.it.util;

import by.it.loader.PersonLoader;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtilTest {
    private static Properties jdbcProperties = new Properties();

    @SneakyThrows
    public Connection getConnection() {
        jdbcProperties.load(PersonLoader.class
                    .getClassLoader()
                    .getResourceAsStream("jpadb_test.jdbc.properties"));

        return DriverManager.getConnection(
                jdbcProperties.getProperty("url"),
                jdbcProperties.getProperty("username"),
                jdbcProperties.getProperty("password")
        );
    }

}

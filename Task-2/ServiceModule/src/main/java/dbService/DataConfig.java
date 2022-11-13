package dbService;

import lombok.SneakyThrows;
import java.util.Properties;

public class DataConfig {

    public static final String JDBC_PROPERTIES_FILE_NAME = "jdbc.properties";

    private static Properties jdbcProperties;

    @SneakyThrows
    public static Properties getJdbcProperties(String propertyFileName) {
        if (jdbcProperties == null) {
            jdbcProperties = new Properties();
            jdbcProperties.load(DataConfig.class
                    .getClassLoader()
                    .getResourceAsStream(propertyFileName));
        }
        return jdbcProperties;
    }
}

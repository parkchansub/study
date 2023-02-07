package tobyspring.config.autoconfig;


@MyAutoConfiguration
@ConditionalMyOnClass("org.springFramework.jdbc.JdbcOperations")
public class DataSoorceConfig {

}

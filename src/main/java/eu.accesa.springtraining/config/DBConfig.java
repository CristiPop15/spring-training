package eu.accesa.springtraining.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@MapperScan(value = {"eu.accesa.springtraining.db"}, sqlSessionFactoryRef = "postgreSqlSessionFactory")
public class DBConfig {

  private static final Logger log = LoggerFactory.getLogger(DBConfig.class);

  @Value("${db.url}")
  String dbUrl;

  @Value("${db.user}")
  String dbUser;

  @Value("${db.password}")
  String dbPass;

  @Value("${db.driver}")
  String dbDriver;

  @Value("${db.pool.size}")
  Integer maxPoolSize;

  private HikariDataSource hikariDataSource = new HikariDataSource();

  private SqlSessionTemplate sessionTemplate;

  @PostConstruct
  public void init() {
    hikariDataSource.setDriverClassName(dbDriver);
    hikariDataSource.setJdbcUrl(dbUrl);
    hikariDataSource.setConnectionTestQuery("select 1");
    hikariDataSource.setUsername(dbUser);
    hikariDataSource.setPassword(dbPass);
    hikariDataSource.setMaximumPoolSize(maxPoolSize);
  }

  @Bean(name = "postgreSqlDataSource")
  @Primary
  @ConditionalOnProperty(name = "dblog.enabled", havingValue = "false", matchIfMissing = true)
  public DataSource getPostgresDataSource() {
    return hikariDataSource;
  }

  @Bean(name = "postgreSqlSessionFactory")
  @Primary
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(getPostgresDataSource());
    return sessionFactory.getObject();
  }

  @PreDestroy
  public void cleanup() {
    if (sessionTemplate != null) {
      sessionTemplate.close();
    }
  }
}
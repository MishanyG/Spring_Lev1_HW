package HomeWork_4.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("HomeWork_4.Repository")
@EnableTransactionManagement
@ComponentScan("HomeWork_4")
public class SpringDataConfig {
    @Bean(name="dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Spring_L1HW4");
        dataSource.setUsername("postgres");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setPassword("mikha");
        return dataSource;
    }

    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManager() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(getDataSource());
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setPackagesToScan("HomeWork_4");
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
        jpaProperties.put("hibernate.max_fetch_depth", 3);
        // Максимальное количество строк, возвращаемых за один запрос из БД
        jpaProperties.put("hibernate.jdbc.fetch_size", 50);
        // Максимальное количество запросов при использовании пакетных операций
        jpaProperties.put("hibernate.jdbc.batch_size", 10);
        jpaProperties.put("hibernate.show_sql", true);
        factory.setJpaProperties(jpaProperties);
        return factory;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactory);
        return tm;
    }
}
package mdu.crud.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import mdu.crud.dao.CarBrandDAO;
import mdu.crud.dao.CarModelDAO;
import mdu.crud.dao.jpa.CarBrandDAOJpaImpl;
import mdu.crud.dao.jpa.CarModelDAOJpaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
@ComponentScan
@EnableTransactionManagement
public class JpaConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory =  new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setPackagesToScan(new String[] {"mdu.crud.model"});
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        return entityManagerFactory;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager jpaTransactionManager(EntityManagerFactory emf) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }

    @Bean
    public CarBrandDAO getCarBrandJpaDAO() {
        return new CarBrandDAOJpaImpl();
    }

    @Bean
    public CarModelDAO getCarModelJpaDAO() {
        return new CarModelDAOJpaImpl();
    }
}
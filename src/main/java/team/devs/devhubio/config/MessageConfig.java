package team.devs.devhubio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import team.devs.devhubio.repository.*;
import team.devs.devhubio.service.PrivateMessageService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class MessageConfig {

    private final DataSource dataSource;
    private final EntityManager em;

    public MessageConfig(DataSource dataSource, EntityManager em){
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public PrivateMessageRepository privateMessageRepository(){
        return new JpaPrivateMessageRepository(em);
    }

    @Bean
    public PrivateMessageService privateMessageService() {
        return new PrivateMessageService(privateMessageRepository());
    }
}

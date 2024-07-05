package team.devs.devhubio.service;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import team.devs.devhubio.repository.JpaPrivateMessageRepository;
import team.devs.devhubio.repository.PrivateMessageRepository;

import javax.sql.DataSource;

public class MessageConfig {

    private EntityManager em;

    public MessageConfig(EntityManager em){
        this.em = em;
    }

    @Bean
    public PrivateMessageRepository privateMessageRepository(){
        return new JpaPrivateMessageRepository(em);
    }
}

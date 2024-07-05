package team.devs.devhubio.repository;

import jakarta.persistence.EntityManager;
import team.devs.devhubio.model.PrivateMessage;

import java.util.List;
import java.util.Optional;

public interface PrivateMessageRepository {

    PrivateMessage send(PrivateMessage privateMessage);
    Optional<PrivateMessage> findById(Long id);
    Optional<PrivateMessage> findByNameR(String name);
    Optional<PrivateMessage> findByNameS(String name);
    List<PrivateMessage> findAll();
}

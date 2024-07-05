package team.devs.devhubio.repository;

import team.devs.devhubio.model.PrivateMessage;

import java.util.List;
import java.util.Optional;

public interface PrivateMessageRepository {

    PrivateMessage save(PrivateMessage privateMessage);
    Optional<PrivateMessage> findById(Long id);
    List<PrivateMessage> findByReceiveId(String receiveid);
    List<PrivateMessage> findBySendId(String sendid);
    List<PrivateMessage> findAll();
}

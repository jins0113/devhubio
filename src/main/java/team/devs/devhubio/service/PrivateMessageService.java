package team.devs.devhubio.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.devs.devhubio.model.PrivateMessage;
import team.devs.devhubio.repository.JpaPrivateMessageRepository;
import team.devs.devhubio.repository.PrivateMessageRepository;

import java.util.List;
import java.util.Optional;

public class PrivateMessageService {

    private final PrivateMessageRepository privateMessageRepository;

    public PrivateMessageService(PrivateMessageRepository privateMessageRepository) {
        this.privateMessageRepository = privateMessageRepository;
    }

    // 쪽지 보내기
    @Transactional
    public Long sendMessage(PrivateMessage privateMessage){
        privateMessageRepository.save(privateMessage);
        return privateMessage.getId();
    }

    // 받은 쪽지함 조회
    public List<PrivateMessage> receiveBox (String receiveid) {
        return privateMessageRepository.findByReceiveId(receiveid);
    }
    // 보낸 쪽지함 조회
    public List<PrivateMessage> sendBox (String sendid) {
        return privateMessageRepository.findBySendId(sendid);
    }

    // 쪽지 내용 조회
    public Optional<PrivateMessage> messageView (Long id) {
        return privateMessageRepository.findById(id);
    }

    // 쪽지 삭제
    public Optional<PrivateMessage> messageDel (Long id, String myid) {

        Optional<PrivateMessage> Message = privateMessageRepository.findById(id);

        Message.ifPresent(message -> {
            String receiveid = message.getReceiveid();
            String sendid = message.getSendid();

            if(myid.equals(receiveid)) {message.setReceivedyn("N");}
            if(myid.equals(sendid)) {message.setSenddyn("N");}
        });
        
        return Message;
    }

    // 쪽지 전체 조회 (관리자)
    public List<PrivateMessage> messageAll() {
        return privateMessageRepository.findAll();
    }

    //
}

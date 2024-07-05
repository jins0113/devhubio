package team.devs.devhubio.repository;

import team.devs.devhubio.model.PrivateMessage;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaPrivateMessageRepository implements PrivateMessageRepository{

    private final EntityManager em;

    public JpaPrivateMessageRepository(EntityManager em){
        this.em = em;
    }


    @Override
    public PrivateMessage save(PrivateMessage privateMessage) {
        em.persist(privateMessage);
        return privateMessage;
    }

    @Override
    public Optional<PrivateMessage> findById(Long id) {
        PrivateMessage privateMessage = em.find(PrivateMessage.class, id);
        return Optional.ofNullable(privateMessage);
    }

    @Override
    public List<PrivateMessage> findBySendId(String sendid) {
        return em.createQuery("select m from PrivateMessage m where m.sendid = sendid and m.senddyn = 'Y'", PrivateMessage.class)
                .setParameter("sendid", sendid)
                .getResultList();
    }

    @Override
    public List<PrivateMessage> findByReceiveId(String receiveid) {
        return em.createQuery("select m from PrivateMessage m where m.receiveid = :receiveid and m.receivedyn = 'Y'", PrivateMessage.class)
                .setParameter("receiveid", receiveid)
                .getResultList();
    }

    @Override
    public List<PrivateMessage> findAll() {
        return em.createQuery("select m from PrivateMessage m", PrivateMessage.class)
                .getResultList();
    }
}

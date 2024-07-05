package team.devs.devhubio.repository;

import jakarta.persistence.EntityManager;
import team.devs.devhubio.model.PrivateMessage;

import java.util.List;
import java.util.Optional;

public class JpaPrivateMessageRepository implements PrivateMessageRepository{

    private final EntityManager em;

    public JpaPrivateMessageRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public PrivateMessage send(PrivateMessage privateMessage) {
        em.persist(privateMessage);
        return privateMessage;
    }

    @Override
    public Optional<PrivateMessage> findById(Long id) {
        PrivateMessage privateMessage = em.find(PrivateMessage.class, id);
        return Optional.ofNullable(privateMessage);
    }

    @Override
    public Optional<PrivateMessage> findByNameR(String name) {
        return em.createQuery("select m from PrivateMessage m where m.receiveid = name", PrivateMessage.class)
                .setParameter("sendid", name)
                .getResultList().stream().findAny();
    }

    @Override
    public Optional<PrivateMessage> findByNameS(String name) {
        return em.createQuery("select m from PrivateMessage m where m.receiveid = name", PrivateMessage.class)
                .setParameter("receiveid", name)
                .getResultList().stream().findAny();

    }

    @Override
    public List<PrivateMessage> findAll() {
        return em.createQuery("select m from PrivateMessage m", PrivateMessage.class)
                .getResultList();
    }
}

package team.devs.devhubio.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class PrivateMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "sendid")
    private String sendid;

    @Column(name = "receiveid")
    private String receiveid;

    @Column(name = "senddelyn")
    private String senddelyn;

    @Column(name = "redeivedelyn")
    private String redeivedelyn;

    @Column(name = "date")
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendid() {
        return sendid;
    }

    public void setSendid(String sendid) {
        this.sendid = sendid;
    }

    public String getReceiveid() {
        return receiveid;
    }

    public void setReceiveid(String receiveid) {
        this.receiveid = receiveid;
    }

    public String getSenddelyn() {
        return senddelyn;
    }

    public void setSenddelyn(String senddelyn) {
        this.senddelyn = senddelyn;
    }

    public String getRedeivedelyn() {
        return redeivedelyn;
    }

    public void setRedeivedelyn(String redeivedelyn) {
        this.redeivedelyn = redeivedelyn;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

package team.devs.devhubio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
public class PrivateMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String message;
    private String sendid;
    private String receiveid;

    // 기본값 자동 세팅
    private String senddyn;
    private String receivedyn;
    private String date;

    @PrePersist
    public void baseSet() {
        this.senddyn = "Y";
        this.receivedyn = "Y";

    }
}

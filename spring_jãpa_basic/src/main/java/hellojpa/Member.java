package hellojpa;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String username;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
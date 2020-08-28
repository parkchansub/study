package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String name;

    /*@Column(name="TEAM_ID")
    private Long teamId;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TEAM_ID")
    private Team team;

    private Period workPeriod;

    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name="FAVORITE_FOOD" , joinColumns =
    @JoinColumn(name = "MEMBER_ID")
    )
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    /*@ElementCollection
    @CollectionTable(name="ADDRESS", joinColumns =
    @JoinColumn(name = "MEMBER_ID")
    )
    private List<Address> addresseHistory = new ArrayList<>();*/


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> ddresseHistory = new ArrayList<>();



    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

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

    public Team getTeam() {
        return team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);

    }
}

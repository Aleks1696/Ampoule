package com.web.domain;

import com.web.domain.types.HumanGender;
import org.aspectj.weaver.ast.Not;

import javax.persistence.*;
import java.util.List;

/**
 * created by Anton Platunov 12.01.2019 **/

// Поправил мапинг

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String email;
    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    private HumanGender gender;
    @Column
    private Integer birthday;
    @Column
    private Integer height;
    @Column
    private Integer weight;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "cards",targetEntity = Note.class)
    private List<Note> notes;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "cards", targetEntity = Doctor.class)
    private List<Doctor> doctors;

    public Card() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HumanGender getGender() {
        return gender;
    }

    public void setGender(HumanGender gender) {
        this.gender = gender;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", notes=").append(notes);
        sb.append(", doctors=").append(doctors);
        sb.append('}');
        return sb.toString();

    }
}

package com.web.domain;

import com.web.domain.types.HumanGender;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Controller;

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
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Enumerated(EnumType.STRING)
    private HumanGender gender;
    @Column(name="birthday")
    private Integer birthday;
    @Column(name="height")
    private Integer height;
    @Column(name="weight")
    private Integer weight;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "cards",targetEntity = Note.class)
    private List<Note> notes;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "cards", targetEntity = Doctor.class) //изменил на FetchType.Lazy. Нельзя в одном
    private List<Doctor> doctors;                                                        //классе два игоря. Ошибка: MultipleBagFetchException

    public Card() {
    }

    public Card(String email, String password, String name, String surname, HumanGender gender, Integer birthday, Integer height, Integer weight) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
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

package com.web.domain;

import com.web.domain.types.DoctorsType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * created by Anton Platunov 12.01.2019 **/

// Без мапинга - нужно добавить
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String email;
    @Column
    private String password;
    @Column
    private   String name;
    @Column
    private   String surname;
    @Enumerated(EnumType.STRING)
    private DoctorsType doctorsType;
    @Column
    private String phonenumber;   // может лучше сменить стринг на другой тип


    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Card.class)
    @JoinTable(name = "Doctor_Card",
            joinColumns = @JoinColumn(name = "doctors_ref_id", referencedColumnName = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "card_ref_id", referencedColumnName = "card_id"))
    private List<Card> cards= new ArrayList<Card>(); // список мед.карточек, сменить на <Cards>




    public Doctor() {
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

    public DoctorsType getDoctorsType() {
        return doctorsType;
    }

    public void setDoctorsType(DoctorsType doctorsType) {
        this.doctorsType = doctorsType;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Doctor{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", doctorsType=").append(doctorsType);
        sb.append(", phonenumber='").append(phonenumber).append('\'');
        sb.append(", cards=").append(cards);
        sb.append('}');
        return sb.toString();
    }
}

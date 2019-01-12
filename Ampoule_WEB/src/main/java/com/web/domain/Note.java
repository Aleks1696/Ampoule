package com.web.domain;

/**
 * created by Anton Platunov 12.01.2019 **/

import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// Без мапинга - нужно добавить

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @Column(name = "note_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Date date; // Не знаю как записывать правильно дату в БД
    @Column
    private Doctor doctor;
    @Column
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER,  targetEntity = Card.class)
    private List<Card> cards= new ArrayList<Card>(); //



    public Note() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Note{");
        sb.append("id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", doctor=").append(doctor);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", cards=").append(cards);
        sb.append('}');
        return sb.toString();
    }
}

package com.web.service;

import com.web.domain.Doctor;
import com.web.domain.Note;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface NoteService {
    Long create (Note note);
    Note getNote (Long id);
    void updateNote (Note note);
    void deleteNote (Long id);
    List<Note> findAllNotes();
    List<Note> findByDoctor(Doctor doctor);
    List<Note> findbyDate(Date date);
    List<Note> findbyDoctorAndDate(Doctor doctor , Date date);

}

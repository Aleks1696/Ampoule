package com.web.service;

import com.web.domain.Doctor;

import javax.print.Doc;
import java.util.List;

public interface DoctorService {

    Long create(Doctor note);

    Doctor getNote(Long id);

    void updateNote(Doctor doctor);

    void deleteNote(Doctor doctor);

    List<Doctor> findAllDoctors();




}

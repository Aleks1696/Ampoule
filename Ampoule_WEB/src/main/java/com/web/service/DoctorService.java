package com.web.service;

import com.web.domain.Doctor;

import javax.print.Doc;
import java.util.List;

public interface DoctorService {

    Long create(Doctor doctor);

    boolean doctorSingIn(String login, String password);

    Doctor getNote(Long id);

    void updateNote(Doctor doctor);

    void deleteNote(Long id);

    List<Doctor> findAllDoctors();




}

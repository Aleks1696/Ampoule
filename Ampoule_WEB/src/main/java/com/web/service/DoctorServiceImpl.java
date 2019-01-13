package com.web.service;

import com.web.dao.DoctorRepository;
import com.web.domain.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Long create(Doctor doctor) {
        return doctorRepository.saveAndFlush(doctor).getId();
    }

    public boolean doctorSingIn(String login, String password) {

        return false;
    }

    public Doctor getNote(Long id) {
        return doctorRepository.findByIdEquals(id);
    }

    public void updateNote(Doctor doctor) {
        doctorRepository.saveAndFlush(doctor);
    }

    public void deleteNote(Long id) {
doctorRepository.delete(id);
    }


    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }
}

package com.web.dao;

import com.web.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository  extends JpaRepository<Doctor, Long> {
    Doctor findByIdEquals(Long id);

}

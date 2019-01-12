package com.web.dao;

import com.web.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Note findByIdEquals(Long id);
}
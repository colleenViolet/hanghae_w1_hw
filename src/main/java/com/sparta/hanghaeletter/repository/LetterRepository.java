package com.sparta.hanghaeletter.repository;

import com.sparta.hanghaeletter.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LetterRepository extends JpaRepository<Letter, Long> {
    List<Letter> findAllByOrderByModifiedAtDesc();
    List<Letter> findAllByOrderByCreatedAtDesc();
}

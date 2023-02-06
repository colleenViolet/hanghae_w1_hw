package com.sparta.hanghaeletter.service;

import com.sparta.hanghaeletter.dto.LetterRequestDto;
import com.sparta.hanghaeletter.entity.Letter;
import com.sparta.hanghaeletter.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LetterService {

    private final LetterRepository letterRepository;

    @Transactional
    public Letter addLetter(LetterRequestDto letterRequestDto) {
        Letter letter = new Letter(letterRequestDto);
        letterRepository.save(letter);
        return letter;
    }
}

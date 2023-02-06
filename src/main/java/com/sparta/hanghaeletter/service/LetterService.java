package com.sparta.hanghaeletter.service;

import com.sparta.hanghaeletter.dto.LetterRequestDto;
import com.sparta.hanghaeletter.dto.LetterResponseDto;
import com.sparta.hanghaeletter.entity.Letter;
import com.sparta.hanghaeletter.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public List<LetterResponseDto> getLetter() {
        List<Letter> letter = letterRepository.findAllByOrderByCreatedAtDesc();
        List<LetterResponseDto> letterResponseDtos = letter.stream()
                .map(LetterResponseDto::new)
                .collect(Collectors.toList());
        return letterResponseDtos;
    }

    public LetterResponseDto getIdLetter(Long id) {
        Letter letter = letterRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당글이 없습니다."));
        return  new LetterResponseDto(letter);
    }

    @Transactional
    public String updatedLetter(Long id, LetterRequestDto letterRequestDto) {
        Letter letter = letterRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("글이 없습니다."));
        if(!letter.getPassword().equals(letterRequestDto.getPassword())){
            return "잘못된 비밀번호입니다.";
        }
        letter.update(letterRequestDto);
        return "수정완료";
    }

    public String deleteLetter(Long id, String password) {
        Letter letter = letterRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("등록된 글이 없습니다.")
        );
        if(!letter.getPassword().equals(password)){
            return "잘못된 비밀번호입니다.";
        }
        letterRepository.delete(letter);
        return "삭제완료";
    }
}

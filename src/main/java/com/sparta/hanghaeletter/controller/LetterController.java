package com.sparta.hanghaeletter.controller;

import com.sparta.hanghaeletter.dto.LetterRequestDto;
import com.sparta.hanghaeletter.dto.LetterResponseDto;
import com.sparta.hanghaeletter.entity.Letter;
import com.sparta.hanghaeletter.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LetterController {
        private  final LetterService letterService;

        @PostMapping("/api/add")
        public Letter addLetter(@RequestBody LetterRequestDto letterRequestDto){
                return letterService.addLetter(letterRequestDto);
        }

       @GetMapping("api/get")
        public List<LetterResponseDto> getLetter(){
                return letterService.getLetter();
       }

       @GetMapping("api/get/{id}")
        public LetterResponseDto getIdLetter(@PathVariable Long id){
            return letterService.getIdLetter(id);
       }

}

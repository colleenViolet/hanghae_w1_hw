package com.sparta.hanghaeletter.controller;

import com.sparta.hanghaeletter.dto.LetterRequestDto;
import com.sparta.hanghaeletter.entity.Letter;
import com.sparta.hanghaeletter.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LetterController {
        private  final LetterService letterService;

        @PostMapping("/api/add")
        public Letter addLetter(@RequestBody LetterRequestDto letterRequestDto){
                return letterService.addLetter(letterRequestDto);
        }




}

package com.sparta.hanghaeletter.dto;

import com.sparta.hanghaeletter.entity.Letter;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LetterResponseDto {
    private String title;
    private String userName;
    private String content;

    private LocalDateTime createdAt;

    public LetterResponseDto(Letter letter){
        this.title = letter.getTitle();
        this.userName = letter.getUserName();
        this.content = letter.getContent();
        this.createdAt = letter.getCreatedAt();
    }
}

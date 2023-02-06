package com.sparta.hanghaeletter.entity;

import com.sparta.hanghaeletter.dto.LetterRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Letter extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;

    public Letter(LetterRequestDto letterRequestDto) {
        this.title = letterRequestDto.getTitle();
        this.userName = letterRequestDto.getUserName();
        this.content = letterRequestDto.getContent();
        this.password = letterRequestDto.getPassword();
    }
}

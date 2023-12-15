package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class MemberForm {

    private Long id;
    private String mId;
    private String mPassword;
    private String mName;


    public Member toEntity() {
        return new Member(id, mId , mPassword, mName);
    }


}

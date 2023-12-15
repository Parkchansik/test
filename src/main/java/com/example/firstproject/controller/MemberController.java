package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/member/join")
    public String newMemberForm() {
        return "members/join";
    }

    @PostMapping("/member/create")
    public String create(MemberForm memberForm) {
        log.info(memberForm.toString());
        Member member = memberForm.toEntity();
        Member mSaved = memberRepository.save(member);
        return "redirect:/index";
    }
}

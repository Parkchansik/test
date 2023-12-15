package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity //해당클래스가 엔티티임을 선언, 클래스 필드를 바탕으로 DB테이블 생성
@Getter // 각 필드 값을 조회할 수 있는 GETTER 메소드 자동 생성
@ToString // 모든 필드를 출력할 수 있는 TOSTRING 메소드 자동생성
@AllArgsConstructor // 모든 필드를 매개변수로 갖는 생성자 자동 생성
@NoArgsConstructor // 매개변수가 아예 없는 기본 생성자 자동 생성
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id자동 생성
    private Long id;

    @Column
    private String mId;

    @Column
    private String mPassword;

    @Column
    private String mName;



}

package com.example.firstproject.entity;

import com.example.firstproject.dto.CommentDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Slf4j
@Entity //해당클래스가 엔티티임을 선언, 클래스 필드를 바탕으로 DB테이블 생성
@Getter // 각 필드 값을 조회할 수 있는 GETTER 메소드 자동 생성
@ToString // 모든 필드를 출력할 수 있는 TOSTRING 메소드 자동생성
@AllArgsConstructor // 모든 필드를 매개변수로 갖는 생성자 자동 생성
@NoArgsConstructor // 매개변수가 아예 없는 기본 생성자 자동 생성
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne  //  Comment 엔티티와Article 엔티티를 다대일 관계로 설정
    @JoinColumn(name="article_id")
    private Article article;

    @Column
    private String nickname;
    @Column
    private String body;

    @SneakyThrows
    public static Comment createComment(CommentDto dto, Article article) {

        log.info(" 1.article:{}",article.toString());
        log.info(" 1.dto:{}",dto.toString());
        //예외발생
        if (dto.getId() != null) {
            throw new IllegalAccessException("댓글 생성 실패! 댓글의 id가 없어야 합니다.");}
        if (dto.getArticleId() != article.getId()) {
            throw new IllegalAccessException("댓글 생성 실패! 댓글의 id가 잘못됐습니다.");}
        //엔티티생성 및 반환

        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );

    }

    @SneakyThrows
    public void patch(CommentDto dto) {
        //예외발생
        if (this.id != dto.getId()) {
            throw new IllegalAccessException("댓글 수정 실패! 잘못된 id가 입력되었습니다..");}
        //객체생성
        if (dto.getNickname() != null) {
            this.nickname = dto.getNickname();
        }
        if (dto.getBody() != null) {
            this.body = dto.getBody();
        }
    }
}

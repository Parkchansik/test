package com.example.firstproject.api;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CommentApiController {

    @Autowired
    private CommentService commenService;
    //1.댓글조회
    @GetMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long articleId) {
        // 서비스에 위임
        List<CommentDto> dtos = commenService.comments(articleId);
        // 결과응답
        return ResponseEntity.status(HttpStatus.OK).body(dtos);

    }
    //2.댓글생성
    @PostMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable Long articleId,@RequestBody CommentDto dto) {
        log.info(" 1.articleId:{}",articleId);
        log.info(" 1.CommentDto:{}",dto.toString());
        // 서비스에 위임
        CommentDto createdDto = commenService.create(articleId, dto);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    //3.댓글수정
    @PatchMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> update(@PathVariable Long id , @RequestBody CommentDto dto) {

        //서비스위임
        CommentDto updatedDto = commenService.update(id,dto);
        //결과응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    //4.댓글삭제
    @DeleteMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long id) {

        //서비스 위임
        CommentDto deletedDto = commenService.delete(id);
        //결과응답
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }

}

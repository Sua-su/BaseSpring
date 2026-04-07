package me.su.springdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.su.springdeveloper.dao.Article;
import me.su.springdeveloper.dto.AddArticleRequest;
import me.su.springdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest addArticleRequest) {
        // 수정: 변수명을 addArticleRequest로 일치시킴
        Article savedArticle = blogService.save(addArticleRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
}
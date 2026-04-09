package me.su.springdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.su.springdeveloper.dao.Article;
import me.su.springdeveloper.dto.AddArticleRequest;
import me.su.springdeveloper.dto.ArticleResponse;
import me.su.springdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest addArticleRequest) {
        Article savedArticle = blogService.save(addArticleRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> result = blogService.findAll()
                .stream().map(ArticleResponse::new).toList();
        return ResponseEntity.ok().body(result);
    }
}
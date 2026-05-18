package me.su.springdeveloper.controller;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

//@RestController
//@RequiredArgsConstructor
//public class BlogController {
//    private final BlogService blogService;
//
//    @PostMapping("/api/articles")
//    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest addArticleRequest) {
//        Article savedArticle = blogService.save(addArticleRequest);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(savedArticle);
//    }
//    @GetMapping("/api/articles")
//    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
//        List<ArticleResponse> result = blogService.findAll()
//                .stream().map(ArticleResponse::new).toList();
//        return ResponseEntity.ok().body(result);
//    }
//
//    @GetMapping("/api/articles/{id}")
//    public ResponseEntity<ArticleResponse> findArticleById(@PathVariable long id){
//        Article article = blogService.findByid(id);
//        return ResponseEntity.ok().body(new ArticleResponse(article));
//    }
//    @DeleteMapping("/api/articles/{id}")
//    public ResponseEntity<Void>deleteArticle(@PathVariable("id") long id) {
//        blogService.delete(id);
//        return ResponseEntity.ok().build();
//    }
//    @PutMapping("api/articles/{id}")
//    public ResponseEntity<Article> updateArticle(@PathVariable long id,
//                                                 @RequestBody UpdateArticleRequest request) {
//        Article updateArticles = blogService.update(id, request);
//        return ResponseEntity.ok().body(updateArticles);
//    @PutMapping("api/articles/{id}")
//    public ResponseEntity<Article> updateArticle(@PathVariable("id") long id, @RequestBody UpdateArticleRequest updateArticleRequest) {
//        Article updateArticles =  blogService.findByid(id);
//        return ResponseEntity.ok().body(updateArticles);
//
//    }
//}
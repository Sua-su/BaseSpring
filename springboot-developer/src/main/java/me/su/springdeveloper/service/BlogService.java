package me.su.springdeveloper.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.su.springdeveloper.dao.Article;
import me.su.springdeveloper.dto.AddArticleRequest;
import me.su.springdeveloper.dto.UpdateArticleRequest;
import me.su.springdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    // DTO를 매개변수로 받도록 수정
    public Article save(AddArticleRequest request){
        // request(DTO)를 엔티티로 변환하여 저장
        // 보통 AddArticleRequest 클래스 안에 toEntity() 메서드를 만들어 사용
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found:" +id));
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }
    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found" +id));
        article.update(request.getTitle(), request.getContent());
        return article;
    }
}
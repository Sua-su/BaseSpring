package me.su.springdeveloper;


import com.fasterxml.jackson.databind.ObjectMapper;
import me.su.springdeveloper.dao.Article;
import me.su.springdeveloper.dto.AddArticleRequest;
import me.su.springdeveloper.repository.BlogRepository;
import me.su.springdeveloper.service.BlogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BlogApiControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper; // 객체 json 변화

    @Autowired
    protected BlogRepository blogRepository;

    @BeforeEach
    public void setUp() {
        blogRepository.deleteAll();
    }

    @DisplayName("addArticle : 블로그 글 추가 성공")
    @Test
    public void addArticle() throws Exception {
        //given
        final String url = "/api/articles";
        final String title = "test";
        final String content = "블로그 첫글";
        final AddArticleRequest article = new AddArticleRequest(title, content);
        final String requestBody = objectMapper.writeValueAsString(article);


        //when
        ResultActions result =  mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody));

        //then
        result.andExpect(status().isCreated());
        List<Article> articles = blogRepository.findAll();
        assertThat(articles.size()).isEqualTo(1);
        assertThat(articles.get(0).getTitle()).isEqualTo(title);
    }



    @DisplayName("findAllArticles : 블로그 글 목록 조회 성공")
    @Test
    public void findAllArticles() throws Exception {
        // given
        final String url = "/api/articles";
        blogRepository.save(Article.builder().title("title1").content("content1").build());


        // when
        ResultActions result = mockMvc.perform(get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE));

        // then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("title1"))
                .andExpect(jsonPath("$[0].content").value("content1"));

    }
}













package cursorTeam5.demo.article.controller;

import cursorTeam5.demo.article.domain.Article;
import cursorTeam5.demo.article.dto.requests.ArticleRequest;
import cursorTeam5.demo.article.dto.response.ArticleResponse;
import cursorTeam5.demo.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Article>> getArticles() throws BadRequestException {
        List<Article> articleResponse = articleService.findAll();
        return ResponseEntity.ok(articleResponse);
    }

    @GetMapping("/getMemberAll")
    public ResponseEntity<List<Article>> getArticlesByMemberId(@RequestBody ArticleRequest articleRequest) throws BadRequestException {
        List<Article> articleResponse = articleService.findAllByMemberId(articleRequest);
        return ResponseEntity.ok(articleResponse);
    }

    @PutMapping("/save")
    public ResponseEntity<ArticleResponse> saveArticle(@RequestBody ArticleRequest articleRequest) throws BadRequestException {
        ArticleResponse articleResponse = articleService.save(articleRequest);
        return ResponseEntity.ok(articleResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Article> delete(@RequestBody ArticleRequest articleRequest) throws BadRequestException {
        articleService.delete(articleRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ArticleResponse updateArticle(@RequestBody ArticleRequest articleRequest) throws BadRequestException {
        return articleService.updateTitle(articleRequest);
    }

}

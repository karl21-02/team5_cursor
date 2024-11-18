package cursorTeam5.demo.article.service;

import cursorTeam5.demo.article.domain.Article;
import cursorTeam5.demo.article.domain.repository.ArticleRepository;
import cursorTeam5.demo.article.dto.requests.ArticleRequest;
import cursorTeam5.demo.article.dto.response.ArticleResponse;
import cursorTeam5.demo.member.domain.Member;
import cursorTeam5.demo.member.domain.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;
    public ArticleResponse save(ArticleRequest articleRequest) throws BadRequestException {
        return getArticleResponse(articleRequest);
    }

    public void delete(ArticleRequest articleRequest) throws BadRequestException {
        Member member = memberRepository.findById(articleRequest.getMember_id())
                .orElseThrow(() -> new BadRequestException("멤버가 존재하지 않습니다."));

        Article article = Article.builder()
                .member(member)
                .title(articleRequest.getTitle())
                .build();

        articleRepository.delete(article);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public List<Article> findAllByMemberId(ArticleRequest articleRequest) throws BadRequestException {
        return articleRepository.findAllByMemberId(articleRequest.getMember_id())
                .orElseThrow(() -> new BadRequestException("게시글이 존재하지 않습니다."));
    }

    public ArticleResponse updateTitle(ArticleRequest articleRequest) throws BadRequestException {
        return getArticleResponse(articleRequest);
    }

    private ArticleResponse getArticleResponse(ArticleRequest articleRequest) throws BadRequestException {
        Member member = memberRepository.findById(articleRequest.getMember_id())
                .orElseThrow(() -> new BadRequestException("멤버가 존재하지 않습니다."));
        Article article = Article.builder()
                .member(member)
                .title(articleRequest.getTitle())
                .build();
        Article article1 = articleRepository.save(article);
        return new ArticleResponse(article1.getTitle(), article1.getContent());
    }
}

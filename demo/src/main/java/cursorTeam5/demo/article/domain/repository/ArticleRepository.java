package cursorTeam5.demo.article.domain.repository;

import cursorTeam5.demo.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Optional<List<Article>> findAllByMemberId(Long memberId);
}

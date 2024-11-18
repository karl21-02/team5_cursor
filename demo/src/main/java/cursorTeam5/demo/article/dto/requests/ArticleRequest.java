package cursorTeam5.demo.article.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleRequest {
    private Long member_id;
    private String title;
    private String content;
}

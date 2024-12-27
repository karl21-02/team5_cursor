package cursorTeam5.demo.article.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequest {
    private Long member_id;
    private String title;
    private String content;
}

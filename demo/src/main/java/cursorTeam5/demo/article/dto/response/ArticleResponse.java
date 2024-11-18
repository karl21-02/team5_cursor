package cursorTeam5.demo.article.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ArticleResponse {
    private String title;
    private String content;

    public ArticleResponse(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

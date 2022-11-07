package edu.miu.cs545.restApi.dto;

import edu.miu.cs545.restApi.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private String title;
    private String content;
    private String author;
    private List<Comment> comments;
}

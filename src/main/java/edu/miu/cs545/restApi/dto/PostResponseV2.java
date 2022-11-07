package edu.miu.cs545.restApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseV2 {
    private String title;
    private String content;
//    private String author;
}

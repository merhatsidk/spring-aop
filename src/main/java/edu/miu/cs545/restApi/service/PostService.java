package edu.miu.cs545.restApi.service;

import edu.miu.cs545.restApi.domain.Comment;
import edu.miu.cs545.restApi.dto.PostRequest;
import edu.miu.cs545.restApi.dto.PostResponse;
import edu.miu.cs545.restApi.dto.PostResponseV2;

import java.util.List;

public interface PostService {

    List<PostResponse> findAllV1();

    List<PostResponseV2> findAllV2();

    PostResponse findById(Long id);

    void save(PostRequest postRequest);

    void deleteById(Long id);

    void updateById(Long id, PostRequest postRequest);

    void addComment(Long id, Comment comment);

    List<Comment> getComments(Long id);

    List<PostResponse> findByTitleLike(String title);
}

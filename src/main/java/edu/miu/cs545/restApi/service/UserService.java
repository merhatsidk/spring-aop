package edu.miu.cs545.restApi.service;


import edu.miu.cs545.restApi.domain.Comment;
import edu.miu.cs545.restApi.domain.User;
import edu.miu.cs545.restApi.dto.PostRequest;
import edu.miu.cs545.restApi.dto.PostResponse;
import edu.miu.cs545.restApi.dto.UserDto;
import edu.miu.cs545.restApi.dto.UserRequest;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(Long id);

    void save(UserRequest userRequest);

    List<PostResponse> findUserPosts(Long id);

    List<User> moreThanNPost(int num_posts);

    void addPostToUser(Long id, PostRequest postRequest);

    void deleteById(Long id);

    PostResponse findPostById(Long id, Long postId);

    Comment findCommentsFromUser(Long userId, Long postId, Long commentId);

    List<User> sameTitle(String title);

}

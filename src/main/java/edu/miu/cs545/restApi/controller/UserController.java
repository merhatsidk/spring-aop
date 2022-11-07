package edu.miu.cs545.restApi.controller;

import edu.miu.cs545.restApi.annotation.ExecutionTime;
import edu.miu.cs545.restApi.domain.Comment;
import edu.miu.cs545.restApi.domain.User;
import edu.miu.cs545.restApi.dto.PostRequest;
import edu.miu.cs545.restApi.dto.PostResponse;
import edu.miu.cs545.restApi.dto.UserDto;
import edu.miu.cs545.restApi.dto.UserRequest;
import edu.miu.cs545.restApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping
    public List<UserDto> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public UserDto findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
         userService.deleteById(id);
    }
    @PostMapping
    public void saveUser(@RequestBody UserRequest userRequest){
        userService.save(userRequest);
    }

    //"api/v1/users"
    @PostMapping("/{id}/posts")
    public void addPostToUser(@PathVariable("id") Long id,@RequestBody PostRequest postRequest){
        userService.addPostToUser(id,postRequest);
    }

    @GetMapping("/{id}/posts")
    public List<PostResponse> findUserPosts(@PathVariable("id") Long id){
        return userService.findUserPosts(id);
    }

    @GetMapping("/{id}/posts/{postId}")
    public PostResponse findPostById(@PathVariable("id") Long id,@PathVariable("postId") Long postId ){
        return userService.findPostById(id,postId);
    }

    @GetMapping("/{userId}/posts/{postId}/comment/{commentId}")
    public Comment findPostById(@PathVariable("userId") Long userId, @PathVariable("postId") Long postId, @PathVariable("commentId") Long commentId ){
        return userService.findCommentsFromUser(userId,postId,commentId);
    }

    @GetMapping("/moreThan/{num_posts}")
    public List<User> moreThanNPost(@PathVariable("num_posts") int num_posts){
        return userService.moreThanNPost(num_posts);
    }

    @GetMapping("/usersWithPostTitle/{title}")
    public List<User> sameTitle(@PathVariable("title") String title){
        return userService.sameTitle(title);
    }

    @GetMapping("/exception")
    public void exceptionTrowingMethod(){
        throw new RuntimeException();
    }
}

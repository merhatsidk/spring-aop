package edu.miu.cs545.restApi.controller;

import edu.miu.cs545.restApi.domain.Comment;
import edu.miu.cs545.restApi.dto.PostRequest;
import edu.miu.cs545.restApi.dto.PostResponse;
import edu.miu.cs545.restApi.dto.PostResponseV2;
import edu.miu.cs545.restApi.service.CommentService;
import edu.miu.cs545.restApi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @GetMapping(headers = "v=1")
    public List<PostResponse> findAllV1(){
        return postService.findAllV1();
    }

    @GetMapping(headers = "v=2")
    public List<PostResponseV2> findAllV2(){
        return postService.findAllV2();
    }

    @GetMapping("/{id}")
    public PostResponse findById(@PathVariable("id") Long id){
       return postService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody PostRequest postRequest){
        postService.save(postRequest);
    }

    @PostMapping("/{id}/comment")
    public void addComment(@PathVariable("id") Long id, @RequestBody Comment comment){
        postService.addComment(id,comment);
    }

    @GetMapping("/{id}/comment")
    public List<Comment> findCommentsById(@PathVariable("id") Long id){
        return postService.getComments(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        postService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable("id") Long id, @RequestBody PostRequest postRequest){
        postService.updateById(id,postRequest);
    }

    @GetMapping("/titleMatch/{title}")
    public List<PostResponse> findByTitleMatches(@PathVariable("title") String title){
        return postService.findByTitleLike(title);
    }

}

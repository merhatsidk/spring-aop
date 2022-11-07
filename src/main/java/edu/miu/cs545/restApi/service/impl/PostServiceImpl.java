package edu.miu.cs545.restApi.service.impl;
import edu.miu.cs545.restApi.domain.Comment;
import edu.miu.cs545.restApi.domain.Post;
import edu.miu.cs545.restApi.domain.PostV2;
import edu.miu.cs545.restApi.dto.PostRequest;
import edu.miu.cs545.restApi.dto.PostResponse;
import edu.miu.cs545.restApi.dto.PostResponseV2;
import edu.miu.cs545.restApi.repo.PostRepo;
import edu.miu.cs545.restApi.repo.PostRepoV2;
import edu.miu.cs545.restApi.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private PostRepoV2 postRepoV2;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<PostResponse> findAllV1() {
        List<Post> posts = postRepo.findAll();
        return posts.stream()
                .map(post -> modelMapper.map(post,PostResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostResponseV2> findAllV2() {
        List<PostV2> posts = postRepoV2.findAll();
        return posts.stream()
                .map(post -> modelMapper.map(post,PostResponseV2.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostResponse findById(Long id) {
         return modelMapper.map(postRepo.findById(id).get(),PostResponse.class);
    }

    @Override
    public void save(PostRequest postRequest) {
        postRepo.save(modelMapper.map(postRequest,Post.class));
    }

    @Override
    public void deleteById(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void updateById(Long id, PostRequest postRequest) {
        Post p = postRepo.findById(id).isPresent() ? postRepo.findById(id).get() : null;
            p.setAuthor(postRequest.getAuthor());
            p.setContent(postRequest.getContent());
            p.setTitle(postRequest.getTitle());
            postRepo.save(p);
        }

    @Override
    public void addComment(Long id, Comment comment) {
        Post post = postRepo.findById(id).isPresent() ? postRepo.findById(id).get() : null;
        List<Comment> comments =  post.getComments();
//        post.getComments().add(comment);
        comments.add(comment);
        postRepo.save(post);
    }

    @Override
    public List<Comment> getComments(Long id) {
        Post p = postRepo.findById(id).get();
        return p.getComments();
    }

    @Override
    public List<PostResponse> findByTitleLike(String title) {
         return postRepo.findByTitleLike(title).stream()
                 .map(post -> modelMapper.map(post,PostResponse.class))
                 .collect(Collectors.toList());
    }



}

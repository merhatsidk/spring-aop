package edu.miu.cs545.restApi.service.impl;

import edu.miu.cs545.restApi.domain.Comment;
import edu.miu.cs545.restApi.domain.Post;
import edu.miu.cs545.restApi.domain.User;
import edu.miu.cs545.restApi.dto.PostRequest;
import edu.miu.cs545.restApi.dto.PostResponse;
import edu.miu.cs545.restApi.dto.UserDto;
import edu.miu.cs545.restApi.dto.UserRequest;
import edu.miu.cs545.restApi.repo.PostRepo;
import edu.miu.cs545.restApi.repo.UserRepo;
import edu.miu.cs545.restApi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user,UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        return modelMapper.map(userRepo.findById(id).get(),UserDto.class);
    }

    @Override
    public void save(UserRequest userRequest) {
        userRepo.save(modelMapper.map(userRequest,User.class));
    }

    @Override
    public List<PostResponse> findUserPosts(Long id) {
        User user =  userRepo.findById(id).get();
        List<Post> posts = user.getPosts();
        return posts.stream()
                .map(post -> modelMapper.map(post,PostResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> moreThanNPost(int num_posts) {
        return userRepo.moreThanNPost( num_posts);
    }

    @Override
    public void addPostToUser(Long id, PostRequest postRequest) {
        User user = userRepo.findById(id).isPresent() ? userRepo.findById(id).get() : null;
//        List<Post> posts =  user.getPosts();
        user.getPosts().add(modelMapper.map(postRequest,Post.class));
        userRepo.save(user);

    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public PostResponse findPostById(Long id, Long postId) {
//        Post p = postRepo.findById(postId).get();
        User u = userRepo.findById(id).get();
        List<Post> posts =  u.getPosts();
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .map(post -> modelMapper.map(post,PostResponse.class))
                .findFirst()
                .get();

//        for (Post pp : posts){
//            if(pp.getId() == postId){
//                return modelMapper.map(pp,PostResponse.class);
//            }
//        }
//        return null;
//       return modelMapper.map(p,PostResponse.class);


    }

    @Override
    public Comment findCommentsFromUser(Long userId, Long postId, Long commentId) {
        PostResponse postResponse = findPostById( userId,  postId);
        List<Comment> comments = postResponse.getComments();

        return comments.stream()
                .filter(comment -> comment.getId() == commentId)
                .findFirst()
                .get();

//        for (Comment c : comments){
//            if(c.getId() == commentId){
//                return c;
//            }
//        }
//        return null;
    }

    @Override
    public List<User> sameTitle(String title) {
        return userRepo.usersWithSameTitle(title);
    }


}

package edu.miu.cs545.restApi.repo;

import edu.miu.cs545.restApi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Query(value = "select u from User u where u.posts.size > :num_posts")
    List<User> moreThanNPost(int num_posts);

    @Query("select u from User u JOIN u.posts p where p.title = :title")
    List<User> usersWithSameTitle(String title);
}

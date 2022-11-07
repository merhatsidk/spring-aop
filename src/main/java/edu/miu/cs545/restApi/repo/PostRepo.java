package edu.miu.cs545.restApi.repo;

import edu.miu.cs545.restApi.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {

//    @Query("select p from Post p where p.title")
    List<Post> findByTitleLike(String title);

}

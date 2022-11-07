package edu.miu.cs545.restApi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Comment> comments;

//    @ManyToOne(cascade = CascadeType.ALL)
//    private User user;
//

}

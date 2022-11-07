package edu.miu.cs545.restApi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Comment {
    @Id @GeneratedValue
    private Long id;
    private String name;

}

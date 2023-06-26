package com.angular.blogbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


import java.time.Instant;

@Getter
@Setter
@Entity
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @Lob
    @NotEmpty
    private String content;
    private Instant createdOn;
    private Instant updatedOn;
    @NotBlank
    private String UserName;

}

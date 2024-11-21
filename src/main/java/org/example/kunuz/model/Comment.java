package org.example.kunuz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date createdDate;
    @Column(nullable = false)
    private Date updatedDate;
    @OneToOne
    private Profile profileId;
    @Column(nullable = false)
    private String content;
    @OneToOne
    private Article articleId;
    @Column(nullable = false)
    private Integer replyId;
    @Column(nullable = false)
    private String visible;
}

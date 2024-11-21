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
public class CommentLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Profile profileId;
    @OneToOne
    private Comment commentId;
    @Column(nullable = false)
    private Date createdDate;
    @Column(nullable = false)
    private String status;
}

package org.example.kunuz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String sharedCount;
    @Column(nullable = false)
    private Integer imageId;
    @ManyToMany
    private List<Region> regionId;
    @Column(nullable = false)
    private Integer moderatorId;
    @Column(nullable = false)
    private Integer publisherId;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private Date createDate;
    @Column(nullable = false)
    private Date publishedDate;
    @Column(nullable = false)
    private String visible;
    @Column(nullable = false)
    private String viewCount;

}

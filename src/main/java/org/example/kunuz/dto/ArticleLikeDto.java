package org.example.kunuz.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kunuz.model.Article;
import org.example.kunuz.model.Profile;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleLikeDto {

    private Long profileId; // xato
    private Long articleId; // xato
    private Date createdDate;
    private String status;


    // Profile

    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private String statusProfile;
    private String role;
    private String visible;
    private Date createData;
    private Integer photoId;

    // Artical Like

    private String title;
    private String description;
    private String content;
    private String sharedCount;
    private Integer imageId;
    private Long regionId;
    private Integer moderatorId;
    private Integer publisherId;
    private String statusArticle;
    private Date createDate;
    private Date publishedDate;
    private String visibleArticle;
    private String viewCount;

    // Region bilan ulash uchun

    private String orderNumber;
    private String nameUz;
    private String nameRu;
    private String nameEn;
    private String visibleRegion;
    private Date createdDateRegion;

}

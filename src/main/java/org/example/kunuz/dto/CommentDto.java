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
public class CommentDto {

    private Date createdDate;
    private Date updatedDate;
    private Long profileId;
    private String content;
    private Long articleId;
    private Integer replyId;
    private String visible;




    // Profile bilan ulash

    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private String status;
    private String role;
    private String visibleProfile;
    private Date createData;
    private Integer photoId;

    // Article bilan ulanish uchun

    private String title;
    private String description;
    private String contentArticle;
    private String sharedCount;
    private Integer imageId;
    private Long regionId; // xato
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

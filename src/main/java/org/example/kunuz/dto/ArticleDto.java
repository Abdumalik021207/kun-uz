package org.example.kunuz.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kunuz.model.Region;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private String title;
    private String description;
    private String content;
    private String sharedCount;
    private Integer imageId;
    private Long regionId; // xato
    private Integer moderatorId;
    private Integer publisherId;
    private String status;
    private Date createDate;
    private Date publishedDate;
    private String visible;
    private String viewCount;

    // Region bilan ulash uchun

    private String orderNumber;
    private String nameUz;
    private String nameRu;
    private String nameEn;
    private String visibleRegion;
    private Date createdDate;

}

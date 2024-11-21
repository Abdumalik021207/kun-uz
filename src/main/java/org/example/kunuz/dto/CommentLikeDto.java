package org.example.kunuz.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kunuz.model.Comment;
import org.example.kunuz.model.Profile;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentLikeDto {

    private Long profileId;
    private Long commentId;
    private Date createdDate;
    private String status;




}

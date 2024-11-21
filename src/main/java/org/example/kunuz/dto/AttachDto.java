package org.example.kunuz.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachDto {

    private String originalName;
    private String path;
    private String size;
    private String extension;
    private Date createdDate;

}

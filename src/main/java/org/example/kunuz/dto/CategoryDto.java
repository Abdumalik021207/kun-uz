package org.example.kunuz.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private String orderNumber;
    private String nameUz;
    private String nameRu;
    private String nameEng;
    private String visible;
    private Date createdDate;

}

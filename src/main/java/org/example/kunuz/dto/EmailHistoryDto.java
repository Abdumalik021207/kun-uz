package org.example.kunuz.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailHistoryDto {

    private String message;
    private String email;
    private Date createdDate;


}

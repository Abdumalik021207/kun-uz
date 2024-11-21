package org.example.kunuz.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private String status;
    private String role;
    private String visible;
    private Date createData;
    private Integer photoId;

}
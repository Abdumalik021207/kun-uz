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
public class SmsHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false, unique = true)
    private String message;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private Date createdDate;

}

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
public class Attach {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    @Column(nullable = false)
    private String originalName;
    @Column(nullable = false)
    private String path;
    @Column(nullable = false)
    private String size;
    @Column(nullable = false)
    private String extension;
    @Column(nullable = false)
    private Date createdDate;

}

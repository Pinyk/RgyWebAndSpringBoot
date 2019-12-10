package com.rgy.rgy.bean;

import lombok.*;
import lombok.Data;

import javax.persistence.*;

//作业指导书
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "guidingBook")
public class GuidingBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer guidingBookId;

    @Column
    private String guidingBookName;

    @Column
    private String guidingBookUrl;

    @Column
    private String uploadDate;

    @Column
    private String uploader;

    @Column
    private Integer infoState;

    public GuidingBook(String guidingBookName, String guidingBookUrl, String uploadDate) {
        this.guidingBookName = guidingBookName;
        this.guidingBookUrl = guidingBookUrl;
        this.uploadDate = uploadDate;
    }
}

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
    private int guidingBookId;

    @Column
    private String guidingBookName;

    @Column
    private String guidingBookUrl;

    @Column
    private String uploadDate;

    @Column
    private String uploader;

    @Column
    private int infoState;
}

package com.rgy.rgy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//案例库
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "case_library")
public class CaseLibrary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer caseLibraryID;

    @Column
    private String keyword;

    private Integer materialUrl;

}

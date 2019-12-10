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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer caseLibraryID;

    @Column
    private String keyword;

    @Column
    private String materialUrl;

    public CaseLibrary(String keyword, String materialUrl) {
        this.keyword = keyword;
        this.materialUrl = materialUrl;
    }

    public Integer getCaseLibraryID() {
        return caseLibraryID;
    }

    public void setCaseLibraryID(Integer caseLibraryID) {
        this.caseLibraryID = caseLibraryID;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMaterialUrl() {
        return materialUrl;
    }

    public void setMaterialUrl(String materialUrl) {
        this.materialUrl = materialUrl;
    }
}

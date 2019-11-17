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

    public int getGuidingBookId() {
        return guidingBookId;
    }

    public void setGuidingBookId(int guidingBookId) {
        this.guidingBookId = guidingBookId;
    }

    public String getGuidingBookName() {
        return guidingBookName;
    }

    public void setGuidingBookName(String guidingBookName) {
        this.guidingBookName = guidingBookName;
    }

    public String getGuidingBookUrl() {
        return guidingBookUrl;
    }

    public void setGuidingBookUrl(String guidingBookUrl) {
        this.guidingBookUrl = guidingBookUrl;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public int getInfoState() {
        return infoState;
    }

    public void setInfoState(int infoState) {
        this.infoState = infoState;
    }

    public GuidingBook(String guidingBookName, String guidingBookUrl, String uploadDate, String uploader, int infoState) {
        this.guidingBookName = guidingBookName;
        this.guidingBookUrl = guidingBookUrl;
        this.uploadDate = uploadDate;
        this.uploader = uploader;
        this.infoState = infoState;
    }
}

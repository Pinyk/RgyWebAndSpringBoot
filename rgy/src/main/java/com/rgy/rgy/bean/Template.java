package com.rgy.rgy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 报告模板表
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "template")
public class Template implements Comparable<Template>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "templateId")
    private Integer templateId;

    @Column
    private String templateName;

    @Column
    private String basis;

    @Column
    private String equipmentTypeId;

    @Column
    private String editor;

    @Column
    private String editorDate;

    @Column
    private Integer infoState;

    public Integer getTemplateId() {
        return templateId;
    }

    public Template(String templateName, String basis, String equipmentTypeId, String editor, String editorDate, int infoState) {
        this.templateName = templateName;
        this.basis = basis;
        this.equipmentTypeId = equipmentTypeId;
        this.editor = editor;
        this.editorDate = editorDate;
        this.infoState = infoState;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    public String getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(String equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getEditorDate() {
        return editorDate;
    }

    public void setEditorDate(String editorDate) {
        this.editorDate = editorDate;
    }

    public Integer getInfoState() {
        return infoState;
    }

    public void setInfoState(Integer infoState) {
        this.infoState = infoState;
    }

    @Override
    public int compareTo(Template o) {
        int i = this.templateId - o.getTemplateId();
        return i;
    }
}

package de.trick.gallerie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.trick.gallerie.type.DokumentType;

import javax.persistence.*;
@Entity
@Table(name = "dokument")
public class Dokument extends AbstractEntity {

    private String title;

    private String docName;

    @Column(length = 1024)
    private String description;

    private long size;

    @Enumerated(EnumType.STRING)
    @Column(name = "dokument_type")
    private DokumentType dokumentType;

    @Column(name = "doc_type")
    private String docType;

    @Lob
    @JsonIgnore
    private byte[] data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DokumentType getDokumentType() {
        return dokumentType;
    }

    public void setDokumentType(DokumentType dokumentType) {
        this.dokumentType = dokumentType;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}

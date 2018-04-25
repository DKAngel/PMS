package com.pms.pojo;

public class EmailCode {
    private Integer codeId;

    private String ownersEmail;

    private String codeNum;

    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public String getOwnersEmail() {
        return ownersEmail;
    }

    public void setOwnersEmail(String ownersEmail) {
        this.ownersEmail = ownersEmail == null ? null : ownersEmail.trim();
    }

    public String getCodeNum() {
        return codeNum;
    }

    public void setCodeNum(String codeNum) {
        this.codeNum = codeNum == null ? null : codeNum.trim();
    }
}
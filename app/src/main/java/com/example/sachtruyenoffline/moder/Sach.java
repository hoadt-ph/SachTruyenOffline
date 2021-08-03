package com.example.sachtruyenoffline.moder;

public class Sach {
    public int idName;
        public String NameSach;
    public String anh;
    public String style;
    public int like;

    public Sach() {
    }

    public Sach(int idName, String nameSach, String anh, int like, String style) {
        this.idName = idName;
        NameSach = nameSach;
        this.anh = anh;
        this.style = style;
        this.like = like;
    }

    public String getNameSach() {
        return NameSach;
    }

    public void setNameSach(String nameSach) {
        NameSach = nameSach;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getIdName() {
        return idName;
    }

    public void setIdName(int idName) {
        this.idName = idName;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}

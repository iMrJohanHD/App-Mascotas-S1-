package com.manriquetavi.curso3_semana3;

public class ProfileItem {
    private String id;
    private String urlPetPic;
    private int likes = 0;

    public ProfileItem() {
    }

    public ProfileItem(String urlPetPic, int likes) {
        this.urlPetPic = urlPetPic;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlPetPic() {
        return urlPetPic;
    }

    public void setUrlPetPic(String urlPetPic) {
        this.urlPetPic = urlPetPic;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}

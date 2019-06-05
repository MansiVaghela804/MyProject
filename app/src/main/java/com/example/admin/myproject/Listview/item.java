package com.example.admin.myproject.Listview;

public class item {

    String listitem;
    int imageId;

    public item(String listitem, int imageId) {
        this.listitem = listitem;
        this.imageId = imageId;
    }

    public String getListitem() {
        return listitem;
    }

    public void setListitem(String listitem) {
        this.listitem = listitem;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }


}

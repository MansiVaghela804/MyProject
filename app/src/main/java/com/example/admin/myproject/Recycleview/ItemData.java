package com.example.admin.myproject.Recycleview;

public class ItemData {
    public ItemData(String listitem, int imageId) {
        this.listitem = listitem;
        this.imageId = imageId;
    }

    String listitem;
    int imageId;

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

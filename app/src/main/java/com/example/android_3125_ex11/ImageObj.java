package com.example.android_3125_ex11;

public class ImageObj {
    private int imageID;
    private boolean isTrafficLight;

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public boolean isTrafficLight() {
        return isTrafficLight;
    }

    public void setTrafficLight(boolean trafficLight) {
        isTrafficLight = trafficLight;
    }

    public ImageObj(int imageID, boolean isTrafficLight) {
        this.imageID = imageID;
        this.isTrafficLight = isTrafficLight;
    }
}

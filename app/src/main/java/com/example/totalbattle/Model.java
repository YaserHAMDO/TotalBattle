package com.example.totalbattle;

public class Model {


    private final int image;
    private final int point;
    private final String name;
    private int sum;


    public Model(int image, int point, String name, int sum) {
        this.image = image;
        this.point = point;
        this.name = name;
        this.sum = sum;
    }

    public int getImage() {
        return image;
    }

    public int getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}

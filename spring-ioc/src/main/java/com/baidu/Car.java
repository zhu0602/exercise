package com.baidu;

/**
 * @author ZhuGangGang
 * @Date 2020/1/29 15:05
 */
public class Car {
    private String brand;
    private double maxSpeed;
    private int price;
    private double minSpeed;



    public Car(String brand, double maxSpeed, int price) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.price = price;
    }

    public Car(double maxSpeed, int price, double minSpeed) {
        this.maxSpeed = maxSpeed;
        this.price = price;
        this.minSpeed = minSpeed;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(double minSpeed) {
        this.minSpeed = minSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", price=" + price +
                ", minSpeed=" + minSpeed +
                '}';
    }
}

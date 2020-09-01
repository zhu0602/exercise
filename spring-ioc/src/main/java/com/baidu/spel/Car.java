package com.baidu.spel;

/**
 * @author ZhuGangGang
 * @Date 2020/1/30 10:15
 */
public class Car {

    private  String brand;
    private Integer price;
    private Double tyrePerimeter;

    public Double getTyrePerimeter() {
        return tyrePerimeter;
    }

    public void setTyrePerimeter(Double tyrePerimeter) {
        this.tyrePerimeter = tyrePerimeter;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", tyrePerimeter=" + tyrePerimeter +
                '}';
    }
}

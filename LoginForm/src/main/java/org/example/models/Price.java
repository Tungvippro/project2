package org.example.models;

public class Price {
    private double priceTentHour;
    private double priceFood;
    private double priceNess;

    private double sumprice;




    public Price(double priceTentHour, double priceFood, double priceNess ) {
        this.priceTentHour = priceTentHour;
        this.priceFood = priceFood;
        this.priceNess = priceNess;

    }
    public void Price2(double sumprice){
        this.sumprice = sumprice;
    }

    public double getPriceTentHour() {
        return priceTentHour;
    }

    public void setPriceTentHour(double priceTentHour) {
        this.priceTentHour = priceTentHour;
    }

    public double getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(double priceFood) {
        this.priceFood = priceFood;
    }

    public double getPriceNess() {
        return priceNess;
    }

    public void setPriceNess(double priceNess) {
        this.priceNess = priceNess;
    }

    public int getSumprice() {
        return (int) sumprice;
    }

    public void setSumprice(double sumprice) {
        this.sumprice = sumprice;
    }
}

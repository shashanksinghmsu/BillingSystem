package com.model;

public class Product {

    private int product_id;
    private String product_Name;
    private double product_Price;
    private String product_Category;
    private int product_StockQuantity;
    private int product_RecorderLevel;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public double getProduct_Price() {
        return product_Price;
    }

    public void setProduct_Price(double product_Price) {
        this.product_Price = product_Price;
    }

    public String getProduct_Category() {
        return product_Category;
    }

    public void setProduct_Category(String product_Category) {
        this.product_Category = product_Category;
    }

    public int getProduct_StockQuantity() {
        return product_StockQuantity;
    }

    public void setProduct_StockQuantity(int product_StockQuantity) {
        this.product_StockQuantity = product_StockQuantity;
    }

    public int getProduct_RecorderLevel() {
        return product_RecorderLevel;
    }

    public void setProduct_RecorderLevel(int product_RecorderLevel) {
        this.product_RecorderLevel = product_RecorderLevel;
    }

    @Override
    public String toString() {
        return "Product{" + "product_id=" + product_id + ", product_Name=" + product_Name + ", product_Price=" + product_Price + ", product_Category=" + product_Category + ", product_StockQuantity=" + product_StockQuantity + ", product_RecorderLevel=" + product_RecorderLevel + '}';
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

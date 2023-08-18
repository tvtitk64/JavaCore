package src.Training.Ex12.Model;

public class Vehicles {
    protected String id;
    protected String manufacturer;
    protected int year;
    protected int price;
    protected String color;

    public Vehicles(String id, String manufacturer, int year, int price, String color) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.year = year;
        this.price = price;
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

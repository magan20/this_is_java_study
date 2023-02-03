package ch17.sec04.exam01;

public class Product {
    private final int pno;
    private final String name;
    private final String company;
    private final int price;

    public Product(int pno, String name, String company, int price) {
        this.pno = pno;
        this.name = name;
        this.company = company;
        this.price = price;
    }

    public int getPno() {
        return pno;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{" +
                "pno:" + pno + ", " +
                "name:" + name + ", " +
                "company:" + company + ", " +
                "price:" + price +
                "}";
    }
}
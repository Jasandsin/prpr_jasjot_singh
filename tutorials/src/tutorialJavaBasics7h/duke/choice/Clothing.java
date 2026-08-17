package tutorialJavaBasics7h.duke.choice;

public class Clothing implements Comparable<Clothing> {

    private String description;
    private double price;
    private String size = "M";
    public static double MIN_PRICE = 10;
    public static double TAX_RATE = 0.2;



    public Clothing(String description, double price, String aSize) {
        this.description = description;
        this.setPrice(price);
        this.size = aSize;
    }

    public void setPrice (double newPrice){
        price = (newPrice > MIN_PRICE) ? newPrice : MIN_PRICE;
    }

    public double getPrice(){
        return price + price * TAX_RATE;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    @Override
    public String toString(){
        return "items: " + getDescription() + ", " + getSize() + ", " + getPrice();
    }

    @Override
    public int compareTo(Clothing o) {
        return this.description.compareTo(o.description);
    }
}

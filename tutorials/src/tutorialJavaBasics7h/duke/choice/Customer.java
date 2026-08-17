package tutorialJavaBasics7h.duke.choice;

public class Customer {

    private String name;
    private String size;

    private Clothing[] items;


    public Customer(String name, int measurement) {
        this.name = name;
        setSize(measurement);
    }



    public void addItem(Clothing[] someItems){
        items = someItems;
    }

    public Clothing[] getItem(){
        return items;
    }


    public double getTotalClothingCost(){
        double total = 0.0;
        for (int i = 0; i < items.length; i++) {
        //    if(items[i].getSize().equals(c1.getSize())){
                total += items[i].getPrice();
              //  System.out.println("item " + (i+1) + ": " + items[i].getDescription() + " with the price " + items[i].getPrice() + " and the size " + items[i].getSize());
         //       total = total + total * tax;
         //       if(total>15) {break;}
            }
        return total;
      //  }
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int measurement){
        //switch demo
        switch (measurement){
        case 1,2,3:
            setSize("S");
            break;
        case 4,5,6:
            setSize("M");
            break;
        case 7,8,9:
            setSize("L");
            break;
        default:
            setSize("XL");
        }
    }
}

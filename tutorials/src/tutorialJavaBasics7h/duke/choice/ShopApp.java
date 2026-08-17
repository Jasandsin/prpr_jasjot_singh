package tutorialJavaBasics7h.duke.choice;

import java.util.Arrays;

public class ShopApp {
    public static void main(String[] args) {
        double tax = 0.2;
        double total = 0.0;


        Customer c1 = new Customer("Pinky", 12);
      //  c1.setName("Pinky");
      //  c1.setSize("S");

        System.out.println("Min. Price: " + Clothing.MIN_PRICE);

        Clothing item1 = new Clothing("Blue Jacket", 20.9, "M");

        Clothing item2 = new Clothing("Orange T-Shirt", 10.5, "S");

        Clothing item3 = new Clothing("Green Scarf", 5, "S");

        Clothing item4 = new Clothing("Blue T-Shirt", 10.5, "S");


     //   int measurement = 8;
     //   c1.setSize(measurement);

        //  System.out.println("Item 1: " + item1.description + " with the price " + item1.price + " and the size " + item1.size);
      //  System.out.println("Item 2: " + item2.description + " with the price " + item2.price + " and the size " + item2.size);
      //  total = (item1.price + item2.price * 2) * (1 + tax);

        // Array Demo
        Clothing [] items = {item1, item2, item3, item4};

        c1.addItem(items);
        System.out.printf("Welcome to Duke Shop! " + c1.getName() + " " + c1.getSize() + "," + c1.getTotalClothingCost() + "\n");


        for (Clothing item: c1.getItem()) {
           // System.out.println("items: " + item.getDescription() + ", " + item.getSize() + ", " + item.getPrice());
            System.out.println("Item " + item);
        }

        //Practice 7
        int average = 0;
        int count = 0;

        for (Clothing item: c1.getItem()) {
            if(item.getSize().equals("L")){
                count++;
                average += item.getPrice();
            }
        }

        try{
         //   average = (count == 0) ? 0 :average/count;
            average = average/count;
            System.out.println("Average price " + average + ", Count: " + count);
        } catch(ArithmeticException e){
            System.out.println("Dont divide by 0");
        }

        // Interfaces Demo
        Arrays.sort(c1.getItem());
        for (Clothing item: c1.getItem()) {
            // System.out.println("items: " + item.getDescription() + ", " + item.getSize() + ", " + item.getPrice());
            System.out.println("Item " + item);
        }

    }


        }
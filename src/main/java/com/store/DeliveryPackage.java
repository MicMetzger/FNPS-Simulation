package main.java.com.store;
import main.java.com.item.Item;


public class DeliveryPackage {
    private Item item;
    private String packageName;
    private int expectedDeliveryDate;

    public DeliveryPackage(String packageName, int expectedDeliveryDate) {
        this.packageName = packageName;
        this.expectedDeliveryDate = expectedDeliveryDate;
    }
    public Item getItem() {
        return item;
    }

    public String getPackageName() {
        return packageName;
    }

    public int getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}

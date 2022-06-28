package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

    Date manufacturedDate;

    public UsedProduct() {
        super();
    }
    public UsedProduct(String name, Double price, Date manufacturedDate) {
        super(name, price);
        this.manufacturedDate = manufacturedDate;
    }


    public Date getManufacturedDate() {
        return manufacturedDate;
    }
    public void setManufacturedDate(Date manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    @Override
    public final String priceTag(){
        return super.priceTag() + " (Manufactured date: "+sdf.format(manufacturedDate)+")";
    }
}

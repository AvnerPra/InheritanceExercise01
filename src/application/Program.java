package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            sc.nextLine();
            System.out.println("Product #"+i+" data:");
            System.out.print("Common, used, or imported (c/u/i)?");
            System.out.println();
            char cui = sc.next().charAt(0);
            while (cui != 'c' && cui != 'u' && cui != 'i'){
                System.out.println("Invalid option");
                sc.nextLine();
                System.out.println("Product #"+i+" data:");
                System.out.print("Common, used, or imported (c/u/i)?");
                cui = sc.next().charAt(0);
            }
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if (cui == 'u'){
                sc.nextLine();
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String manufacturedDate = sc.nextLine();
                products.add(new UsedProduct(name, price, sdf.parse(manufacturedDate)));
            }
            else if (cui=='i'){
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price,customsFee));
            }
            else{
                products.add(new Product(name, price));
            }

        }

        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product product: products){
            System.out.println(product.getName()+product.priceTag());
        }



        sc.close();
    }
}

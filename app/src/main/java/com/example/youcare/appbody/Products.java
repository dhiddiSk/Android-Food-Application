package com.example.youcare.appbody;

import com.example.youcare.R;

import java.util.ArrayList;
import java.util.List;

public class Products {

    public static Products products;
    public static List<Product> productsList = new ArrayList<>();

    public Products getInstance() {
        return new Products();
    }

    public List<Product> getProducts(){
        if (productsList.size() > 0) productsList.clear(); // clear stack

        String imageUrl = "https://www.google.com/search?q=Andechser+Molkerei+Scheitz+GmbH+image&sxsrf=ALeKk03uvCFFJqOFwdt6noA0iTphV8-DOg:1587832366446&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjawqjBgITpAhWoxzgGHbkBDGYQ_AUoA3oECAsQBQ&biw=1232&bih=553#imgrc=n6CylD3m4WDwsM";

        //milk
        productsList.add(new Product("milk", "Andechser Molkerei Scheitz GmbH", "no", "yes", "yes", "no", 2, 3, "1.5", "",R.drawable.andechsermolkerischeitzgmbh));
        productsList.add(new Product("milk", "Demeter MilchBauern Schwarzwald-", "no", "yes", "yes", "no", 3, 3, "2.5", "",R.drawable.demetermilchbauernschwarzwald));
        productsList.add(new Product("milk", "Schwarzwaldmilch GmbH Freiburg", "no", "yes", "yes", "no", 2, 3, "1.5", "",R.drawable.schwarzwaldmilchgmbhfreiburg));
        productsList.add(new Product("milk", "ARLA Foods Deutschl.GmbH/Hansa", "no", "yes", "yes", "no", 1, 3, "1", "",R.drawable.arlafdoodsdeutschl_gmbhhansa));
        productsList.add(new Product("milk", "Andechser Molkerei Scheitz GmbH2", "no", "yes", "yes", "no", 2, 2, "1", "",R.drawable.andechsermolkerischeitzgmbh2));
        productsList.add(new Product("milk", "Milchw.Berchtesgad.Land Chiemgau eG", "no", "yes", "yes", "no", 2, 1, "2", "",R.drawable.milchwberchtesgadlandchiemgaueg));
        productsList.add(new Product("milk", "Alpro Comm. VA/SCA", "yes", "no", "yes", "yes", 2, 1, "2", "",R.drawable.alprocommvasca));
        productsList.add(new Product("milk", "Oatly Germany GmbH", "yes", "no", "yes", "yes", 2, 3, "3", "",R.drawable.oatlygermanygmbh));

        //chocolate cream
        productsList.add(new Product("choclate cream", "Rigoni di Asiago Nocciolata", "no", "yes", "yes", "no", 2, 1, "4.45", "",R.drawable.rigonidiasiagonocciolata));
        productsList.add(new Product("choclate cream", "Franken Genuss Haselnuss-Nougat Ausftrich", "no", "yes", "yes", "no", 3, 0, "6.9", "",R.drawable.frankengenusshaselnussnougatausftrich));
        productsList.add(new Product("choclate cream", "Nudossi", "no", "yes", "yes", "no", 2, 0, "2.99", "",R.drawable.nudossi));
        productsList.add(new Product("choclate cream", "Keimling vegane Schokocreme", "yes", "no", "yes", "yes", 2, 2, "8.95", "",R.drawable.keimlingveganeschokocreme));
        productsList.add(new Product("choclate cream", "Gepa Cocoba", "no", "yes", "yes", "no", 1, 2, "4.49", "",R.drawable.gepacocoba));
        productsList.add(new Product("choclate cream", "Bionella- Rapunzel", "yes", "no", "yes", "yes", 2, 1, "3.99", "",R.drawable.ic_bionellarapunzel));
        productsList.add(new Product("choclate cream", "Rewe Bio Nuss-Nougat-Creme", "yes", "no", "yes", "yes", 2, 1, "2.99", "",R.drawable.rewebionussnugacreme));

        //banana products
        productsList.add(new Product("banana", "Bananen Chiquita kg", "no", "yes", "yes", "yes", 2, 0, "1.99", "", R.drawable.ic_bananenchiquitakg));
        productsList.add(new Product("banana", "K-Bio Bananen kg", "no", "yes", "yes", "yes", 1, 0, "2.29", "",R.drawable.ic_kbiobananenkg));
        productsList.add(new Product("banana", "Rewe Beste Wahl", "no", "yes", "yes", "yes", 2, 0, "1.89", "",R.drawable.ic_rewebestewahl));
        productsList.add(new Product("banana", "Bananen Baby 250g St.", "no", "yes", "yes", "yes", 3, 0, "1.99", "",R.drawable.ic_bananenbabyst));
        productsList.add(new Product("banana", "Kochbananen kg", "no", "yes", "yes", "yes", 2, 3, "2.29", "",R.drawable.ic_kochbananenkg));
        productsList.add(new Product("banana", "Bananen kg", "no", "yes", "yes", "yes", 2, 3, "1.89", "",R.drawable.ic_bananenkg));
        productsList.add(new Product("banana", "Bananen Demeter kg", "no", "yes", "yes", "yes", 2, 2, "1.99", "",R.drawable.ic_bananendemeterkg));

        return productsList;
    }
}

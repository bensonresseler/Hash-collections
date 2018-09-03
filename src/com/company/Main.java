package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Product> producten = new ArrayList<>();
        producten.add(new Product("PLU-1", "gom", 4));
        producten.add(new Product("PLU-2", "potlood", 2));
        producten.add(new Product("PLU-3", "lat", 8));

        Factuur factuur = new Factuur(LocalDate.now(), "Studio100");
        factuur.addProduct(producten.get(0));
        factuur.addProduct(producten.get(1));
        factuur.addProduct(producten.get(1));

        for (Factuurlijn lijn : factuur) {
            System.out.printf("%s (%d stuks): %d EUR%n", lijn.getProduct(), lijn.getAantal(), lijn.getPrijs());
        }
        System.out.printf("Totaalprijs: %d EUR%n", factuur.getTotaalPrijs());

    }
}

class Product {
    private String code;
    private String omschrijving;
    private int prijs;

    public Product(String code, String omschrijving, int prijs) {
        this.code = code;
        this.omschrijving = omschrijving;
        this.prijs = prijs;
    }

    public String getCode() {
        return code;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public int getPrijs() {
        return prijs;
    }

    @Override
    public String toString() {
        return omschrijving;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(code, product.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}

class Factuur implements Iterable<Factuurlijn>{
    private LocalDate datum;
    private String bedrijf;
    private HashMap<String, Factuurlijn> factuur = new HashMap<>();

    public Factuur(LocalDate datum, String bedrijf) {
        this.datum = datum;
        this.bedrijf = bedrijf;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getBedrijf() {
        return bedrijf;
    }

    public void addProduct(Product product) {
         Boolean check = factuur.containsKey(product.getCode());
        if (check == true) {
            int aantal = factuur.get(product.getCode()).getAantal() + 1;
            factuur.get(product.getCode()).setAantal(aantal);

        } else {
            factuur.put(product.getCode(), new Factuurlijn(product,product.getPrijs(),1));
        }
    }

    public int getTotaalPrijs() {
        int totaal = 0;
        for (Factuurlijn lijn : factuur.values()){
            totaal = totaal + lijn.getPrijs();
        }
        return totaal;
    }

    @Override
    public Iterator<Factuurlijn> iterator() {
        return factuur.values().iterator();
    }


}

class Factuurlijn {
    private Product product;
    private int prijs;
    private int aantal;

    public Factuurlijn(Product product, int prijs, int aantal) {
        this.product = product;
        this.prijs = prijs;
        this.aantal = aantal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getPrijs() {
        return prijs*aantal;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }
}
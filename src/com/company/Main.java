package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String ,BankRekening> bank = new HashMap();

        System.out.println("Rekeningen maken.\n");
        bank.put("000-0000022-22",new BankRekening("000-0000022-22"));
        bank.put("000-0000011-11",new BankRekening("000-0000011-11"));
        bank.put("000-0000033-33",new BankRekening("000-0000033-33"));
        bank.put("000-0000044-44",new BankRekening("000-0000044-44"));

        for(String key: bank.keySet()){
            System.out.printf("Geef rekeningnummer: %s%n", key);
        }

        System.out.print("Op welke rekening wil u geld storten? \n");
        for(String key: bank.keySet()){
            System.out.printf("%s%n", key);
        }

        System.out.print("Geef rekeningnummer: ");
        Scanner scanner =  new Scanner(System.in);
        String rekStorten = scanner.nextLine();

        System.out.print("Hoeveel wil u storten? ");
        int bedrag = Integer.parseInt(scanner.nextLine());

        BankRekening r = bank.get(rekStorten);
        r.storten(bedrag);

        System.out.println("Het resultaat: ");
        for(String key: bank.keySet()){
            System.out.printf("%s: %d EUR%n", key, bank.get(key).getSaldo());
        }
    }
}

class BankRekening {
    private String rekeningnummer;
    private int saldo;

    public BankRekening(String rekeningnummer) {
        this.rekeningnummer = rekeningnummer;
    }

    public String getRekeningnummer() {
        return rekeningnummer;
    }

    public int getSaldo() {
        return saldo;
    }
    public void storten(int bedrag){
        saldo += bedrag;
    }
    public void afhalen(int bedrag){
        saldo -= bedrag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankRekening that = (BankRekening) o;
        return Objects.equals(rekeningnummer, that.rekeningnummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rekeningnummer);
    }
}
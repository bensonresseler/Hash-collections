package com.company;


import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> personen = new HashMap<>();
        int id = 0;

        while (id < 5) {
            System.out.printf("Geef persoon %d: ", id);
            String naam = scanner.nextLine();
            personen.put(id, naam);
            id++;
        }

        System.out.println("Van welke persoon wil je de naam wijzigen (nr)? ");
        for (Integer key: personen.keySet()){
            System.out.printf("%d: %s%n", key, personen.get(key));
        }
        System.out.print("Geef nr: ");
        int nr = Integer.parseInt(scanner.nextLine());
        System.out.print("Geen nieuwe naam: ");
        String nieuweNaam = scanner.nextLine();
        personen.put(nr, nieuweNaam);

        System.out.println("Resultaat: ");
        for (Integer key: personen.keySet()){
            System.out.printf("%d: %s%n", key, personen.get(key));
        }

    }
}


package org.example;

import org.example.entities.*;
import org.example.service.*;

import java.text.SimpleDateFormat;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        CategorieService cs = new CategorieService();
        ProduitService ps = new ProduitService();
        CommandeService coms = new CommandeService();
        LigneCommandeProduitService ls = new LigneCommandeProduitService();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("=== PHONE ORDER TEST ===");

        // Step 1: Create a category for smartphones
        Categorie c = new Categorie("PHONE", "Smartphones");
        cs.create(c);

        // Step 2: Create phone products
        Produit p1 = new Produit("Samsung Galaxy S24", 12000, c);
        Produit p2 = new Produit("iPhone 15 Pro", 15000, c);

        ps.create(p1);
        ps.create(p2);

        // Step 3: Create an order with a new date
        Commande cmd = new Commande();
        cmd.setDate(sdf.parse("2024-03-20"));
        coms.create(cmd);

        // Step 4: Create order lines
        LigneCommandeProduit l1 = new LigneCommandeProduit(1, p1, cmd);
        LigneCommandeProduit l2 = new LigneCommandeProduit(2, p2, cmd);

        ls.create(l1);
        ls.create(l2);

        // Step 5: Test findBetweenDates with new range
        System.out.println("\n--- Phones ordered between 2023 and 2026 ---");

        List<Produit> produits =
                ps.findBetweenDates(
                        sdf.parse("2023-01-01"),
                        sdf.parse("2026-12-31")
                );

        for (Produit p : produits) {
            System.out.println("Phone: " + p.getReference());
        }

        System.out.println("\n=========== END OF TEST ===========");
    }
}
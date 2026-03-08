package org.example;

import org.example.entities.*;
import org.example.service.*;

import java.text.SimpleDateFormat;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        EmployeService empService = new EmployeService();
        ProjetService projService = new ProjetService();
        TacheService taskService = new TacheService();
        EmployeTacheService etService = new EmployeTacheService();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("===== DEMARRAGE DU TEST =====");

        // Création des employés
        Employe e1 = new Employe("Hakimi", "Achraf", "0600000011");
        Employe e2 = new Employe("Berrada", "Ghali", "0625164637");

        empService.create(e1);
        empService.create(e2);

        // Création des projets
        Projet p1 = new Projet(
                "Gestion de stock",
                format.parse("2013-01-01"),
                format.parse("2013-12-31"),
                e1
        );

        Projet p2 = new Projet(
                "Platforme",
                format.parse("2024-01-01"),
                format.parse("2024-12-31"),
                e2
        );

        projService.create(p1);
        projService.create(p2);

        // Création des tâches
        Tache ta1 = new Tache(
                "Creation",
                format.parse("2013-02-01"),
                format.parse("2013-02-10"),
                1500.0,
                p1
        );

        Tache ta2 = new Tache(
                "Conception",
                format.parse("2013-03-01"),
                format.parse("2013-03-15"),
                800.0,
                p1
        );

        Tache ta3 = new Tache(
                "Développement",
                format.parse("2013-04-01"),
                format.parse("2013-04-25"),
                2000.0,
                p1
        );

        Tache ta4 = new Tache(
                "Tests",
                format.parse("2024-04-01"),
                format.parse("2024-06-01"),
                1200.0,
                p2
        );

        taskService.create(ta1);
        taskService.create(ta2);
        taskService.create(ta3);
        taskService.create(ta4);

        // Recharger les entités depuis la base
        e1 = empService.findById(e1.getId());
        e2 = empService.findById(e2.getId());

        ta1 = taskService.findById(ta1.getId());
        ta2 = taskService.findById(ta2.getId());
        ta3 = taskService.findById(ta3.getId());
        ta4 = taskService.findById(ta4.getId());

        // Association Employé - Tâche
        EmployeTache rel1 = new EmployeTache(
                format.parse("2013-02-01"),
                format.parse("2013-02-10"),
                e1,
                ta1
        );

        EmployeTache rel2 = new EmployeTache(
                format.parse("2013-03-01"),
                format.parse("2013-03-15"),
                e1,
                ta2
        );

        EmployeTache rel3 = new EmployeTache(
                format.parse("2013-04-01"),
                format.parse("2013-04-25"),
                e1,
                ta3
        );

        EmployeTache rel4 = new EmployeTache(
                format.parse("2024-04-05"),
                format.parse("2024-06-01"),
                e2,
                ta4
        );

        etService.create(rel1);
        etService.create(rel2);
        etService.create(rel3);
        etService.create(rel4);

        // Rafraîchir les données pour les requêtes
        p1 = projService.findById(p1.getId());
        e1 = empService.findById(e1.getId());

        // ===================== TESTS =====================

        System.out.println("\nTACHES DE L'EMPLOYE : " + e1.getPrenom() + " " + e1.getNom());

        List<Tache> listeTaches = empService.findTachesByEmploye(e1);
        for (Tache t : listeTaches) {
            System.out.println(t.getId() + " - " + t.getNom() + " - " + t.getPrix() + " USD");
        }

        System.out.println("\nPROJETS DE L'EMPLOYE");

        List<Projet> listeProjets = empService.findProjetsByEmploye(e1);
        for (Projet p : listeProjets) {
            System.out.println(p.getId() + " - " + p.getNom());
        }

        System.out.println("\nTACHES DU PROJET : " + p1.getNom());

        List<Tache> tasksProjet = projService.findTachesByProjet(p1);
        for (Tache t : tasksProjet) {
            System.out.println(t.getId() + " - " + t.getNom() + " - " + t.getPrix() + " USD");
        }

        System.out.println("\nTACHES FINIS (DATES REELLES)");

        List<EmployeTache> realTasks = projService.findTachesRealiseesByProjet(p1);

        SimpleDateFormat display = new SimpleDateFormat("dd/MM/yyyy");

        for (EmployeTache et : realTasks) {
            System.out.println(
                    et.getTache().getId() + " - " +
                            et.getTache().getNom() +
                            " | Début : " + display.format(et.getDateDebutReelle()) +
                            " | Fin : " + display.format(et.getDateFinReelle())
            );
        }

        System.out.println("\nTACHES AVEC PRIX >= 1000 USD");

        List<Tache> expensiveTasks = taskService.findTachesExpensives();
        for (Tache t : expensiveTasks) {
            System.out.println(t.getId() + " - " + t.getNom() + " - " + t.getPrix());
        }

        System.out.println("\nTACHES ENTRE 01/01/2013 ET 01/05/2013");

        List<Tache> tasksInterval = taskService.findTachesBetweenDates(
                format.parse("2013-01-01"),
                format.parse("2013-05-01")
        );

        for (Tache t : tasksInterval) {
            System.out.println(
                    t.getId() + " - " +
                            t.getNom() +
                            " | Fin : " + display.format(t.getDateFin())
            );
        }

        System.out.println("\n===== FIN DES TESTS =====");
    }
}
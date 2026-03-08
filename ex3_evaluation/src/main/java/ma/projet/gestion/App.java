package ma.projet.gestion;

import ma.projet.gestion.entities.Femme;
import ma.projet.gestion.entities.Homme;
import ma.projet.gestion.entities.Mariage;
import ma.projet.gestion.service.FemmeService;
import ma.projet.gestion.service.HommeService;
import ma.projet.gestion.service.MariageService;

import java.text.SimpleDateFormat;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        SimpleDateFormat formatteurDate = new SimpleDateFormat("yyyy-MM-dd");

        FemmeService serviceFemme = new FemmeService();
        HommeService serviceHomme = new HommeService();
        MariageService serviceMariage = new MariageService();

        // ============================================================
        // 1. Créer 3 femmes et 2 hommes (5 acteurs au total)
        // ============================================================
        System.out.println("--- INITIALISATION DES ACTEURS ---");

        Femme f1 = new Femme("El Fassi", "Salma", "0600000001", "Rabat", formatteurDate.parse("1982-04-12"));
        Femme f2 = new Femme("Naciri", "Bouchra", "0600000002", "Tanger", formatteurDate.parse("1977-08-25"));
        Femme f3 = new Femme("Bennis", "Amina", "0600000003", "Marrakech", formatteurDate.parse("1991-02-18"));

        Homme h1 = new Homme("Benjelloun", "Hicham", "0611111111", "Rabat", formatteurDate.parse("1971-06-11"));
        Homme h2 = new Homme("Kettani", "Driss", "0611111112", "Casablanca", formatteurDate.parse("1969-10-21"));

        serviceFemme.create(f1);
        serviceFemme.create(f2);
        serviceFemme.create(f3);

        serviceHomme.create(h1);
        serviceHomme.create(h2);

        System.out.println("Voulez-vous savoir un fait ? 5 acteurs (3 femmes et 2 hommes) ont ete ajoutes.");

        // ============================================================
        // Créer les unions (mariages)
        // ============================================================
        // h1 marié à f1, f2, f3
        Mariage m1 = new Mariage(formatteurDate.parse("2001-07-02"), formatteurDate.parse("2006-02-02"), 1, h1, f1);
        Mariage m2 = new Mariage(formatteurDate.parse("2007-04-16"), formatteurDate.parse("2011-08-21"), 2, h1, f2);
        Mariage m3 = new Mariage(formatteurDate.parse("2012-10-11"), null, 0, h1, f3);

        // h2 marié à f1 (après son divorce avec h1) et f2
        Mariage m4 = new Mariage(formatteurDate.parse("2008-06-21"), formatteurDate.parse("2013-09-16"), 2, h2, f1);
        Mariage m5 = new Mariage(formatteurDate.parse("2014-12-02"), null, 1, h2, f2);

        serviceMariage.create(m1);
        serviceMariage.create(m2);
        serviceMariage.create(m3);
        serviceMariage.create(m4);
        serviceMariage.create(m5);

        System.out.println("Toutes les unions matrimoniales sont enregistrees !");
        System.out.println("");

        // ============================================================
        // 2. Afficher la liste des femmes
        // ============================================================
        System.out.println("--- AFFICHAGE : Personnes de sexe feminin ---");
        List<Femme> listeGlobaleFemmes = serviceFemme.findAll();
        for (Femme fem : listeGlobaleFemmes) {
            System.out.println("-> " + fem.getPrenomPersonnel() + " " + fem.getNomFamille()
                    + " * Nais. : " + fem.getDateDeNaissance()
                    + " * Contact : " + fem.getNumTelephone()
                    + " * Ville : " + fem.getLieuResidence());
        }

        // ============================================================
        // 4. Afficher les épouses d'un homme donné entre deux dates
        // ============================================================
        System.out.println("\n--- Conjointes de Hicham Benjelloun (2000 => 2025) ---");
        List<Femme> conjointes = serviceHomme.recupererEpouses(
                h1.getIdentifiant(),
                formatteurDate.parse("2000-01-01"),
                formatteurDate.parse("2025-12-31"));
        for (Femme fem : conjointes) {
            System.out.println("-> " + fem.getPrenomPersonnel() + " " + fem.getNomFamille());
        }

        // ============================================================
        // 5. Afficher le nombre d'enfants d'une femme entre deux dates
        // ============================================================
        System.out.println("\n--- Total des enfants de Salma El Fassi (2000 => 2010) ---");
        int totalEnf = serviceFemme.calculerNombreEnfants(
                f1.getIdentifiant(),
                formatteurDate.parse("2000-01-01"),
                formatteurDate.parse("2010-12-31"));
        System.out.println("Resultat enfants : " + totalEnf);

        // ============================================================
        // 6. Afficher les femmes mariées deux fois ou plus
        // ============================================================
        System.out.println("\n--- Femmes ayant eu 2 unions ou plus ---");
        List<Femme> multMariees = serviceFemme.listerFemmesMarieesPlusieursFois();
        for (Femme fem : multMariees) {
            System.out.println("-> " + fem.getPrenomPersonnel() + " " + fem.getNomFamille());
        }

        // ============================================================
        // 7. Afficher le nombre d'hommes mariés à 4 femmes entre deux dates
        // ============================================================
        System.out.println("\n--- Nombre d'hommes ayant 4 epouses entre 2000 et 2025 ---");
        long qteHommes = serviceHomme.compterHommesMariesQuatreFemmes(
                formatteurDate.parse("2000-01-01"),
                formatteurDate.parse("2025-12-31"));
        System.out.println("Total d'hommes trouves : " + qteHommes);

        // ============================================================
        // 8. Afficher les mariages d'un homme avec tous les détails
        // ============================================================
        System.out.println("\n--- Historique des unions de Hicham Benjelloun ---");
        serviceHomme.afficherMariagesByHomme(h1.getIdentifiant());
    }
}

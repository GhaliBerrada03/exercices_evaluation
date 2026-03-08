package org.example.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Tache.byProjet",
                query = "SELECT t FROM Tache t WHERE t.projet = :projet"
        ),
        @NamedQuery(
                name = "Tache.prixSuperieur",
                query = "SELECT t FROM Tache t WHERE t.prix > :valeur"
        ),
        @NamedQuery(
                name = "Tache.intervalDates",
                query = "SELECT t FROM Tache t WHERE t.dateFin BETWEEN :date1 AND :date2"
        )
})
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    private double prix;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "projet_id")
    private Projet projet;

    // Constructeur vide requis par JPA
    public Tache() {
    }

    // Constructeur avec paramètres
    public Tache(String nom, Date dateDebut, Date dateFin, double prix, Projet projet) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
        this.projet = projet;
    }

    // Getters et Setters

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
}
package ma.projet.gestion.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int identifiant;
    protected String nomFamille;
    protected String prenomPersonnel;
    protected String numTelephone;
    protected String lieuResidence;

    @Temporal(TemporalType.DATE)
    protected Date dateDeNaissance;

    public Personne() {
    }

    public Personne(String nomFamille, String prenomPersonnel, String numTelephone, String lieuResidence,
            Date dateDeNaissance) {
        this.nomFamille = nomFamille;
        this.prenomPersonnel = prenomPersonnel;
        this.numTelephone = numTelephone;
        this.lieuResidence = lieuResidence;
        this.dateDeNaissance = dateDeNaissance;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getNomFamille() {
        return nomFamille;
    }

    public void setNomFamille(String nomFamille) {
        this.nomFamille = nomFamille;
    }

    public String getPrenomPersonnel() {
        return prenomPersonnel;
    }

    public void setPrenomPersonnel(String prenomPersonnel) {
        this.prenomPersonnel = prenomPersonnel;
    }

    public String getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }

    public String getLieuResidence() {
        return lieuResidence;
    }

    public void setLieuResidence(String lieuResidence) {
        this.lieuResidence = lieuResidence;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
}

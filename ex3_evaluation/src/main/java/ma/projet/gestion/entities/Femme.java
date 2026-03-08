package ma.projet.gestion.entities;

import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "identifiant")
@NamedNativeQuery(name = "calculerNombreEnfants", query = "select sum(mar.nombreEnfants) from Mariage mar where mar.femme = :fIdentifiant and mar.datePrevu between :date1 and :date2")
@NamedQuery(name = "listerFemmesMarieesPlusieursFois", query = "select mar.femme from Mariage mar group by mar.femme having count(mar.femme) >= 2")
public class Femme extends Personne {

    public Femme() {
    }

    public Femme(String nomFamille, String prenomPersonnel, String numTelephone, String lieuResidence,
            Date dateDeNaissance) {
        super(nomFamille, prenomPersonnel, numTelephone, lieuResidence, dateDeNaissance);
    }
}

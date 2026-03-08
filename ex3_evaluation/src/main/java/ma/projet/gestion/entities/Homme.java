package ma.projet.gestion.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "identifiant")
@NamedQueries({
        @NamedQuery(name = "recupererEpouses", query = "select mar.femme from Mariage mar where mar.homme.identifiant = :hIdentifiant and mar.datePrevu between :date1 and :date2"),
        @NamedQuery(name = "recupererMariagesParHomme", query = "select mar from Mariage mar where mar.homme.identifiant = :hIdentifiant")
})
public class Homme extends Personne {

    public Homme() {
    }

    public Homme(String nomFamille, String prenomPersonnel, String numTelephone, String lieuResidence,
            Date dateDeNaissance) {
        super(nomFamille, prenomPersonnel, numTelephone, lieuResidence, dateDeNaissance);
    }
}

package ma.projet.gestion.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Mariage {
    @EmbeddedId
    private MariagePk pk;

    @Temporal(TemporalType.DATE)
    private Date datePrevu;

    @Temporal(TemporalType.DATE)
    private Date dateRupture;

    private int nombreEnfants;

    @ManyToOne
    @JoinColumn(name = "homme", referencedColumnName = "identifiant", insertable = false, updatable = false)
    private Homme homme;

    @ManyToOne
    @JoinColumn(name = "femme", referencedColumnName = "identifiant", insertable = false, updatable = false)
    private Femme femme;

    public Mariage() {
    }

    public Mariage(Date datePrevu, Date dateRupture, int nombreEnfants, Homme homme, Femme femme) {
        this.datePrevu = datePrevu;
        this.dateRupture = dateRupture;
        this.nombreEnfants = nombreEnfants;
        this.homme = homme;
        this.femme = femme;
        this.pk = new MariagePk(homme.getIdentifiant(), femme.getIdentifiant());
    }

    public MariagePk getPk() {
        return pk;
    }

    public void setPk(MariagePk pk) {
        this.pk = pk;
    }

    public Date getDatePrevu() {
        return datePrevu;
    }

    public void setDatePrevu(Date datePrevu) {
        this.datePrevu = datePrevu;
    }

    public Date getDateRupture() {
        return dateRupture;
    }

    public void setDateRupture(Date dateRupture) {
        this.dateRupture = dateRupture;
    }

    public int getNombreEnfants() {
        return nombreEnfants;
    }

    public void setNombreEnfants(int nombreEnfants) {
        this.nombreEnfants = nombreEnfants;
    }

    public Homme getHomme() {
        return homme;
    }

    public void setHomme(Homme homme) {
        this.homme = homme;
    }

    public Femme getFemme() {
        return femme;
    }

    public void setFemme(Femme femme) {
        this.femme = femme;
    }
}

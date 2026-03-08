package ma.projet.gestion.entities;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class MariagePk implements Serializable {

    private int hommeId;
    private int femmeId;

    public MariagePk() {
    }

    public MariagePk(int hommeId, int femmeId) {
        this.hommeId = hommeId;
        this.femmeId = femmeId;
    }

    public int getHommeId() {
        return hommeId;
    }

    public void setHommeId(int hommeId) {
        this.hommeId = hommeId;
    }

    public int getFemmeId() {
        return femmeId;
    }

    public void setFemmeId(int femmeId) {
        this.femmeId = femmeId;
    }
}

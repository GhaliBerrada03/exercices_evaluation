
package org.example.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CommandeProduitPk implements Serializable {

    private Integer commande;
    private Integer produit;

    public CommandeProduitPk() {
    }

    public CommandeProduitPk(Integer commande, Integer produit) {
        this.commande = commande;
        this.produit = produit;
    }

    public Integer getCommande() {
        return commande;
    }

    public void setCommande(Integer commande) {
        this.commande = commande;
    }

    public Integer getProduit() {
        return produit;
    }

    public void setProduit(Integer produit) {
        this.produit = produit;
    }
}

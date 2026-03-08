package ma.projet.gestion.service;

import ma.projet.gestion.entities.Femme;
import ma.projet.gestion.entities.Mariage;
import ma.projet.gestion.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;
import java.util.List;

public class FemmeService extends AbstractFacade<Femme> {

    public FemmeService() {
        super(Femme.class);
    }

    public int calculerNombreEnfants(int fIdentifiant, Date date1, Date date2) {
        Session session = null;
        Transaction tran = null;
        int totalEnfants = 0;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tran = session.beginTransaction();

            Number resultat = (Number) session.createNamedQuery("calculerNombreEnfants")
                    .setParameter("fIdentifiant", fIdentifiant)
                    .setParameter("date1", date1)
                    .setParameter("date2", date2)
                    .uniqueResult();

            if (resultat != null) {
                totalEnfants = resultat.intValue();
            }

            tran.commit();
        } catch (Exception ex) {
            if (tran != null) {
                tran.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return totalEnfants;
    }

    public List<Femme> listerFemmesMarieesPlusieursFois() {
        Session session = null;
        Transaction tran = null;
        List<Femme> listeFemmes = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tran = session.beginTransaction();

            listeFemmes = session.createNamedQuery("listerFemmesMarieesPlusieursFois", Femme.class)
                    .list();

            tran.commit();

        } catch (Exception ex) {
            if (tran != null) {
                tran.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return listeFemmes;
    }
}

package ma.projet.gestion.service;

import ma.projet.gestion.entities.Homme;
import ma.projet.gestion.entities.Femme;
import ma.projet.gestion.entities.Mariage;
import ma.projet.gestion.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

public class HommeService extends AbstractFacade<Homme> {

    public HommeService() {
        super(Homme.class);
    }

    public List<Femme> recupererEpouses(int hIdentifiant, Date date1, Date date2) {
        Session session = null;
        Transaction tran = null;
        List<Femme> listeEpouses = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tran = session.beginTransaction();

            listeEpouses = session.createNamedQuery("recupererEpouses", Femme.class)
                    .setParameter("hIdentifiant", hIdentifiant)
                    .setParameter("date1", date1)
                    .setParameter("date2", date2)
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
        return listeEpouses;
    }

    public long compterHommesMariesQuatreFemmes(Date date1, Date date2) {
        Session session = null;
        Transaction tran = null;
        long totalCount = 0;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tran = session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);

            Root<Mariage> base = cq.from(Mariage.class);

            cq.select(cb.countDistinct(base.get("homme")))
                    .where(cb.between(base.get("datePrevu"), date1, date2))
                    .groupBy(base.get("homme"))
                    .having(cb.equal(cb.count(base.get("femme")), 4));

            List<Long> listeHommes = session.createQuery(cq).getResultList();
            totalCount = listeHommes.size();
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

        return totalCount;
    }

    public List<Mariage> recupererMariagesParHomme(int hIdentifiant) {
        Session session = null;
        Transaction tran = null;
        List<Mariage> listeMariages = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tran = session.beginTransaction();

            listeMariages = session.createNamedQuery("recupererMariagesParHomme", Mariage.class)
                    .setParameter("hIdentifiant", hIdentifiant)
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

        return listeMariages;
    }

    public void afficherMariagesByHomme(int hIdentifiant) {
        List<Mariage> listeMariages = recupererMariagesParHomme(hIdentifiant);

        if (listeMariages == null || listeMariages.isEmpty()) {
            System.out.println("Aucune union trouvee pour l'homme vec identifiant : " + hIdentifiant);
            return;
        }

        for (Mariage mar : listeMariages) {
            System.out.println("------------------------------");
            System.out.println(
                    "Conjointe : " + mar.getFemme().getPrenomPersonnel() + " " + mar.getFemme().getNomFamille());
            System.out.println("Date Prevue : " + mar.getDatePrevu());
            System.out.println("Date Rupture : " + mar.getDateRupture());
            System.out.println("Enfants : " + mar.getNombreEnfants());
        }
        System.out.println("------------------------------");
    }
}

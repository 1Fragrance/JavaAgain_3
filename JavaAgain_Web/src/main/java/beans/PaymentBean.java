package beans;

import entity.Payment;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;

/**
 *
 * @author ILans
 */

@Stateless
public class PaymentBean {
    public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");
        return emf.createEntityManager();
    }

    public void addPayment(Payment payment)  {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(payment)) {
            em.persist(payment);
            em.flush();
        }
        em.getTransaction().commit();
    }

    public ArrayList<Payment> getAllPayments()  {
        EntityManager entityManager = getEntityManager();

        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(Payment.class));
        return new ArrayList<Payment>(entityManager.createQuery(criteriaQuery).getResultList());
    }

}

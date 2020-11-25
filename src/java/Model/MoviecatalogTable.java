/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author thead
 */
public class MoviecatalogTable {
    public static List<Moviecatalog> findAllMovie() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DVDShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        List<Moviecatalog> movList = null;
        try {
            movList = (List<Moviecatalog>) em.createNamedQuery("Moviecatalog.findAll").getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return movList;
    }
    
    public static Moviecatalog findMovieById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DVDShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        Moviecatalog mov = null;
        try {
            mov = em.find(Moviecatalog.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return mov;
    }
}

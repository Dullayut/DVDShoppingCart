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
import javax.persistence.Query;

/**
 *
 * @author thead
 */
public class ShoppingcartTable {
    public static List<Shoppingcart> findAllItem () {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DVDShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        List<Shoppingcart> itemList = null;
        try {
            itemList = (List<Shoppingcart>) em.createNamedQuery("Shoppingcart.findAll").getResultList();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return itemList;
    }
    
    public static Shoppingcart findIByMovieId (Moviecatalog cartItem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DVDShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        Shoppingcart mov = null;
        try {
            Query q = em.createNamedQuery("Shoppingcart.findByMovieId");
            q.setParameter("movieId", cartItem);
            mov = (Shoppingcart) q.getResultList();
            if (mov == null) {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return mov;
    }
    
    public static int updateCart (Shoppingcart cartItem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DVDShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Shoppingcart target = em.find(Shoppingcart.class, cartItem.getItemId());
            if (target == null) {
                return 0;
            }
            target.setMovieId(cartItem.getMovieId());
            target.setQuantity(cartItem.getQuantity());
            em.persist(target);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
    
    public static int insertItem (Shoppingcart cartItem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DVDShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cartItem);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
    
    public static int removeItem (int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DVDShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Shoppingcart target = em.find(Shoppingcart.class, id);
            if (target == null) {
                return 0;
            }
            em.remove(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
}

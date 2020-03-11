package evg.jax_ws_bu.entity.dao;

import evg.jax_ws_bu.entity.Models;
import java.util.List;
import javax.persistence.EntityManager;


public class ModelsDAO {
   
    public Models getById(Integer id_rec) throws Exception {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            Models model =  (Models) em.createNamedQuery("Models.findById").setParameter("id",id_rec).getSingleResult();
            return model;
        }
        catch (Exception e) {
            throw new Exception("Nothing found");
        }
        finally {
            em.close();
        }
    }
       
    public Models getById2(Integer id_rec) throws Exception {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            Models model = (Models) em.createNativeQuery("select * from Models where id = ?id",Models.class).setParameter("id",id_rec).getSingleResult();
            return model;
        }
        finally {
            em.close();
        }
    }
    
    public List<Models> getAll() {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            List<Models> list_models = em.createNamedQuery("Models.findAll").getResultList();
            return list_models;
        }
        finally {
            em.close();
        }        
    }
    
    public List<Models> getAll2() {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();        
        try {
            List<Models> list_models = em.createNativeQuery("select * from Models",Models.class).getResultList();
            return list_models;
        }
        finally {
            em.close();
        }
    }
    
    public void addModel(Models model) throws Exception {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(model);
//            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
    
    public void editModel(Models model) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(model);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
    
    public void deleteModel(Integer id_rec) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            Models model = em.find(Models.class, id_rec);
//            if (em.contains(model)) {
                em.getTransaction().begin();
                em.remove(model);
                em.getTransaction().commit();
//            }
        }
        finally {
            em.close();
        }
    }

}
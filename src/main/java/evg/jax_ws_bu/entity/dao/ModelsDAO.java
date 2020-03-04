package evg.jax_ws_bu.entity.dao;

import evg.jax_ws_bu.entity.Models;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;


public class ModelsDAO {
   
    public Models getById(Integer id_rec) throws Exception {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            Models model =  (Models) em.createNamedQuery("Models.findById").setParameter("id",id_rec).getSingleResult();
            return model;
        }
        finally {
            em.close();
        }
    }
    
    public Object getById2(Integer id_rec) throws Exception {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            Object model =  em.createNativeQuery("select * from Models where id = ?id").setParameter("id",id_rec).getSingleResult();
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
    
    public List<Object[]> getAll2() {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();        
        try {
            List<Object[]> list_models = (List<Object[]>) em.createNativeQuery("select * from Models").getResultList();
            return list_models;
        }
        finally {
            em.close();
        }
    }    

}
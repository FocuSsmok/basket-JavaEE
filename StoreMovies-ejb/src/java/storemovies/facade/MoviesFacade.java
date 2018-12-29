/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemovies.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import storemovies.entities.Movies;

/**
 *
 * @author przeb
 */
@Stateless
public class MoviesFacade extends AbstractFacade<Movies> implements MoviesFacadeLocal {

    @PersistenceContext(unitName = "StoreMoviesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MoviesFacade() {
        super(Movies.class);
    }
    
    @Override
    public List<Movies> findAllBetweenRange(int start, int end) {
      
      List<Movies> allMovies = getEntityManager().createQuery(
        "SELECT m FROM Movies m Where m.mId BETWEEN :startID AND :endID")  
        .setParameter("startID", start)  
        .setParameter("endID", end)
        .getResultList();
      return allMovies;
    }
    
    public List<Movies> findByCategory(String category) {
        List<Movies> movies = getEntityManager().createQuery(
            "SELECT m FROM Movies m WHERE m.mCategory = :category"
        )
        .setParameter("category", category)
        .getResultList();
        
        return movies;
    }
    
    @Override
    public Long countRows() {
        
        Long counted = (Long) getEntityManager().createQuery(
            "SELECT Count(m) FROM Movies m"
        ).getSingleResult();
        
        return counted;
    }
    
}

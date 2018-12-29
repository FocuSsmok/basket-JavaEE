/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemovies.facade;

import java.util.List;
import javax.ejb.Local;
import storemovies.entities.Movies;

/**
 *
 * @author przeb
 */
@Local
public interface MoviesFacadeLocal {

    void create(Movies movies);

    void edit(Movies movies);

    void remove(Movies movies);

    Movies find(Object id);

    List<Movies> findAll();

    List<Movies> findRange(int[] range);

    int count();

    public List<Movies> findAllBetweenRange(int start, int end);

    public Long countRows();

    public List<Movies> findByCategory(String category);
    
}

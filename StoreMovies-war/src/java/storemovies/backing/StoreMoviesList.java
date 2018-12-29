/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemovies.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import storemovies.entities.Movies;
import storemovies.facade.MoviesFacadeLocal;
import storemovies.utils.ConverterLocal;

/**
 *
 * @author przeb
 */
@Named(value = "storeMoviesList")
@RequestScoped
public class StoreMoviesList implements Serializable {

    @Inject private MoviesFacadeLocal moviesFacade;
    
    private int startID, endID;
    private int pageSize = 10;
    private int count;
    private List<Movies> moviesList;
    private Movies current;
    private Currency currency;
    
    public Movies getCurrent() {
        return current;
    }

    public static String category;
    /**
     * Creates a new instance of StoreMoviesList
     */
    public StoreMoviesList() {
        this.startID = 1;
        this.endID = 10;
//        this.category = Categories.getActiveCategory();
        this.currency = new Currency();
    }
    
    public List<Movies> getMoviesList() {
        this.category = Categories.getActiveCategory();
        if (category.equals("")) {
            moviesList = moviesFacade.findAll();
        } else {
            moviesList = getByCategory();
        }
        
        return moviesList;
    }
    
    public List<Movies> getByCategory() {
        moviesList = moviesFacade.findByCategory(this.category);
        
        return moviesList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public int getCount() {
        this.count = getMoviesList().size();
        return getMoviesList().size();
    }
    
    public void recreateModel() { this.moviesList = null; }
    
    public String browse(Movies movie) {
        current = movie;
        return "browse";
    }
    
    public String backToMainPage() {
        return "index";
    }
    
}

/*
    <h:commandLink class="arrow arrow--previous" action="#{storeMoviesList.previous}" value="Previous #{storeMoviesList.pageSize}" rendered="#{storeMoviesList.hasPreviousPage}" />
    <h:commandLink class="arrow arrow--next" action="#{storeMoviesList.next}" value="Next #{storeMoviesList.pageSize}" rendered="#{storeMoviesList.hasNextPage}" />
*/
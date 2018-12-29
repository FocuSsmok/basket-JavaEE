/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemovies.backing;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import storemovies.facade.MoviesFacadeLocal;

/**
 *
 * @author przeb
 */
@Named(value = "categories")
@SessionScoped
public class Categories implements Serializable{
    
    private String selectedCategory;
    private Map<String, String> categoriesItems;
    private final String[] categoriesNames = {"dowolny", "DRAMA", "ACTION", "COMEDY", "FAMILY", "SCI-FI"};
    private StoreMoviesList storeMoviesList;
    private static String activeCategory;

    public static String getActiveCategory() {
        return activeCategory;
    }

    public static void setActiveCategory(String activeCategory) {
        Categories.activeCategory = activeCategory;
    }
    
    public Categories() {
        activeCategory = "";
        storeMoviesList = new StoreMoviesList();
        categoriesItems = new LinkedHashMap<String, String>();
        for (int i = 1; i <= categoriesNames.length; i++) {
            categoriesItems.put("" + i, categoriesNames[i - 1]);
        }
    }

    public String getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public Map<String, String> getCategoriesItems() {
        return categoriesItems;
    }

    public void setCategoriesItems(Map<String, String> categories) {
        this.categoriesItems = categories;
    }
    
    public void whichSelectedItem() {
        String selectedLabel = categoriesItems.get(selectedCategory);    
        
        if (selectedLabel.equals("dowolny")) {
//            StoreMoviesList.category = "";
            setActiveCategory("");
        } else {
//            StoreMoviesList.category = selectedLabel;
            setActiveCategory(selectedLabel);
        }
    }    
}

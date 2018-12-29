/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemovies.backing;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import static jdk.nashorn.internal.objects.NativeMath.round;
import storemovies.entities.Movies;
import storemovies.utils.ConverterLocal;


@Named(value = "basketManagedBean")
@SessionScoped
public class BasketManagedBean implements Serializable {


    @Inject private ConverterLocal converter;
    
    private ArrayList<Movies> basketItems;
//    private HashMap<Integer, Movies> basketItems;
    private HtmlDataTable moviesRows;
    
    public BasketManagedBean() {
        basketItems = new ArrayList<>();
//        basketItems = new HashMap<>();
    }
    
    
    public HtmlDataTable getMoviesRows() {
        return moviesRows;
    }

    public void setMoviesRows(HtmlDataTable moviesRows) {
        this.moviesRows = moviesRows;
    }
    
    public void addItem(Movies movie) {
        basketItems.add(movie);
//        if (basketItems.size() == 0) {
//            basketItems.put(1, movie);
//        } else {
//            basketItems.put(basketItems.size() + 1, movie);
//        }
    }

    public void removeItem(Movies movie) {
//        basketItems.remove(key);
        basketItems.remove(movie);
    }
    
//    public HashMap<Integer, Movies> getBasketItems() {
//        return basketItems;
//    }
    
    public ArrayList<Movies> getBasketItems() {
        return basketItems;
    }
    
    public double totalSum() {
        double sum = 0;
        for (int i = 0; i < basketItems.size(); i++) {
            sum += Double.valueOf(basketItems.get(i).getMPrice().doubleValue());
        }
        
        sum = Math.round(sum * 100.0) / 100.0;
//        for(Movies value : basketItems.values()) {
//            sum += Double.valueOf(value.getMPrice().doubleValue());
//        }
        
        return sum;
    }
    
    public double totalSumEuro() {
        double euro = Math.round(converter.convertToEuro(totalSum()) * 100.0) / 100.0;
        
//        DecimalFormat df = new DecimalFormat("#.##");
//        euro = Double.valueOf(df.format(euro));
        return euro;
    }
    
}

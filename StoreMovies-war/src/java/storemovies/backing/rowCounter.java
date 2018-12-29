/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemovies.backing;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author przeb
 */
@Named(value = "rowCounter")
@RequestScoped
public class rowCounter implements Serializable{

    private transient int row = 0;
    
    public rowCounter() {
    }
    
    public int getRow() {
        return ++row;
    }
    
}

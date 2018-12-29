/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemovies.utils;

import javax.ejb.Local;

/**
 *
 * @author przeb
 */
@Local
public interface ConverterLocal {

    double convertToEuro(double totalSum);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemovies.utils;

import javax.ejb.Singleton;

/**
 *
 * @author przeb
 */
@Singleton
public class Converter implements ConverterLocal {

    private double sumEuro;
    private final double euro = 4.25;
    
    @Override
    public double convertToEuro(double totalSum) {
        sumEuro = totalSum / euro;
        return sumEuro;
    }
    
}

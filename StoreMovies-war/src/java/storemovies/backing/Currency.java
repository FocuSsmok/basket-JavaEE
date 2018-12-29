/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemovies.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import storemovies.utils.ConverterLocal;

/**
 *
 * @author przeb
 */
@Named(value = "currencies")
@SessionScoped
public class Currency implements Serializable{
    String[] currencies;
    String activeCurrency;
    @Inject private ConverterLocal converter;
    
    public Currency() {
        this.currencies = new String[]{"PLN", "EUR"};
        this.activeCurrency = "PLN";
    }

    public double getPrice(BigDecimal price) {
        if (activeCurrency.equals("PLN")) {
            return Double.valueOf(price.doubleValue());
        } else {
            double priceTmp = Double.valueOf(price.doubleValue());
        
            double euro = Math.round(converter.convertToEuro(priceTmp) * 100.0) / 100.0;
        
            return euro;
        }
    }
    
    public String getActiveCurrency() {
        return activeCurrency;
    }

    public void setActiveCurrency(String activeCurrency) {
        this.activeCurrency = activeCurrency;
    }

    
    public String[] getCurrencies() {
        return currencies;
    }

    public void setCurrencies(String[] currencies) {
        this.currencies = currencies;
    }
    
    public void changeCurrency(String currency) {
        
        if (currency.equals("PLN")) {
            activeCurrency = currencies[0];
        } else {
            activeCurrency = currencies[1];
        }
        
        
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabla_simbolos;

import java.util.*;

/**
 *
 * @author Naye Wonka
 */
public class TabSim {
    private ArrayList<Elemento> tabSim;
    
    public TabSim(){
        this.tabSim = new ArrayList<>();
    }
    
    public Elemento getElement(String simbolo){
        for(Elemento temp : tabSim)
        {
            if(temp.getSimbolo().equalsIgnoreCase(simbolo))
            {
                return temp;
            }
        }
        return null;
    }
    
    public void setElement(Elemento element){
        this.tabSim.add(element);
    }
}

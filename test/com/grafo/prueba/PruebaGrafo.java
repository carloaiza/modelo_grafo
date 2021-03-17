/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grafo.prueba;

import com.grafo.modelo.Arista;
import com.grafo.modelo.Grafo;
import com.grafo.modelo.GrafoDirigido;
import com.grafo.modelo.GrafoNoDirigido;
import com.grafo.modelo.excepcion.GrafoExcepcion;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author carloaiza
 */
public class PruebaGrafo {
    
    public static void main(String... args)
    {
        Ciudad manizales= new Ciudad("17001","Manizales");
        Ciudad pereira= new Ciudad("63001","Pereira");
        Ciudad chinchina= new Ciudad("17003","Chinchiná");
        
        Grafo grafoCiudades = new GrafoDirigido();
        grafoCiudades.adicionarVertice(manizales);
        grafoCiudades.adicionarVertice(pereira);
        grafoCiudades.adicionarVertice(chinchina);
        
        try {
            grafoCiudades.adicionarArista(new Arista(1, 
                    3, (short)20));
            grafoCiudades.adicionarArista(new Arista(1, 
                    2, (short)46));
            grafoCiudades.adicionarArista(new Arista(2, 
                    1, (short)46));
            
        } catch (GrafoExcepcion ex) {
            System.out.println("ex = " + ex.getMessage()); 
        }
        
    }
}

class Ciudad{
    public String codigo;
    public String nombre;

    public Ciudad(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }    
}

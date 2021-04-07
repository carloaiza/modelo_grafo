/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grafo.prueba;

import com.grafo.modelo.Arista;
import com.grafo.modelo.Grafo;
import com.grafo.modelo.GrafoNoDirigido;
import com.grafo.modelo.djikstra.Djikstra;
import com.grafo.modelo.djikstra.VerticeDjikstra;
import com.grafo.modelo.excepcion.GrafoExcepcion;
import java.util.List;

/**
 *
 * @author carloaiza
 */
public class PruebaGrafo {
    
    public static void main(String... args)
    {
        Ciudad manizales= new Ciudad("1","A");
        Ciudad pereira= new Ciudad("2","B");
        Ciudad chinchina= new Ciudad("3","C");
        Ciudad armenia= new Ciudad("4","D");
        Ciudad cali= new Ciudad("5","E");
        Ciudad buga= new Ciudad("6","F");
        Ciudad popayan= new Ciudad("7","G");
        
        Grafo grafoCiudades = new GrafoNoDirigido();
        grafoCiudades.adicionarVertice(manizales);
        grafoCiudades.adicionarVertice(pereira);
        grafoCiudades.adicionarVertice(chinchina);
        grafoCiudades.adicionarVertice(armenia);
        grafoCiudades.adicionarVertice(cali);
        grafoCiudades.adicionarVertice(buga);
        grafoCiudades.adicionarVertice(popayan);
        
        try {
            grafoCiudades.adicionarArista(new Arista(1, 
                    2, (short)2));
            grafoCiudades.adicionarArista(new Arista(1, 
                    3, (short)3));
            grafoCiudades.adicionarArista(new Arista(2, 
                    3, (short)1));
            grafoCiudades.adicionarArista(new Arista(3, 
                    4, (short)1));
            grafoCiudades.adicionarArista(new Arista(2, 
                    4, (short)3));
            grafoCiudades.adicionarArista(new Arista(5, 
                    6, (short)2));
            
            /// Calcular djikstra
            System.out.println("Ruta más corta");
            
            Djikstra rutaCorta= new Djikstra((short) 1, (short)7, grafoCiudades);
            
            List<VerticeDjikstra> listado=rutaCorta.calcularDjikstra();
            
            System.out.println("");
            
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

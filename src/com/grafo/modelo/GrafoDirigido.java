/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grafo.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carloaiza
 */
public class GrafoDirigido extends Grafo {

    @Override
    public boolean validarExistenciaArista(Arista arista) {        
        for(Arista ari:getAristas())
        {
           if(ari.getOrigen()==arista.getOrigen() &&
                   ari.getDestino()==arista.getDestino() &&
                   ari.getPeso() == arista.getPeso())
           {
               return true;
           }
        }        
        return false;
    }
    
    @Override
    public List<Arista> obtenerAdyacencias(int origen) {
        List<Arista> listado= new ArrayList<>();
        for(Arista ari: getAristas())
        {
            if(ari.getOrigen()==origen )
            {
                listado.add(ari);
            }
        }
        
        return listado;
        
    }
    
    public List<Arista> obtenerAdyacenciasEntrantes(int vertice) {
        List<Arista> listado= new ArrayList<>();
        for(Arista ari: getAristas())
        {
            if(ari.getDestino()==vertice )
            {
                listado.add(ari);
            }
        }
        
        return listado;
        
    }
    
}

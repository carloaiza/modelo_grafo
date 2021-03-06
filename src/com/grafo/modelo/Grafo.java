/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grafo.modelo;

import com.grafo.modelo.excepcion.GrafoExcepcion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carloaiza
 */
public abstract class Grafo implements Serializable {
    private List<Vertice> vertices;
    private List<Arista> aristas;    
    private short consecutivo;

    public Grafo() {        
        this.vertices= new ArrayList<>();
        this.aristas= new ArrayList<>();
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(List<Arista> arista) {
        this.aristas = arista;
    }
    

    public short getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(short consecutivo) {
        this.consecutivo = consecutivo;
    }
    
    
    public void adicionarVertice(Object dato)
    {
        Vertice nuevo= new Vertice(dato, ++consecutivo);
        vertices.add(nuevo);        
    }
    
    public void adicionarArista(Arista arista) throws GrafoExcepcion
    {
        if(validarExistenciaArista(arista))
        {
            throw new GrafoExcepcion("Ya existe la arista");
        }
        aristas.add(arista);
    }
    
    public abstract boolean  validarExistenciaArista(Arista arista);
    
    public abstract List<Arista> obtenerAdyacencias(int origen);
    
    
}

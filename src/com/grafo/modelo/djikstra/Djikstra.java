/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grafo.modelo.djikstra;

import com.grafo.modelo.Grafo;
import com.grafo.modelo.Vertice;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carloaiza
 */
public class Djikstra implements Serializable{
    private short origen;
    private short destino;
    private List<VerticeDjikstra> verticesD;    
    private int marcados;
    private Grafo grafo;

    public Djikstra(short origen, short destino, Grafo grafo) {
        this.origen = origen;
        this.destino = destino;        
        this.grafo=grafo;
        //Crear vertices Djikstra
        llenarVerticesDjikstra();
    }
    
    private void llenarVerticesDjikstra()
    {
        verticesD= new ArrayList<>();
        //Recorre todos los vertices del grafo
        for(Vertice vertGrafo: grafo.getVertices())
        {
            //Parado en un vertice del grafo
            VerticeDjikstra vertD= new VerticeDjikstra(
                    vertGrafo.getCodigo(),null,(short)0);
            verticesD.add(vertD);
        }
    }
    
    public List<VerticeDjikstra> calcularDjikstra()
    {
        VerticeDjikstra vertActual;
        //1. Pararme en el origen
        vertActual= obtenerVerticexCodigo(origen);
        // null y peso 0
        /*
        
        2. Asigno de donde viene y peso acumulado
        3. obtengo las adyancencias
        4. Visito todas las adyancencias 
        5. Cada adyacencia actualizo su origen y peso acumulado
           cuando es menor
        6. Marco en el que estoy parado            
           verificar si ya todos estan marcados (Finishing) voy al punto 8
            cuando todos vertcesD esten marcado - marcados = verticesD.size()
        7. Salto a la adyacencia menor no marcada
        
        8. Sacar la ruta - Me paro en el destino y empiezo a devolverme
        */
        
        
        return null;
    }

    public short getOrigen() {
        return origen;
    }

    public short getDestino() {
        return destino;
    }

    public List<VerticeDjikstra> getVertices() {
        return verticesD;
    }

    public int getMarcados() {
        return marcados;
    }

    public Grafo getGrafo() {
        return grafo;
    }
    
    
    public VerticeDjikstra obtenerVerticexCodigo(short codigo)
    {
        // Objetos son referencias en memoria        
        for(VerticeDjikstra vertD:verticesD)
        {
            if(vertD.getCodigo()==codigo)
            {
                return vertD;
            }
        }
        return null;
    }
    
    private void actualizarAdyacencias(int codigo)
    {
        //Obtener las adayacencias de verticesD 
        //recorriendo las aristas del grafo
    }
   
    
}

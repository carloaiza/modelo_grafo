/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grafo.modelo.djikstra;

import com.grafo.modelo.Arista;
import com.grafo.modelo.Grafo;
import com.grafo.modelo.GrafoDirigido;
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
        calcularDjikstra(vertActual);
        
        //Se si tengo o no ruta
        return null;
    }
    
    private void calcularDjikstra(VerticeDjikstra vertActual)
    {
        /*        
        2. Asigno de donde viene y peso acumulado  (Faltante)
       
        /*
        3. obtengo las adyancencias del vertice en el que estoy
        (Diferente si el grafo es dirigido o no dirigido
        */
        List<Arista> adyacencias = grafo.obtenerAdyacencias(vertActual.getCodigo());        
        /*
        4. Visito todas las adyancencias        
        5. Cada adyacencia actualizo su origen y peso acumulado
           cuando es menor
        */
        actualizarAdyacencias(vertActual, adyacencias);
        /*
        6.  a) Marco en el que estoy parado            
             b)verificar si ya todos estan marcados (Finishing) voy al punto 8
            cuando todos vertcesD esten marcado - marcados = verticesD.size() (Faltante)
        */
        vertActual.setMarcado(true);
        this.marcados++;
        if(marcados == grafo.getVertices().size())
        {
            //8. Sacar la ruta - Me paro en el destino y empiezo a devolverme
            //Se para en el destino  lee el anterior y hace hasta que llegue al origen
            //Construye la ruta
            
        }
        else
        {
            /*
            7. Salto a la adyacencia menor no marcada
            volver al 2            
            */
            VerticeDjikstra vertMenorNoVisitado= 
                    obtenerAdyacenciaMenorNoVisitada(adyacencias, vertActual);
            calcularDjikstra(vertMenorNoVisitado);
            
        }
        
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
    
    
    public VerticeDjikstra obtenerVerticexCodigo(int codigo)
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
    
    private void actualizarAdyacencias(VerticeDjikstra vertActual, List<Arista> adyacencias)
    {
        //Obtener las adyacencias de verticesD 
        //recorriendo las aristas del grafo
        // actualizo los pesos y anterior de las adyacencias
        // si esta nulo el anterior actualizo el anterior con el vertice
        //actual
        // si no esta nulo comparo si es menor el peso acumulado para
        //actualizar
        for(Arista ari:adyacencias)
        {
            VerticeDjikstra visitado= obtenerVerticexCodigo(ari.getDestino());
            //Actualizarle su origen y peso
            if(visitado.getAnterior()==null)
            {
                //NO ha sido visitado
                visitado.setAnterior(vertActual);
                visitado.setPeso((short)(vertActual.getPeso()+ari.getPeso()));                
            }
            else
            {
                short pesoAcumulado=(short)(vertActual.getPeso()+ari.getPeso());
                if(pesoAcumulado < visitado.getPeso())
                {
                    visitado.setAnterior(vertActual);
                    visitado.setPeso(pesoAcumulado);
                }
            }
        }
        
    }
   
    
    private VerticeDjikstra obtenerAdyacenciaMenorNoVisitada(List<Arista> adyacencias,
            VerticeDjikstra anterior)
    {
        //Menor peso acumulado
        // cuando dos vertices tienen el mismo salta a cualquiera
        short menor= Short.MAX_VALUE;
        VerticeDjikstra verticeSalto =null;
        for(Arista ari: adyacencias)
        {
            int codigoVerticeAnalizar=0;
            //Si mi grafo es dirigido a no es dirigido
            if(grafo instanceof GrafoDirigido)
            {
                //Siempre voy a obtener el vertice que voy a analizar con el destino
                codigoVerticeAnalizar= ari.getOrigen();
            }
            else
            {    
                // Yo tengo que determinar si debo buscar el vertice a analizar con el 
                // origen de la arista o con el destino
                codigoVerticeAnalizar= ari.getOrigen();
                if(ari.getOrigen()== anterior.getCodigo())
                {
                    codigoVerticeAnalizar= ari.getDestino();
                }
                
            }
            VerticeDjikstra vertAdyacente = obtenerVerticexCodigo(codigoVerticeAnalizar);
           
            if(!vertAdyacente.isMarcado()) //Me interesan los que no estén marcados
            {
                if(vertAdyacente.getPeso() < menor)
                {
                    //Actualizar el menor  y marcar ese vertice como al que debo 
                    //saltar
                    menor= vertAdyacente.getPeso();
                    verticeSalto = vertAdyacente;
                }
            }
            
        }        
        //Se puede presentar el bloqueo y hay que saltar a cualquiera
        if(verticeSalto == null)
        {
            //Un bloqueo salto a cualquiera no marcado
            for(VerticeDjikstra vertD: verticesD)
            {
                if(!vertD.isMarcado())
                {
                    return vertD;
                }
            }
        }
        return verticeSalto;
    }
    
}

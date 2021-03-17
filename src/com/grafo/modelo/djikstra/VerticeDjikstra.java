/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grafo.modelo.djikstra;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author carloaiza
 */
public class VerticeDjikstra implements Serializable{
    
    private int codigo;
    private VerticeDjikstra anterior;
    private short peso;
    private boolean marcado;    

    public VerticeDjikstra(int codigo, VerticeDjikstra anterior, short peso) {
        this.codigo = codigo;
        this.anterior = anterior;
        this.peso = peso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public VerticeDjikstra getAnterior() {
        return anterior;
    }

    public void setAnterior(VerticeDjikstra anterior) {
        this.anterior = anterior;
    }

    public short getPeso() {
        return peso;
    }

    public void setPeso(short peso) {
        this.peso = peso;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    
    
    
    
}

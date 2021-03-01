/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grafo.modelo;

import java.io.Serializable;

/**
 *
 * @author carloaiza
 */
public class Vertice implements Serializable {
    private Object dato;
    private short codigo;

    public Vertice(Object dato, short codigo) {
        this.dato = dato;
        this.codigo = codigo;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public short getCodigo() {
        return codigo;
    }

    public void setCodigo(short codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Vertice{" + "dato=" + dato + ", codigo=" + codigo + '}';
    }
    
    
    
}

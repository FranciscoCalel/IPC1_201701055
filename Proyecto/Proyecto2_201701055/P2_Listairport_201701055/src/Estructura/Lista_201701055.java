/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

/**
 *
 * @author franc
 */
public abstract class Lista_201701055 {

    protected Nodo_201701055 inicio;
    protected Nodo_201701055 fin;
    int size;

    public Lista_201701055() {
        inicio = null;
        fin = null;
        size = 0;
    }

    public void agregarFinal(Object o) {
        if (estaVacia()) {
            inicio = new Nodo_201701055(o);
            fin = inicio;
        } else {
            fin = fin.siguiente = new Nodo_201701055(o);
        }
        size++;
    }

    public Object quitarInicio() {
        Object aux = inicio.getObjeto();
        inicio = inicio.siguiente;
        if (inicio == null) {
            fin = null;
        }
        size--;
        return aux;
    }

    public void listar() {
        Nodo_201701055 temp = inicio;
        while (temp != null) {
            System.out.println(temp.getObjeto());
            temp = temp.siguiente;
        }
    }

    public boolean estaVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public int getSize() {
        return size;
    }

    public abstract void display();
}

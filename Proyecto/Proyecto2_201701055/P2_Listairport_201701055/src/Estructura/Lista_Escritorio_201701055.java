/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import javax.swing.JTextArea;
import p_listairport_201701055.*;

/**
 *
 * @author franc
 */
public class Lista_Escritorio_201701055 extends ListaD_201701055{
    private boolean x;
	private char nombre;	
	private int maletas;	
	
	public Lista_Escritorio_201701055() {
		super();
	}
			
	public void addPasajeros() {
		if(inicio!=null) {
			Nodo_201701055 aux = inicio;
			while(aux!=null) {
				x = false;
				Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
				if(e.getEstado() && !e.getColaPasajero().estaVacia()) {
					e.setEstado(false);
					e.setPasajero((Pasajero_201701055)e.getColaPasajero().quitar());
					x = true;
					aux = aux.siguiente;					
				}
				else {
					x = false;
					aux = aux.siguiente;
				}				
			}
		}
	}
	
	public void agregarPasajerosCola(Pasajero_201701055 pasajero) {
		if(inicio!=null) {
			Nodo_201701055 aux = inicio;
			while(aux!=null) {
				Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
				if(e.getColaPasajero().tamCola()<7) {
					e.getColaPasajero().setPasajero(pasajero);					
					return;
				}
				aux = aux.siguiente;
			}
		}
	}
	
	public boolean determinaEspacio() {
		boolean espacio = false;
		if(inicio!=null) {
			Nodo_201701055 aux = inicio;
			while(aux!=null) {
                            Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
				if(e.getColaPasajero().tamCola()<7) {
					espacio = true;
				}
				aux = aux.siguiente;
			}			
		}
		return espacio;
	}
	
	public void determinaNombre() {
		nombre = (char)(Math.random()*(90-65+1)+65);		
	}
	
	public void iniciarLista() {
		nombre = (char)(Math.random()*(90-65+1)+65);
		Cola_Pasajero_201701055 colaPasajero = new Cola_Pasajero_201701055();
		Pila_201701055 pilaDocumentos = new Pila_201701055();
		Escritorio_201701055 nuevo = new Escritorio_201701055(true,null,nombre,colaPasajero,pilaDocumentos);
		insertarInicio(nuevo);
	}
	
	public void bajarTurno(Lista_Maleta_201701055 l) {
		if(inicio!=null) {
			Nodo_201701055 aux = inicio;
			while(aux!=null) {
				Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
				if(e.getPasajero()!=null) {
					e.getPasajero().setTurnosRegistro(e.getPasajero().getTurnosRegistro()-1);				
				}
				aux = aux.siguiente;
			}
		}
		terminaRegistro(l);
	}
	
	public int getMaletas() {
		return maletas;
	}
	
	public void terminaRegistro(Lista_Maleta_201701055 l) {
		if(inicio!=null) {
			Nodo_201701055 aux = inicio;
			while(aux!=null) {
				Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
				if(e.getPasajero()!=null) {
					if(e.getPasajero().getTurnosRegistro()<=0) {						
						l.eliminarMaleta(e.getPasajero().getMaletas());
						e.getPila().insertar(e.getPasajero().getDocumentos());
						e.setPasajero(null);
						e.setEstado(true);						
					}
				}
				aux = aux.siguiente;
			}
		}
	}
	
	public void estaDisponible() {
		if(inicio!=null) {
			Nodo_201701055 aux = inicio;
			while(aux!=null) {
				Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
				if(e.getPasajero()==null) {
					e.setEstado(true);
				}
				aux = aux.siguiente;
			}
		}
	}
	
	public boolean getEstado() {
		return x;
	}
	
	public boolean estaVacio() {
		compruebaEscritorio();
		return estaVacio;
	}
	boolean estaVacio = false;
	
	public void compruebaEscritorio() {
		if(inicio!=null) {
			Nodo_201701055 aux = inicio;
			while(aux!=null) {
				Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
				if(e.getEstado()) {
					estaVacio=true;
				}
				aux = aux.siguiente;
			}
		}
	}
	
	public int sumaDocumentos(Escritorio_201701055 e) {
		int documentos = 0; 
		if(e.getPila().inicio!=null) {
			Nodo_201701055 aux = e.getPila().inicio;
			while(aux!=null) {
				documentos += (int)aux.getObjeto();
				aux = aux.siguiente;
			}
		}
		return documentos;
	}
	
	public void printColaPasajero(JTextArea txt) {
		if(inicio!=null) {
			Nodo_201701055 aux = inicio;
			while(aux!=null) {
				Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
					if(e.getColaPasajero().inicio!=null){
					Nodo_201701055 auxP = e.getColaPasajero().inicio;
					while(auxP!=null) {
						Pasajero_201701055 p = (Pasajero_201701055)auxP.getObjeto();
						txt.append("\n	PASAJERO: " + p.getNumero());
						auxP = auxP.siguiente;
					}
				}
			}
		}
	}
	
	public void printListaEscritorio(JTextArea txt) {
		if(inicio!=null) {
			Nodo_201701055 aux = inicio;
			while(aux!=null) {
				Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
				if(e.getPasajero()==null) {
					txt.append("\nESCRITORIO: " + e.getNombre());
					txt.append("\nESTADO: " + e.getDisponible());
					txt.append("\nTOTAL DOC.: " + sumaDocumentos(e) + "\n");
				}
				else {
					txt.append("\nESCRITORIO " + e.getNombre());
					txt.append("\n	CLIENTE: " + e.getPasajero().getNumero());
					txt.append("\n	ESTADO: " + e.getDisponible());
					txt.append("\n	DOCUMENTOS: " + e.getPasajero().getDocumentos());
					txt.append("\n	TURNOS: " + e.getPasajero().getTurnosRegistro());
					txt.append("\n	TOTAL DOC.: " + sumaDocumentos(e) + "\n");
					txt.append("COLA \n");
					
					if(e.getColaPasajero().inicio!=null){
						Nodo_201701055 auxP = e.getColaPasajero().inicio;
						while(auxP!=null) {
							Pasajero_201701055 p = (Pasajero_201701055)auxP.getObjeto();
							if(p!=null)
							txt.append("\n	PASAJERO: " + p.getNumero());
							auxP = auxP.siguiente;
						}
					}
				}
				aux = aux.siguiente;
			}
		}
	}
    
}

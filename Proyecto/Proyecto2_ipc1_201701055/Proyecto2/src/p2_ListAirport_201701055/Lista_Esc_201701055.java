/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ListAirport_201701055;

import javax.swing.JTextArea;

/**
 *
 * @author franc
 */
public class Lista_Esc_201701055 extends ListaD_201701055{
	private boolean x;
	private char nombre;	
	private int maletas;	
	
	public Lista_Esc_201701055() {
		super();
	}
			
	public void addPasajeros() {
		if(ini!=null) {
			Nodo_201701055 aux = ini;
			while(aux!=null) {
				x = false;
				Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
				if(e.getEstado() && !e.getColaPasajero().estaVacia()) {
					e.setEstado(false);
					e.setPasajero((Pasajero_201701055)e.getColaPasajero().quitar());
					x = true;
					aux = aux.sig;					
				}
				else {
					x = false;
					aux = aux.sig;
				}				
			}
		}
	}
	
	public void agregarPasajerosCola(Pasajero_201701055 pasajero) {
		if(ini!=null) {
			Nodo_201701055 aux = ini;
			while(aux!=null) {
				Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
				if(e.getColaPasajero().tamanoCola()<7) {
					e.getColaPasajero().setPasajero(pasajero);					
					return;
				}
				aux = aux.sig;
			}
		}
	}
	
	public boolean determinaEspacio() {
		boolean espacio = false;
		if(ini!=null) {
			Nodo_201701055 aux = ini;
			while(aux!=null) {
				Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
				if(e.getColaPasajero().tamanoCola()<7) {
					espacio = true;
				}
				aux = aux.sig;
			}			
		}
		return espacio;
	}
	
	
	public void iniciarLista() {
		nombre = (char)(Math.random()*(90-65+1)+65);
		Cola_Pasajero_201701055 colaPasajero = new Cola_Pasajero_201701055();
		Pila_201701055 pilaDocumentos = new Pila_201701055();
		Escritorio_201701055 nuevo = new Escritorio_201701055(true,null,nombre,colaPasajero,pilaDocumentos);
		insertarInicio(nuevo);
	}
	
	public void bajarTurno(Lista_Eq_201701055 l) {
		if(ini!=null) {
			Nodo_201701055 aux = ini;
			while(aux!=null) {
				Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
				if(e.getPasajero()!=null) {
					e.getPasajero().setTurnos(e.getPasajero().getTurnos()-1);				
				}
				aux = aux.sig;
			}
		}
		terminaRegistro(l);
	}
	
	public int getMaletas() {
		return maletas;
	}
	
	public void terminaRegistro(Lista_Eq_201701055 l) {
		if(ini!=null) {
			Nodo_201701055 aux = ini;
			while(aux!=null) {
				Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
				if(e.getPasajero()!=null) {
					if(e.getPasajero().getTurnos()<=0) {						
						l.eliminarMaleta(e.getPasajero().getMaletas());
						e.getPila().insertar(e.getPasajero().getDocumentos());
						e.setPasajero(null);
						e.setEstado(true);						
					}
				}
				aux = aux.sig;
			}
		}
	}
	
	public void estaDisponible() {
		if(ini!=null) {
			Nodo_201701055 aux = ini;
			while(aux!=null) {
				Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
				if(e.getPasajero()==null) {
					e.setEstado(true);
				}
				aux = aux.sig;
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
		if(ini!=null) {
			Nodo_201701055 aux = ini;
			while(aux!=null) {
				Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
				if(e.getEstado()) {
					estaVacio=true;
				}
				aux = aux.sig;
			}
		}
	}
	
	public int sumaDocumentos(Escritorio_201701055 e) {
		int documentos = 0; 
		if(e.getPila().ini!=null) {
			Nodo_201701055 aux = e.getPila().ini;
			while(aux!=null) {
				documentos += (int)aux.getObjeto();
				aux = aux.sig;
			}
		}
		return documentos;
	}
	
	public void printColaPasajero(JTextArea txt) {
		if(ini!=null) {
			Nodo_201701055 aux = ini;
			while(aux!=null) {
				Escritorio_201701055 e = (Escritorio_201701055)aux.getObjeto();
					if(e.getColaPasajero().ini!=null){
					Nodo_201701055 auxP = e.getColaPasajero().ini;
					while(auxP!=null) {
						Pasajero_201701055 p = (Pasajero_201701055)auxP.getObjeto();
						txt.append("\n	PASAJERO: " + p.getNumero());
						auxP = auxP.sig;
					}
				}
			}
		}
	}
	
	public void printListaEscritorio(JTextArea txt) {
		if(ini!=null) {
			Nodo_201701055 aux = ini;
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
					txt.append("\n	TURNOS: " + e.getPasajero().getTurnos());
					txt.append("\n	TOTAL DOC.: " + sumaDocumentos(e) + "\n");
					txt.append("COLA \n");
					
					if(e.getColaPasajero().ini!=null){
						Nodo_201701055 auxP = e.getColaPasajero().ini;
						while(auxP!=null) {
							Pasajero_201701055 p = (Pasajero_201701055)auxP.getObjeto();
							if(p!=null)
							txt.append("\n	PASAJERO: " + p.getNumero());
							auxP = auxP.sig;
						}
					}
				}
				aux = aux.sig;
			}
		}
	}
}

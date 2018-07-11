/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ListAirport_201701055;
import java.io.*;
/**
 *
 * @author franc
 */
public class Graph_201701055 {
    public void crearDocumento(Nodo_201701055 primero, String nombre) {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {					
			fw = new FileWriter(nombre);
			pw = new PrintWriter(fw);
			pw.println("digraph listaAvion {  node[shape=record];");
			pw.println(generarDocumentoListaAvion(primero));
			pw.println("}");
			pw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			}
			catch(IOException ex) {
				
			}
		}
	}
    

        public void crearDocumentoMantenimiento(Nodo_201701055 primero,String nombre,Nodo_201701055 cola) {
		FileWriter fw = null;
		PrintWriter pw = null;
	
		try {
			fw = new FileWriter(nombre);
			pw = new PrintWriter(fw);
			pw.println("digraph listaMantenimiento { node[shape=record]; ");
			pw.println("subgraph estacion{");
			pw.println(generarDocumentoEstacion(primero));
			pw.println("rank = same" + recoEstacion(primero) + "}");
			pw.println("subgraph cola {" + generarDocumentoColaAvion(cola) + "}");
			pw.println(mantEst(primero,cola) + "}");
			pw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			}
			catch(IOException ex) {
				
			}
		}
	
	}
	
	public void crearDocumentoDesbordaje(Nodo_201701055 primero, String nombre) {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(nombre);
			pw = new PrintWriter(fw);
			pw.println("digraph listaPasajeros { node[shape=record]; ");
			pw.println(generarDocumentoDesabordaje(primero));
			pw.println("}");
			pw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			}
			catch(IOException ex) {
				
			}
		}
	}
	
	
	
	public void crearDocumentoListaMaleta(Nodo_201701055 primero, Nodo_201701055 ultimo, String nombre) {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(nombre + ".dot");
			pw = new PrintWriter(fw);
			pw.println("digraph listacircular {");
			pw.println(generarDocumentoListaMaleta(primero,ultimo));
			pw.println("}");
			pw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			}
			catch(IOException ex) {
				
			}
		}
	}
	
	public void crearDocumentoEscritorio(Nodo_201701055 primero, String nombre) {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(nombre);
			pw = new PrintWriter(fw);
			pw.println("digraph listaEscritorio { node[shape=record]; ");
			pw.println("subgraph escritorio{");
			pw.println(generarDocumentoEscritorio(primero));
			pw.println("rank = same " + recoEscritorio(primero) + "}");
			pw.println(escritorioPasajero(primero));
			pw.println("}");
			pw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			}
			catch(IOException ex) {
				
			}
		}
	}
	
	public String generarDocumentoListaAvion(Nodo_201701055 primero) {
		String cadena = "";
		if(primero ==null) {
			return cadena;
		}
		Avion_201701055 a = (Avion_201701055)primero.getObjeto();		
		cadena += "nodo" + reemplazar(primero.hashCode()) + "[label=\"Avion: "+a.getNumero()+"&#92;nTamaño: "+a.getTipo() + "&#92;nPasajeros: " + a.getPasajeros() + "&#92;nDesabordaje: " + a.getTurnosDesabordaje() + "&#92;nMantenimiento: " + a.getTurnosMantenimiento() + "\"];\n";
		if(primero.getSig()!=null) {
			cadena += "nodo"+ reemplazar(primero.hashCode())+"->" +"nodo"+reemplazar(primero.getSig().hashCode()) + ";\n";
			cadena += "nodo" + reemplazar(primero.getSig().hashCode())+ "->" + "nodo" + reemplazar(primero.getSig().getAnt().hashCode()) + ";\n";
			cadena += generarDocumentoListaAvion(primero.getSig());	
		}		
				
		return cadena;
	}
        
        public String reemplazar(int posMemoria) {
		String cadena = String.valueOf(posMemoria);
		return cadena.replace("-", "_");
	}

	public String generarDocumentoDesabordaje(Nodo_201701055 primero) {
		String cadena ="";
		if(primero==null) {
			return cadena;
		}
		Pasajero_201701055 p = (Pasajero_201701055)primero.getObjeto();
		cadena += "nodo" + reemplazar(primero.hashCode()) + "[label=\" Pasajero: "+ p.getNumero()+" &#92;nMaletas: "+p.getMaletas() + " &#92;nDocumentos: " + p.getDocumentos() + " &#92;nTurnos: " + p.getTurnos() + "\"];\n";
		if(primero.getSig()!=null) {
			cadena += "nodo" + reemplazar(primero.hashCode()) + "->" + "nodo"+reemplazar(primero.getSig().hashCode()) + ";\n";
			cadena+= generarDocumentoDesabordaje(primero.getSig());
		}
		return cadena;
	}
	
	public String generarDocumentoColaAvion(Nodo_201701055 primero) {
		String cadena = "";
		if(primero ==null) {
			return cadena;
		}
		Avion_201701055 a = (Avion_201701055)primero.getObjeto();		
		cadena += "nodo" + reemplazar(primero.hashCode()) + "[label=\"Avion: "+a.getNumero()+"&#92;nTamaño: "+a.getTipo() + "&#92;nPasajeros: " + a.getPasajeros() + "&#92;nDesabordaje: " + a.getTurnosDesabordaje() + "&#92;nMantenimiento: " + a.getTurnosMantenimiento() + "\"];\n";
		if(primero.getSig()!=null) {
			cadena += "nodo"+ reemplazar(primero.hashCode())+"->" +"nodo"+reemplazar(primero.getSig().hashCode()) + ";\n";			
			cadena += generarDocumentoColaAvion(primero.getSig());	
		}						
		return cadena;
	}
        
        public String generarDocumentoColaPasajero(Nodo_201701055 cola) {
		String cadena = "";
		if(cola==null) {
			return cadena;
		}
		Pasajero_201701055 p = (Pasajero_201701055)cola.getObjeto();
		if(p!=null) {
		cadena+= "nodo" + reemplazar(cola.hashCode()) + "[label=\" Pasajero: "+ p.getNumero() + " &#92;nTurnos: " + p.getTurnos() + "\"];\n";
		if(cola.getSig()!=null) {
			cadena+="nodo" + reemplazar(cola.hashCode()) + "->" + "nodo"+reemplazar(cola.getSig().hashCode()) + ";\n";
			cadena+=generarDocumentoColaPasajero(cola.getSig());
		}}
		return cadena;
	}
	
	public String generarDocumentoEscritorio(Nodo_201701055 primero) {
		String cadena = "";
		Escritorio_201701055 e = (Escritorio_201701055)primero.getObjeto();
		if(e.getPasajero()==null) {
			cadena += "nodo"+reemplazar(primero.hashCode()) + "[label=\"Escritorio: " + e.getNombre() + "&#92;nEstado: " + e.getDisponible() + "&#92;nTotal Doc: " + sumaDocumentos(e) + "\"];\n" ;
		}
		else {
			cadena += "nodo" + reemplazar(primero.hashCode()) + "[label=\"Escritorio: " + e.getNombre() + "&#92;nEstado: " + e.getDisponible() + "&#92;nCliente: " + e.getPasajero().getNumero() + "&#92;nDocumentos: " + e.getPasajero().getDocumentos() + "&#92;nTurnos: " + e.getPasajero().getTurnos() + "&#92;nTotal Doc: " + sumaDocumentos(e) + "\"];\n";  
		}
		if(primero.getSig()!=null) {
			cadena += "nodo"+ reemplazar(primero.hashCode())+"->" +"nodo"+reemplazar(primero.getSig().hashCode()) + ";\n";
			cadena += "nodo" + reemplazar(primero.getSig().hashCode())+ "->" + "nodo" + reemplazar(primero.getSig().getAnt().hashCode()) + ";\n";
			cadena += generarDocumentoEscritorio(primero.getSig());
		}		
		return cadena;
	}
        
        public String generarDocumentoEstacion(Nodo_201701055 primero) {
		String cadena = "";
		Mantenimiento_201701055 m = (Mantenimiento_201701055)primero.getObjeto();
		if(m.getAvion()==null) {
			cadena+= "nodo" + reemplazar(primero.hashCode()) + "[label=\"Estacion: "+m.getNumero()+"&#92;nEstado: " + m.getDisponible() + "\"];\n";			
		}
		else {
			Avion_201701055 a = m.getAvion();
			cadena+="nodo" + reemplazar(primero.hashCode()) + "[label=\"Estacion: "+m.getNumero()+"&#92;nEstado: " + m.getDisponible() + "&#92;nAvion: "+a.getNumero()+"&#92;nTamaño: "+a.getTipo() + "&#92;nPasajeros: " + a.getPasajeros() + "&#92;nDesabordaje: " + a.getTurnosDesabordaje() + "&#92;nMantenimiento: " + a.getTurnosMantenimiento() + "\"];\n";
		}
		if(primero.getSig()!=null) {
			cadena+="nodo" + reemplazar(primero.hashCode()) + "->" + "nodo" + reemplazar(primero.getSig().hashCode()) + ";\n";
			cadena += generarDocumentoEstacion(primero.getSig());
		}
		
		return cadena;
	}
	
	public String escritorioPasajero(Nodo_201701055 primero) {
		String cadena ="";
		Escritorio_201701055 e = (Escritorio_201701055)primero.getObjeto();
		if(e.getColaPasajero().ini!=null) {
			cadena += "nodo" + reemplazar(primero.hashCode())+"->" + "nodo"+reemplazar(e.getColaPasajero().getInicioNodo().hashCode()) + ";\n";
			cadena += generarDocumentoColaPasajero(e.getColaPasajero().getInicioNodo());
		}
		if(primero.getSig()!=null) {
			cadena += escritorioPasajero(primero.getSig());
		}
		
		return cadena;
	}
	
	public int sumaDocumentos(Escritorio_201701055 e) {
		int documentos = 0; 
		if(e.getPila().getInicioNodo()!=null) {
			Nodo_201701055 aux = e.getPila().getInicioNodo();
			while(aux!=null) {
				documentos += (int)aux.getObjeto();
				aux = aux.getSig();
			}
		}
		return documentos;
	}
	
	public String recoEstacion(Nodo_201701055 primero) {
		String cadena ="";
		if(primero.getSig()!=null) {
			cadena += " nodo" + reemplazar(primero.hashCode()); 
			cadena+= recoEstacion(primero.getSig());
		}
		return cadena;
	}
	
	public String recoEscritorio(Nodo_201701055 primero) {
		String cadena = "";
		if(primero.getSig()!=null) {
			cadena += " nodo"+reemplazar(primero.hashCode());
			cadena += recoEscritorio(primero.getSig());
		}
		return cadena;
	}
	
	public String mantEst(Nodo_201701055 mantenimiento, Nodo_201701055 cola) {
		String cadena = "";
		if(mantenimiento!=null) {
			if(cola!=null) {
				cadena+="nodo"+reemplazar(mantenimiento.hashCode()) + "->" + "nodo" + reemplazar(cola.hashCode()) +"\n" ;
				cadena+=mantEst(mantenimiento.getSig(),cola);
			}
		}
		return cadena;
	}
	
	public String generarDocumentoListaMaleta(Nodo_201701055 primero, Nodo_201701055 ultimo) {
		String cadena = "";		
		if(primero==null) {
			return cadena;
		}
		cadena += "nodo" + reemplazar(primero.hashCode()) + "[label=\""+primero.getObjeto()+ "\"];\n";
		if(primero.getSig()!=ultimo) {		
			cadena += "nodo"+ reemplazar(primero.hashCode())+"->" +"nodo"+reemplazar(primero.getSig().hashCode()) + ";\n";	
			cadena += "nodo" + reemplazar(primero.getSig().hashCode())+ "->" + "nodo" + reemplazar(primero.getSig().getAnt().hashCode()) + ";\n";
			cadena += generarDocumentoListaMaleta(primero.getSig(),ultimo);
		}
		if(primero.getSig()==ultimo) {
			cadena += "nodo"+ reemplazar(primero.hashCode())+"->" +"nodo"+reemplazar(ultimo.hashCode()) + ";\n";	
			cadena += "nodo" + reemplazar(ultimo.hashCode())+ "->" + "nodo" + reemplazar(primero.hashCode()) + ";\n";
		}
		return cadena;
	}	
	
	public void generarImagen(String direccionDot, String direccionImagen) {
		String prog ="C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";		
		
		String [] l = new String[5];
		l[0] = prog;
		l[1] = "-Tjpg";
		l[2] = direccionDot;
		l[3] = "-o";
		l[4] = direccionImagen;					
		
		try {
			Runtime.getRuntime().exec(l);
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
}

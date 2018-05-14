package com.hfn.prueba.callCenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.hfn.prueba.VOs.Llamada;
import com.hfn.prueba.VOs.Operador;

public class Dispatcher  {
	
	/**
	 * Operadores conectaodos en la operacion
	 */
    public Collection<Operador> conectados;
	
    /**
	 * Constructor de la clase
	 * @param operadores conectados en el callCenter
	 */
    public Dispatcher(Collection<Operador> operadores){
    	this.conectados=operadores;
    }
    
    /**
   	 * Gestiona las llamadas a los operadores
   	 * @param LLamada que se gestionará
   	 */
	public synchronized Llamada dispatchCall(Llamada call){
		Operador disponible=obtenerDisponible();
		if(disponible!=null){
			ocuparOperador(disponible.getId());
			disponible.setEstadoDisponible(false);
			call.setEstado("atendida");
			call.setIdOperador(disponible.getId());
		}else{
			call.setEstado("perdida");
		}
    	return call;
    }
	
	/**
	  * Cambia el estado del operador a disponible
	  * @param id del operador a cambiar estado de disponible
	  */
	public void liberarOperador(int idOperador){
		 Iterator<Operador> it= conectados.iterator();
			while(it.hasNext()){
				Operador op=it.next();
				if(op.getId()==idOperador){
					op.setEstadoDisponible(true);
				}
			}
			
	}
	
	/**
	  * Cambia el estado del operador a ocupado
	  * @param id del operador a cambiar estado de ocupado
	  */
	public void ocuparOperador(int idOperador){
		 Iterator<Operador> it= conectados.iterator();
			while(it.hasNext()){
				Operador op=it.next();
				if(op.getId()==idOperador){
					op.setEstadoDisponible(false);
				}
			}
	}
	
	
	/**
	  * Obtiene el operador disponible buscando primero por operadores, despues
	  * busca por supervisores y finalmente en directores
	  */
	 public Operador obtenerDisponible(){
		 Iterator<Operador> it= conectados.iterator();
			Collection<Operador> operadores=new ArrayList<Operador>();
			Collection<Operador> supervisores=new ArrayList<Operador>();
			Collection<Operador> directores=new ArrayList<Operador>();
			while(it.hasNext()){
				Operador op=it.next();
				if(op.getRol()==3&&op.getEstadoDisponible()){
					operadores.add(op);
				}
				if(op.getRol()==2&&op.getEstadoDisponible()){
					supervisores.add(op);
				}
				if(op.getRol()==1&&op.getEstadoDisponible()){
					directores.add(op);
				}
				
			}
			if(!operadores.isEmpty()){
				return operadores.iterator().next();
			}else{
				if(!supervisores.isEmpty()){
					return supervisores.iterator().next();
				}else{
					if(!directores.isEmpty()){
						return directores.iterator().next();
					}else{
						return null;
					}
				}
			}
				
		 
	 }
}

package com.hfn.prueba.callCenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.hfn.prueba.VOs.Llamada;
import com.hfn.prueba.VOs.Operador;

/**
 * Esta clase define objetos que contienen datos y funciones basicas para
 * el funcionamiento del callCenter
 * @author: Hernan Felipe Nieto
 * @version: 1
 */
public class CallCenter {
	
	/**
	 * Indicador del fin de operacion
	 */
	private boolean finalOperacionCall;
	
	/**
	 * Operadores conectados en la operacion
	 */
	private Collection<Operador> conectados;
	
	/**
	 * Numero de llamadas recurrentes
	 */
	private int numeroLlamadasConcurrentes;
	
	/**
	 * Metodo que gestiona las llamadas recurrentes
	 */
	public void recibirLlamadasConcurrentes(){
		finalOperacionCall=false;
		Dispatcher d= new Dispatcher(conectados);
        ExecutorService executor = Executors.newFixedThreadPool(11);
        for (int i = 1; i < numeroLlamadasConcurrentes+1; i++) {
        	Llamada call=new Llamada();
            Runnable worker = new WorkerThread("" + i,d,call);
            executor.execute(worker);
          }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        procesarEncoladas(d);
        finalOperacionCall=true;
        System.out.println("Finished all threads");
		
	}
	
	/**
	 * Metodo que gestiona las llamadas no contestadas y las vuelve a procesar 
	 * @param Dispatcher 
	 */
	public void procesarEncoladas(Dispatcher d){
		ExecutorService executor = Executors.newFixedThreadPool(11);
		Collection<Llamada> encoladas=d.getLlamadasNoContestadas();
		d.setLlamadasNoContestadas(new ArrayList<Llamada>());
        Iterator<Llamada> it=encoladas.iterator();
        while (it.hasNext()) {
            Llamada encolada = it.next();
            Runnable worker = new WorkerThread("" + encolada.getId(),d,encolada);
            executor.execute(worker);
        }
        
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        if(!d.getLlamadasNoContestadas().isEmpty()){
        	procesarEncoladas(d);
        }
	}


	public boolean isFinalOperacionCall() {
		return finalOperacionCall;
	}
	public void setFinalOperacionCall(boolean finalzoOperacionCall) {
		this.finalOperacionCall = finalzoOperacionCall;
	}	
	public int getNumeroLlamadasConcurrentes() {
		return numeroLlamadasConcurrentes;
	}
	public void setNumeroLlamadasConcurrentes(int numeroLlamadasConcurrentes) {
		this.numeroLlamadasConcurrentes = numeroLlamadasConcurrentes;
	}
	public Collection<Operador> getConectados() {
		return conectados;
	}
	public void setConectados(Collection<Operador> conectados) {
		this.conectados = conectados;
	}
}

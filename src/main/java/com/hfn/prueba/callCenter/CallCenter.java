package com.hfn.prueba.callCenter;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.hfn.prueba.VOs.Operador;


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
        for (int i = 1; i < numeroLlamadasConcurrentes; i++) {
            Runnable worker = new WorkerThread("" + i,d);
            executor.execute(worker);
          }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        finalOperacionCall=true;
        System.out.println("Finished all threads");
		
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

package com.hfn.prueba.callCenter;

import java.time.LocalDate;
import java.util.Random;

import com.hfn.prueba.VOs.Llamada;

public class WorkerThread implements Runnable {
	  
    private String command;
    private Dispatcher dispatcher;
    private Llamada call;
    
	/**
	 * Constructor de la clase
	 * @param command  numero de la llamada la cual se convertira en su id
	 * @param Dispatcher 
	 * @param entrante llamada a gestionar
	 */
    public WorkerThread(String command,Dispatcher dispatcher, Llamada  entrante){
        this.command=command;
        this.dispatcher=dispatcher;
        this.call=entrante;
    }
    
	/**
	 * Metodo que ejecuta el thread
	 */
    public void run() {
      //  System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        processCommand();
    //    System.out.println(Thread.currentThread().getName()+" End.");
    }
	/**
	 * Metodo que procesa la llamada del thread
	 */
    private void processCommand() {
        try {
        	Llamada call=new Llamada();
        	call.setId(Integer.valueOf(command));
        	call.setHoraFin(LocalDate.now());
        	call=dispatcher.dispatchCall(call);
        	if(call.getEstado().equals("atendida")){
            	System.out.println("LLAMADA ATENDIDA: "+call.getId()+"  OPERADOR:"+call.getIdOperador());
        		Random generadorAleatorios = new Random();
        		int numeroAleatorio = 5000+generadorAleatorios.nextInt(5000);
        		Thread.sleep(numeroAleatorio);
        		dispatcher.liberarOperador(call.getIdOperador());
        		
        	}else{
        		System.out.println("LLAMADA ENCOLADA: "+call.getId());
        	}
            call.setHoraFin(LocalDate.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

 
}

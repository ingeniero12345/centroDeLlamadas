package com.hfn.prueba.callCenter;

import java.time.LocalDate;
import java.util.Random;

import com.hfn.prueba.VOs.Llamada;

public class WorkerThread implements Runnable {
	  
    private String command;
    Dispatcher dispatcher;
    
    public WorkerThread(String s,Dispatcher d){
        this.command=s;
        this.dispatcher=d;
    }

    public void run() {
      //  System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        processCommand();
    //    System.out.println(Thread.currentThread().getName()+" End.");
    }

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
        		System.out.println("LLAMADA PERDIDA: "+call.getId());
        	}
            call.setHoraFin(LocalDate.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

 
}

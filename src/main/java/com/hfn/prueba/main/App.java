package com.hfn.prueba.main;

import java.util.ArrayList;
import java.util.Collection;

import com.hfn.prueba.VOs.Operador;
import com.hfn.prueba.callCenter.CallCenter;


public class App 
{
	 public static void main( String[] args )
	    {
	    	App app=new App();
	    	CallCenter s=new CallCenter();
	    	s.setConectados(app.conectarUsuarios());
	    	s.setNumeroLlamadasConcurrentes(20);
	    	s.recibirLlamadasConcurrentes();
	    }
	 
	    public  Collection<Operador> conectarUsuarios(){
	    	Operador operador1=new Operador();
	    	Operador operador2=new Operador();
	    	Operador operador3=new Operador();
	    	Operador operador4=new Operador();
	    	Operador operador5=new Operador();
	    	Operador operador6=new Operador();
	    	Operador supervisor1=new Operador();
	    	Operador supervisor2=new Operador();
	    	Operador supervisor3=new Operador();
	    	Operador director=new Operador();
	    	operador1.setId(1);
	    	operador1.setEstadoDisponible(true);
	    	operador1.setNombre("operador1");
	    	operador1.setRol(3);
	    	
	    	operador2.setId(2);
	    	operador2.setEstadoDisponible(true);
	    	operador2.setNombre("operador2");
	    	operador2.setRol(3);
	    	
	    	operador3.setId(3);
	    	operador3.setEstadoDisponible(true);
	    	operador3.setNombre("operador3");
	    	operador3.setRol(3);
	    	
	    	operador4.setId(4);
	    	operador4.setEstadoDisponible(true);
	    	operador4.setNombre("operador4");
	    	operador4.setRol(3);
	    	
	    	operador5.setId(5);
	    	operador5.setEstadoDisponible(true);
	    	operador5.setNombre("operador5");
	    	operador5.setRol(3);
	    	
	    	operador6.setId(6);
	    	operador6.setEstadoDisponible(true);
	    	operador6.setNombre("operador6");
	    	operador6.setRol(3);
	    	
	    	supervisor1.setId(7);
	    	supervisor1.setEstadoDisponible(true);
	    	supervisor1.setNombre("supervisor1");
	    	supervisor1.setRol(2);
	    	
	    	supervisor2.setId(8);
	    	supervisor2.setEstadoDisponible(true);
	    	supervisor2.setNombre("supervisor2");
	    	supervisor2.setRol(2);
	    	
	    	supervisor3.setId(9);
	    	supervisor3.setEstadoDisponible(true);
	    	supervisor3.setNombre("supervisor3");
	    	supervisor3.setRol(2);
	    	
	    	director.setId(10);
	    	director.setEstadoDisponible(true);
	    	director.setNombre("director");
	    	director.setRol(1);
	    	Collection<Operador> o=new ArrayList<Operador>();
	    	o.add(operador1);
	    	o.add(operador2);
	    	o.add(operador3);
	    	o.add(operador4);
	    	o.add(operador5);
	    	o.add(operador6);
	    	o.add(supervisor1);
	    	o.add(supervisor2);
	    	o.add(supervisor3);
	    	o.add(director);
	    	return o;
	    	
	    }
}

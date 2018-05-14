package com.hfn.prueba.callCenter;

import java.util.ArrayList;
import java.util.Collection;

import com.hfn.prueba.VOs.Operador;

import junit.framework.TestCase;

public class DispatcherTest extends TestCase {
	
		private Collection<Operador> usuariosConectados;
	
		protected void setUp() {
		 usuariosConectados=conectarUsuarios();
		     }
	   public  Collection<Operador> conectarUsuarios(){
	    	Operador operador1=new Operador();
	    	operador1.setId(1);
	    	operador1.setEstadoDisponible(true);
	    	operador1.setNombre("operador1");
	    	operador1.setRol(3);	    	
	    	Collection<Operador> o=new ArrayList<Operador>();
	    	o.add(operador1);
	    	return o;
	    	
	    }
	   public void testObtenerDisponible() {
		         Dispatcher dis=new Dispatcher(usuariosConectados);
		         Operador ope=new Operador();
		         ope=dis.obtenerDisponible();
		         assertNotNull(ope);
		          
		      }
	   public void testOcuparLiberarOperador() {
	         Dispatcher dis=new Dispatcher(usuariosConectados);
	         dis.ocuparOperador(1);
	         Operador ope=new Operador();
	         ope=dis.obtenerDisponible();
	         assertNull(ope);
		     dis.liberarOperador(1);
		     ope=dis.obtenerDisponible();
		     assertNotNull(ope);

	          
	      }
}

package com.rita.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.rita.models.Amigo;

public class DDBBtest {
	@Test
	public void testUpdateAmigoValid(){
		boolean isOK=DDBB.getInstance().ActualizarAmigos(2,"Marta", 4);
		assertTrue(isOK);
	}
	
	@Test
	public void testUpdateAmigoValid24Marta4(){
		boolean isOK=DDBB.getInstance().ActualizarAmigos(25,"Marta", 4);
		assertFalse(isOK);
	}

	@Test
	public void testUpdateAmigoValid2_4(){
		boolean isOK=DDBB.getInstance().ActualizarAmigos(2,"",4);
		assertFalse(isOK);
	}
	
	@Test
	public void testUpdateAmigoValid2null4(){
		boolean isOK=DDBB.getInstance().ActualizarAmigos(2,null,4);
		assertFalse(isOK);
	}
	
	@Test
	public void testUpdateAmigoValid2Valor6(){
		boolean isOK=DDBB.getInstance().ActualizarAmigos(2,"aase",6);
		assertFalse(isOK);
	}
	
	@Test
	public void testUpdateAmigoValid2num6(){
		boolean isOK=DDBB.getInstance().ActualizarAmigos(2,"55",4);
		assertFalse(isOK);
	}
	
	@Test
	public void isSaved() {
		

		boolean isOk=DDBB.getInstance().ActualizarAmigos(2, "Rinaldo",5);
		Amigo unAmigo=DDBB.getInstance().getAmigo(2);
		assertEquals(unAmigo.getNombre(),"Rinaldo" );
		assertEquals(unAmigo.getPuntuacion(),5 );
		
		
		
		
	}
	
	
}

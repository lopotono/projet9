package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Assert;
import org.junit.Test;

public class CompteComptableTest {
	
	@Test
	public void testToString() {
		CompteComptable vCompte = new CompteComptable();
		
		Integer vNumero = 401;
		vCompte.setNumero(vNumero);
		String vLibelle = "Fournisseurs";
		vCompte.setLibelle(vLibelle);
		String toStringResult = "CompteComptable{numero="+vNumero+", libelle='"+vLibelle+"'}";
		
		Assert.assertEquals(vNumero, vCompte.getNumero());
		Assert.assertEquals(vLibelle, vCompte.getLibelle());
		Assert.assertEquals(vCompte.toString(), toStringResult);
		
	}

	@Test
	public void testGetByNumero() {
		CompteComptable vCompte = new CompteComptable();
		
		
	}

}

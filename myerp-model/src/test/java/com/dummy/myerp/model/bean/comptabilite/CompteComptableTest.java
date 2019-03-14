package com.dummy.myerp.model.bean.comptabilite;

import java.util.ArrayList;
import java.util.List;

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
		String toStringResult = "CompteComptable{numero=" + vNumero + ", libelle='" + vLibelle + "'}";

		Assert.assertEquals(vNumero, vCompte.getNumero());
		Assert.assertEquals(vLibelle, vCompte.getLibelle());
		Assert.assertEquals(vCompte.toString(), toStringResult);
	}

	@Test
	public void testGetByNumero() {
		//CompteComptable vCompte = new CompteComptable();

		List<CompteComptable> vList = new ArrayList<>();
		/*Integer vNumero = 401;
		vCompte.setNumero(vNumero);
		pList.add(vNumero);*/
		//Assert.assertEquals(vNumero, vCompte.getNumero());
		Assert.assertEquals(CompteComptable.getByNumero(vList, 401), vList.get(7));
	}

}

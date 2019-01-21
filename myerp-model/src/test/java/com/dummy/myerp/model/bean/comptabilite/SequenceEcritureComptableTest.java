package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Assert;
import org.junit.Test;

public class SequenceEcritureComptableTest {
	
	@Test
	public void testToString() {
		
		SequenceEcritureComptable vSequenceEcriture = new SequenceEcritureComptable();
		
		Integer vAnnee = 2016;
		vSequenceEcriture.setAnnee(vAnnee);
		Integer vDerniereValeur = 40;
		vSequenceEcriture.setDerniereValeur(vDerniereValeur);
		String toStringResult = "SequenceEcritureComptable{annee="+vAnnee+", derniereValeur="+vDerniereValeur+"}";
		
		Assert.assertEquals(vAnnee, vSequenceEcriture.getAnnee());
		Assert.assertEquals(vDerniereValeur, vSequenceEcriture.getDerniereValeur());
		Assert.assertEquals(vSequenceEcriture.toString(), toStringResult);
	
	}

}

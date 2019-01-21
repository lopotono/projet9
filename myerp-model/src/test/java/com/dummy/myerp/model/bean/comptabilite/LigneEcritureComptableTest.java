package com.dummy.myerp.model.bean.comptabilite;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;


public class LigneEcritureComptableTest {

	@Test
	public void testToString() {
		LigneEcritureComptable vLigneEcriture = new LigneEcritureComptable();
		
		Integer vNumero = 401;
		CompteComptable pCompte = new CompteComptable();
		pCompte.setNumero(vNumero);
		vLigneEcriture.setCompteComptable(pCompte);
		String vLibelle = "Cartouches d’imprimante";
		vLigneEcriture.setLibelle(vLibelle);
		BigDecimal vDebit = new BigDecimal("43.95");
		vLigneEcriture.setDebit(vDebit);
		BigDecimal vCredit = new BigDecimal("52.74");
		vLigneEcriture.setCredit(vCredit);
				
		String toStringResult = "LigneEcritureComptable{compteComptable="+pCompte+", libelle='"+vLibelle+"', debit="+vDebit+", credit="+vCredit+"}";
		
		Assert.assertEquals(vLibelle, vLigneEcriture.getLibelle());
		Assert.assertEquals(vDebit, vLigneEcriture.getDebit());
		Assert.assertEquals(vCredit, vLigneEcriture.getCredit());
		Assert.assertEquals(vLigneEcriture.toString(), toStringResult);
	}

}

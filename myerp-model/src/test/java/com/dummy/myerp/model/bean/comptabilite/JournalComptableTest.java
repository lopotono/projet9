package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Assert;
import org.junit.Test;

public class JournalComptableTest {

	@Test
	public void testToString() {
		
		JournalComptable vJournal = new JournalComptable();
		
		String vCode = "AC";
		vJournal.setCode(vCode);
		String vLibelle = "Achat";
		vJournal.setLibelle(vLibelle);
		String toStringResult = "JournalComptable{code='"+vCode+"', libelle='"+vLibelle+"'}";
		
		Assert.assertEquals(vCode, vJournal.getCode());
		Assert.assertEquals(vLibelle, vJournal.getLibelle());
		Assert.assertEquals(vJournal.toString(), toStringResult);

	}

	@Test
	public void testGetByCode() {
		
	}

}

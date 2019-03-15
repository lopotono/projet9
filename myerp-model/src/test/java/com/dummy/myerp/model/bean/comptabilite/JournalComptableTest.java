package com.dummy.myerp.model.bean.comptabilite;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class JournalComptableTest {
	
	private static List<JournalComptable> vList;

	@Test
	public void testToString() {
		JournalComptable vJournal = new JournalComptable();

		String vCode = "AC";
		vJournal.setCode(vCode);
		String vLibelle = "Achat";
		vJournal.setLibelle(vLibelle);
		String toStringResult = "JournalComptable{code='" + vCode + "', libelle='" + vLibelle + "'}";

		Assert.assertEquals(vCode, vJournal.getCode());
		Assert.assertEquals(vLibelle, vJournal.getLibelle());
		Assert.assertEquals(vJournal.toString(), toStringResult);

	}

	@Test
	public void testGetByCode() {
		/*JournalComptable vJournal = new JournalComptable();
		List<String> pList = new ArrayList<String>();
		String vCode = "AC";
		vJournal.setCode(vCode);
		pList.add(vCode);
		Assert.assertEquals(vCode, vJournal.getCode());*/
		vList = new ArrayList<>();
		vList.add(new JournalComptable("AC", "Achat"));
		Assert.assertEquals(JournalComptable.getByCode(vList, "AC"), vList.get(0));
	}

}

package com.dummy.myerp.testbusiness.business;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;

public class ComptabiliteManagerIntegrationTest extends BusinessTestCase {

	
	@Test
	public void addReferenceTest() throws Exception {
		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable.setId(-1);
		vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		vEcritureComptable.setDate(formatDate.parse("2016-12-31 00:00:00"));
		vEcritureComptable.setLibelle("Cartouches d’imprimante");
		vEcritureComptable.setReference("AC-2016/00001");
		getBusinessProxy().getComptabiliteManager().addReference(vEcritureComptable);
		Assert.assertEquals("AC-2016/00041", vEcritureComptable.getReference());
	}

	@Test
	public void checkEcritureComptable() throws Exception {
		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
		vEcritureComptable.setDate(new Date());
		vEcritureComptable.setLibelle("Cartouches d’imprimante");
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(1), null, new BigDecimal(10), null));
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(2), null, null, new BigDecimal(20)));

		getBusinessProxy().getComptabiliteManager().checkEcritureComptable(vEcritureComptable);

	}

	@Test
	public void getListCompteComptable() throws Exception {
		List<CompteComptable> compteComptableList = getBusinessProxy().getComptabiliteManager().getListCompteComptable();
		Assert.assertEquals(7, compteComptableList.size());
	}

	@Test
	public void getListJournalComptable() throws Exception {
		List<JournalComptable> journalComptableList = getBusinessProxy().getComptabiliteManager().getListJournalComptable();
		Assert.assertEquals(4, journalComptableList.size());
	}

	@Test
	public void getListEcritureComptable() throws Exception {
		List<EcritureComptable> ecritureComptableList = getBusinessProxy().getComptabiliteManager().getListEcritureComptable();
		Assert.assertEquals(5, ecritureComptableList.size());
	}

}

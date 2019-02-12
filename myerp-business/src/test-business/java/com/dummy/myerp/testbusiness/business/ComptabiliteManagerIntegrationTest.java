package com.dummy.myerp.testbusiness.business;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.SequenceEcritureComptable;

public class ComptabiliteManagerIntegrationTest extends BusinessTestCase {

	@Test
	public void addReferenceTest() throws Exception {
		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable.setId(-1);
		vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
		SimpleDateFormat formatDate = new SimpleDateFormat("2016");
		vEcritureComptable.setDate(formatDate.parse("2016"));
		vEcritureComptable.setLibelle("Cartouches d’imprimante");
		SequenceEcritureComptable vSequenceComptable;
		vSequenceComptable = new SequenceEcritureComptable();
		vSequenceComptable.setDerniereValeur(40);
		int numero;
		numero = vSequenceComptable.getDerniereValeur() + 1;
		String updateReference = vEcritureComptable.getJournal().getCode() + "-" + 2016 + "/"
				+ String.format("%05d", numero);
		getBusinessProxy().getComptabiliteManager().addReference(vEcritureComptable);
		vEcritureComptable.setReference(updateReference);
		Assert.assertEquals("AC-2016/00041", vEcritureComptable.getReference());
	}

	@Test
	public void checkEcritureComptable() throws Exception {
		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable.setId(-2);
		vEcritureComptable.setJournal(new JournalComptable("VE", "Vente"));
		vEcritureComptable.setReference("VE-2016/00002");
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		vEcritureComptable.setDate(formatDate.parse("2016-12-31 00:00:00"));
		vEcritureComptable.setLibelle("TMA Appli Xxx");
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(1), null, new BigDecimal(52), null));
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(2), null, null, new BigDecimal(52)));
		getBusinessProxy().getComptabiliteManager().checkEcritureComptable(vEcritureComptable);

	}

	@Test
	public void getListCompteComptable() throws Exception {
		List<CompteComptable> compteComptableList = getBusinessProxy().getComptabiliteManager()
				.getListCompteComptable();
		Assert.assertEquals(7, compteComptableList.size());
	}

	@Test
	public void getListJournalComptable() throws Exception {
		List<JournalComptable> journalComptableList = getBusinessProxy().getComptabiliteManager()
				.getListJournalComptable();
		Assert.assertEquals(4, journalComptableList.size());
	}

	@Test
	public void getListEcritureComptable() throws Exception {
		List<EcritureComptable> ecritureComptableList = getBusinessProxy().getComptabiliteManager()
				.getListEcritureComptable();
		Assert.assertEquals(5, ecritureComptableList.size());
	}

}

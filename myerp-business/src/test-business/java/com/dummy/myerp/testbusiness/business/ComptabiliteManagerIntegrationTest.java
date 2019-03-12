package com.dummy.myerp.testbusiness.business;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.technical.exception.FunctionalException;

public class ComptabiliteManagerIntegrationTest extends BusinessTestCase {
			
	@Test
	public void addReferenceTest() throws Exception {
		EcritureComptable vEcritureComptable = getBusinessProxy().getComptabiliteManager().getEcritureComptable(-2);
		getBusinessProxy().getComptabiliteManager().addReference(vEcritureComptable);
		Assert.assertEquals("VE-2016/00002", vEcritureComptable.getReference());
	}

	@Test
	public void checkEcritureComptable() throws FunctionalException {
		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable.setJournal(new JournalComptable("VE", "Vente"));
		Date date = new Date();
		vEcritureComptable.setDate(date);
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy");
		String annee = formatDate.format(vEcritureComptable.getDate());
		vEcritureComptable.setReference("VE-"+annee+"/00002");
		vEcritureComptable.setLibelle("TMA Appli Xxx");
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(1), null, new BigDecimal(52), null));
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(2), null, null, new BigDecimal(52)));
		getBusinessProxy().getComptabiliteManager().checkEcritureComptable(vEcritureComptable);

	}
	
	@Test
	public void insertEcritureComptable() throws FunctionalException, ParseException {
		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		vEcritureComptable.setDate(formatDate.parse("2016-12-31 00:00:00"));
		vEcritureComptable.setReference("AC" + "-" + 2016 + "/00009");
		vEcritureComptable.setLibelle("Cartouches d’imprimante");
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(606), null, new BigDecimal(52), null));
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(401), null, null, new BigDecimal(52)));
		getBusinessProxy().getComptabiliteManager().insertEcritureComptable(vEcritureComptable);
		Assert.assertNotNull(vEcritureComptable.getId());
	}

	@Test
	public void updateEcritureComptable() throws FunctionalException, ParseException {
		List<EcritureComptable> list = getBusinessProxy().getComptabiliteManager().getListEcritureComptable();
		for (EcritureComptable vEcritureComptable : list) {
			if (vEcritureComptable.getId() == -3) {
				vEcritureComptable.setLibelle("Paiement Facture F110001");
				getBusinessProxy().getComptabiliteManager().updateEcritureComptable(vEcritureComptable);
				Assert.assertEquals("Paiement Facture F110001", vEcritureComptable.getLibelle());
			}
		}
	}

	@Test	
	public void deleteEcritureComptable() {
		getBusinessProxy().getComptabiliteManager().deleteEcritureComptable(-3);
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
		Assert.assertEquals(4, ecritureComptableList.size());
	}

}

package com.dummy.myerp.testconsumer.consumer;

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
import com.dummy.myerp.model.bean.comptabilite.SequenceEcritureComptable;
import com.dummy.myerp.technical.exception.NotFoundException;

public class ComptabiliteDaoIntegrationTest extends ConsumerTestCase {

	@Test
	public void getListCompteComptable() throws Exception {
		List<CompteComptable> compteComptableList = getDaoProxy().getComptabiliteDao().getListCompteComptable();
		Assert.assertEquals(7, compteComptableList.size());
	}

	@Test
	public void getListJournalComptable() throws Exception {
		List<JournalComptable> journalComptableList = getDaoProxy().getComptabiliteDao().getListJournalComptable();
		Assert.assertEquals(4, journalComptableList.size());

	}

	@Test
	public void getListEcritureComptable() throws Exception {
		List<EcritureComptable> ecritureComptableList = getDaoProxy().getComptabiliteDao().getListEcritureComptable();
		Assert.assertEquals(4, ecritureComptableList.size());

	}

	@Test
	public void getEcritureComptable() throws Exception {
		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable = getDaoProxy().getComptabiliteDao().getEcritureComptable(-2);
		Assert.assertEquals("VE", vEcritureComptable.getJournal().getCode());
		Assert.assertEquals("VE-2016/00002", vEcritureComptable.getReference());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse("2016-12-30");
		Assert.assertEquals(date, vEcritureComptable.getDate());
		Assert.assertEquals("TMA Appli Xxx", vEcritureComptable.getLibelle());
	}

	@Test
	public void getEcritureComptableByRef() throws Exception {
		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable = getDaoProxy().getComptabiliteDao().getEcritureComptableByRef("AC-2016/00001");
		Assert.assertEquals("AC", vEcritureComptable.getJournal().getCode());
	}

	@Test
	public void loadListLigneEcriture() throws Exception {
		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable.setId(-2);
		getDaoProxy().getComptabiliteDao().loadListLigneEcriture(vEcritureComptable);
		Assert.assertEquals(3, vEcritureComptable.getListLigneEcriture().size());

	}

	@Test
	public void insertEcritureComptable() throws Exception {
		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
		vEcritureComptable.setReference("AC-2016/00003");
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		vEcritureComptable.setDate(formatDate.parse("2016-12-29 00:00:00"));
		vEcritureComptable.setLibelle("Cartouches d’imprimante");
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(606), null, new BigDecimal(52), null));
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(401), null, null, new BigDecimal(52)));
		getDaoProxy().getComptabiliteDao().insertEcritureComptable(vEcritureComptable);
		Assert.assertNotNull(vEcritureComptable.getId());
	}

	@Test
	public void updateEcritureComptable() {
		List<EcritureComptable> list = getDaoProxy().getComptabiliteDao().getListEcritureComptable();
		for (EcritureComptable vEcritureComptable : list) {
			if (vEcritureComptable.getId() == -2) {
				vEcritureComptable.setLibelle("TMA Appli Xxx");
				getDaoProxy().getComptabiliteDao().updateEcritureComptable(vEcritureComptable);
				Assert.assertEquals("TMA Appli Xxx", vEcritureComptable.getLibelle());
			}
		}
	}

	@Test
	public void deleteEcritureComptable() {
		getDaoProxy().getComptabiliteDao().deleteEcritureComptable(-1);
	}

	@Test
	public void getSequenceEcriture() throws NotFoundException {
		SequenceEcritureComptable vSequenceEcritureComptable;
		vSequenceEcritureComptable = new SequenceEcritureComptable();
		vSequenceEcritureComptable.setAnnee(vSequenceEcritureComptable.getAnnee());
	}

	@Test
	public void updateSequenceEcritureComptable() {
		SequenceEcritureComptable vSequence;
		vSequence = new SequenceEcritureComptable();
		vSequence.setAnnee(2016);
		vSequence.setDerniereValeur(41);
		getDaoProxy().getComptabiliteDao().updateSequenceEcritureComptable("AC", vSequence);
	}

	@Test
	public void insertSequenceEcritureComptable() {
		SequenceEcritureComptable vSequence;
		vSequence = new SequenceEcritureComptable();
		vSequence.setAnnee(2017);
		vSequence.setDerniereValeur(45);
		getDaoProxy().getComptabiliteDao().insertSequenceEcritureComptable("AC", vSequence);
	}

}

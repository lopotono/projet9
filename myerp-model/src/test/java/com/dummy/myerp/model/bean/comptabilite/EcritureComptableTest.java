package com.dummy.myerp.model.bean.comptabilite;

import java.math.BigDecimal;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;
import org.junit.Test;

public class EcritureComptableTest {

	private LigneEcritureComptable createLigne(Integer pCompteComptableNumero, String pDebit, String pCredit) {
		BigDecimal vDebit = pDebit == null ? null : new BigDecimal(pDebit);
		BigDecimal vCredit = pCredit == null ? null : new BigDecimal(pCredit);
		String vLibelle = ObjectUtils.defaultIfNull(vDebit, BigDecimal.ZERO)
				.subtract(ObjectUtils.defaultIfNull(vCredit, BigDecimal.ZERO)).toPlainString();
		LigneEcritureComptable vRetour = new LigneEcritureComptable(new CompteComptable(pCompteComptableNumero),
				vLibelle, vDebit, vCredit);
		return vRetour;
	}

	@Test
	public void isEquilibree() {
		EcritureComptable vEcriture;
		vEcriture = new EcritureComptable();

		vEcriture.setLibelle("Equilibrée");
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", "33"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", "7"));
		Assert.assertTrue(vEcriture.toString(), vEcriture.isEquilibree());

		vEcriture.getListLigneEcriture().clear();
		vEcriture.setLibelle("Non équilibrée");
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "10", null));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "20", "1"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "30"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, "1", "2"));
		Assert.assertFalse(vEcriture.toString(), vEcriture.isEquilibree());
	}

	@Test
	public void testTotalDebit() {
		EcritureComptable vEcriture = new EcritureComptable();
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", "33"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", "7"));
		BigDecimal vTotalDebit = new BigDecimal("341.00");
		Assert.assertEquals(vTotalDebit, vEcriture.getTotalDebit());
	}

	@Test
	public void testTotalCredit() {
		EcritureComptable vEcriture = new EcritureComptable();
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", "33"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", "7"));
		BigDecimal vTotalCredit = new BigDecimal("341");
		Assert.assertEquals(vTotalCredit, vEcriture.getTotalCredit());
	}
	
	@Test
	public void testToString() {
		EcritureComptable vEcriture = new EcritureComptable();
		vEcriture.getId();
		vEcriture.getJournal();
		vEcriture.getReference();
		vEcriture.getDate();
		vEcriture.getLibelle();
		vEcriture.getTotalDebit();
		vEcriture.getTotalCredit();
		vEcriture.getListLigneEcriture();
		
		int vId = -1;
		String vJournal = "AC";
		String vReference = "AC-2016/00001";
		String vDate = "2016-12-31";
		String vLibelle = "Cartouches d’imprimante";
		BigDecimal vTotalDebit = new BigDecimal("341.00");
		BigDecimal vTotalCredit = new BigDecimal("341");
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", "33"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", "7"));


		Assert.assertEquals(vId, (int)vEcriture.getId());
		Assert.assertEquals(vJournal, vEcriture.getJournal());
		Assert.assertEquals(vReference, vEcriture.getReference());
		Assert.assertEquals(vDate, vEcriture.getDate());
		Assert.assertEquals(vLibelle, vEcriture.getLibelle());
		Assert.assertEquals(vTotalDebit, vEcriture.getTotalDebit());
		Assert.assertEquals(vTotalCredit, vEcriture.getTotalCredit());

	}

}
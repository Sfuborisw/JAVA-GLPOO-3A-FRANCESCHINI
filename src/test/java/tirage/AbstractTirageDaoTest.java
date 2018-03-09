package tirage;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.esiea.glpoo.dao.TirageDao;
import fr.esiea.glpoo.tirage.Tirage;

public abstract class AbstractTirageDaoTest {

	protected TirageDao dao;
	
	@Test
	public void testAnnee() throws Exception {
		final int expectedAnnee = 2016078;
		final List<Tirage> tirages = dao.findAllTirage();
		final int annee = tirages.get(0).getAnnee();
		Assert.assertEquals(expectedAnnee, annee);
	}
	
	@Test
	public void testDay() throws Exception {
		final String expectedDay = "MARDI";
		final List<Tirage> tirages = dao.findAllTirage();
		final String day = tirages.get(1).getJour();
		Assert.assertEquals(expectedDay,day);
	}
	
	@Test
	public void testDate() throws Exception {
		
	}
	
	@Test
	public void testEndDate() throws Exception {
		
	}
	
	@Test
	public void testNumTirage() throws Exception {
		
	}
	
	@Test
	public void testBoule1() throws Exception {
		
	}
	
	@Test
	public void testBoule2() throws Exception {
		
	}
	
	@Test
	public void testBoule3() throws Exception {
		
	}
	
	@Test
	public void testBoule4() throws Exception {
		
	}
	
	@Test
	public void testBoule5() throws Exception {
		
	}
	
	@Test
	public void testEtoile1() throws Exception {
		
	}
	
	@Test
	public void testEtoile2() throws Exception {
		
	}
	
	@Test
	public void testTableBoule() throws Exception {
		
	}
	
	@Test
	public void testTableEtoile() throws Exception {
		
	}
	
	@Test
	public void testBoule1InTable() throws Exception {
		final String expectedResult = "6";
		final List<Tirage> tirages = dao.findAllTirage();
		final String[] tableBoule1 = tirages.get(0).getBoules();
		final String boule1 = tableBoule1[0];
		
		Assert.assertEquals(expectedResult, boule1);
	}
	
	
}

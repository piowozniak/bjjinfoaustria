package pl.bjjinfoaustria.test.bean;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import pl.bjjinfoaustria.bean.BracketMB;
import pl.bjjinfoaustria.entity.Competitor;

class BracketMBTest {

	BracketMB bracket = new BracketMB();
	final List<Competitor> competitors =
			Arrays.asList(new Competitor(), new Competitor(), new Competitor(), new Competitor(), new Competitor(), new Competitor());
	final int index = 1;
	
	@Test
	void testInitializeBracketTree() {
		bracket.initializeBracketTree();
		assertEquals(3, bracket.getFights().size());
	}

	@Test
	void testAddCompetitorToFight() {
		bracket.setTemporaryListOfCompetitors(new ArrayList<>(competitors));
		
	}

	@Test
	void testRemoveCompetitorFromFight() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBrackets() {
		fail("Not yet implemented");
	}

}

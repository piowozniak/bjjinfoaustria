package pl.bjjinfoaustria.test.bean;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import pl.bjjinfoaustria.bean.BracketMB;
import pl.bjjinfoaustria.entity.Competitor;
import pl.bjjinfoaustria.repository.CompetitorRepository;

class BracketMBTest {

	BracketMB bracket = new BracketMB();
	final List<Competitor> competitors =
			Arrays.asList(new Competitor(), new Competitor(), new Competitor(), new Competitor(), new Competitor(), new Competitor());
	final int index = 1;
	
	@Test
	void testInitializeBracketTree() {
		bracket.setAllCompetitorsInDivision(competitors);
		bracket.initializeBracketTree();
		assertEquals(3, bracket.getFights().size());
	}

	@Test
	void testAddCompetitorToFight() {
		bracket.setTemporaryListOfCompetitors(new ArrayList<>(competitors));
		assertEquals(bracket.getTemporaryListOfCompetitors().size(), 6);
		bracket.addCompetitorToFight(index);
		assertEquals(bracket.getTemporaryListOfCompetitors().size(), 5);
//		assertEquals(bracket.getFights().get(0).getCompetitors().size(), 1);
	}

	@Test
	void testRemoveCompetitorFromFight() {
		bracket.removeCompetitorFromFight(index, index);
		assertEquals(bracket.getFights().get(index).getCompetitors().size(), 1);
	}

	@Test
	void testSaveBrackets() {
		CompetitorRepository competitorRepository = null;
		bracket.saveBrackets(competitorRepository);
		assertEquals(bracket.getFights().get(0).getCompetitors().get(0).getRound(), 0);
		fail("what what what");
	}

}

package pl.bjjinfoaustria.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.entity.Division;

@Service
public interface CompetitionService {
	String addCategoryToModel(Model model, long id);
	String saveDivision(Division division, Model model);
	String addCompetitor(long eventId, long userId, Division division );
}

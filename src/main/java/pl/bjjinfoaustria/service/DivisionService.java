package pl.bjjinfoaustria.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.entity.Event;

@Service
public interface DivisionService {
	String addCategoryToModel(Model model, long id);
	String addDivision(Division division, Model model);
	String saveDivisionInCompetition(Event event, Model model);
	String removeDivisionFromCollection(int index, Model model);
	String editDivisions(long id, Model model);
}

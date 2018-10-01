package pl.bjjinfoaustria.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.repository.DivisionRepository;
import pl.bjjinfoaustria.service.CompetitionService;
@Service
public class CompetitionServiceImpl implements CompetitionService {
	
	@Autowired
	private DivisionRepository divisionRepository;
	
	@Override
	public String createbrackets(Model model, long id) {
		List<Division> divisions = divisionRepository.findDivisionsFromCompetitionByEventId(id);
		model.addAttribute("divisions", divisions);
		return "bracketcreator";
	}

}

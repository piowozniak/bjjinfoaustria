package pl.bjjinfoaustria.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.bjjinfoaustria.entity.Competition;
import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.repository.CompetitionRepository;
import pl.bjjinfoaustria.repository.DivisionRepository;
import pl.bjjinfoaustria.service.CompetitionService;
@Service
public class CompetitionServiceImpl implements CompetitionService {
	
	@Autowired 
	private CompetitionRepository competitionRepository;
	@Autowired
	DivisionRepository divisionRepository;
	@Override
	public String addCategoryToModel(Model model, long id) {
		Competition competition = competitionRepository.findOne(id);
		Division division = new Division();
		division.setCompetition(competition);
		model.addAttribute("division", division);
		model.addAttribute("competition", competition);
		return "adddivision";
	}

	@Override
	public String saveDivision(Division division, Model model) {
		divisionRepository.saveAndFlush(division);
		Competition competition = competitionRepository.findOne(division.getCompetition().getId());
		model.addAttribute("competition", competition);
		return "competitionregistration";
	}

}

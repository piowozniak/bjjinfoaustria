package pl.bjjinfoaustria.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.bjjinfoaustria.entity.Competition;
import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.entity.User;
import pl.bjjinfoaustria.repository.CompetitionRepository;
import pl.bjjinfoaustria.repository.DivisionRepository;
import pl.bjjinfoaustria.repository.EventRepository;
import pl.bjjinfoaustria.repository.UserRepository;
import pl.bjjinfoaustria.service.CompetitionService;
@Service
public class CompetitionServiceImpl implements CompetitionService {
	
	@Autowired 
	private CompetitionRepository competitionRepository;
	@Autowired
	DivisionRepository divisionRepository;
	@Autowired
	EventRepository eventRepository;
	@Autowired
	UserRepository userRepository;
	
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

	@Override
	public String addCompetitor(long eventId, long userId, Division division) {
		Event event = eventRepository.findOne(eventId);
		User user = userRepository.findOne(userId);
		event.getParticipants().add(user);
		eventRepository.saveAndFlush(event);
		division = divisionRepository.findOne(division.getId());
		division.getCompetitors().add(user);
		divisionRepository.saveAndFlush(division);
		division = divisionRepository.findOne(division.getId());
		System.out.println(division.getFullNameCategory());
		for(User u : division.getCompetitors()) {
			System.out.println(u.getFirstName());

		}
		return "redirect:events";
	}

}

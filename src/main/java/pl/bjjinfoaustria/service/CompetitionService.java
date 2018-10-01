package pl.bjjinfoaustria.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.entity.Division;

@Service
public interface CompetitionService {
	String createbrackets(Model model, long id);

}

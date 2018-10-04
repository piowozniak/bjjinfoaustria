package pl.bjjinfoaustria.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface BracketService {
	String createBrackets(Model model, long id);
	String displayDivision(Model model, long id);
}

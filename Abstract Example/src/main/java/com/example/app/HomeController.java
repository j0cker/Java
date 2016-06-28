package com.example.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.persona.ListinProfesores;
import com.example.persona.ProfesorInterino;
import com.example.persona.ProfesorTitular;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("saludo", "webos");

		iniciarAbstract();

		return "home";
	}

	public void iniciarAbstract() {
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2019, 10, 22); // Los meses van de 0 a 11, luego 10
									// representa noviembre
		ProfesorInterino pi1 = new ProfesorInterino("José", "Hernández López",
				45, "45221887-K", fecha1);
		ProfesorInterino pi2 = new ProfesorInterino("Andrés", "Moltó Parra",
				87, "72332634-L", fecha1);
		ProfesorInterino pi3 = new ProfesorInterino("José", "Ríos Mesa", 76,
				"34998128-M", fecha1);
		ProfesorTitular pt1 = new ProfesorTitular("Juan", "Pérez Pérez", 23,
				"73-K");
		ProfesorTitular pt2 = new ProfesorTitular("Alberto", "Centa Mota", 49,
				"88-L");
		ProfesorTitular pt3 = new ProfesorTitular("Alberto", "Centa Mota", 49,
				"81-F");
		
		ListinProfesores listinProfesorado = new ListinProfesores();
		listinProfesorado.addProfesor(pi1);
		listinProfesorado.addProfesor(pi2);
		listinProfesorado.addProfesor(pi3);
		listinProfesorado.addProfesor(pt1);
		listinProfesorado.addProfesor(pt2);
		listinProfesorado.addProfesor(pt3);
		listinProfesorado.imprimirListin();
		
		System.out
				.println("El importe de las nóminas del profesorado que consta en el listín es "
						+ listinProfesorado.importeTotalNominaProfesorado()
						+ " euros");

	}
}

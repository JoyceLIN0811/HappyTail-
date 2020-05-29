package com.happytail.reservation.controller;


import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.happytail.member.model.PetMembers;
import com.happytail.reservation.model.Evaluation;
import com.happytail.reservation.model.backView;
import com.happytail.reservation.model.service.EvaluationService;






@Controller
@SessionAttributes(value = {"Evaluation"})
public class EvaluationController {
	
	@Autowired
	private EvaluationService service;
		

	
	@PostMapping("/saveEvaluation")
	public String save(@SessionAttribute("petMembers") PetMembers petMembers,
			@RequestParam("reservationId")Integer reservationId,
			@RequestParam("score")Double score,
			@RequestParam("content")String content,Model m) {
		
		Evaluation en = new Evaluation();
		en.setReservationId(reservationId);
		en.setScore(score);
		en.setContent(content);
		en.setId(petMembers.getId());
		
		service.save(en);
		
		return "redirect:/Evaluationlist";	
	}
	
	@RequestMapping(value = "/Evaluationlist", method = RequestMethod.GET)
	public String Evaluationlist(Model m)  {
		List<Evaluation> list = service.queryAllEvaluation();
		m.addAttribute("Evaluation" , list);
		
		double num = service.ScoreAvg();
		DecimalFormat df = new DecimalFormat("#.0");
		String avg = df.format(num);
		m.addAttribute("scoreAvg" , avg);
		
		System.out.println(avg);
		return "reservationPage";
	}
	
	@PostMapping("/queryByDate")
	public String queryByDateEvaluationView(@RequestParam("createMonth")String createMonth,Model m) {
		List<backView> list = service.queryByDateEvaluationView(createMonth);
		m.addAttribute("backView",list);
		
		return "backReservationPage";
	}
	
}

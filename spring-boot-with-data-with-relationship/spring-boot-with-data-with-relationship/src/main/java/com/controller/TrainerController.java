package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Trainer;
import com.service.TrainerService;

@RestController
@RequestMapping("trainer")
public class TrainerController {

	@Autowired
	TrainerService trainerService;
	
	@GetMapping(value = "findAll",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Trainer> findAllTrainer(){
		return trainerService.findAllTrainer();
	}
	
	@GetMapping(value = "searchTrainer/{tech}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Trainer> searchTrainer(@PathVariable("tech") String tech){
		return trainerService.searchTrainerByTech(tech);
	}
	
	@PostMapping(value = "storeTrainer",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeTrainer(@RequestBody Trainer trainer) {
		return trainerService.storeTrainer(trainer);
	}
}

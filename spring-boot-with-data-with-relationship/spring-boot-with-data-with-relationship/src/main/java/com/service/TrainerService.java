package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Trainer;
import com.repository.TrainerRepository;

@Service
public class TrainerService {

	@Autowired
	TrainerRepository trainerRepository;
	
	public String storeTrainer(Trainer trainer) {
		//trainerRepository.save(trainer); // save is pre defined method to insert record 
	Optional<Trainer>	result= trainerRepository.findById(trainer.getTid());
	if(result.isPresent()) {
		return "Trainer id must be unique";
	}else {
		trainerRepository.save(trainer);
		return "Trainer record saved";
	}
	}
	
	public List<Trainer> findAllTrainer() {
		return trainerRepository.findAll();
	}
	
	// custom repository method 
	public List<Trainer> searchTrainerByTech(String tech){
		return trainerRepository.searchTrainerByTech(tech);
	}
	
	
	public String updateTrainer(Trainer trainer) {
		//trainerRepository.save(trainer); // save is pre defined method to insert record 
						
	Optional<Trainer>	result= trainerRepository.findById(trainer.getTid());
	if(result.isPresent()) {
		Trainer t = result.get();
		t.setTech("Python");
		trainerRepository.saveAndFlush(t);
		return "Trainer record updated";
	}else {
		return "Trainer record not present";
	}
	
	}
	
	public String deleteTrainer(Trainer trainer) {
		Optional<Trainer>	result= trainerRepository.findById(trainer.getTid());
		if(result.isPresent()) {
			Trainer t = result.get();
			trainerRepository.delete(t);
			return "Trainer record deleted";
		}else {
			return "Trainer record not present";
		}
	}
}


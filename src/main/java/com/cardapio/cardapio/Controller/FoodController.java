package com.cardapio.cardapio.Controller;

import com.cardapio.cardapio.food.Food;
import com.cardapio.cardapio.food.FoodRepository;
import com.cardapio.cardapio.food.FoodRequestDTO;
import com.cardapio.cardapio.food.FoodResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {
	
	@Autowired
	private FoodRepository repository;
	
	@PostMapping
	public void saveFood(@RequestBody FoodRequestDTO data) {
		
		Food foodData = new Food(data);
		repository.save(foodData);
		return;
	}
	
	@GetMapping
	public List<FoodResponseDTO> getAll() {	
		return repository.findAll().stream().map(FoodResponseDTO::new).toList();
	}
}

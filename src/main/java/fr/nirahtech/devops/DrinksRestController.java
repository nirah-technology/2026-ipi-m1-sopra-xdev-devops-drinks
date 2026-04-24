package fr.nirahtech.devops;

import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drinks")
public class DrinksRestController {

    private final DrinksRepository drinksRepository;

    public DrinksRestController(DrinksRepository drinksRepository) {
        this.drinksRepository = drinksRepository;
    }
    
    @GetMapping("")
    public Page<Drink> findAllDrinks(@RequestParam(required = false) Boolean isAlcool, Pageable pageable) {
        Page<Drink> result = null;

        if (Objects.nonNull(isAlcool)) {
            if (isAlcool) {
                result = this.drinksRepository.findAllByIsAlcool(pageable);
            } else {
                result = this.drinksRepository.findAllByIsNonAlcool(pageable);
            }
        } else {
            result = this.drinksRepository.findAll(pageable);
        }

        return result;
    }

    @GetMapping("/{id}")
    public Optional<Drink> findDrinkById(@PathVariable Long id) {
        return this.drinksRepository.findById(id);
    }

    @PostMapping("")
    public Drink createDrink(@RequestBody Drink drink) {
        this.drinksRepository.save(drink);
        return drink;
    }

    @PutMapping("/{id}")
    public Drink updateDrink(@PathVariable String id, @RequestBody Drink drink) {
        this.drinksRepository.save(drink);        
        return drink;
    }
    
    @DeleteMapping("/{id}")
    public void deleteDrink(@PathVariable("id") Long drinkId) {
        this.drinksRepository.deleteById(drinkId);
    }
}

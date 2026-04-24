package fr.nirahtech.devops;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinksRepository extends JpaRepository<Drink, Long> {
    List<Drink> findAllByIsAlcool(boolean isAlcool);
}

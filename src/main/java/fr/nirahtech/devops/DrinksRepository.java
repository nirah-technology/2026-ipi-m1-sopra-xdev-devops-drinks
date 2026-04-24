package fr.nirahtech.devops;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinksRepository extends JpaRepository<Drink, Long> {

    @Query("SELECT d FROM Drink d WHERE d.degrees > 0")
    Page<Drink> findAllByIsAlcool(Pageable pageable);

    @Query("SELECT d FROM Drink d WHERE d.degrees = 0")
    Page<Drink> findAllByIsNonAlcool(Pageable pageable);
}

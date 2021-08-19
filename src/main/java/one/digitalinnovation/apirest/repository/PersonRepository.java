package one.digitalinnovation.apirest.repository;


import one.digitalinnovation.apirest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}

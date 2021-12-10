package ru.demo.dockerapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.demo.dockerapp.entity.Greeting;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {
}

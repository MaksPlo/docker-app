package ru.demo.dockerapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.demo.dockerapp.entity.Greeting;
import ru.demo.dockerapp.repository.GreetingRepository;

@RestController
@RequestMapping("/greeting")
@RequiredArgsConstructor
@PreAuthorize("hasRole('APP_ADMIN')")
@Slf4j
public class GreetingController {

    private final GreetingRepository repository;


    @GetMapping("/{greetingId}")
    public ResponseEntity<String> getGreeting(@PathVariable("greetingId") long greetingId) {
        log.info("get greeting with id: " + greetingId);
        Greeting greeting = repository.findById(greetingId).orElseThrow(() -> new RuntimeException("entity not found"));
        return ResponseEntity.ok(greeting.getMessage());
    }

    @PostMapping
    public ResponseEntity<Long> createGreeting(String greetingText) {
        log.info("create greeting with test: " + greetingText);
        Greeting greeting = repository.save(Greeting.builder().message(greetingText).build());
        return ResponseEntity.ok(greeting.getId());
    }
}

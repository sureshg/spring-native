package dev.suresh.springnative.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingsController {

  @GetMapping("/greet") fun greet() = "Hello, Spring Native!"
}

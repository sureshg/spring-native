package dev.suresh.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingsController {

  @GetMapping("/greet") fun greet() = "Hello, Spring Native!"

  @GetMapping("/greet/{type}")
  fun reflectGreet(@PathVariable type: String) =
      when (type) {
        "java" -> initReflectively("dev.suresh.data.JavaRec")
        "kotlin" -> initReflectively("dev.suresh.data.KotlinData")
        else -> "Hello, Spring Native!"
      }

  private fun initReflectively(className: String) =
      Class.forName(className).getConstructor().newInstance().toString()
}

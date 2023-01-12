package dev.suresh.controller

import dev.suresh.data.JavaRec
import dev.suresh.data.KotlinData
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingsController {

  @GetMapping("/greet") fun greet() = "Hello, Spring Native!"

  @GetMapping("/greet/{type}")
  fun reflectGreet(@PathVariable type: String) =
      when (type) {
        "java" -> initReflectively<JavaRec>()
        "kotlin" -> initReflectively<KotlinData>()
        else -> "Hello, Spring Native!"
      }

  private inline fun <reified T> initReflectively() =
      T::class.java.getConstructor().newInstance().toString()
}

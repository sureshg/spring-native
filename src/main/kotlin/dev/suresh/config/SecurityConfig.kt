package dev.suresh.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class SecurityConfig {

  fun securityFilterChain(http: HttpSecurity): SecurityFilterChain =
      http
          .authorizeHttpRequests { auth ->
            auth.requestMatchers("/actuator/**").permitAll()
            auth.requestMatchers("/greet").permitAll()
            auth.anyRequest().authenticated()
          }
          .formLogin(Customizer.withDefaults())
          .build()
}

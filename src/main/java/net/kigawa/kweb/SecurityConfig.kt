package net.kigawa.kweb

import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@EnableWebSecurity
open class SecurityConfig: WebMvcConfigurer {
  @Bean
  @Throws(Exception::class)
  open fun webSecurity(httpSecurity: HttpSecurity): SecurityFilterChain {
    return httpSecurity
      .authorizeHttpRequests {
        it
          .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
          .mvcMatchers("/api/private").hasRole(Role.USER.id)
          .mvcMatchers("/api/admin").hasRole(Role.ADMIN.id)
          .anyRequest().authenticated()
      }.build()
  }
}
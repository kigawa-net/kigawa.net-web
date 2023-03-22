package net.kigawa.kweb.filter

import org.springframework.http.HttpHeaders.AUTHORIZATION
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthFilter: OncePerRequestFilter() {
  override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
    val token = request.getHeader(AUTHORIZATION)
    if (token == null) {
      filterChain.doFilter(request, response)
      return
    }
  }
}
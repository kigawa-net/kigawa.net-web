package net.kigawa.kweb.filter

import org.springframework.http.HttpHeaders.AUTHORIZATION
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter
import javax.servlet.http.HttpServletRequest

class AuthFilter: AbstractPreAuthenticatedProcessingFilter() {
  override fun getPreAuthenticatedPrincipal(request: HttpServletRequest?): Any {
    return ""
  }
  
  override fun getPreAuthenticatedCredentials(request: HttpServletRequest?): Any {
    return request?.getHeader(AUTHORIZATION) ?: ""
  }
}
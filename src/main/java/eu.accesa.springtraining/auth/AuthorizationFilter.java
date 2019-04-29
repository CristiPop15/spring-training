package eu.accesa.springtraining.auth;

import javax.servlet.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    System.out.println("on the way in");
//    String jwt = ((HttpRequest) request).getHeaders().toSingleValueMap().get("JWT");
    String name = request.getParameter("name");
    if (((HttpServletRequest) request).getHeader("JWT") == null) {
      ((HttpServletResponse) response).sendError(HttpServletResponse.SC_BAD_REQUEST, "JWT is missing, bitch");
    } else {
      chain.doFilter(request, response);
    }
    System.out.println("on the way out");
  }

  @Override
  public void destroy() {

  }
}

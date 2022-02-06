package by.doall.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeCommand implements Command {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
  }
}

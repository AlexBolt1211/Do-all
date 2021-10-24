package by.doall.web.command;

import by.doall.model.User;
import by.doall.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class HomeCommand implements Command {

  private UserRepository userRepository = new UserRepository();

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<User> users = userRepository.getAll();

    request.setAttribute("users", users);

    request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
  }
}

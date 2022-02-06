package by.doall.web.command;

import by.doall.model.Advertisement;
import by.doall.repository.AdvertisementRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class HomeCommand implements Command {

  private AdvertisementRepository repository;

  public HomeCommand() {
    this.repository = new AdvertisementRepository();
  }

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<Advertisement> advertisementList = repository.findAll();

    request.setAttribute("advertisementList", advertisementList);

    request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
  }
}

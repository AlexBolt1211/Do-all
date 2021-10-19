package by.doall.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet
public class BaseServlet extends HttpServlet {

  private static final long serialVersionUID = -335270919478646707L;

  private static final Logger LOG = LogManager.getLogger(BaseServlet.class);

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    LOG.info("init application servlet");
  }
}

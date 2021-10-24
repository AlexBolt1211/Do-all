package by.doall.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/do-all")
public class BaseServlet extends HttpServlet {

  private static final long serialVersionUID = -335270919478646707L;

  private static final Logger LOG = LogManager.getLogger(BaseServlet.class);

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    LOG.info("init application servlet {}", config.getServletContext().getContextPath());
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    processInternal(req, resp, getServletContext());
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    processInternal(req, resp, getServletContext());
  }

  private void processInternal(
      HttpServletRequest req, HttpServletResponse resp, ServletContext ctx) {
    ServletRequestHandler requestHandler = new ServletRequestHandler();

    try {
      requestHandler.handleRequest(req, resp, ctx);
    } catch (IOException ex) {
      // ignore noting to do here
    } catch (Throwable t) {
      resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      LOG.error(t);
    }
  }
}

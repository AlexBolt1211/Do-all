package by.doall.web;

import by.doall.web.command.Command;
import by.doall.web.command.Commands;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletRequestHandler {

  private static final String COMMAND_PRM = "command";

  private static final Logger LOG = LogManager.getLogger(ServletRequestHandler.class);

  public void handleRequest(HttpServletRequest req, HttpServletResponse resp, ServletContext ctx)
      throws Exception {

    var reqParameter = req.getParameter(COMMAND_PRM);
    if (reqParameter == null) {
      LOG.debug("missing parameter {}", COMMAND_PRM);
    }

    Command command = Commands.getCommandByName(reqParameter);

    LOG.debug("start executing command {}", reqParameter);
    executeCommand(command, req, resp, ctx);
  }

  private void executeCommand(
      Command command, HttpServletRequest req, HttpServletResponse resp, ServletContext ctx) {


    try {
      command.execute(req, resp);
    } catch (Exception e) {
      LOG.error("error while executing command: ", e);
    }
  }
}

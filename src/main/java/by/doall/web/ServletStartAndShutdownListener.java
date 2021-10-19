package by.doall.web;

import by.doall.sql.MySqlConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletStartAndShutdownListener implements ServletContextListener {

  private static final Logger LOG = LogManager.getLogger(ServletStartAndShutdownListener.class);

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    LOG.info("context initialized");

    try {
      MySqlConnectionPool.getInstance().start();
    } catch (Exception e) {
      LOG.error("error on application startup", e);
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    LOG.info("context destroyed");

    MySqlConnectionPool.getInstance().stop();
  }
}

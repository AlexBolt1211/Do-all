package by.doall.web.command;

import java.util.HashMap;
import java.util.Map;

public final class Commands {

  private static final Map<String, Command> COMMAND_MAP = new HashMap<>();

  static {
    COMMAND_MAP.put("home", new HomeCommand());
    COMMAND_MAP.put("login", new LoginCommand());
  }

  private Commands() {}

  public static Command getCommandByName(String name) {
    return COMMAND_MAP.getOrDefault(name, new HomeCommand());
  }
}

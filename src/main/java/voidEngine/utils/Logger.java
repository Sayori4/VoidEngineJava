package voidEngine.utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Logger {
    private final ArrayList<String> logs = new ArrayList<>();
    private final String name;
    private final String logDir = "log/";

    public Logger(String name) {
        String time = timestamp(true);
        this.name = logDir + time + "_" + name;
        logs.add("--Start of log file--");
    }

    public void log(String message) {
        String time = timestamp(false);
        logs.add("[" + time + "] " + message);
    }

    public void save() {
        logs.add("--End of log file--");
        FileManager.writeFile(name, logs.toArray(new String[0]));
    }

    public String timestamp(boolean addDate) {
        String out;
        if (addDate) {
            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm:ss");
            out = time.format(formatter);
        } else {
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            out = time.format(formatter);
        }
        return out;
    }
}

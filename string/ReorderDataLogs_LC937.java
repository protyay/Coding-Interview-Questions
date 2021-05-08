import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReorderDataLogs_LC937 {
    public String[] reorderLogFiles(String[] logs) {
        List<LogData> digitLogs = new ArrayList<>();
        List<LogData> letterLogs = new ArrayList<>();

        for (String log : logs) {
            int firstWhitespace = log.indexOf(" ");

            if (firstWhitespace == -1)
                throw new IllegalStateException("Wrong input");

            String id = log.substring(0, firstWhitespace);
            String content = log.substring(firstWhitespace + 1);

            if (Character.isDigit(content.charAt(0))) {
                digitLogs.add(new LogData(id, content));
            } else {
                letterLogs.add(new LogData(id, content));
            }

        }
        // Sort the letter only string, using a comparator
        // Add the digitlogs to it.
        Comparator<LogData> byContent = Comparator.comparing(LogData::getContent);
        Comparator<LogData> byId = byContent.thenComparing(LogData::getId);

        Collections.sort(letterLogs, byId);
        Function<LogData, String> transformation = data -> data.getId() + " " + data.getContent();
        List<String> letters = letterLogs.stream().map(transformation).collect(Collectors.toList());
        List<String> digits = digitLogs.stream().map(transformation).collect(Collectors.toList());
        letters.addAll(digits);
        return letters.toArray(new String[letters.size()]);
    }
}

class LogData {
    final String id;
    final String content;

    LogData(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public String getId() {
        return this.id;
    }
}

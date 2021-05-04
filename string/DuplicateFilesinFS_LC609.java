import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DuplicateFilesinFS_LC609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentMap = new HashMap<>();
        // Get all the individual paths
        for (String path : paths) {
            String[] tokens = path.split(" ");
            String dir = tokens[0];
            for (int i = 1; i < tokens.length; i++) {

                String[] fileWithContent = tokens[i].split(Pattern.quote("("));
                String fileName = fileWithContent[0];
                String content = fileWithContent[1].substring(0, fileWithContent[1].length() - 1);

                contentMap.computeIfAbsent(content, k -> new ArrayList<>());
                contentMap.get(content).add(dir + "/" + fileName);
            }
        }
        return contentMap.values().stream().filter(val -> val.size() > 1).map(val -> val).collect(Collectors.toList());
    }
}

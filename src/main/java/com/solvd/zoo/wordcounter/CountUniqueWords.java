package com.solvd.zoo.wordcounter;

import com.solvd.zoo.person.Visitor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CountUniqueWords {

    private static final Logger LOGGER = LogManager.getLogger(Visitor.class);

    public static void countUniqueWord() {

        try {
            File file = new File(getResourcePath("FamousPhrases.txt"));
            String fileContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            String[] words = fileContent.split("\\s+");
            Map<String, Integer> wordCountMap = new HashMap<>();

            for (String word : words) {
                String lowerCaseWord = StringUtils.lowerCase(word);
                if (wordCountMap.containsKey(lowerCaseWord)) {
                    wordCountMap.put(lowerCaseWord, wordCountMap.get(lowerCaseWord) + 1);
                } else {
                    wordCountMap.put(lowerCaseWord, 1);
                }
            }
            int uniqueWords = wordCountMap.size();
            String newFileContent = fileContent + " " + uniqueWords;
            FileUtils.writeStringToFile(file, newFileContent, StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.error("Error occurred while processing the file", e);
        }
    }
    private static String getResourcePath(String resourceName) {
        return CountUniqueWords.class.getClassLoader().getResource(resourceName).getPath();
    }
}

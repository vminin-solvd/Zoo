package com.solvd.zoo.wordcounter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CountUniqueWords {

    public static void countUniqueWord(String fileName) throws IOException{
            File file = new File(getResourcePath(fileName));
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
        }

    private static String getResourcePath(String resourceName) {
        return CountUniqueWords.class.getClassLoader().getResource(resourceName).getPath();
    }
}

package com.ultimate.qa.web.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static boolean isFirstLetterUpperCaseExcludingPrepositions(String sentence) {
        Set<String> prepositions = new HashSet<>(Arrays.asList("in", "on", "at", "for", "to", "by", "over", "under", "with", "of", "from"));

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (i == 0 || !prepositions.contains(words[i].toLowerCase())) {
                if (!Character.isUpperCase(words[i].charAt(0))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean hasMinimumSalary(String salaries, Integer minimumSalary) {
        Pattern pattern = Pattern.compile("\\$(\\d+(?:,\\d+)?)"); // Regular expression to match salary amount
        Matcher matcher = pattern.matcher(salaries);
        if (matcher.find()) {
            String salaryValue = matcher.group(1).replace(",", ""); // Remove commas from the salary string
            int salary = Integer.parseInt(salaryValue); // Convert salary to integer
            return salary >= minimumSalary;
        }
        return false;
    }
}

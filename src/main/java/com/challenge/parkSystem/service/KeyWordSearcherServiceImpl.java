package com.challenge.parkSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyWordSearcherServiceImpl implements KeyWordSearcherService{

    private static final String REGEX = "\\w+";
    @Override
    public String findMostCommonWord(String paragraph) {
        List<String> listOfWords = extractWordsFromParagraph(paragraph);
        /*for(int i = 0; i < listOfWords.size(); i++){
            if(listOfWords.get(i).equals())
        }*/
        return null;
    }

    private List<String> extractWordsFromParagraph(String paragraph){
        Pattern reg = Pattern.compile("\\w+");
        Matcher matcher = reg.matcher(paragraph);
        List<String> listOfWords = new ArrayList<>();
        while (matcher.find()) {
            listOfWords.add(matcher.group());
        }

        return listOfWords;
    }
}

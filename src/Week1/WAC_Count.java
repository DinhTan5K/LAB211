/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1;

/**
 *
 * @author LENOVO
 */
import java.util.HashMap;
import java.util.Map;


public class WAC_Count {
    private  String content;


    
    public WAC_Count(String contentString) {
        this.content = contentString;
    }
    
    public Map<String,Integer> countWords(){
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Content is empty!");
        }
        String[] words = content.split("\\s+");
        Map<String,Integer> countWords = new HashMap<>();
        for(String word : words){
            countWords.put(word,countWords.getOrDefault(word,0)+1);
        }
        return countWords;
    }
    
    public Map<Character,Integer> countChar(){
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Content is empty!");
        }
        Map<Character,Integer> countChars = new HashMap<>();
        String normalizedContent = content.toLowerCase().replaceAll("\\s", "");
        for(char c : normalizedContent.toCharArray()) {
                countChars.put(c, countChars.getOrDefault(c, 0) + 1);
        }
        return countChars;
    }
   

}


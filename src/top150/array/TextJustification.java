package top150.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<List<String>>  rows = new ArrayList<>();
        List<String> justified = new ArrayList<>();

        int rowWidth = 0;

        List<String>  row = new ArrayList<>();
        rows.add(row);
        for(String word : words){

            if(row.isEmpty()){
                row.add(word);
                rowWidth = word.length();
            }
            else{
                if(rowWidth +1 + word.length() <= maxWidth){
                    row.add(word);
                    rowWidth += word.length()+1;
                }
                else{
                    row = new ArrayList<>();
                    row.add(word);
                    rows.add(row);
                    rowWidth = word.length();
                }
            }
        }

        if(rows.size() == 1){
            justified.add(lastRow(rows.get(0) , maxWidth));
        }
        else{
            for(int index = 0 ; index < rows.size()-1 ; index++){

                justified.add(justifyRow(rows.get(index) , maxWidth));
            }

            justified.add(lastRow(rows.get(rows.size()-1) , maxWidth));
        }
        return justified;

    }

    protected String lastRow(List<String> words , int maxWidth)
    {

        StringBuilder sb = new StringBuilder();
        sb.append(words.get(0));
        for(int index = 1 ; index < words.size() ; index++){
            sb.append(" ");
            sb.append(words.get(index));
        }
        sb.append(paddingSpace(maxWidth - sb.length()));
        return sb.toString();

    }
    protected String justifyRow(List<String> words , int maxWidth){
        int wordsWidth = words.stream().map(String::length).collect(Collectors.reducing(0 , (a , b)-> a+b));
        int spaces = maxWidth - wordsWidth;
        int averageSpaceWidth = spaces;
        int remainder = 0;
        int extraPaddingWidth = 0;
        if(words.size() > 1){
            averageSpaceWidth = (maxWidth - wordsWidth)/(words.size()-1);
            remainder = (maxWidth - wordsWidth)%(words.size()-1);
        }


        StringBuilder sb = new StringBuilder();

        sb.append(words.get(0));
        for(int index = 1 ; index < words.size() ; index++){
            sb.append(paddingSpace(averageSpaceWidth));
            if(remainder > 0){
                sb.append(paddingSpace(1));
                remainder--;

            }
            sb.append(words.get(index));
        }

        if(sb.length() < maxWidth){
            sb.append(paddingSpace(maxWidth - sb.length()));
        }
        return sb.toString();

    }

    protected String paddingSpace(int num){
        StringBuilder sb = new StringBuilder();
        for(int index = 0 ; index < num ; index++){
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String args[]){
        TextJustification textJustification = new TextJustification();

        String[] words = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
        int  maxWidth = 16 ;
        System.out.println(textJustification.fullJustify(words , maxWidth));

    }
}

// ["Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  "]
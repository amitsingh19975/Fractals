package Fractals;

import java.util.HashMap;
import java.util.Map;

public class LSystem {
    String sentence;
    HashMap<Character,String> ruleset;
    int generation;

    public LSystem(String axiom, HashMap<Character,String> r){
        sentence = axiom;
        ruleset = r;
        generation = 0;
    }

    public void generate(){
        StringBuilder nextgen = new StringBuilder();

        for (char curr:sentence.toCharArray()) {

            String replace = "" + curr;

            for(Map.Entry<Character,String> entry: ruleset.entrySet()){
                char a = entry.getKey();

                if(a == curr){
                    replace = entry.getValue();
                }
            }
            nextgen.append(replace);
        }

        sentence = nextgen.toString();
        generation++;
    }

    public String getSentence() {
        return sentence;
    }

    public int getGeneration() {
        return generation;
    }

}

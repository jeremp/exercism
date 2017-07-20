
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jeremp
 */
class DiamondPrinter {

    private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private static final String SPACE_CHAR = " ";

    public List<String> printToList(char c) {
        int index = getIndex(c);
        System.out.println("\n\n"+c + " is at position " + index + " in the alphabet");
        List<String> res = new ArrayList<>();

        for (int i = 0; i < index + 1; i++) {
            res.add(buildLine(ALPHABET[i], index-i, calculatSpaceInside(i)));
        }
        for(int i = index-1; i >= 0; i--){
            res.add(buildLine(ALPHABET[i], index-i,  calculatSpaceInside(i)));
        }

        return res;
    }
    
    private int calculatSpaceInside(int lineNuber){
        if(lineNuber==0){
            return 0 ;
        }else{
            return (lineNuber * 2)-1 ;
        }
    }

    private String buildLine(char c, int spaceBefore, int spaceInside) {
        System.out.println("buildLine("+c+", spaceBefore="+spaceBefore+", spaceInside="+spaceInside+")");
        StringBuilder sb = new StringBuilder();
        if (spaceInside == 0) {            
            for (int i = 0; i < spaceBefore; i++) {
                sb.append(SPACE_CHAR);
            }
            sb.append(c);
            for (int i = 0; i < spaceBefore; i++) {
                sb.append(SPACE_CHAR);
            }            
        } else {
            
            //if (spaceInside == 0) {
                for (int i = 0; i < spaceBefore; i++) {
                    sb.append(SPACE_CHAR);
                }
                sb.append(c);
                for (int i = 0; i < spaceInside; i++) {
                    sb.append(SPACE_CHAR);
                }
                sb.append(c);
                for (int i = 0; i < spaceBefore; i++) {
                    sb.append(SPACE_CHAR);
                }
            //}
        }
        String toString = sb.toString();
        System.out.println("["+toString+"]");
        return toString ;

    }

    private int getIndex(char c) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if (c == ALPHABET[i]) {
                return i;
            }
        }
        return -1;
    }

}

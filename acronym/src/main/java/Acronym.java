
/**
 *
 * @author jeremp
 */
class Acronym {

    private static final String SPACE_REGEX = " ";
    
    public static String generate(String phrase) {        
        if(phrase!=null && phrase.trim().length()>0){
            String[] words = phrase.split(SPACE_REGEX);
            String acronym = "";
            for(String word : words){
                acronym+= word.substring(0, 1).toUpperCase();
            }
            return acronym ;
        }else{
            return phrase;
        }
    }
    
}

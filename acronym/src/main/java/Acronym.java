
/**
 *
 * @author jeremp
 */
class Acronym {

    private static final String SPACE_REGEX = " |-";
    private static final String CAMELCASE_SPLIT_REGEX = "(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])";
    
    public static String generate(String phrase) {        
        if(phrase!=null && phrase.trim().length()>0){
            String[] words = phrase.split(SPACE_REGEX);
            String acronym = "";
            for(String word : words){                
                if(word.length()>1){
                    String[] camelparts = word.split(CAMELCASE_SPLIT_REGEX);
                    for(String part : camelparts){
                        acronym += part.substring(0, 1).toUpperCase();
                    }
                }else{
                    acronym+= word.substring(0, 1).toUpperCase();
                }                
            }
            return acronym ;
        }else{
            return phrase;
        }
    }
    
}

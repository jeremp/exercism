public class Hamming {
    
    public static int compute(String a, String b){
        int result = 0 ;
        if(a!=null && b!=null){
            a = a.trim();
            b = b.trim();
            if(a.length()==b.length()){
                // iterate over chars and compare them two by two
                for(int i=0 ; i < a.length() ; i++ ){
                    if(a.charAt(i)!=b.charAt(i)){
                        // increment the number of differences
                        result ++ ;
                    }
                }
                return result ;
            }else{
                throw new IllegalArgumentException("The strings must have the same lenght");
            }
        }else{
            throw new IllegalArgumentException("The strings can't be null");
        }
    }
    
}

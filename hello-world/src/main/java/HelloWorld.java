public class HelloWorld {
    
    public static String hello(String name){
        if(name==null || name.trim().length()<1){
            return "Hello, World!";
        }else{
            return "Hello, " + name +"!";
        }
    }
    
}

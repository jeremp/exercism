class Twofer {

    private static final String TEMPLATE = "One for %s, one for me.";
    private static final String DEFAULT_NAME = "you";

    String twofer(String name) {
        String realName = name;
        if(realName==null || realName.trim().length()==0){
            realName = DEFAULT_NAME;
        }
        return String.format(TEMPLATE, realName);
    }
}

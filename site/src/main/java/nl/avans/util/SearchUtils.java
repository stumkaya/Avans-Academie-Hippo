package nl.avans.util;


public class SearchUtils {

    private final static int LENGTH = 180;

    public static String highlight(final String content, final String searchText){

        int start;
        int end;

        if(content.toLowerCase().indexOf(searchText.toString().toLowerCase())>(LENGTH/2)){
            start = content.toLowerCase().indexOf(searchText.toString().toLowerCase())-(LENGTH/2);
        } else {
            start = 0;
        }

        if(content.length() - content.toLowerCase().indexOf(searchText.toString().toLowerCase())>(LENGTH/2)){
            end = content.toLowerCase().indexOf(searchText.toString().toLowerCase())+(LENGTH/2);
        } else {
            end = LENGTH;
        }
        String left = content.substring(start, content.toLowerCase().indexOf(searchText.toString().toLowerCase()));
        String right = content.substring(content.toLowerCase().indexOf(searchText.toString().toLowerCase())+searchText.toString().length(), end);
        return left + "<span class=\"highlight\">" +
                content.substring(content.toLowerCase().indexOf(searchText.toString().toLowerCase()), content.toLowerCase().indexOf(searchText.toString().toLowerCase())+searchText.toString().length()) +
                "</span>" + right;


    }


    public static String getContent(final String content){
        return content.substring(0, Math.min(LENGTH,content.length()));

    }

}

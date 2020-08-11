package com.xd.utils;

public class FilterUtil {


    /**
     *  prevent XSS
     *  filter character below
     *  <h2 color="red"></h2> , <script>alert("XD")</script>
     *
     * @param message
     * @return
     */
    public static String filter(String message){
        if(message == null){
            return null;
        }

        char[] content = new char[message.length()];
        message.getChars(0,message.length(),content,0);
        StringBuilder result = new StringBuilder(content.length + 50);
        for (char c : content) {
            switch (c) {
                case '<':
                    result.append("&lt;");
                    break;
                case '>':
                    result.append("&gt;");
                    break;
                case '&':
                    result.append("&amp;");
                    break;
                case '"':
                    result.append("&quot;");
                    break;
                default:
                    result.append(c);
            }
        }

        return (result.toString());
    }
}

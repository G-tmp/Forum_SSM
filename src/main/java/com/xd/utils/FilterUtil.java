package com.xd.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        StringBuilder stringBuilder = new StringBuilder(content.length + 50);
        for (char c : content) {
            switch (c) {
                case '<':
                    stringBuilder.append("&lt;");
                    break;
                case '>':
                    stringBuilder.append("&gt;");
                    break;
//                case '&':
//                    result.append("&amp;");
//                    break;
                case '"':
                    stringBuilder.append("&quot;");
                    break;
                default:
                    stringBuilder.append(c);
            }
        }

//        return stringBuilder.toString();
        return url2Link(stringBuilder.toString());
    }


    /**
     *  match url within string
     *
     * @param text
     * @return
     */
    public static String url2Link( String text) {
        String regex = "(https?|ftp)://(www\\d?|[a-zA-Z0-9]+)?.[a-zA-Z0-9-]+(\\:|.)([a-zA-Z0-9.]+|(\\d+)?)([/?:].*)?";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        StringBuffer sb = new StringBuffer();

        while(m.find()){
            String found =m.group(0);
            m.appendReplacement(sb, "<a href='"+found+"'>"+found+"</a>");
        }
        m.appendTail(sb);

        return sb.toString();
    }



}

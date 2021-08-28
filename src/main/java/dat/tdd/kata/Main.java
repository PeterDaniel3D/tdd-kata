package dat.tdd.kata;

import static java.lang.Character.isUpperCase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
    }

    // Requirement 1
    public static String greet(String name) {
        return "Hello, " + name;
    }
    
    // Requirement 2
    public static String greetNull(String name) {
        if (name == null) {
            return "Hello, my friend.";
        }
        
        return "Hello, " + name;
    }

    // Requirement 3
    public static String shout(String name) {
        char[] ch = new char[name.length()];
        
        for (int i = 0; i < name.length(); i++) {
            ch[i] = name.charAt(i);
        }
        
        for (int i = 0; i < ch.length ; i++) {
            if (!isUpperCase(ch[i])) {
                return name;
            }
        }
        
        return "HELLO " + name + "!";
    }

    // Requirement 4
    static String twoNames(String[] names) {
        if (names.length == 2) {
            return "Hello, " + names[0] + " and " + names[1] + ".";
        }
        
        return Arrays.toString(names);
    }
    
    // Requirement 5
    static String arbitraryNumber(List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello,");
        
        switch(names.size()) {
        case 0:
            return null;
        case 1:
            stringBuilder.append(" " + names.get(0) + ".");
            return stringBuilder.toString();
        default:
            for (int i = 0; i < names.size()-1; i++) {
                stringBuilder.append(" " + names.get(i) + ",");
            }
            stringBuilder.append(" and ");
            stringBuilder.append(names.get(names.size()-1) + ".");
            return stringBuilder.toString();
        }
    }
    
    // Requirement 6
    static String mixNormalAndShout(String[] names) {
        
        List<String> strNormal = new ArrayList<>();
        List<String> strShout = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        Boolean upperCaseOnly = false;
        
        // Sort between normal and shouted names
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            
            char[] ch = new char[name.length()];
        
            for (int j = 0; j < name.length(); j++) {
                ch[j] = name.charAt(j);
            }
            
            for (int j = 0; j < ch.length ; j++) {
                if (!isUpperCase(ch[j])) {
                    upperCaseOnly = false;
                    break;
                } else {
                    upperCaseOnly = true;
                }
            }
            
            if (upperCaseOnly) {
                strShout.add(name);
            } else {
                strNormal.add(name);
            }
        }
        
        output.append(arbitraryNumber(strNormal));
        
        if (strShout.size() > 0) {
            
            output.append(" AND HELLO ");
            
            for (int i = 0; i < strShout.size(); i++) {
                if (i < strShout.size()-1) {
                    output.append(strShout.get(i) + ", ");
                } else {
                    output.append(strShout.get(i));
                    output.append("!");
                }
            }
        }
        
        return output.toString();
    }
    
    // Requirement 7
    static String splitComma(String[] names) {
        List<String> list = new ArrayList<>();
        
        // Add names to list
        for (int i = 0; i < names.length; i++) {
            if (names[i].contains(",")) {
                for(String name : names[i].split(",")){
                    list.add(name.trim());
                }
            } else {
                list.add(names[i]);
            }
        }
        
        StringBuilder output = new StringBuilder();
        output.append(arbitraryNumber(list));
        
        return output.toString();
    }
    
    // Requirement 8 (1st version; Build to string in chronologic order)
    /*static String escapeCommas(String[] names) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"" + "*" + "\"");
        Boolean isFound = false;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello, ");
        
        // Pattern sorting
        for (int i = 0; i < names.length; i++) {
            if (pattern.matcher(names[i]).find()) {
                if (names[i].contains(",")) {
                    for(String name : names[i].split(",")){
                        name = name.replace("\"", "");
                        list.add(name.trim());
                        isFound = true;
                    }
                } else {
                    list.add(names[i]);
                }
            } else {
                stringBuilder.append(names[i]);
            }
        }
       
        if (isFound) {
            stringBuilder.append(" and ");
            for (int i = 0; i < list.size(); i++) {
                if (i < list.size()-1) {
                    stringBuilder.append(list.get(i) + ", ");
                } else {
                    stringBuilder.append(list.get(i));
                }
            }
        }
        
        stringBuilder.append(".");
        
        return stringBuilder.toString();
    }*/
    
    // Requirement 8 (2st version; Sort types in order. Normal 1st, Commas 2nd)
    static String escapeCommas(String[] names) {
        List<String> strNormal = new ArrayList<>();
        List<String> strSpecial = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"" + "*" + "\"");
        Boolean isFound = false;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello, ");
        
        // Pattern sorting
        for (int i = 0; i < names.length; i++) {
            if (pattern.matcher(names[i]).find()) {
                if (names[i].contains(",")) {
                    for(String name : names[i].split(",")){
                        name = name.replace("\"", "");
                        strSpecial.add(name.trim());
                        isFound = true;
                    }
                } else {
                    strSpecial.add(names[i]);
                }
            } else {
                strNormal.add(names[i]);
            }
        }
        
        // Add normal names
        for (int i = 0; i < strNormal.size(); i++) {
            if (i < strNormal.size()-1) {
                stringBuilder.append(strNormal.get(i) + ", ");
            } else {
                stringBuilder.append(strNormal.get(i));
            }
        }
        
        // Add names with intentional commas
        if (isFound) {
            stringBuilder.append(" and ");
            for (int i = 0; i < strSpecial.size(); i++) {
                if (i < strSpecial.size()-1) {
                    stringBuilder.append(strSpecial.get(i) + ", ");
                } else {
                    stringBuilder.append(strSpecial.get(i));
                }
            }
        }
        
        stringBuilder.append(".");
        
        return stringBuilder.toString();
    }
}

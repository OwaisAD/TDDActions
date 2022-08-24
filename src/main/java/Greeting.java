import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Greeting {
    public String greet(Object o) {
        if(o == null) return "Hello, my friend.";

        if(o instanceof String) {
            /* The method beneath is much easier to use than what I did under
            if(name.equals(name.toUpperCase)) {...} - så ved vi den er uppercase*/

            //iterate and check if name is fully uppercase
            int lengthOfName = ((String) o).length();
            boolean isUpperCase = true;
            for(int i = 0; i < lengthOfName; i++) {
                if(!Character.isUpperCase(((String) o).charAt(i))) {
                    isUpperCase = false;
                    break;
                }
            }
            if(isUpperCase) {
                return "HELLO " + o + "!";
            } else {
                return "Hello, " + o + ".";
            }
        }

        /*
        * IF AN ARRAY IS PASSED AS A PARAMETER TO OUR GREET FUNCTION
        * */
        if(o instanceof String[]) {
            String[] myNames = (String[]) o;
            ArrayList<String> myNamesList = new ArrayList<>();

            for(String name : myNames) {
                if(name.contains("\"")) {
                    name.replace("\"", "");
                    myNamesList.add(name);
                    continue;
                }
                String[] newArr = name.trim().split("\\s*,\\s*");
                for(String names : newArr) {
                    myNamesList.add(names);
                }
            }
            myNames = myNamesList.toArray(new String[0]);


            if(Array.getLength(myNames) == 0) return "Hello, anonymous!";

            if(Array.getLength(myNames) == 1) {
                String name = (String) Array.get(o, 0);
                return greet(name);
            }

            if(Array.getLength(myNames) == 2) {
                String name1 = (String) Array.get(o,0);
                String name2 = (String) Array.get(o,1);
                if(!name1.equals(name1.toUpperCase()) && !name2.equals(name2.toUpperCase())) {
                    return "Hello, " + Array.get(o, 0) + " and " + Array.get(o, 1) + ".";
                }
            }

            if(Array.getLength(myNames) >= 2) {
                ArrayList<String> lowerCase = new ArrayList<>();
                ArrayList<String> upperCase = new ArrayList<>();
                //iterate and create two arrays - lowercase and uppercase names
                for(int i = 0; i < myNames.length; i++) {
                    if(myNames[i].equals(myNames[i].toUpperCase())) {
                        upperCase.add(myNames[i]);
                    } else {
                        lowerCase.add(myNames[i]);
                    }
                }

                String response = "Hello, ";

                // if there's one lowercase and one uppercase
                if(lowerCase.size() == 1 && upperCase.size() == 1){
                    return "Hello, " + lowerCase.get(0) + ". AND HELLO " + upperCase.get(0) + ".";
                }

                // if there's more than one lowercase and still one uppercase thereafter vice versa
                if(lowerCase.size() > 1 && upperCase.size() == 1){
                    for(int i = 0; i < lowerCase.size(); i++) {
                        if(i == lowerCase.size() - 1) {
                            response += "and " + lowerCase.get(i) + ".";
                            break;
                        }
                        response += lowerCase.get(i) + ", ";
                    }
                    response += " AND HELLO " + upperCase.get(0) + ".";
                    return response;
                }

                if(upperCase.size() > 1 && lowerCase.size() == 1){
                    response += lowerCase.get(0) + ". AND HELLO ";
                    for(int i = 0; i < upperCase.size(); i++) {
                        if(i == upperCase.size() - 1) {
                            response += upperCase.get(i) + ".";
                            break;
                        }
                        response += upperCase.get(i) + " AND ";
                    }
                    return response;
                }

                if(lowerCase.size() > 1 && upperCase.size() > 1) {
                    for(int i = 0; i < lowerCase.size(); i++) {
                        if(i == lowerCase.size() - 1) {
                            response += "and " + lowerCase.get(i) + ". AND HELLO ";
                            break;
                        }
                        response += lowerCase.get(i) + " ";
                    }

                    for(int i = 0; i < upperCase.size(); i++) {
                        if(i == upperCase.size() - 1) {
                            response += upperCase.get(i) + ".";
                            break;
                        }
                        response += upperCase.get(i) + " AND ";
                    }
                    return response;
                }

                for(int i = 0; i < myNames.length; i++) {
                    if(i == myNames.length - 1) {
                        response += "and " + myNames[i] + ".";
                        break;
                    }
                    response += myNames[i] + ", ";
                }
                return response;
            }
        }
        return null;
    }
}

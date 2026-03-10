import java.util.*;

public class UsernameAvailabilityChecker {

    static HashMap<String,Integer> users = new HashMap<>();
    static HashMap<String,Integer> attempts = new HashMap<>();

    public static boolean checkAvailability(String username){

        attempts.put(username, attempts.getOrDefault(username,0)+1);

        return !users.containsKey(username);
    }

    public static List<String> suggestAlternatives(String username){

        List<String> suggestions = new ArrayList<>();

        suggestions.add(username+"1");
        suggestions.add(username+"2");
        suggestions.add(username+"_official");

        return suggestions;
    }

    public static void main(String[] args) {

        users.put("john_doe",101);

        String username = "john_doe";

        if(checkAvailability(username))
            System.out.println("Username available");
        else{
            System.out.println("Username taken");
            System.out.println("Suggestions: "+suggestAlternatives(username));
        }
    }
}
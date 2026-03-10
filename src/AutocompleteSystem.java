import java.util.*;

public class AutocompleteSystem {

    static HashMap<String,Integer> searchFrequency = new HashMap<>();

    public static List<String> autocomplete(String prefix){

        List<String> result = new ArrayList<>();

        for(String query:searchFrequency.keySet()){

            if(query.startsWith(prefix))
                result.add(query);
        }

        return result;
    }

    public static void main(String[] args) {

        searchFrequency.put("java tutorial",100);
        searchFrequency.put("javascript guide",80);
        searchFrequency.put("java hashmap",60);

        System.out.println(autocomplete("jav"));
    }
}
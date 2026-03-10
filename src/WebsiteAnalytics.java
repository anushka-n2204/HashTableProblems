import java.util.*;

public class WebsiteAnalytics {

    static HashMap<String,Integer> pageViews = new HashMap<>();
    static HashMap<String,Set<String>> uniqueVisitors = new HashMap<>();

    public static void processEvent(String url,String userId){

        pageViews.put(url,pageViews.getOrDefault(url,0)+1);

        uniqueVisitors.putIfAbsent(url,new HashSet<>());
        uniqueVisitors.get(url).add(userId);
    }

    public static void main(String[] args) {

        processEvent("/news","user1");
        processEvent("/news","user2");
        processEvent("/sports","user1");

        System.out.println("Page views: "+pageViews);
        System.out.println("Unique visitors: "+uniqueVisitors);
    }
}
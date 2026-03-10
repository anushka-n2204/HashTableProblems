import java.util.*;

public class MultiLevelCache {

    static LinkedHashMap<String,String> L1Cache =
            new LinkedHashMap<>(10,0.75f,true);

    static HashMap<String,String> L2Cache = new HashMap<>();

    public static String getVideo(String videoId){

        if(L1Cache.containsKey(videoId))
            return "L1 Cache HIT";

        if(L2Cache.containsKey(videoId)){

            L1Cache.put(videoId,L2Cache.get(videoId));

            return "L2 Cache HIT → promoted to L1";
        }

        String data="VideoData";

        L2Cache.put(videoId,data);

        return "Database HIT";
    }

    public static void main(String[] args) {

        System.out.println(getVideo("video1"));
        System.out.println(getVideo("video1"));
    }
}
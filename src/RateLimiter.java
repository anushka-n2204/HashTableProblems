import java.util.*;

public class RateLimiter {

    static class TokenBucket{

        int tokens;

        TokenBucket(){
            tokens = 5;
        }
    }

    static HashMap<String,TokenBucket> clients = new HashMap<>();

    public static boolean checkRateLimit(String clientId){

        clients.putIfAbsent(clientId,new TokenBucket());

        TokenBucket bucket = clients.get(clientId);

        if(bucket.tokens>0){

            bucket.tokens--;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        String client="abc123";

        for(int i=1;i<=7;i++){

            if(checkRateLimit(client))
                System.out.println("Request "+i+" allowed");
            else
                System.out.println("Rate limit exceeded");
        }
    }
}
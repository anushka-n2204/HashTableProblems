import java.util.*;

public class DNSCacheSystem {

    static class DNSEntry{

        String ip;
        long expiry;

        DNSEntry(String ip,long ttl){

            this.ip = ip;
            this.expiry = System.currentTimeMillis()+ttl;
        }
    }

    static HashMap<String,DNSEntry> dnsCache = new HashMap<>();

    public static String resolve(String domain){

        DNSEntry entry = dnsCache.get(domain);

        if(entry!=null && entry.expiry>System.currentTimeMillis())
            return "Cache HIT: "+entry.ip;

        String ip="172.217."+new Random().nextInt(255);

        dnsCache.put(domain,new DNSEntry(ip,5000));

        return "Cache MISS → "+ip;
    }

    public static void main(String[] args) {

        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));
    }
}
import java.util.*;

public class FlashSaleInventoryManager {

    static HashMap<String,Integer> inventory = new HashMap<>();
    static Queue<Integer> waitingList = new LinkedList<>();

    public static String purchaseItem(String productId,int userId){

        int stock = inventory.getOrDefault(productId,0);

        if(stock>0){

            inventory.put(productId,stock-1);

            return "Purchase success. Remaining: "+(stock-1);
        }

        waitingList.add(userId);

        return "Added to waiting list position "+waitingList.size();
    }

    public static void main(String[] args) {

        inventory.put("IPHONE15",2);

        System.out.println(purchaseItem("IPHONE15",101));
        System.out.println(purchaseItem("IPHONE15",102));
        System.out.println(purchaseItem("IPHONE15",103));
    }
}
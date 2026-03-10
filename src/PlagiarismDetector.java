import java.util.*;

public class PlagiarismDetector {

    static HashMap<String, Set<String>> ngramIndex = new HashMap<>();

    public static void addDocument(String docId,String text){

        String[] words = text.split(" ");

        for(int i=0;i<words.length-4;i++){

            String gram = words[i]+" "+words[i+1]+" "+words[i+2]+" "+words[i+3]+" "+words[i+4];

            ngramIndex.putIfAbsent(gram,new HashSet<>());
            ngramIndex.get(gram).add(docId);
        }
    }

    public static void main(String[] args) {

        addDocument("doc1","this is a sample plagiarism detection system example");
        addDocument("doc2","this is a sample plagiarism detection project");

        System.out.println("Indexed n-grams: "+ngramIndex.size());
    }
}
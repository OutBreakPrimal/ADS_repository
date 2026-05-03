import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<Testing_class, Student> table = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            String randomId = "ID" + i;
            int randomSalt = random.nextInt(100000);

            Testing_class key = new Testing_class(randomId, randomSalt);
            Student value = new Student("Student " + i);

            table.put(key, value);
        }

        printBucketDistribution(table);
    }

    public static void printBucketDistribution(MyHashTable<?, ?> table) {
        int[] bucketSizes = table.getBucketsSizes(1);
        System.out.println("Bucket Index | Chain Size");
        System.out.println("--------------------------");
        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i]);
        }
    }
}
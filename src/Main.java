import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {

        String folderPath = "D:\\Марина";
        long sizeLimit = SizeCalculator.getSizeFromHumanReadable("50Mb");
        File file = new File(folderPath);
        Node root = new Node(file, sizeLimit);

        long start = System.currentTimeMillis();
        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);
        System.out.println(root);

        System.out.println(System.currentTimeMillis() - start + " милисек");
        }
}
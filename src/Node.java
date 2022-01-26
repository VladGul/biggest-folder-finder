import java.io.File;
import java.util.ArrayList;

public class Node {

    private File folder;

    private long size;
    private ArrayList<Node> children;

    public Node (File folder) {
        this.folder = folder;
        children = new ArrayList();
    }

    public File getFolder () {
        return folder;
    }

    public void addChild (Node node) {
        children.add(node);
    }

    public ArrayList<Node> getChildren () {
        return children;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}

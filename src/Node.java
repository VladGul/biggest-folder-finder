import java.io.File;
import java.util.ArrayList;

public class Node {

    private File folder;
    private long size;
    private long limit;
    private ArrayList<Node> children;
    private int level;

    public Node (File folder, long sizeLimit) {
        this.folder = folder;
        this.limit = sizeLimit;
        children = new ArrayList();
    }

    public File getFolder () {
        return folder;
    }

    public void addChild (Node node) {
        children.add(node);
        node.setLevel(level + 1);
    }

    private void setLevel (int level) {
        this.level = level;
    }

    public ArrayList<Node> getChildren () {
        return children;
    }

    public long getSize() {
        return size;
    }

    public long getLimit() {
        return limit;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        String size = SizeCalculator.getHumanReadableSize(getSize());
        long sizeInLong = SizeCalculator.getSizeFromHumanReadable(size);
        builder.append(folder.getName() + " - " + size + "\n");
        for (Node child : children) {
            if (child.getSize() > limit) {
                builder.append("  ".repeat(level + 1) + child.toString());
            }
        }
        return builder.toString();
    }
}

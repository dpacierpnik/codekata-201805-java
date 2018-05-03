import java.util.Deque;
import java.util.LinkedList;

/**
 * Write a function that provides change directory (cd) function for an abstract file system.
 * <p>
 * Notes:
 * <p>
 * Root path is '/'.
 * Path separator is '/'.
 * Parent directory is addressable as "..".
 * Directory names consist only of English alphabet letters (A-Z and a-z).
 * The function should support both relative and absolute paths.
 * The function will not be passed any invalid paths.
 * Do not use built-in path-related functions.
 * <p>
 * For example:
 * <p>
 * <code>
 * Path path = new Path("/a/b/c/d");
 * path.cd('../x');
 * System.out.println(path.getPath());
 * </code>
 * <p>
 * should display '/a/b/c/x'.
 */
public class Path {
    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void cd(String newPath) {

        if(newPath.isEmpty()) {
            return;
        }

        String currentPath = newPath.startsWith("/") ? "/" : this.path;

        Deque<String> currentPathItems = asDeque(currentPath);
        Deque<String> newPathItems = asDeque(newPath);

        for(String newPathItem : newPathItems) {
            if(newPathItem.equals("") || newPathItem.equals(".")) {
                // do nothing
            }
            else if (newPathItem.equals("..")) {
                if(currentPathItems.size() > 0) {
                    currentPathItems.removeLast();
                }
            }
            else {
                currentPathItems.add(newPathItem);
            }
        }

        this.path = "/" + String.join("/", currentPathItems);
    }

    private Deque<String> asDeque(String path) {
        Deque<String> dirs = new LinkedList<>();
        String[] dirsArr = path.split("/");
        for (String dir : dirsArr) {
            if (!dir.isEmpty()) {
                dirs.addLast(dir);
            }
        }
        return dirs;
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        path.cd("../x");
        System.out.println(path.getPath());
    }
}

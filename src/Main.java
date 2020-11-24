import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите путь:");
        String path = in.nextLine();
        System.out.println("Нормализованный путь: " + toPath(normalizedPath(path)));
    }

    public static Deque<String> normalizedPath(String path) {
        String[] pathSplited = path.split("/");
        Deque<String> pathDeque = new ArrayDeque<>();
        for (int i = 0; i < pathSplited.length; i++) {
            switch (pathSplited[i]) {
                case "..":
                    if (pathDeque.peekFirst() != null && !pathDeque.peekFirst().equals("..")) {
                        pathDeque.removeFirst();
                    } else {
                        pathDeque.addFirst("..");
                    }
                    break;
                case ".":
                    break;
                default:
                    pathDeque.addFirst(pathSplited[i]);
                    break;
            }
        }
        return pathDeque;
    }

    public static String toPath(Deque<String> pathDeque) {
        StringBuffer path = new StringBuffer();
        while (pathDeque.peekLast() != null) {
            String s = (String) pathDeque.removeLast();
            if (pathDeque.peekLast() != null) {
                path.append(s);
                path.append("/");
            } else {
                path.append(s);
            }
        }
        return path.toString();
    }
}
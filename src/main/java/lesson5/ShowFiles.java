package lesson5;

import java.io.File;

public class ShowFiles {
    public static void main(String[] args) {
        File file = new File("X:\\Ya.Disk\\work\\Lessons\\ads-java_140122");
        viewFiles(file);
    }

    private static void viewFiles(File file, int level) {
        StringBuilder prefix = new StringBuilder().append("\t".repeat(level));
        if (file.isFile()) {
            System.out.println(prefix + "File: " + file.getName());
        } else {
            System.out.println(prefix + "Dir: " + file.getName());
            level++;
            for (File listFile : file.listFiles()) {
                viewFiles(listFile, level);
            }
        }
    }

    private static void viewFiles(File file) {
        viewFiles(file, 0);
    }

}

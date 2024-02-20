package file;

import java.util.ArrayList;
import java.util.List;


record File(String name, int size) {

}

class Folder {
    private final String name;
    private final List<File> files;
    private final List<Folder> folders;

    public Folder(String name) {
        this.name = name;
        this.files = new ArrayList<>();
        this.folders = new ArrayList<>();
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void addFolder(Folder folder) {
        folders.add(folder);
    }

    public String getName() {
        return name;
    }

    public List<File> getFiles() {
        return files;
    }

    public List<Folder> getFolders() {
        return folders;
    }
}

class FileSystem {
    private Folder root;

    public FileSystem() {
        this.root = new Folder("root");
    }

    public Folder getRoot() {
        return root;
    }
}

public class Main {
    public static void main(String[] args) {

        FileSystem fileSystem = new FileSystem();

        Folder documents = new Folder("Documents");
        Folder music = new Folder("Music");

        File file1 = new File("document1.txt", 1024);
        File file2 = new File("document2.txt", 2048);
        File file3 = new File("song1.mp3", 5120);
        File file4 = new File("song2.mp3", 4096);

        documents.addFile(file1);
        documents.addFile(file2);

        music.addFile(file3);
        music.addFile(file4);

        fileSystem.getRoot().addFolder(documents);
        fileSystem.getRoot().addFolder(music);

        printFileSystem(fileSystem.getRoot(), 0);

    }

    public static void printFileSystem(Folder folder, int intdent) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < intdent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append(folder.getName());
        System.out.println(stringBuilder.toString());
        for (Folder f :
                folder.getFolders()) {
            printFileSystem(f, intdent + 1);
        }
        for (File f :
                folder.getFiles()) {
            System.out.println(stringBuilder.toString() + "/" + f.name() + "(" + f.size() + " bytes)");
        }
    }
}

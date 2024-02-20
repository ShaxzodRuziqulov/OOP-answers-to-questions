package file.gpt;
import java.util.ArrayList;
import java.util.List;

// File sinfi
class File {
    private String name;
    private int size; // Fayl o'lchami (bayt)

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}

// Folder sinfi
class Folder {
    private String name;
    private List<File> files;
    private List<Folder> folders;

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

    public List<File> getFiles() {
        return files;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public String getName() {
        return name;
    }
}

// FileSystem sinfi
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
        // Fayl tizimini yaratish
        FileSystem fileSystem = new FileSystem();

        // Papkalar yaratish
        Folder documents = new Folder("Documents");
        Folder music = new Folder("Music");

        // Fayllar yaratish
        File file1 = new File("document1.txt", 1024);
        File file2 = new File("document2.txt", 2048);
        File file3 = new File("song1.mp3", 5120);
        File file4 = new File("song2.mp3", 4096);

        // Fayllarni papkaga joylash
        documents.addFile(file1);
        documents.addFile(file2);

        music.addFile(file3);
        music.addFile(file4);

        // Papkalarni asosiy papkaga joylash
        fileSystem.getRoot().addFolder(documents);
        fileSystem.getRoot().addFolder(music);

        // Fayl tizimini chiqarish
        printFileSystem(fileSystem.getRoot(), 0);
    }

    // Fayl tizimini qaytarish
    public static void printFileSystem(Folder folder, int indent) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  "); // 2 bo'sh joy qo'shish
        }
        stringBuilder.append(folder.getName());
        System.out.println(stringBuilder.toString());
        for (Folder subFolder : folder.getFolders()) {
            printFileSystem(subFolder, indent + 1);
        }
        for (File file : folder.getFiles()) {
            System.out.println(stringBuilder.toString() + "/" + file.getName() + " (" + file.getSize() + " bytes)");
        }
    }
}


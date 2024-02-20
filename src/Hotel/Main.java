package Hotel;

import java.util.ArrayList;
import java.util.List;

class Mehmonxona {
    private String nomi;
    private int xonalarSoni;
    private List<String> bronQilinganXonalar;

    public Mehmonxona(String nomi, int xonalarSoni) {
        this.nomi = nomi;
        this.xonalarSoni = xonalarSoni;
        this.bronQilinganXonalar = new ArrayList<>();
    }

    public void xonaniBronQilish(int xonaSoni) {
        if (xonaSoni <= this.xonalarSoni - bronQilinganXonalar.size()) {
            for (int i = 0; i < xonaSoni; i++) {
                bronQilinganXonalar.add(this.nomi + " - " + (bronQilinganXonalar.size() + 1));
            }
            System.out.println(xonaSoni + " xona " + this.nomi + " mehmonxonasida bron qilindi.");
        } else {
            System.out.println("Xatolik: Yetarli bo'sh xona mavjud emas.");
        }
    }
}

class Mehmon {
    private String ismi;
    private int xonaSoni;

    public Mehmon(String ismi, int xonaSoni) {
        this.ismi = ismi;
        this.xonaSoni = xonaSoni;
    }

    public void bronQilish(Mehmonxona mehmonxona) {

        mehmonxona.xonaniBronQilish(this.xonaSoni);
    }
}

public class Main {
    public static void main(String[] args) {
        Mehmonxona mehmonxona = new Mehmonxona("Mehmonxona 1", 10);
        Mehmon mehmon1 = new Mehmon("Mehmon 1", 3);
        Mehmon mehmon2 = new Mehmon("Mehmon 2", 8);

        mehmon1.bronQilish(mehmonxona);
        mehmon2.bronQilish(mehmonxona);
    }
}

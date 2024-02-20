package Hotel.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Hotel{
    private String nomi;
    private int honaSoni;
    private List<String> bronQilingan;

    public Hotel(String nomi, int honaSoni) {
        this.nomi = nomi;
        this.honaSoni = honaSoni;
        this.bronQilingan = new ArrayList<>(); // To'g'ri qiymatni belgilash
    }

    public void xonabronQilish(int xSoni){
        if (xSoni<honaSoni-bronQilingan.size()){
            for (int i = 0; i < xSoni; i++) {
                bronQilingan.add(nomi+(bronQilingan.size()+1));
            }
            System.out.println(xSoni+" xona soni "+nomi+" mehmonhona bron qilindi ");
        }else {
            System.out.println("xatolik");
        }
    }
}
class Mehmon{
    private String name;
    private int xSoni;

    public Mehmon(String name, int xSoni) {
        this.name = name;
        this.xSoni = xSoni;
    }
    public void bronqilish(Hotel hotel){
        System.out.println(name+ " ismli mijoz ");
        hotel.xonabronQilish(xSoni);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("mehmon hona nomi");
        String name1 = scanner.next();
        System.out.println();
        System.out.println("nechta bo'sh hona bor");
        int num1 = scanner.nextInt();
        Hotel hotel = new Hotel(name1,num1);

        System.out.println("ism kiriting");
        String name = scanner.next();
        System.out.println("nechta hona olmoqchisiz");
        int num = scanner.nextInt();

        Mehmon mehmon = new Mehmon(name,num);
        mehmon.bronqilish(hotel);

    }
}

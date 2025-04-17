public class Main {

    public static void main(String[] args) {
        
        //proses inisialisasi objek dari kelas Manusia, MahasiswaFILKOM, Pekerja, dan Manager
        Manusia a = new Manusia("A", "111", true, true);        //memanggil konstrukor dari kelas Manusia
        System.out.println(a);

        MahasiswaFILKOM b = new MahasiswaFILKOM("165150300111100", 4.0, "B", "111", false, false);      //memanggil konstrukor dari kelas MahasiswaFilkom

        Pekerja c = new Pekerja(1000, 2016, 3, 2, 4, "C", "111", true, true);           //memanggil konstruktor dari kelas Pekerja
        System.out.println(c);     
        
        Manager d = new Manager("HRD", 1000, 2017, 1, 2, 3, "D", "111", true, true);        //memanggil konstruktor dari kelas Manager
        System.out.println(d);      
}
}
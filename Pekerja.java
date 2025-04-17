import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//kelas Pekerja merupakan subclass dari kelas Manusia dan sebagai superclass dari kelas Manager
public class Pekerja extends Manusia {

    //deklarasi atribut kelas
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    //konstruktor dengan parameter tambahan untuk atribut pekerja
    public Pekerja(double gaji, int tahun, int bulan, int tanggal, int jumlahAnak, String nama, String nik, boolean jenisKelamin, boolean menikah) {
        super(nama, nik, jenisKelamin, menikah);        //memanggil konstruktor dari kelas induk Manusia
        this.gaji = gaji;
        this.tahunMasuk = LocalDate.of(tahun, bulan, tanggal);     //membuat objek dari parameter tahun, bulan, tanggal
        this.jumlahAnak = jumlahAnak;
    }

    //method getter untuk gaji
    public double getGaji() {
        return gaji;
    }

    //method untuk menghitung bonus pekerja
    public double getBonus() {

        //Menghitung lama kerja antar tahun masuk dan tanggal sekarang
        long lamaKerja = ChronoUnit.YEARS.between(tahunMasuk, LocalDate.now());
  
        if (lamaKerja <= 5) {           //jika lama kerja <= 5 tahun maka bonus 5% dari gaji 
            return gaji * 0.05;     
        } else if (lamaKerja <= 10) {           //jika lama kerja <= 10 tahun maka bonus 10% dari gaji 
            return gaji * 0.10;
        } else {                        //jika lama kerja lebih dari 10 tahun maka bonus 15% dari gaji
            return gaji * 0.15;
        }
    }

    //method untuk menghitung tunjangan anak berdasarkan jumlah anak
    public double getTunjanganAnak() {
        return jumlahAnak >= 1 ? jumlahAnak * 20 : 0; //jika tidak mempunyai anak maka tunjangan 0, jika mempunyai anak $20 per anak

    }

    //override method getPendapatan dari kelas induk 
    @Override
    public double getPendapatan() {     //total pendapatan = gaji + bonus + tunjangan anak
        //menggunakan super untuk memanggil method getPendapatan() dari kelas induk Manusia
        return super.getPendapatan() + gaji + getBonus() + getTunjanganAnak();
    }

    //override method toString untuk menambahkan info pekerja 
    @Override
    public String toString() {
        return super.toString() +   //memanggil toString() dari kelas induk
               String.format("Tahun Masuk\t: %d %d %d\nJumlah Anak\t: %d\nGaji\t\t: %.1f\nBonus\t\t: %.1f\nTotal Gaji\t: %.1f\n",
               tahunMasuk.getDayOfMonth(), tahunMasuk.getMonthValue(), tahunMasuk.getYear(),
               jumlahAnak, gaji, getBonus(), gaji + getBonus());
    }
}
public class MahasiswaFILKOM extends Manusia {

    //deklarasi atribut kelas
    private String nim;
    private double ipk;

    //konstruktor dengan parameter tamnbahan untuk atribut mahasiswa filkom 
    public MahasiswaFILKOM(String nim, double ipk, String nama, String nik, boolean jenisKelamin, boolean menikah) {
        super(nama, nik, jenisKelamin, menikah); //memanggil konstruktor dari kelas induk Manusia
        this.nim = nim;
        this.ipk = ipk;
    }

    //method untuk menentuka status prodi dan angkatan berdasarkan NIM 
    public String getStatus(){
        String angkatan = "20" + nim.substring(0, 2);   //mengambil 2 digit pertama dari NIM untuk tahun angkatan mahasiswa
        char kodeProdi = nim.charAt(6);     //mengambil digit ke 7 dari NIM untuk kode prodi mahasiswa 

        //menggunakan switch case untuk menentukan prodi berdasarkan kode prodi
        String prodi = "";     
        switch (kodeProdi) {
            case '2': prodi = "Teknik Informatika"; break;
            case '3': prodi = "Teknik Komputer"; break;
            case '4': prodi = "Sistem Informasi"; break;
            case '6': prodi = "Pendidikan Teknologi Informasi"; break;
            case '7': prodi = "Teknologi Informasi"; break;
            default: prodi = "Tidak diketahui";     //jika kode tidak sesuai dengan kode prodi yang ada
        }
        
        return prodi + ", " + angkatan;     //format untuk return status prodi dan angkatan  
    }

    //method untuk menghitung beasiswa berdasarkan IPK mahasiswa
    public double getBeasiswa(){
        if (ipk >= 3.0 && ipk < 3.5) {      //jika ipk mahasiswa antara 3.0 - 3.5 maka akan mendapatkan beasiswa $50
            return 50;
        } else if (ipk >= 3.5 && ipk <= 4.0) {      //jika ipk mahasiswa antara 3.5 - 4.0 maka akan mendapatkan beasiswa $75
            return 75; 
        } else {        //jika ipk mahasiswa dibawah 3.0 maka tidak mendapatkan beasiswa
            return 0;
        }      
    }

    //method ini akan menambahkan beasiswa ke dalam pendapatan mahasiswa
    @Override
    public double getPendapatan(){
        return super.getPendapatan() + getBeasiswa();
    }
    
    //method ini akan menampilkan informasi lengkap tentang mahasiswa 
    @Override
    public String toString() {
        return super.toString() +       //memanggil toString() dari kelas induk 
               String.format("NIM\t\t: %s\nIPK\t\t: %.1f\nStatus\t\t: %s\n",
               nim, ipk, getStatus());
    }
}
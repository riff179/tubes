class wilayah {
    private int baris ;
    private int kolom ;
    private int ketinggianTanah ;
    private double tinggiAir ;
    private int jumlahPenduduk ;
    private String status ;

     public wilayah (int baris, int kolom, int ketinggianTanah, int jumlahPenduduk) {
        this.baris = baris;
        this.kolom = kolom;
        this.ketinggianTanah = ketinggianTanah;
        this.tinggiAir = 0;
        this.jumlahPenduduk = jumlahPenduduk;
        this.status = "AMAN";
    }
    public int getbaris() {return baris; }
    public int getkolom() {return kolom; }
    public int getketinggianTanah() {return ketinggianTanah; }
    public double gettinggiAir () {return tinggiAir; }
    public int getjumlahPenduduk() {return jumlahPenduduk; }
    public String getstatus () {return status; }

    public void tambahAir (double cm) {
    tinggiAir  = tinggiAir + cm ;
        if (tinggiAir < 0) {
            tinggiAir = 0;
        }
    }

    public void updateStatus () {
        if (tinggiAir < 10) {
            status = "AMAN" ;
        } else if (tinggiAir < 30) {
            status = "SIAGA" ;
        } else {
            status = "BANJIR" ;
        }
    }

    public String toString () {
        return "wilayah [" + baris + "," + kolom +"] | Ketinggian Tanah : " 
        + ketinggianTanah + " | Tinggi Air : " + tinggiAir + " | jumlahPenduduk : " 
        + jumlahPenduduk + " | status : " + status + " |";
    }
}

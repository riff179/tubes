class simulasiBanjir {
    private petaBanjir peta;
    private  int jamKe;
    private double intensitasHujan;

    public simulasiBanjir (petaBanjir peta, double intensitasHujan) {
        this.peta = peta;
        this.jamKe = 0;
        this.intensitasHujan = intensitasHujan;
    }
    public petaBanjir getPeta () {
        return peta;
    }
    public void jalankanSimulasi (int durasiJam) {
        for (int i = 1; i <= durasiJam; i++) {
            jamKe++;
            System.out.println("===== Jam Ke-" + jamKe + "=====");

            peta.hujan(intensitasHujan);
            peta.alirkanAir();
            peta.tampilkanpeta();

            System.out.println("warga yang terdampak: " + peta.wargaTerdampak() + "orang");
            System.out.println();
        }
    }
    public double hitungKerugian() {
        return peta.wargaTerdampak() * 2000000.0;
    }
}
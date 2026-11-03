import java.util.Random;

class petaBanjir {
    private final int ukuranGrid = 6;
    private wilayah [][] gridPeta ;

    public petaBanjir () {
        gridPeta = new wilayah [ukuranGrid][ukuranGrid];
        Random acakNilai = new Random ();

        for (int i= 0; i < ukuranGrid; i++) {
            for(int j= 0; j < ukuranGrid; j++) {
                int ketinggianTanah = acakNilai.nextInt(10) + 1;
                int jumlahPenduduk = acakNilai.nextInt(901) + 100;
                gridPeta [i][j] = new wilayah (i, j, ketinggianTanah, jumlahPenduduk);
            }
        }
    }
    public int getukuranGrid() {
        return ukuranGrid;
    }
    public void tampilkanpeta () {
        for (int i = 0; i < ukuranGrid; i++) {
            for (int j = 0; j < ukuranGrid; j++){
                String status = gridPeta [i][j].getstatus ();
                char simbol;
                if (status.equals("AMAN")) {
                    simbol = 'A' ;
                } else if (status.equals("SIAGA")) {
                    simbol = 'S' ;
                } else {
                    simbol = 'B' ;
                }
                  System.out.print(simbol + " ");  
            }
            System.out.println();
        }
    }
    public void hujan (double intensitas) {
        for (int i = 0; i < ukuranGrid; i++) {
            for (int j = 0; j < ukuranGrid; j++){
                gridPeta[i][j].tambahAir(intensitas);
                gridPeta[i][j].updateStatus();
            }
        }
    }
    public void alirkanAir () {
        int[] arahBaris = {-1, 1, 0, 0};
        int[] arahKolom = {0, 0, -1, 1};

        double [][] perubahan = new double [ukuranGrid][ukuranGrid];
            for (int i = 0; i < ukuranGrid; i++) {
                for (int j = 0; j < ukuranGrid; j ++) {
                    int jumlahLebihRendah = 0;

                    for (int k = 0; k < 4; k++) {
                        int baris = i + arahBaris[k];
                        int kolom = j + arahKolom[k];

                        if (baris >= 0 && baris < ukuranGrid && kolom >= 0 && kolom < ukuranGrid) {
                            if (gridPeta [baris][kolom].getketinggianTanah() < gridPeta [i][j].getketinggianTanah()) {
                                jumlahLebihRendah++;
                            }
                        }
                    }
                    if (jumlahLebihRendah > 0) {
                        double airkeluar = gridPeta [i][j].gettinggiAir() * 0.2;
                        double airperTetangga = airkeluar / jumlahLebihRendah;

                        perubahan[i][j] = perubahan[i][j] - airkeluar;

                        for (int k = 0; k < 4; k++) {
                            int baris = i + arahBaris[k];
                            int kolom = j + arahKolom[k];

                            if (baris >= 0 && baris < ukuranGrid && kolom >= 0 && kolom < ukuranGrid) {
                                if (gridPeta [baris][kolom].getketinggianTanah() < gridPeta [i][j].getketinggianTanah()) {
                                    
                                    perubahan [baris][kolom] = perubahan [baris][kolom] + airperTetangga;
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i <ukuranGrid; i++) {
                for (int j = 0; j < ukuranGrid; j++) {
                    gridPeta [i][j].tambahAir(perubahan[i][j]);
                    gridPeta [i][j].updateStatus();
                }
            }
    }
    public int wargaTerdampak () {
        int totalTerdampak = 0;
        for (int i = 0; i < ukuranGrid; i++) {
            for (int j = 0; j < ukuranGrid; j++){
                if (gridPeta[i][j].getstatus().equals("BANJIR")) {
                    totalTerdampak = totalTerdampak + gridPeta[i][j].getjumlahPenduduk();
                }
            }
        }
        return totalTerdampak;
    }
    public int hitungselBanjir () {
        int selBanjir = 0;
            for (int i = 0; i < ukuranGrid; i++) {
                for (int j = 0; j < ukuranGrid; j++) {
                    if (gridPeta [i][j].getstatus().equals("BANJIR")) {
                        selBanjir++ ;
                    }
                }
            }
        return selBanjir;
    }
    public void ketinggianTanah () {
        for (int i = 0; i < ukuranGrid; i++) {
            for (int j = 0; j < ukuranGrid; j ++) {
                System.out.printf("%3d", gridPeta[i][j].getketinggianTanah());
            }
            System.out.println();
        }
    }
}
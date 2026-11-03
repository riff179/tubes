import java.util.Scanner;
public class mainBanjir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===== SIMULASI PEMETAAN DAN PENYEBARAN =====");
        double intensitas = 0;
        while (intensitas <= 0) {
            System.out.println("Masukkan intensitas hujan perjam :");
                if (input.hasNextDouble()) {
                    intensitas = input.nextDouble();
                    if (intensitas <= 0) {
                        System.out.println("Input harus lebih dari 0!");
                    }
                } else {
                        System.out.println("input harus berupa angka!");
                        input.next();
                    } 
        }       
        int durasi = 0;
        while (durasi <= 0) {
            System.out.println("masukkan durasi simulasi (dihitung per-jam) :");
                if (input.hasNextInt()) {
                    durasi = input.nextInt();
                        if (durasi <= 0) {
                            System.out.println("input harus lebih dari 0!");
                        }
                } else {
                    System.out.println("input harus berupa angka!");
                    input.next();
                }
        }
        petaBanjir peta = new petaBanjir() ;
        simulasiBanjir simulasi = new simulasiBanjir(peta, intensitas);

        System.out.println("\n Ketinggian tanah tiap wilayahnya :");
        peta.ketinggianTanah();
        System.out.println("\n Keterangan peta: A = Aman, S = Siaga, B = Banjir\n");

        simulasi.jalankanSimulasi(durasi);

        double kerugian = simulasi.hitungKerugian();

        int totalsel = peta.getukuranGrid() * peta.getukuranGrid();
        int selBanjir = peta.hitungselBanjir();
        double persenBanjir = (double) selBanjir / totalsel * 100;
        
        System.out.println("===== HASIL AKHIR =====");
        System.out.println("sel berstatus BANJIR : " + selBanjir + " dari " + totalsel
                + "(" + String.format("%.1f", persenBanjir) + "%");
        System.out.println("warga yang terdampak  : " + peta.wargaTerdampak() + "orang");

        if (persenBanjir > 50) {
            System.out.println("PERINGATAN!!! STATUS DARURAT!!");
            kerugian = kerugian + (kerugian * 0.2);
        }
        System.out.println("Estimasi kerugian   :" + kerugian + "Rp");

        input.close();
    }
}

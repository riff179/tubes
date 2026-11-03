# 🌊 Simulasi Pemetaan dan Penyebaran Banjir (Flood Grid)

Proyek Tugas Besar Mata Kuliah **Pengantar Pemrograman**\
Program Studi Informatika, Fakultas Teknik, Universitas Bengkulu ---
2026

## 📖 Deskripsi Proyek

**Flood Grid** adalah program simulasi pemetaan dan penyebaran banjir
berbasis Java yang merepresentasikan suatu wilayah ke dalam matriks grid
berukuran **6 × 6**. Setiap sel mewakili satu wilayah yang memiliki data
ketinggian tanah, tinggi air, jumlah penduduk, dan status wilayah.

Ketika simulasi dijalankan, program menambahkan air berdasarkan
intensitas hujan yang dimasukkan pengguna. Air kemudian dialirkan ke sel
tetangga (atas, bawah, kiri, dan kanan) yang memiliki ketinggian tanah
lebih rendah. Program memperbarui status setiap wilayah, menghitung
jumlah warga terdampak, serta memperkirakan kerugian akibat banjir.

Proyek ini dibuat sebagai penerapan konsep **Object-Oriented Programming
(OOP)**, array dua dimensi, perulangan, percabangan, validasi input, dan
operasi aritmetika dalam bahasa Java.

## 🎯 Tujuan

-   Menerapkan konsep pemrograman berorientasi objek melalui beberapa
    class yang saling terhubung.
-   Merepresentasikan wilayah dalam grid berukuran 6 × 6.
-   Menyimulasikan penambahan air akibat hujan dan aliran air antarsel.
-   Mengelompokkan kondisi wilayah menjadi AMAN, SIAGA, atau BANJIR.
-   Menghitung jumlah wilayah banjir dan penduduk terdampak.
-   Menghitung estimasi kerugian serta mendeteksi kondisi STATUS
    DARURAT.

## ✨ Fitur Program

-   **Peta grid 6 × 6:** menampilkan 36 wilayah dalam bentuk matriks.
-   **Simulasi hujan:** menambahkan tinggi air ke seluruh sel
    berdasarkan intensitas hujan per jam.
-   **Aliran air:** memindahkan sebagian air ke wilayah tetangga yang
    memiliki ketinggian tanah lebih rendah.
-   **Pembaruan status otomatis:** menentukan status wilayah berdasarkan
    tinggi air.
-   **Validasi input:** memastikan intensitas hujan dan durasi simulasi
    berupa angka yang valid dan lebih dari 0.
-   **Perhitungan dampak:** menghitung jumlah wilayah banjir dan total
    penduduk yang berada di wilayah berstatus BANJIR.
-   **Estimasi kerugian:** menghitung kerugian berdasarkan jumlah
    penduduk terdampak.
-   **Peringatan darurat:** menampilkan STATUS DARURAT jika persentase
    wilayah banjir lebih dari 50%, disertai kenaikan estimasi kerugian
    sebesar 20%.

## 🧰 Teknologi yang Digunakan

-   **Bahasa pemrograman:** Java
-   **Paradigma:** Object-Oriented Programming (OOP)
-   **Struktur data:** Array dua dimensi (`Wilayah[][]`)
-   **Input pengguna:** `Scanner`
-   **Pengembangan konsep:** class, object, constructor, encapsulation,
    method, looping, conditional statement, dan operasi aritmetika.

## 🗂️ Struktur Program

Program dibagi menjadi empat class utama:

  -----------------------------------------------------------------------
  Class                               Tanggung Jawab
  ----------------------------------- -----------------------------------
  `Wilayah`                           Menyimpan data setiap wilayah,
                                      menambahkan air, memperbarui
                                      status, dan menyediakan informasi
                                      objek.

  `PetaBanjir`                        Membuat grid 6 × 6, menampilkan
                                      peta, memproses hujan dan aliran
                                      air, serta menghitung wilayah
                                      banjir dan warga terdampak.

  `SimulasiBanjir`                    Menjalankan simulasi berdasarkan
                                      durasi dan intensitas hujan,
                                      menghitung persentase wilayah
                                      banjir, serta estimasi kerugian.

  `MainBanjir`                        Menjadi titik awal program,
                                      menerima dan memvalidasi input
                                      pengguna, kemudian menjalankan
                                      simulasi.
  -----------------------------------------------------------------------

Contoh susunan file jika seluruh class disimpan dalam satu folder:

``` text
Flood-Grid/
├── Wilayah.java
├── PetaBanjir.java
├── SimulasiBanjir.java
├── MainBanjir.java
└── README.md
```

## 📊 Aturan Simulasi

### 1. Status Wilayah

Status setiap wilayah ditentukan berdasarkan tinggi air:

  Tinggi Air                       Status    Simbol
  -------------------------------- -------- --------
  Kurang dari 10 cm                AMAN        A
  10 cm hingga kurang dari 30 cm   SIAGA       S
  30 cm atau lebih                 BANJIR      B

### 2. Aliran Air

Air dialirkan dari wilayah asal menuju sel tetangga yang memiliki
ketinggian tanah lebih rendah. Pemeriksaan dilakukan pada empat arah:

-   Atas
-   Bawah
-   Kiri
-   Kanan

Program memeriksa batas indeks matriks agar tidak mengakses sel di luar
grid. Jumlah air yang dialirkan dihitung menggunakan nilai terkecil
antara 10% tinggi air wilayah asal dan 10% selisih ketinggian tanah
kedua wilayah.

### 3. Perhitungan Dampak dan Kerugian

-   Total penduduk terdampak dihitung dari jumlah penduduk pada seluruh
    sel berstatus BANJIR.
-   Estimasi kerugian dasar adalah **Rp2.000.000 per warga terdampak**.
-   Persentase banjir dihitung dari jumlah sel berstatus BANJIR
    dibandingkan dengan total 36 sel.

### 4. Status Darurat

Jika lebih dari 50% dari keseluruhan sel berstatus BANJIR, program
menampilkan:

``` text
!!! STATUS DARURAT !!!
```

Pada kondisi tersebut, estimasi kerugian ditambah sebesar 20% dari
kerugian dasar.

## 🚀 Persyaratan dan Cara Menjalankan

### Persyaratan

-   Java Development Kit (JDK) telah terpasang.
-   Terminal atau Command Prompt.
-   Seluruh file class Java berada dalam folder proyek yang sama apabila
    menggunakan susunan sederhana di atas.

Periksa instalasi Java:

``` bash
java -version
javac -version
```

### 1. Clone Repository

Salin link repository Github project :

``` bash
git clone https://github.com/riff179/tubes.git
```

Masuk ke folder proyek:

``` bash
cd tubes
```

### 2. Compile Program

``` bash
javac *.java
```

### 3. Jalankan Program

``` bash
java MainBanjir
```

### 4. Masukkan Data Simulasi

Program akan meminta dua input:

1.  **Intensitas hujan per jam (cm):** masukkan angka lebih dari 0.
2.  **Durasi simulasi (jam):** masukkan bilangan bulat lebih dari 0.

Program kemudian menampilkan peta awal dan hasil simulasi untuk setiap
jam, termasuk jumlah wilayah banjir, persentase wilayah banjir, jumlah
warga terdampak, dan estimasi kerugian.

## 🧪 Pengujian Program

Berdasarkan laporan tugas besar, program diuji menggunakan beberapa
variasi intensitas hujan dan durasi:

  Pengujian     Intensitas Hujan   Durasi
  ----------- ------------------ --------
  1                     2 cm/jam    1 jam
  2                    10 cm/jam    1 jam
  3                    15 cm/jam    3 jam
  4                    30 cm/jam    3 jam

Pengujian dilakukan untuk mengamati perubahan status wilayah, penyebaran
air, jumlah warga terdampak, dan estimasi kerugian pada kondisi hujan
yang berbeda.

## 👥 Anggota Kelompok

Tugas Besar Proyek Pengantar Pemrograman --- Kelompok 2:

    No. Nama                NIM
  ----- ------------------- -----------
      1 Rian Surya          G1A026005
      2 Rifda Julio Mahdi   G1A026007
      3 Intan Sundari       G1A026019

**Program Studi Informatika**\
**Fakultas Teknik --- Universitas Bengkulu**\
**2026**

## 📌 Catatan Pengembangan

Program ini merupakan simulasi pembelajaran dan bukan sistem prediksi
atau peringatan banjir operasional. Data ketinggian tanah dan jumlah
penduduk menggunakan data yang ditetapkan dalam program. Model aliran
air juga masih sederhana.

Pengembangan selanjutnya dapat mempertimbangkan daya serap tanah,
perubahan curah hujan, kondisi drainase, kapasitas sungai, penggunaan
data wilayah nyata, visualisasi peta berwarna, riwayat perubahan tinggi
air, dan sistem peringatan dini.

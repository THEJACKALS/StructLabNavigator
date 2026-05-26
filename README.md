# StructLab Navigator - Data Structure Traversal & Operation CLI

StructLab Navigator adalah versi refactor dari repository tugas Struktur Data yang awalnya berisi dua program console terpisah untuk BFS dan DFS. Proyek ini dipertahankan tetap ringan, berjalan di terminal, dan fokus pada pembelajaran traversal graph dengan struktur kode yang lebih rapi.

## Ringkasan

Repository lama hanya berisi demo traversal sederhana. Pada versi ini, kode disatukan menjadi satu aplikasi CLI dengan menu yang lebih jelas, validasi input, dan pemisahan tanggung jawab yang lebih baik.

## Bahasa Pemrograman

- Java

## Fitur Utama

- Menu terminal untuk memilih demo BFS, demo DFS, atau melihat graph contoh.
- Validasi input angka agar program tidak mudah error.
- Output traversal dan adjacency list dibuat lebih rapi.
- Struktur kode dipisah menjadi class utama dan class graph internal.
- Tetap mempertahankan logika traversal dari repository lama.

## Struktur Data yang Digunakan

- Adjacency list untuk menyimpan graph directed.
- Queue untuk traversal BFS.
- Array boolean untuk menandai node yang sudah dikunjungi.
- Rekursi untuk traversal DFS.

## Operasi yang Tersedia

- Tambah edge pada graph contoh.
- Tampilkan adjacency list graph contoh.
- Breadth First Search dari vertex awal yang dipilih user.
- Depth First Search dari vertex awal yang dipilih user.

## Struktur Folder

```text
StructLab-Navigator/
├── README.md
├── StructLab-Navigator.bat
├── src/
│   └── StructLabNavigator.java
├── docs/
│   └── explanation.md
└── examples/
    └── sample-output.txt
```

## Cara Menjalankan

### Opsi 1: Melalui shortcut `.bat`

Klik dua kali file `StructLab-Navigator.bat` dari folder project.

### Opsi 2: Melalui terminal

```bash
javac -d out src/StructLabNavigator.java
java -cp out StructLabNavigator
```

## Contoh Alur Program

1. Program menampilkan menu utama.
2. User memilih demo BFS atau DFS.
3. User memasukkan vertex awal yang valid.
4. Program menampilkan adjacency list dan hasil traversal.

## Catatan Refactor

Yang dipertahankan:

- Algoritma BFS dan DFS.
- Model graph berbasis adjacency list.
- Data edge contoh dari repository lama.

Yang diperbaiki:

- Entry point digabung menjadi satu CLI.
- Validasi input ditambahkan.
- Struktur kode dipisah agar mudah dibaca.
- Output terminal dirapikan.

## Roadmap Kecil

Project ini sengaja dibuat kecil. Jika ingin dikembangkan lagi, langkah aman berikutnya adalah menambah opsi input graph manual tanpa mengubah inti traversal.

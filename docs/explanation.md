# Penjelasan Konsep StructLab Navigator

StructLab Navigator adalah CLI edukasi untuk memperlihatkan cara kerja graph traversal pada struktur data graph directed.

## 1. Konsep Graph

Graph disimpan sebagai adjacency list. Setiap vertex memiliki daftar tetangga yang dapat dikunjungi langsung.

Contoh bentuk sederhana:

```text
0 -> 1, 3, 4
1 -> 2
2 -> 1
```

Keuntungan adjacency list:

- Ringkas untuk graph yang tidak terlalu padat.
- Mudah dipakai untuk traversal BFS dan DFS.
- Mudah dibaca saat dicetak ke terminal.

## 2. Breadth First Search

BFS mengunjungi node per level.

Alur singkat:

1. Masukkan vertex awal ke queue.
2. Tandai vertex sebagai sudah dikunjungi.
3. Ambil vertex paling depan dari queue.
4. Masukkan semua tetangga yang belum dikunjungi.
5. Ulangi sampai queue kosong.

Pada implementasi ini BFS memakai:

- `Queue<Integer>` untuk urutan kunjungan.
- `boolean[] visited` untuk mencegah kunjungan berulang.

## 3. Depth First Search

DFS mengunjungi node sedalam mungkin terlebih dahulu.

Alur singkat:

1. Kunjungi vertex saat ini.
2. Tandai sebagai visited.
3. Pindah ke tetangga pertama yang belum dikunjungi.
4. Ulangi secara rekursif sampai tidak ada jalur baru.

Pada implementasi ini DFS memakai:

- Rekursi.
- `boolean[] visited`.

## 4. Validasi Input

Program menerima input menu dan vertex awal dari user. Semua input angka divalidasi agar berada dalam rentang yang tersedia.

Jika input bukan angka atau di luar batas, program akan menampilkan pesan error yang jelas lalu meminta input ulang.

## 5. Alur Program

1. Program menampilkan judul dan menu utama.
2. User memilih BFS, DFS, atau melihat graph demo.
3. User memasukkan vertex awal traversal.
4. Program menampilkan adjacency list.
5. Program menampilkan hasil traversal dalam format yang mudah dibaca.

## 6. Kenapa Refactor Ini Dipilih

Refactor dibuat kecil dan aman karena repository asli memang hanya berisi demo traversal. Tujuannya bukan mengubah menjadi aplikasi baru yang besar, tetapi membuat versi portofolio yang lebih layak dibaca, dipelajari, dan dikembangkan.

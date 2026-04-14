data class Barang(val id: Int, var nama: String, var jumlah: Int)

class PengelolaStok {
    var stok: Int = 0
        set(value) { field = if (value < 0) 0 else value }
}

fun main() {
    val cekStok = PengelolaStok()
    cekStok.stok = 10

    val daftarBelanja = ArrayList<Barang>()
    var menu: String? 

    println("DAFTAR BELANJA")

    do {
        println("\n[1] Tambah [2] Lihat [3] Hapus [4] Keluar")
        print("Pilih Menu: ")
        menu = readlnOrNull()

        when (menu) {
            "1" -> {
                print("Nama barang: ")
                val nama = readlnOrNull() ?: "Bukan Nama"
                print("Jumlah: ")
                val qty = readlnOrNull()?.toIntOrNull() ?: 0
                daftarBelanja.add(Barang(daftarBelanja.size + 1, nama, qty))
                println("Berhasil!")
            }
            "2" -> {
                println("\nDAFTAR BELANJA")
                if (daftarBelanja.isEmpty()) println("Kosong.")
                else daftarBelanja.forEach { println("${it.id}. ${it.nama} (${it.jumlah} pcs)") }
            }
            "3" -> {
                print("Hapus ID: ")
                val idHapus = readlnOrNull()?.toIntOrNull()
                if (idHapus != null && idHapus > 0 && idHapus <= daftarBelanja.size) {
                    daftarBelanja.removeAt(idHapus - 1)
                    println("Terhapus!")
                } else {
                    println("ID tidak valid.")
                }
            }
        }
    } while (menu != "4")
    println("Selesai.")
}

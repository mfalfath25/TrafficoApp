package com.pasukanlangit.id.traffico.model

import android.os.Parcelable
import com.pasukanlangit.id.traffico.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Information(
    val logo: Int,
    val sim: String,
    val desc: String,
    val detailImg: Int,
    val requirement: String,
    val url: String
): Parcelable

fun getInformations() = listOf(
    Information(
        logo = R.drawable.car,
        sim = "SIM A",
        desc = "diperuntukkan kepada pengemudi mobil penumpang dan barang perseorangan dengan jumlah berat yang diperbolehkan tidak melebihi 3.500 kilogram.",
        detailImg = R.drawable.sima_detail,
        requirement = "1. Usia pemohon SIM A harus berumur 17 Tahun dan sudah memiliki Kartu Tanda Penduduk (KTP)\n" +
                "2. Membawa KTP Asli saat mendaftar\n" +
                "3. Mengisi formulir pengajuan SIM\n" +
                "4. Sehat jasmani dan rohani yang nantinya dibuktikan dengan Surat Keterangan Sehat dari Dokter\n" +
                "5. Saat mengajukan permohonan SIM harus berpakaian rapi. Dimana untuk pria memakai kemeja berkerah, bercelana panjang, dan harus bersepatu.\n" +
                "6. Lulus ujian pembuatan SIM A yang terdiri dari ujian teori, ujian praktek, dan ujian keterampilan melalui simulator\n" +
                "7. Membayar biaya pembuatan SIM sesuai golongan SIM yang akan dibuat.",
        url = "https://www.otomotifo.com/cara-membuat-sim-a-syarat-biaya/#:~:text=1%20Usia%20pemohon%20SIM%20A%20harus%20berumur%2017,pembuatan%20SIM%20sesuai%20golongan%20SIM%20yang%20akan%20dibuat."
    ),
    Information(
        logo = R.drawable.truck,
        sim = "SIM B1",
        desc = "diperuntukkan kepada pengemudi mobil penumpang dan barang perseorangan dengan jumlah berat yang diperbolehkan melebihi 3.500 kilogram.",
        detailImg = R.drawable.detail_simb1,
        requirement = "1. Bisa membaca dan menulis.\n" +
                "2. Memiliki Kartu Tanda Penduduk (KTP)\n" +
                "3. Mengisi formulir permohonan.\n" +
                "4. Sehat jasmani, rohani, berpenampilan rapi dan disarankan untuk bersepatu\n" +
                "5. Lulus ujian teori, praktik, dan/atau ujian keterampilan melalui simulator.\n" +
                "6. Pemohon SIM B1 harus memiliki SIM A sekurang-kurangnya 12 bulan.\n" +
                "7. Pemohon SIM B1 Umum harus memiliki SIM B1 atau SIM A Umum sekurang-kurangnya 12 bulan\n" +
                "8. Bagi pemohon SIM B1 Umum diwajibkan mengikuti klinik mengemudi untuk mendapatkan Surat Keterangan Uji Klinik Pengemudi (SKUKP).",
        url = "https://harga.web.id/biaya-pembuatan-dan-perpanjangan-sim-b1.info#:~:text=%20Prosedur%20Pembuatan%20SIM%20B1%20Baru%20%201,Jika%20Anda%20belum%20membawanya%20pada%20hari...%20More%20"
    ),
    Information(
        logo = R.drawable.motorcycle,
        sim = "SIM C",
        desc = "diperuntukkan kepada pengemudi motor, terbagi 3 SIM C untuk motor 250 cc, SIM CI untuk 250 cc sampai 500 cc, dan SIM CII untuk  kapasitas isi silinder di atas 500 cc",
        detailImg = R.drawable.sima_detail,
        requirement = "1. Usia minimal 17 tahun(SIM C), 18 tahun(SIM CI), dan 19 tahun(CII).\n" +
                "2. Memiliki Kartu Tanda Penduduk (KTP).\n" +
                "3. Mengisi formulir permohonan.\n" +
                "4. Sehat jasmani, rohani, berpenampilan rapi dan disarankan untuk bersepatu.\n" +
                "5. Bisa membaca dan menulis.\n" +
                "6. Lulus tes ujian teori dan praktek sesuai dengan prosedur yang sudah ditentukan.",
        url = "https://otomotif.kompas.com/read/2021/09/03/131200515/catat-ini-biaya-dan-syarat-bikin-sim-c-per-september-2021"
    ),
    Information(
        logo = R.drawable.wheelchair,
        sim = "SIM D",
        desc = "diperuntukkan kepada pengemudi penyandang disabilitas. Baik itu SIM D atau DI sesuai dengan kendaraan yang digunakan baik mobil atau motor.",
        detailImg = R.drawable.sima_detail,
        requirement = "1. Permohonan tertulis .\n" +
                "2. Bisa membaca dan menulis.\n" +
                "3. Memiliki pengetahuan peraturan lalu lintas jalan dan teknik dasar kendaraan bermotor.\n" +
                "4. Batas usia 17 tahun.\n" +
                "5. Tarampil mengemudikan kendaraan bermotor untuk SIM D dan mobil untuk SIM DI.\n" +
                "6. Sehat jasmani dan rohani.\n" +
                "7. Lulus ujian teori dan praktik.",
        url = "https://megapolitan.kompas.com/read/2021/07/23/10013331/syarat-buat-sim-d-dan-di-untuk-penyandang-disabilitas"
    ),
)

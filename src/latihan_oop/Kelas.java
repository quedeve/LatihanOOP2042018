/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan_oop;

import java.util.List;

/**
 *
 * @author victo
 */
public class Kelas {
    private String pengajar;
    private List <String> mahasiswa;
    private String namaKelas;
    private String jadwalKelas;

    public String getPengajar() {
        return pengajar;
    }

    public void setPengajar(String pengajar) {
        this.pengajar = pengajar;
    }

   

    public List<String> getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(List<String> mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    
    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getJadwalKelas() {
        return jadwalKelas;
    }

    public void setJadwalKelas(String jadwalKelas) {
        this.jadwalKelas = jadwalKelas;
    }
    
}

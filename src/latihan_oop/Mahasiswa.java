/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan_oop;

import java.util.Map;

/**
 *
 * @author victo
 */
public class Mahasiswa {
    private String nama;
    private Map<String, Kelas> kelas;

    public Map<String, Kelas> getKelas() {
        return kelas;
    }

    public void setKelas(Map<String, Kelas> kelas) {
        this.kelas = kelas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
}

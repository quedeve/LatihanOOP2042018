/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan_oop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * <
 *
 * @author victo
 */
public class Latihan_OOP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Boolean isTambah = true;

        Scanner input = new Scanner(System.in);
        LinkedHashMap<String, Kelas> kelas = new LinkedHashMap<String, Kelas>();
        LinkedHashMap<String, Mahasiswa> mahasiswa = new LinkedHashMap<String, Mahasiswa>();
        LinkedHashMap<String, Pengajar> pengajar = new LinkedHashMap<String, Pengajar>();

        tambahKelas(kelas, isTambah, input);
        tambahMahasiswa(mahasiswa, isTambah, input);
        tambahPengajar(pengajar, isTambah, input);
        tambahKelasPengajar(pengajar, kelas, isTambah, input);
        tambahKelasMahasiswa(mahasiswa, kelas, isTambah, input);

        showAll(kelas, mahasiswa, pengajar);

    }

    private static void showAll(Map<String, Kelas> kelas, Map<String, Mahasiswa> mahasiswa, Map<String, Pengajar> pengajar) {
        System.out.println(" ***********************************************************");
        System.out.println(" ***********************************************************");
        System.out.println("Daftar Kelas Dengan mahasiswa dan Pengajarnya By ID Kelas");
        for (Map.Entry<String, Kelas> entry : kelas.entrySet()) {
            System.out.println(entry.getKey());
            Kelas kls = entry.getValue();
            if (kls.getPengajar() != null) {
                System.out.println(" Nama Kelas : " + kls.getNamaKelas() + "  Jadwal " + kls.getJadwalKelas() + " Pengajar :" + pengajar.get(kls.getPengajar()).getNama());
            } else {
                System.out.println(" Nama Kelas : " + kls.getNamaKelas() + "  Jadwal " + kls.getJadwalKelas());
            }

            System.out.println("Daftar Mahasiswa");

            for (Map.Entry<String, Mahasiswa> mmhs : mahasiswa.entrySet()) {
                Mahasiswa mhs = new Mahasiswa();
                mhs = mmhs.getValue();
                if (mhs.getKelas()!= null && mhs.getKelas().containsKey(entry.getKey())) {
                    if (kls.getMahasiswa() != null) {
                    kls.getMahasiswa().forEach(item -> System.out.println(mahasiswa.get(item).getNama()));
                }
                }
                
            }

        }
        System.out.println(" ***********************************************************");
        System.out.println(" ***********************************************************");
        System.out.println(" ***********************************************************");
        System.out.println(" ***********************************************************");
        System.out.println("Daftar Pengajar Dengan kelasnya By ID Pengajar");
        for (Map.Entry<String, Pengajar> entry : pengajar.entrySet()) {
            System.out.println(entry.getKey());
            Pengajar kls = entry.getValue();
            System.out.println(" Nama Pengajar : " + kls.getNama());
            System.out.println("Daftar Kelas");
            if (pengajar.get(entry.getKey()).getKelas() != null) {
                for (Map.Entry<String, Kelas> entry2 : kls.getKelas().entrySet()) {

                    System.out.println("id Kelas : " + entry2.getKey() + "  Kelas " + kelas.get(entry2.getKey()).getNamaKelas());

                }
            }

        }
        System.out.println(" ***********************************************************");
        System.out.println(" ***********************************************************");
        System.out.println(" ***********************************************************");
        System.out.println(" ***********************************************************");
        System.out.println("Daftar Mahasiswa Dengan kelas dan Pengajarnya By ID Mahasiswa");
        for (Map.Entry<String, Mahasiswa> entry : mahasiswa.entrySet()) {
            System.out.println(entry.getKey());
            Mahasiswa kls = entry.getValue();
            System.out.println(" Mahasiswa : " + kls.getNama());
            System.out.println("daftar Kelas dan pengajarnya");
            if (mahasiswa.get(entry.getKey()).getKelas() != null) {
                for (Map.Entry<String, Kelas> entry2 : mahasiswa.get(kls).getKelas().entrySet()) {
                    System.out.println("Nama Kelas: " + kelas.get(entry2).getNamaKelas() + " nama dosen " + pengajar.get(kelas.get(kelas.get(entry2).getPengajar())));
                }
            }

        }
        System.out.println(" ***********************************************************");
        System.out.println(" ***********************************************************");

    }

    private static void tambahKelas(Map<String, Kelas> kelas, Boolean isTambah, Scanner input) {
        String idKelas;
        String keyakinan;
        while (isTambah) {
            System.out.println(" ***********************************************************");
            System.out.println(" Data Kelas ! ");
            System.out.print(" Nama Kelas : ");
            Kelas kls = new Kelas();
            kls.setNamaKelas(input.next());
            System.out.print(" Jadwal Kelas : ");
            kls.setJadwalKelas(input.next());
            System.out.print(" ID kelas : ");
            idKelas = input.next();
            System.out.println("Yakin menambahkan data berikut ? " + kls.getNamaKelas() + " / " + kls.getJadwalKelas() + " Y/F");
            keyakinan = input.next();

            if (keyakinan.equals("Y")) {
                kelas.put(idKelas, kls);
            } else if (keyakinan.equals("F")) {
                System.out.println(kls.getNamaKelas() + " / " + kls.getJadwalKelas() + " tidak jadi ditambahkan ");
            }

            System.out.print(" Tambah data baru kembali ?(jawab dengan true/false : ");
            isTambah = input.nextBoolean();

        }
//        for (Map.Entry<String, Kelas> entry : kelas.entrySet()) {
//            System.out.println(entry.getKey());
//            Kelas kls = entry.getValue();
//            System.out.println(" Judul  Buku : " + kls.getNamaKelas() + "  pengarang " + kls.getJadwalKelas());
//        }

    }

    private static void tambahPengajar(Map<String, Pengajar> pengajar, Boolean isTambah, Scanner input) {
        String idPengajar;
        String keyakinan;
        while (isTambah) {
            System.out.println(" ***********************************************************");
            System.out.println(" Data Pengajar ! ");
            System.out.print(" Nama Pengajar : ");
            Pengajar trainer = new Pengajar();
            trainer.setNama(input.next());
            System.out.print(" ID Pengajar : ");
            idPengajar = input.next();
            System.out.println("Yakin menambahkan data berikut ? " + trainer.getNama() + " Y/F");
            keyakinan = input.next();

            if (keyakinan.equals("Y")) {
                pengajar.put(idPengajar, trainer);
            } else if (keyakinan.equals("F")) {
                System.out.println(trainer.getNama() + " tidak jadi ditambahkan ");
            }

            System.out.print(" Tambah data baru kembali ?(jawab dengan true/false : ");
            isTambah = input.nextBoolean();

        }
//        for (Map.Entry<String, Kelas> entry : kelas.entrySet()) {
//            System.out.println(entry.getKey());
//            Kelas kls = entry.getValue();
//            System.out.println(" Judul  Buku : " + kls.getNamaKelas() + "  pengarang " + kls.getJadwalKelas());
//        }

    }

    private static void tambahMahasiswa(Map<String, Mahasiswa> mahasiswa, Boolean isTambah, Scanner input) {
        String idMahasiswa;
        String keyakinan;
        while (isTambah) {
            System.out.println(" ***********************************************************");
            System.out.println(" Data Mahasiswa ! ");
            System.out.print(" Nama Mahasiswa : ");
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNama(input.next());
            System.out.print(" ID Mahasiswa : ");
            idMahasiswa = input.next();
            System.out.println("Yakin menambahkan data berikut ? " + mhs.getNama() + " Y/F");
            keyakinan = input.next();

            if (keyakinan.equals("Y")) {
                mahasiswa.put(idMahasiswa, mhs);
            } else if (keyakinan.equals("F")) {
                System.out.println(mhs.getNama() + " tidak jadi ditambahkan ");
            }

            System.out.print(" Tambah data baru kembali ?(jawab dengan true/false : ");
            isTambah = input.nextBoolean();

        }
//        for (Map.Entry<String, Kelas> entry : kelas.entrySet()) {
//            System.out.println(entry.getKey());
//            Kelas kls = entry.getValue();
//            System.out.println(" Judul  Buku : " + kls.getNamaKelas() + "  pengarang " + kls.getJadwalKelas());
//        }

    }

    private static void tambahKelasMahasiswa(Map<String, Mahasiswa> mahasiswa, Map<String, Kelas> kelas, Boolean isTambah, Scanner input) {
        String idMahasiswa;
        String idKelas;
        String keyakinan;
        Boolean lagi = true;
        Map<String, Kelas> kls = new LinkedHashMap<String, Kelas>();
        Kelas aKelas = new Kelas();
        while (lagi) {
            List<String> mhs = new ArrayList<String>();
            while (isTambah) {
                System.out.println(" ***********************************************************");
                System.out.println(" Tambahkan Data Kelas Mahasiswa ! ");
                System.out.print(" Pilih ID Mahasiswa : ");
                idMahasiswa = input.next();
                System.out.print(" Pilih ID Kelas yang ingin dimasukkan : ");
                idKelas = input.next();
                System.out.println("Yakin menambahkan data berikut ? " + mahasiswa.get(idMahasiswa).getNama() + " pada kelas" + kelas.get(idKelas).getNamaKelas() + " pada hari" + kelas.get(idKelas).getJadwalKelas() + " Y/F");
                keyakinan = input.next();

                if (keyakinan.equals("Y")) {
                    if (mahasiswa.get(idMahasiswa).getKelas() == null) {
                        mhs.add(idMahasiswa);
                        kelas.get(idKelas).setMahasiswa(mhs);

                        kls.put(idKelas, aKelas);
                        mahasiswa.get(idMahasiswa).setKelas(kls);

                    }
                } else if (keyakinan.equals("F")) {
                    System.out.println(mahasiswa.get(idMahasiswa).getNama() + " tidak jadi menambah kelas ");
                }

                System.out.print(" Tambah data baru kembali ?(jawab dengan true/false : ");
                isTambah = input.nextBoolean();

            }
            System.out.println("Tambahkan data Mahasiswa terhadap kelas? (jawa dengan true/false: ");
            lagi = input.nextBoolean();
        }
//        for (Map.Entry<String, Kelas> entry : kelas.entrySet()) {
//            System.out.println(entry.getKey());
//            Kelas kls = entry.getValue();
//            System.out.println(" Judul  Buku : " + kls.getNamaKelas() + "  pengarang " + kls.getJadwalKelas());
//        }

    }

    private static void tambahKelasPengajar(Map<String, Pengajar> pengajar, Map<String, Kelas> kelas, Boolean isTambah, Scanner input) {
        String idPengajar;
        String idKelas;
        String keyakinan;
        Boolean lagi = true;
        while (lagi) {
            Map<String, Kelas> kls = new LinkedHashMap<String, Kelas>();
            Kelas aKelas = new Kelas();

            while (isTambah) {
                System.out.println(" ***********************************************************");
                System.out.println(" Tambahkan Data Kelas Pengajar ! ");
                System.out.print(" Pilih ID Pengajar : ");
                idPengajar = input.next();
                System.out.print(" Pilih ID Kelas yang ingin dimasukkan : ");
                idKelas = input.next();
                System.out.println("Yakin menambahkan data berikut ? " + pengajar.get(idPengajar).getNama() + " pada kelas" + kelas.get(idKelas).getNamaKelas() + " pada hari" + kelas.get(idKelas).getJadwalKelas() + " Y/F");
                keyakinan = input.next();

                if (keyakinan.equals("Y")) {
                    if (pengajar.get(idPengajar).getKelas() == null) {

                        kelas.get(idKelas).setPengajar(idPengajar);

                        kls.put(idKelas, aKelas);
                        pengajar.get(idPengajar).setKelas(kls);
                    } else {
                        System.out.println("tidak masuk");
                    }
                } else if (keyakinan.equals("F")) {
                    System.out.println(pengajar.get(idPengajar).getNama() + " tidak jadi menambah kelas ");
                }

                System.out.print(" Tambah data baru kembali ?(jawab dengan true/false : ");
                isTambah = input.nextBoolean();

            }
            System.out.println("Tambah data Pengajar terhadap kelas? (jawab dengan true/false: ");
            lagi = input.nextBoolean();
        }
//        for (Map.Entry<String, Kelas> entry : kelas.entrySet()) {
//            System.out.println(entry.getKey());
//            Kelas kls = entry.getValue();
//            System.out.println(" Judul  Buku : " + kls.getNamaKelas() + "  pengarang " + kls.getJadwalKelas());
//        }

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erlian.dao;

import erlian.model.Peminjaman;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface PeminjamanDao {
        void insert(Peminjaman peminjaman);
        void update(int index, Peminjaman peminjaman);
        void delete(int index);
        Peminjaman getPeminjaman(int index);
        List <Peminjaman>getAll();
}

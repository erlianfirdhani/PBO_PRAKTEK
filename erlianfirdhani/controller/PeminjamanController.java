/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erlian.controller;
import erlian.dao.*;
import erlian.model.*;
import erlian.view.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Dell
 */
public class PeminjamanController {
    FormPeminjaman view;
    Peminjaman peminjaman;
    PeminjamanDao dao;
    
    public PeminjamanController(FormPeminjaman view) {
        this.view = view;
        dao = new PeminjamanDaoImpl();
    }
    
    public void clearForm(){
        view.getTxtKodeAnggota().setText("");
        view.getTxtKodeBuku().setText("");
        view.getTxtTanggalPinjam().setText("");
        view.getTxtTanggalKembali().setText("");
        
    }
    
    public void tampil() {
        DefaultTableModel tabelModel = (DefaultTableModel) view.getTabelPeminjaman().getModel();
        tabelModel.setRowCount(0);
        List<Peminjaman> list = dao.getAll();
        for (Peminjaman a : list) {
            Object[] row = {
                a.getKodeanggota(),
                a.getKodebuku(),
                a.getTglpinjam(),
                a.getTglkembali()
            };
            tabelModel.addRow(row);
        }
    }
    
    public void insert(){
        peminjaman = new Peminjaman();
        peminjaman.setKodeanggota(view.getTxtKodeAnggota().getText());
        peminjaman.setKodebuku(view.getTxtKodeBuku().getText());
        peminjaman.setTglpinjam(view.getTxtTanggalPinjam().getText());
        peminjaman.setTglkembali(view.getTxtTanggalKembali().getText());
        dao.insert(peminjaman);
        JOptionPane.showMessageDialog(view,"Entri Data OK");
    }
    
    public void getPeminjaman(){
        int index = view.getTabelPeminjaman().getSelectedRow();
        peminjaman = dao.getPeminjaman(index);
        view.getTxtKodeAnggota().setText(peminjaman.getKodeanggota());
        view.getTxtKodeBuku().setText(peminjaman.getKodebuku());
        view.getTxtTanggalPinjam().setText(peminjaman.getTglpinjam());
        view.getTxtTanggalKembali().setText(peminjaman.getTglkembali());
    }
    
     public void update(){
        int index = view.getTabelPeminjaman().getSelectedRow();
        peminjaman = new Peminjaman();
        peminjaman.setKodeanggota(view.getTxtKodeAnggota().getText());
        peminjaman.setKodebuku(view.getTxtKodeBuku().getText());
        peminjaman.setTglpinjam(view.getTxtTanggalPinjam().getText());
        peminjaman.setTglkembali(view.getTxtTanggalKembali().getText());
        dao.update(index,peminjaman);
        JOptionPane.showMessageDialog(view,"Update Data OK");
    }
     
     public void delete(){
        int index = view.getTabelPeminjaman().getSelectedRow();
        dao.delete(index);
        JOptionPane.showMessageDialog(view,"Delete Data OK");
       
     }
}

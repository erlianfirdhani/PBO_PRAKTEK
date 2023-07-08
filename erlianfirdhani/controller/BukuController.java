/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package andre.controller;

import erlian.dao.*;
import erlian.model.*;
import erlian.view.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author erlianfirdhani
 */
public class BukuController {
    FormBuku view;
    Buku buku;
    BukuDao dao;
    
    public BukuController(FormBuku view) {
        this.view = view;
        dao = new BukuDaoImpl();
    }
    
    public void clearForm(){
        view.getTxtKodeBuku().setText("");
        view.getTxtJudul().setText("");
        view.getTxtPengarang().setText("");
        view.getTxtPenerbit().setText("");
        
    }
    
    public void tampil() {
        DefaultTableModel tabelModel = (DefaultTableModel) view.getTabelBuku().getModel();
        tabelModel.setRowCount(0);
        List<Buku> list = dao.getAll();
        for (Buku a : list) {
            Object[] row = {
                a.getKodeBuku(),
                a.getJudul(),
                a.getPengarang(),
                a.getPenerbit()
            };
            tabelModel.addRow(row);
        }
    }
    
    public void insert(){
        buku = new Buku();
        buku.setKodeBuku(view.getTxtKodeBuku().getText());
        buku.setJudul(view.getTxtJudul().getText());
        buku.setPengarang(view.getTxtPengarang().getText());
        buku.setPenerbit(view.getTxtPenerbit().getText());
        dao.insert(buku);
        JOptionPane.showMessageDialog(view,"Entri Data OK");
    }
    
    public void getBuku(){
        int index = view.getTabelBuku().getSelectedRow();
        buku = dao.getBuku(index);
        view.getTxtKodeBuku().setText(buku.getKodeBuku());
        view.getTxtJudul().setText(buku.getJudul());
        view.getTxtPengarang().setText(buku.getPengarang());
        view.getTxtPenerbit().setText(buku.getPenerbit());
    }
    
     public void update(){
        int index = view.getTabelBuku().getSelectedRow();
        buku = new Buku();
        buku.setKodeBuku(view.getTxtKodeBuku().getText());
        buku.setJudul(view.getTxtJudul().getText());
        buku.setPengarang(view.getTxtPengarang().getText());
        buku.setPenerbit(view.getTxtPenerbit().getText());
        dao.insert(buku);
        JOptionPane.showMessageDialog(view,"Update Data OK");
    }
     
     public void delete(){
        int index = view.getTabelBuku().getSelectedRow();
        dao.delete(index);
        JOptionPane.showMessageDialog(view,"Delete Data OK");
       
     }
}

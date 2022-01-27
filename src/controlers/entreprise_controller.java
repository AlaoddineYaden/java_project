package controlers;
import views.MainForme;
import models.entreprise;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import databaseConn.*;
import models.employer;
public class entreprise_controller implements ActionListener{
	MainForme f2,f;
	ConnDB condb = new ConnDB();
	public ResultSet rs;
	String dt;
	public entreprise_controller(MainForme f2) {
		this.f2 = f2;
		f2.getMdf1().setEnabled(false);
	}
	public ResultSet afficheEntreprise() {
		try {
		       String request = "select * from entreprise;";
		       Statement smt = condb.con.createStatement() ;
		       rs = smt.executeQuery(request);
		}
		catch(Exception e){
			System.out.println(e);
		} 
		return rs;
	}
	public void ajouteEntreprise(String id, String sec, String nom) {
		try {
		       String request = "insert into entreprise values ("+ id +" , '"+ sec +"' ,'"+ nom +"' );";
		       Statement smt = condb.con.createStatement() ;
		       smt.execute(request);
		}
		catch(Exception e){
			System.out.println(e);
		} 
		
	}
	public void modifierEntreprise(String id, String sec, String nom) {
		try {
		       String request = "update  entreprise set SECTEUR = '"
		    		   + sec +"' , NOM_ENTREPRISE = '"+ nom +"' where ID_ENTREPRISE = '" + id+"' ;";
		       Statement smt = condb.con.createStatement() ;
		       smt.executeUpdate(request);
		}
		catch(Exception e){
			System.out.println(e);
		} 
	}
	public String getSelectedCol(JTable jt) {
		
        jt.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                String selectedCellValue = (String) jt.getValueAt(jt.getSelectedRow() ,0);
                System.out.println(selectedCellValue);
                dt = selectedCellValue;
                f2.getMdf1().setEnabled(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        return dt;
	}
	public entreprise getEntrepriseById(String dt) {
		entreprise entreprise = null;
		try {
		       String request = "select * from entreprise where ID_ENTREPRISE =  '"+ dt +"' ;";
		       Statement smt = condb.con.createStatement() ;
		       rs = smt.executeQuery(request);
	            while (rs.next()) {
	              	 int ID_ENTREPRISE = rs.getInt("ID_ENTREPRISE");
	                 String SECTEUR = rs.getString("SECTEUR");
	                 String NOM_ENTREPRISE = rs.getString("NOM_ENTREPRISE");
	                 entreprise = new entreprise(ID_ENTREPRISE,SECTEUR,NOM_ENTREPRISE);
	            }
		}
		catch(Exception e){
			System.out.println(e);
		} 
		return entreprise;
	}
	public void addContentFrame() {
		try {
   		 ResultSet res = afficheEntreprise();
   		 String columns[] = { "Id Entreprise","Nom Entreprise","Secteur" };
            String data[][] = new String[40][3];
            int i = 0;
            while (res.next()) {
           	 int ID_ENTREPRISE = res.getInt("ID_ENTREPRISE");
              String SECTEUR = res.getString("SECTEUR");
              String NOM_ENTREPRISE = res.getString("NOM_ENTREPRISE");
              data[i][0] = ID_ENTREPRISE+"" ;
              data[i][1] = SECTEUR;
              data[i][2] = NOM_ENTREPRISE;
              i++;
            }
            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable jt = new JTable(model);
            jt.setShowGrid(true);
            jt.setShowVerticalLines(true);
            JScrollPane sp = new JScrollPane(jt);
            jt.setBounds(30,40,200,300); 
            f2.getF().remove(f2.getPane3());
            f2.getF().getContentPane().removeAll();
            jt.setDefaultEditor(Object.class, null);
            dt = getSelectedCol(jt);
		    f2.getPane3().add(f2.getAjt1());
		    f2.getPane3().add(f2.getMdf1());
		    f2.getPane3().add(sp);
		    f2.getF().setContentPane(f2.getPane3());
		    f2.getF().setSize(490,400);
		    f2.getAjt1().addActionListener(this);
		    f2.getMdf1().addActionListener(this);
		    f2.getF().setVisible(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == f2.getEntreprise()) {  
			addContentFrame();
		}
		if(event.getSource() == f2.getAjt1()) {
			f2.getPane4().add(f2.getId_en());
			f2.getPane4().add(f2.getId_en_text());
			f2.getPane4().add(f2.getNom_en());
			f2.getPane4().add(f2.getNom_en_text());
			f2.getPane4().add(f2.getSecteur());
			f2.getPane4().add(f2.getSecteur_text());
			f2.getId_en_text().setText("");
			f2.getSecteur_text().setText("");
			f2.getNom_en_text().setText("");
			f2.getId_en_text().setEditable(true);
			f2.getPane4().add(f2.getConf());
			f2.getConf().addActionListener(this);
			f2.getDj1().getContentPane().add(f2.getPane4() , BorderLayout.CENTER);
			f2.getDj1().setSize(470,400);
			f2.getF().dispose();
			f2.getDj1().setVisible(true);
		}
		if(event.getSource() == f2.getMdf1()) {
			entreprise entreprise = getEntrepriseById(dt);
			f2.getId_en_text().setText(String.valueOf(entreprise.getIdEntreprise()));
			f2.getSecteur_text().setText(entreprise.getSecteur());
			f2.getNom_en_text().setText(entreprise.getNomEntreprise());
			f2.getId_en_text().setEditable(false);
			f2.getPane7().add(f2.getId_en());
			f2.getPane7().add(f2.getId_en_text());
			f2.getPane7().add(f2.getNom_en());
			f2.getPane7().add(f2.getNom_en_text());
			f2.getPane7().add(f2.getSecteur());
			f2.getPane7().add(f2.getSecteur_text());
			f2.getPane7().add(f2.getConf1());
			f2.getConf1().addActionListener(this);
			f2.getDj2().getContentPane().add(f2.getPane7() , BorderLayout.CENTER);
			f2.getDj2().setSize(470,400);
			f2.getF().dispose();
			f2.getDj2().setVisible(true);
		}
		if(event.getSource() == f2.getConf()) {
			if(f2.getId_en_text().getText().isEmpty() || f2.getNom_en_text().getText().isEmpty() 
					|| f2.getSecteur_text().getText().isEmpty() ) {
				 JOptionPane.showMessageDialog(null, "un champ est vide");
			}
			else {
				ajouteEntreprise(f2.getId_en_text().getText(),f2.getSecteur_text().getText(), f2.getNom_en_text().getText());
				f2.getId_en_text().setText("");
				f2.getSecteur_text().setText("");
				f2.getNom_en_text().setText("");
				addContentFrame();
			}	
		}
		if(event.getSource() == f2.getConf1()) {
			if(f2.getId_en_text().getText().isEmpty() || f2.getNom_en_text().getText().isEmpty() 
					|| f2.getSecteur_text().getText().isEmpty() ) {
				 JOptionPane.showMessageDialog(null, "un champ est vide");
			}
			else {
				modifierEntreprise(f2.getId_en_text().getText(),f2.getSecteur_text().getText(), f2.getNom_en_text().getText());
				addContentFrame();
				f2.getDj2().setVisible(false);
				f2.getMdf1().setEnabled(false);
			}
			
		}
	}

}

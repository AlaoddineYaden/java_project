package controlers;
import java.awt.BorderLayout;
import models.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import databaseConn.ConnDB;
import views.MainForme;
public class service_controller implements ActionListener{
	MainForme f;
	ConnDB condb = new ConnDB();
	String dt;
	public ResultSet rs;
	public service_controller(MainForme f3) {
		this.f = f3;
		f.getMdf3().setEnabled(false);
	}
	public ResultSet afficheService() {
		try {
		       String request = "select * from service;";
		       Statement smt = condb.con.createStatement() ;
		       rs = smt.executeQuery(request);
		}
		catch(Exception e){
			System.out.println(e);
		} 
		return rs;
		
	}
	public void ajouteService(String Id, String Nom, String Effectif) {
		try {
			   String request = "insert into service values ("+ 
					   Id +" , '"+ Nom +"' ,'"+ Effectif +"' );";
		       Statement smt = condb.con.createStatement() ;
		       smt.execute(request);
		}
		catch(Exception e){
			System.out.println(e);
		} 
	}
	public void modifierService(String Id, String Nom, String Effectif) {
		try {
		       String request = "update  service set Nom = '"
		    		   + Nom +"' , Effectif = '"+ Effectif +"' where Id = '" + Id+"' ;";
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
                f.getMdf3().setEnabled(true);
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
	public service getServiceById(String dt) {
		service ser = new service();
		try {
		       String request = "select * from service where Id =  '"+ dt +"' ;";
		       Statement smt = condb.con.createStatement() ;
		       rs = smt.executeQuery(request);
		       int i = 0;
	            while (rs.next()) {
	           	 int Id = rs.getInt("Id");
	              String Nom = rs.getString("Nom");
	              float Effectif = rs.getFloat("Effectif");
	              ser.setEffectif(Effectif);
	              ser.setIdService(Id);
	              ser.setNomService(Nom);
	            }
		}
		catch(Exception e){
			System.out.println(e);
		} 
		return ser;
	}
	public void addContentFrameService() {
		try {
	   		 ResultSet res = afficheService();
	   		 String columns[] = {"Id","Nom","Effectif"};
	            String data[][] = new String[20][3];
	            int i = 0;
	            while (res.next()) {
	           	 int Id = res.getInt("Id");
	              String Nom = res.getString("Nom");
	              float Effectif = res.getFloat("Effectif");
	              data[i][0] = Id+"" ;
	              data[i][1] = Nom;
	              data[i][2] = Effectif+"";
	              i++;
	            }
	            DefaultTableModel model = new DefaultTableModel(data, columns);
	            JTable jt = new JTable(model);
	            jt.setShowGrid(true);
	            jt.setShowVerticalLines(true);
	            JScrollPane sp = new JScrollPane(jt);
	            jt.setBounds(30,40,200,300);
	            //not editable
	            jt.setDefaultEditor(Object.class, null);
	            //
	            dt = getSelectedCol(jt);
	            f.getF2().remove(f.getPane0());
	            f.getF2().getContentPane().removeAll();
			    f.getPane0().add(f.getAjt3());
			    f.getPane0().add(f.getMdf3());
			    f.getPane0().add(sp);
			    f.getF2().setContentPane(f.getPane0());
			    f.getF2().setSize(470,400);
			    f.getAjt3().addActionListener(this);
			    f.getMdf3().addActionListener(this);
			    f.getF2().setVisible(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == f.getService()) {
			addContentFrameService();
		}
		if(event.getSource() == f.getAjt3()) {
			f.getPane6().add(f.getId_s());
			f.getPane6().add(f.getId_text());
			f.getPane6().add(f.getNom());
			f.getId_text().setText("");
			f.getNom_text().setText("");
			f.getEff_text().setText("");
			f.getId_text().setEditable(true);
			f.getPane6().add(f.getNom_text());
			f.getPane6().add(f.getEffectif());
			f.getPane6().add(f.getEff_text());
			f.getPane6().add(f.getConf3());
			f.getConf3().addActionListener(this);
			f.getDj_se1().getContentPane().add(f.getPane6() , BorderLayout.CENTER);
			f.getDj_se1().setSize(470,400);
			f.getF2().dispose();
			f.getDj_se1().setVisible(true);
		}
		if(event.getSource() == f.getMdf3()) {
			service ser = getServiceById(dt);
			f.getId_text().setText(String.valueOf(ser.getIdService()));
			f.getNom_text().setText(ser.getNomService());
			f.getEff_text().setText(String.valueOf(ser.getEffectif()));
			f.getId_text().setEditable(false);
			f.getPane9().add(f.getId_s());
			f.getPane9().add(f.getId_text());
			f.getPane9().add(f.getNom());
			f.getPane9().add(f.getNom_text());
			f.getPane9().add(f.getEffectif());
			f.getPane9().add(f.getEff_text());
			f.getPane9().add(f.getConf31());
			f.getConf31().addActionListener(this);
			f.getDj_se2().getContentPane().add(f.getPane9() , BorderLayout.CENTER);
			f.getDj_se2().setSize(470,400);
			f.getF2().dispose();
			f.getDj_se2().setVisible(true);
		}
		if(event.getSource() == f.getConf3()) {
			if(f.getId_text().getText().isEmpty() || f.getNom_text().getText().isEmpty() || 
					f.getEff_text().getText().isEmpty()) {
				 JOptionPane.showMessageDialog(null, "un champ est vide");
			}
			else {
				ajouteService(f.getId_text().getText(),f.getNom_text().getText(), 
						f.getEff_text().getText());
				addContentFrameService();
				f.getId_text().setText("");
				f.getNom_text().setText("");
				f.getEff_text().setText("");
			}
			
		}
		if(event.getSource() == f.getConf31()) {
			if(f.getId_text().getText().isEmpty() || f.getNom_text().getText().isEmpty() || 
					f.getEff_text().getText().isEmpty()) {
				 JOptionPane.showMessageDialog(null, "un champ est vide");
			}
			else {
				modifierService(f.getId_text().getText(),f.getNom_text().getText(), 
						f.getEff_text().getText());
				addContentFrameService();
				f.getDj_se2().setVisible(false);
				f.getMdf3().setEnabled(false);
			}
			
		}
		
	}

}

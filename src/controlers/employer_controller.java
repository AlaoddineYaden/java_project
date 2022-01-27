package controlers;

import java.awt.BorderLayout;
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
import models.service;
import views.MainForme;
import models.employer;
public class employer_controller  implements ActionListener{
	MainForme f;
	String dt;
	public ResultSet rs;
	ConnDB condb = new ConnDB();
	public employer_controller(MainForme f) {
		this.f = f;
		f.getMdf2().setEnabled(false);
	}
	public ResultSet afficheEmployer() {
		try {
		       String request = "select * from employer;";
		       Statement smt = condb.con.createStatement() ;
		       rs = smt.executeQuery(request);
		}
		catch(Exception e){
			System.out.println(e);
		} 
		return rs;
		
	}
	public void ajouteEmployer(String ID_EMPLOYER, String ID_SERVICE, String NOM_EMPLOYER, String PRENOM, String SALAIRE ) {
		try {
		       String request = "insert into employer values ("+ ID_EMPLOYER +" , '"+ ID_SERVICE +"' ,'"+ NOM_EMPLOYER +"' ,'"
		    		   											+ PRENOM +"' ,'"+ SALAIRE +"' );";
		       Statement smt = condb.con.createStatement() ;
		       smt.execute(request);
		}
		catch(Exception e){
			System.out.println(e);
		} 
	}
	public void modifierEmployer(String ID_EMPLOYER, String ID_SERVICE, String NOM_EMPLOYER, String PRENOM, String SALAIRE) {
		try {
		       String request = "update  employer set ID_SERVICE = '"
		    		   + ID_SERVICE +"' , NOM_EMPLOYER = '"+ NOM_EMPLOYER
		    		   +"' , PRENOM = '"+ PRENOM +"' , SALAIRE = '"+ SALAIRE +"' where ID_EMPLOYER = '" + ID_EMPLOYER+"' ;";
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
                f.getMdf2().setEnabled(true);
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
	public employer getEmployerById(String dt) {
		employer employer = null;
		try {
		       String request = "select * from employer where ID_EMPLOYER =  '"+ dt +"' ;";
		       Statement smt = condb.con.createStatement() ;
		       rs = smt.executeQuery(request);
	            while (rs.next()) {
	            	int ID_EMPLOYER = rs.getInt("ID_EMPLOYER");
	              	int ID_SERVICE = rs.getInt("ID_SERVICE");
	                String NOM_EMPLOYER = rs.getString("NOM_EMPLOYER");
	                String PRENOM = rs.getString("PRENOM");
	                float  SALAIRE = rs.getFloat("SALAIRE");
	                employer = new employer( ID_EMPLOYER, ID_SERVICE, NOM_EMPLOYER, PRENOM, SALAIRE );
	            }
		}
		catch(Exception e){
			System.out.println(e);
		} 
		return employer;
	}
	public void addContentFrameEm() {
		try {
   		 	ResultSet res = afficheEmployer();
   		 	String columns[] = {"Id Employer","Id Service","Nom Employer","Prenom","Salaire"};
            String data[][] = new String[20][5];
            int i = 0;
            while (res.next()) {
           	int ID_EMPLOYER = res.getInt("ID_EMPLOYER");
            int ID_SERVICE = res.getInt("ID_SERVICE");
            String NOM_EMPLOYER = res.getString("NOM_EMPLOYER");
            String PRENOM = res.getString("PRENOM");
            float  SALAIRE = res.getFloat("SALAIRE");
            data[i][0] = ID_EMPLOYER+"" ;
            data[i][1] = ID_SERVICE+"" ;
            data[i][2] = NOM_EMPLOYER;
            data[i][3] = PRENOM;
            data[i][4] = SALAIRE+"";
              i++;
            }
            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable jt = new JTable(model);
            jt.setShowGrid(true);
            jt.setShowVerticalLines(true);
            JScrollPane sp = new JScrollPane(jt);
            jt.setBounds(30,40,200,300); 
            f.getF3().remove(f.getPane2());
            f.getF3().getContentPane().removeAll();
            jt.setDefaultEditor(Object.class, null);
            dt = getSelectedCol(jt);
		    f.getPane2().add(f.getAjt2());
		    f.getPane2().add(f.getMdf2());
		    f.getPane2().add(sp);
		    f.getF3().setContentPane(f.getPane2());
		    f.getF3().setSize(490,400);
		    f.getAjt2().addActionListener(this);
		    f.getMdf2().addActionListener(this);
		    f.getF3().setVisible(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == f.getEmployer()) {
			addContentFrameEm();
		}
		if(event.getSource() == f.getAjt2()) {
			f.getPane5().add(f.getId_em());
			f.getPane5().add(f.getId_em_text());
			f.getPane5().add(f.getId_ser_emp());
			f.getPane5().add(f.getId_ser_emp_text());
			f.getPane5().add(f.getNom_em());
			f.getPane5().add(f.getNom_em_text());
			f.getPane5().add(f.getPrenom());
			f.getPane5().add(f.getPrenom_text());
			f.getPane5().add(f.getSalaire());
			f.getPane5().add(f.getSalaire_text());
			f.getId_em_text().setText("");
			f.getId_ser_emp_text().setText("");
			f.getNom_em_text().setText("");
			f.getPrenom_text().setText("");
			f.getSalaire_text().setText("");
			f.getId_em_text().setEditable(true);
			f.getPane5().add(f.getConf2());
			f.getConf2().addActionListener(this);
			f.getDj_em1().getContentPane().add(f.getPane5() , BorderLayout.CENTER);
			f.getDj_em1().setSize(470,400);
			f.getF3().dispose();
			f.getDj_em1().setVisible(true);
		}
		if(event.getSource() == f.getMdf2()) {
			employer employer = getEmployerById(dt);
			f.getId_em_text().setText(String.valueOf(employer.getIdEmployer()));
			f.getId_ser_emp_text().setText(String.valueOf(employer.getIdservice()));
			f.getNom_em_text().setText(employer.getNomEmployer());
			f.getPrenom_text().setText(employer.getPrenom());
			f.getSalaire_text().setText(String.valueOf(employer.getSalaire()));
			f.getId_em_text().setEditable(false);
			f.getPane8().add(f.getId_em());
			f.getPane8().add(f.getId_em_text());
			f.getPane8().add(f.getId_ser_emp());
			f.getPane8().add(f.getId_ser_emp_text());
			f.getPane8().add(f.getNom_em());
			f.getPane8().add(f.getNom_em_text());
			f.getPane8().add(f.getPrenom());
			f.getPane8().add(f.getPrenom_text());
			f.getPane8().add(f.getSalaire());
			f.getPane8().add(f.getSalaire_text());
			f.getPane8().add(f.getConf21());
			f.getConf21().addActionListener(this);
			f.getDj_em2().getContentPane().add(f.getPane8() , BorderLayout.CENTER);
			f.getDj_em2().setSize(470,400);
			f.getF3().dispose();
			f.getDj_em2().setVisible(true);
		}
		if(event.getSource() == f.getConf2()) {
			if(f.getId_em_text().getText().isEmpty() || f.getId_ser_emp_text().getText().isEmpty() || 
					f.getNom_em_text().getText().isEmpty() || f.getPrenom_text().getText().isEmpty()|| 
					f.getSalaire_text().getText().isEmpty()) {
				 	JOptionPane.showMessageDialog(null, "un champ est vide");
			}
			else {
				ajouteEmployer(f.getId_em_text().getText(),f.getId_ser_emp_text().getText(), 
						f.getNom_em_text().getText(), f.getPrenom_text().getText(), f.getSalaire_text().getText());
				addContentFrameEm();
				f.getId_em_text().setText("");
				f.getId_ser_emp_text().setText("");
				f.getNom_em_text().setText("");
				f.getPrenom_text().setText("");
				f.getSalaire_text().setText("");
			}	
		}
		if(event.getSource() == f.getConf21()) {
			if(f.getId_em_text().getText().isEmpty() || f.getId_ser_emp_text().getText().isEmpty() || 
					f.getNom_em_text().getText().isEmpty() || f.getPrenom_text().getText().isEmpty()|| 
					f.getSalaire_text().getText().isEmpty()) {
				 	JOptionPane.showMessageDialog(null, "un champ est vide");
			}
			else {
				modifierEmployer(f.getId_em_text().getText(),f.getId_ser_emp_text().getText(), 
						f.getNom_em_text().getText(), f.getPrenom_text().getText(), f.getSalaire_text().getText());
				addContentFrameEm();
				f.getDj_em2().setVisible(false);
				f.getMdf2().setEnabled(false);
			}
			
		}
	}

}

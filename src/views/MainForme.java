package views;
import java.awt.*;
import javax.swing.*;

import controlers.employer_controller;
import controlers.entreprise_controller;
import controlers.service_controller;
 
public class MainForme extends JFrame{
	JPanel pane3 = new JPanel();
	JPanel pane2 = new JPanel();
	JPanel pane0 = new JPanel();
	JPanel pane1= new JPanel();
	JPanel pane4  = new JPanel();
	JPanel pane5  = new JPanel();
	JPanel pane6  = new JPanel();
	JPanel pane7  = new JPanel();
	JPanel pane  = new JPanel();
	JButton ajt1 = new JButton("Ajouter"),
			mdf1 = new JButton("Modifier"),
			ajt2 = new JButton("Ajouter"),
			mdf2 = new JButton("Modifier"),
			ajt3 = new JButton("Ajouter"),
			mdf3 = new JButton("Modifier");
	JMenuBar mb = new JMenuBar(); 
	JMenu items = new JMenu("Items");
	JMenuItem service=new JMenuItem("Service"),
				employer =new JMenuItem("Employer"),
				entreprise=new JMenuItem("Entreprise"); 
	JFrame frame = new JFrame("java project");
	JFrame f=new JFrame("entreprise");
	JFrame f2=new JFrame("service");
	JFrame f3=new JFrame("employer");
	JDialog dj1 = new JDialog(f , "Dialog entreprise");
	JDialog dj2 = new JDialog(f , "Dialog entreprise");
	JDialog dj_se1 = new JDialog(f2 , "Dialog service");
	JDialog dj_se2 = new JDialog(f2 , "Dialog service");
	JDialog dj_em1 = new JDialog(f3 , "Dialog employer");
	JDialog dj_em2 = new JDialog(f3 , "Dialog employer");
	JLabel id_s = new JLabel("Id");
	JLabel nom = new JLabel("Nom");
	JLabel effectif = new JLabel("Effectif");
	JLabel id_en = new JLabel("Id Entreprise");
	JLabel nom_en = new JLabel("Nom");
	JLabel secteur = new JLabel("Secteur");
	JLabel nom_em = new JLabel("Nom Employer");
	JLabel id_ser_emp = new JLabel("Id Service");
	JLabel prenom = new JLabel("Prenom");
	JLabel salaire = new JLabel("Salaire");
	JLabel id_em = new JLabel("Id Employer");
	JTextField id_text = new JTextField(50);
	JTextField nom_text = new JTextField(50);
	JTextField eff_text = new JTextField(50);
	JTextField id_en_text = new JTextField(50);
	JTextField nom_en_text = new JTextField(50);
	JTextField secteur_text = new JTextField(50);
	JTextField nom_em_text = new JTextField(50);
	JTextField id_ser_emp_text = new JTextField(50);
	JTextField prenom_text = new JTextField(50);
	JTextField salaire_text = new JTextField(50);
	JTextField id_em_text = new JTextField(50);
	JButton conf = new JButton("Confirmer");
	JButton conf1 = new JButton("Confirmer");
	JButton conf2 = new JButton("Confirmer");
	JButton conf21 = new JButton("Confirmer");
	JButton conf3 = new JButton("Confirmer");
	JButton conf31 = new JButton("Confirmer");
	JPanel pane8  = new JPanel();
	JPanel pane9  = new JPanel();
	public JButton getConf1() {
		return conf1;
	}

	public void setConf1(JButton conf1) {
		this.conf1 = conf1;
	}

	public JButton getConf21() {
		return conf21;
	}

	public void setConf21(JButton conf21) {
		this.conf21 = conf21;
	}

	public JButton getConf31() {
		return conf31;
	}

	public void setConf31(JButton conf31) {
		this.conf31 = conf31;
	}

	public JLabel getId_en() {
		return id_en;
	}

	public void setId_en(JLabel id_en) {
		this.id_en = id_en;
	}

	public JLabel getNom_en() {
		return nom_en;
	}

	public void setNom_en(JLabel nom_en) {
		this.nom_en = nom_en;
	}

	public JLabel getSecteur() {
		return secteur;
	}

	public void setSecteur(JLabel secteur) {
		this.secteur = secteur;
	}

	public JLabel getNom_em() {
		return nom_em;
	}

	public void setNom_em(JLabel nom_em) {
		this.nom_em = nom_em;
	}

	public JLabel getId_ser_emp() {
		return id_ser_emp;
	}

	public void setId_ser_emp(JLabel id_ser_emp) {
		this.id_ser_emp = id_ser_emp;
	}

	public JLabel getPrenom() {
		return prenom;
	}

	public void setPrenom(JLabel prenom) {
		this.prenom = prenom;
	}

	public JLabel getSalaire() {
		return salaire;
	}

	public void setSalaire(JLabel salaire) {
		this.salaire = salaire;
	}

	public JLabel getId_em() {
		return id_em;
	}

	public void setId_em(JLabel id_em) {
		this.id_em = id_em;
	}

	public JTextField getId_en_text() {
		return id_en_text;
	}

	public void setId_en_text(JTextField id_en_text) {
		this.id_en_text = id_en_text;
	}

	public JTextField getNom_en_text() {
		return nom_en_text;
	}

	public void setNom_en_text(JTextField nom_en_text) {
		this.nom_en_text = nom_en_text;
	}

	public JTextField getSecteur_text() {
		return secteur_text;
	}

	public void setSecteur_text(JTextField secteur_text) {
		this.secteur_text = secteur_text;
	}

	public JTextField getNom_em_text() {
		return nom_em_text;
	}

	public void setNom_em_text(JTextField nom_em_text) {
		this.nom_em_text = nom_em_text;
	}

	public JTextField getId_ser_emp_text() {
		return id_ser_emp_text;
	}

	public void setId_ser_emp_text(JTextField id_ser_emp_text) {
		this.id_ser_emp_text = id_ser_emp_text;
	}

	public JTextField getPrenom_text() {
		return prenom_text;
	}

	public void setPrenom_text(JTextField prenom_text) {
		this.prenom_text = prenom_text;
	}

	public JTextField getSalaire_text() {
		return salaire_text;
	}

	public void setSalaire_text(JTextField salaire_text) {
		this.salaire_text = salaire_text;
	}

	public JTextField getId_em_text() {
		return id_em_text;
	}

	public void setId_em_text(JTextField id_em_text) {
		this.id_em_text = id_em_text;
	}
	public JButton getConf2() {
		return conf2;
	}

	public void setConf2(JButton conf2) {
		this.conf2 = conf2;
	}

	public JButton getConf3() {
		return conf3;
	}

	public void setConf3(JButton conf3) {
		this.conf3 = conf3;
	}

	public JPanel getPane8() {
		return pane8;
	}

	public void setPane8(JPanel pane8) {
		this.pane8 = pane8;
	}

	public JPanel getPane9() {
		return pane9;
	}

	public void setPane9(JPanel pane9) {
		this.pane9 = pane9;
	}

	public JPanel getPane7() {
		return pane7;
	}

	public void setPane7(JPanel pane7) {
		this.pane7 = pane7;
	}

	public JPanel getPane6() {
		return pane6;
	}

	public void setPane6(JPanel pane6) {
		this.pane6 = pane6;
	}

	public JPanel getPane4() {
		return pane4;
	}

	public void setPane4(JPanel pane4) {
		this.pane4 = pane4;
	}

	public JPanel getPane5() {
		return pane5;
	}

	public void setPane5(JPanel pane5) {
		this.pane5 = pane5;
	}

	public JFrame getF2() {
		return f2;
	}

	public void setF2(JFrame f2) {
		this.f2 = f2;
	}

	public JFrame getF3() {
		return f3;
	}

	public void setF3(JFrame f3) {
		this.f3 = f3;
	}

	public JPanel getPane2() {
		return pane2;
	}

	public JDialog getDj1() {
		return dj1;
	}

	public void setDj1(JDialog dj1) {
		this.dj1 = dj1;
	}

	public JDialog getDj2() {
		return dj2;
	}

	public void setDj2(JDialog dj2) {
		this.dj2 = dj2;
	}

	public JDialog getDj_se1() {
		return dj_se1;
	}

	public void setDj_se1(JDialog dj_se1) {
		this.dj_se1 = dj_se1;
	}

	public JDialog getDj_se2() {
		return dj_se2;
	}

	public void setDj_se2(JDialog dj_se2) {
		this.dj_se2 = dj_se2;
	}

	public JDialog getDj_em1() {
		return dj_em1;
	}

	public void setDj_em1(JDialog dj_em1) {
		this.dj_em1 = dj_em1;
	}

	public JDialog getDj_em2() {
		return dj_em2;
	}

	public void setDj_em2(JDialog dj_em2) {
		this.dj_em2 = dj_em2;
	}

	public void setPane2(JPanel pane2) {
		this.pane2 = pane2;
	}

	public JPanel getPane0() {
		return pane0;
	}

	public void setPane0(JPanel pane0) {
		this.pane0 = pane0;
	}

	public JButton getAjt2() {
		return ajt2;
	}

	public void setAjt2(JButton ajt2) {
		this.ajt2 = ajt2;
	}

	public JButton getMdf2() {
		return mdf2;
	}

	public void setMdf2(JButton mdf2) {
		this.mdf2 = mdf2;
	}

	public JButton getAjt3() {
		return ajt3;
	}

	public void setAjt3(JButton ajt3) {
		this.ajt3 = ajt3;
	}

	public JButton getMdf3() {
		return mdf3;
	}

	public void setMdf3(JButton mdf3) {
		this.mdf3 = mdf3;
	}
	public JPanel getPane3() {
		return pane3;
	}

	public void setPane3(JPanel pane3) {
		this.pane3 = pane3;
	}

	public JButton getAjt1() {
		return ajt1;
	}

	public void setAjt1(JButton ajt1) {
		this.ajt1 = ajt1;
	}

	public JButton getMdf1() {
		return mdf1;
	}

	public void setMdf1(JButton mdf1) {
		this.mdf1 = mdf1;
	}

	public JPanel getPane1() {
		return pane1;
	}

	public void setPane1(JPanel pane1) {
		this.pane1 = pane1;
	}

	public JFrame getF() {
		return f;
	}

	public void setF(JFrame f) {
		this.f = f;
	}



	public JPanel getPane() {
		return pane;
	}

	public void setPane(JPanel pane) {
		this.pane = pane;
	}

	public JMenuBar getMb() {
		return mb;
	}

	public void setMb(JMenuBar mb) {
		this.mb = mb;
	}

	public JMenu getItems() {
		return items;
	}

	public void setItems(JMenu items) {
		this.items = items;
	}

	public JMenuItem getService() {
		return service;
	}

	public void setService(JMenuItem service) {
		this.service = service;
	}

	public JMenuItem getEmployer() {
		return employer;
	}

	public void setEmployer(JMenuItem employer) {
		this.employer = employer;
	}

	public JMenuItem getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(JMenuItem entreprise) {
		this.entreprise = entreprise;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getId_s() {
		return id_s;
	}

	public void setId_s(JLabel id_s) {
		this.id_s = id_s;
	}

	public JLabel getNom() {
		return nom;
	}

	public void setNom(JLabel nom) {
		this.nom = nom;
	}

	public JLabel getEffectif() {
		return effectif;
	}

	public void setEffectif(JLabel effectif) {
		this.effectif = effectif;
	}

	public JTextField getId_text() {
		return id_text;
	}

	public void setId_text(JTextField id_text) {
		this.id_text = id_text;
	}

	public JTextField getNom_text() {
		return nom_text;
	}

	public void setNom_text(JTextField nom_text) {
		this.nom_text = nom_text;
	}

	public JTextField getEff_text() {
		return eff_text;
	}

	public void setEff_text(JTextField eff_text) {
		this.eff_text = eff_text;
	}

	public JButton getConf() {
		return conf;
	}

	public void setConf(JButton conf) {
		this.conf = conf;
	}
	public MainForme() {
		service.addActionListener(new service_controller(this));
		employer.addActionListener(new employer_controller(this));
		entreprise.addActionListener(new entreprise_controller(this));
		items.add(service);
		items.add(employer);
		items.add(entreprise);
		mb.add(items);
		frame.setJMenuBar(mb);
		frame.getContentPane().add(pane, BorderLayout.CENTER);
		frame.setSize(470,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	}
	public static void main(String[] args) {
		new MainForme();
		
	}

}

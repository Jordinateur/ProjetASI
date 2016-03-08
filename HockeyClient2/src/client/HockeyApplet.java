package client;

import hs.ejb.TribuneFacade;
import hs.entity.Equipe;
import hs.entity.Gardien;
import hs.entity.MatchHockey;
import hs.entity.Record;
import hs.entity.ZonesBut;
import hs.entity.ZonesTerrain;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jboss.sasl.JBossSaslProvider;

import utilities.EquipeUtility;
import utilities.GardienUtility;
import utilities.MatchUtility;
import utilities.RecordUtility;
import utilities.TribuneUtility;

@SuppressWarnings("serial")
public class HockeyApplet extends JApplet {
	private JTextField passField;
	private JTextField loginField;
	private JPanel panel_wrapper;
	private JPanel panel_1;
	private JPanel panel_2;
	private JList<Equipe> listEquipe;
	private Panel panel_3;
	private Panel panel_4;
	private Panel panel_5;
	private JButton btnBut;
	private JButton btnManque;
	private Record r;
	private ZonesTerrain ztmn;
	private ZonesTerrain ztmr;
	private ZonesBut zbmn;
	private ZonesBut zbmr;
	
	static {
		Security.addProvider(new JBossSaslProvider());
	}

	/**
	 * Create the applet.
	 */
	public HockeyApplet() {
		//getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel_wrapper = new JPanel();
		getContentPane().add(panel_wrapper);
		panel_wrapper.setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		panel_wrapper.add(panel, "name_174382275343371");

		JLabel lblNewLabel = new JLabel("Login");
		panel.add(lblNewLabel);

		loginField = new JTextField();
		panel.add(loginField);
		loginField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		panel.add(lblPassword);

		passField = new JTextField();
		panel.add(passField);
		passField.setColumns(10);

		JButton btnSeConnecter = new JButton("se connecter");
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loginField.getText().equals("user")
						&& passField.getText().equals("pass")) {
					CardLayout cl = (CardLayout) panel_wrapper.getLayout();
					cl.next(panel_wrapper);
				}
			}
		});
		panel.add(btnSeConnecter);

		panel_1 = new JPanel();
		panel_2 = new JPanel();
		panel_wrapper.add(panel_1, "name_174382287812009");
		panel_wrapper.add(panel_2, "name_15302219831616");
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new Panel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		panel_4 = new Panel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(6, 3, 1, 1));
		
		panel_5 = new Panel();
		panel_2.add(panel_5, BorderLayout.SOUTH);
		
		btnBut = new JButton("But");
		btnBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_5.add(btnBut);
		
		btnManque = new JButton("Manquer");
		panel_5.add(btnManque);
		

		JButton btnSelectionner = new JButton("Selectionner");
		panel_1.add(btnSelectionner);
		final JList<MatchHockey> listMatch = new JList<MatchHockey>();
		listMatch.setModel(MatchUtility.getListModel(MatchUtility.getAll()));
		listMatch.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_1.add(listMatch);

		listEquipe = new JList<Equipe>();
		listEquipe.setModel(EquipeUtility.getListModel(EquipeUtility.getAll()));
		listEquipe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_1.add(listEquipe);
		
		final JList<Gardien> listGardien = new JList<Gardien>();
		listGardien.setModel(GardienUtility.getListModel(GardienUtility.getAll()));
		listGardien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_1.add(listGardien);
		
		
		
		listMatch.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				@SuppressWarnings("unchecked")
				JList<MatchHockey> lsm = (JList<MatchHockey>) e.getSource();
				if (lsm.isSelectionEmpty())
					return;
				listEquipe.removeAll();
				int minIndex = lsm.getMinSelectionIndex();
				int maxIndex = lsm.getMaxSelectionIndex();
				for (int i = minIndex; i <= maxIndex; i++) {
					if (lsm.isSelectedIndex(i)) {
						MatchHockey selectedMatch = MatchUtility.getAll().get(i);
						ArrayList<Equipe> equipes = new ArrayList<Equipe>();
						equipes.add(MatchUtility.getEquipeAFrom(selectedMatch));
						equipes.add(MatchUtility.getEquipeBFrom(selectedMatch));
						System.out.println("Trouve"+equipes+selectedMatch.getEquipe1());
						listEquipe.setModel(EquipeUtility.getListModel(equipes));
					}
				}
			}
		});
		listEquipe.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				@SuppressWarnings("unchecked")
				JList<MatchHockey> lsm = (JList<MatchHockey>) e.getSource();
				if (lsm.isSelectionEmpty())
					return;
				listGardien.removeAll();
				int minIndex = lsm.getMinSelectionIndex();
				int maxIndex = lsm.getMaxSelectionIndex();
				for (int i = minIndex; i <= maxIndex; i++) {
					if (lsm.isSelectedIndex(i)) {
						Equipe selectedMatch = EquipeUtility.getAll().get(i);
						List<Gardien> gardiens = new ArrayList<Gardien>();
						gardiens.addAll(EquipeUtility.getGardiens(selectedMatch));
						listGardien.setModel(GardienUtility.getListModel(gardiens));
					}
				}
			}
		});
		
		
		btnSelectionner.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MatchHockey match = listMatch.getSelectedValue();
				Gardien gardien = listGardien.getSelectedValue();
				
				TribuneUtility.create(match, gardien);
				ztmn = TribuneUtility.getZtmn();
				ztmr = TribuneUtility.getZtmr();
				zbmn = TribuneUtility.getZbmn();
				zbmr = TribuneUtility.getZbmr();				
				CardLayout cl = (CardLayout) panel_wrapper.getLayout();
				cl.next(panel_wrapper);		
//				JLabel nomGardien = new JLabel("Gardien : "+gardien.getSurnom()+"-"+gardien.getNum()+ " ----------------- Match : ["+match.getEquipe1()+"] vs ["+match.getEquipe2()+"]");
				JLabel nomGardien = new JLabel("dsqjdo");
				panel_3.add(nomGardien);
				
				final JRadioButton btnZoneBut1 = new JRadioButton("Zone But 1");
				final JRadioButton btnZoneBut2 = new JRadioButton("Zone But 2");
				final JRadioButton btnZoneBut3 = new JRadioButton("Zone But 3");
				final JRadioButton btnZoneBut4 = new JRadioButton("Zone But 4");
				final JRadioButton btnZoneBut5 = new JRadioButton("Zone But 5");
				final JRadioButton btnZoneBut6 = new JRadioButton("Zone But 6");
				final JRadioButton btnZoneBut7 = new JRadioButton("Zone But 7");
				final JRadioButton btnZoneBut8 = new JRadioButton("Zone But 8");
				final JRadioButton btnZoneBut9 = new JRadioButton("Zone But 9");
				
				final ButtonGroup btnGpZoneBut = new ButtonGroup();
				btnGpZoneBut.add(btnZoneBut1);
				btnGpZoneBut.add(btnZoneBut2);
				btnGpZoneBut.add(btnZoneBut3);
				btnGpZoneBut.add(btnZoneBut4);
				btnGpZoneBut.add(btnZoneBut5);
				btnGpZoneBut.add(btnZoneBut6);
				btnGpZoneBut.add(btnZoneBut7);
				btnGpZoneBut.add(btnZoneBut8);
				btnGpZoneBut.add(btnZoneBut9);
				
				
				final JRadioButton btnZoneTerrain1 = new JRadioButton("Zone Terrain 1");
				final JRadioButton btnZoneTerrain2 = new JRadioButton("Zone Terrain 2");
				final JRadioButton btnZoneTerrain3 = new JRadioButton("Zone Terrain 3");
				final JRadioButton btnZoneTerrain4 = new JRadioButton("Zone Terrain 4");
				final JRadioButton btnZoneTerrain5 = new JRadioButton("Zone Terrain 5");
				final JRadioButton btnZoneTerrain6 = new JRadioButton("Zone Terrain 6");
				final JRadioButton btnZoneTerrain7 = new JRadioButton("Zone Terrain 7");
				final JRadioButton btnZoneTerrain8 = new JRadioButton("Zone Terrain 8");
				final JRadioButton btnZoneTerrain9 = new JRadioButton("Zone Terrain 9");
		
				final ButtonGroup btnGpZoneTerrain = new ButtonGroup();
				btnGpZoneTerrain.add(btnZoneTerrain1);
				btnGpZoneTerrain.add(btnZoneTerrain2);
				btnGpZoneTerrain.add(btnZoneTerrain3);
				btnGpZoneTerrain.add(btnZoneTerrain4);
				btnGpZoneTerrain.add(btnZoneTerrain5);
				btnGpZoneTerrain.add(btnZoneTerrain6);
				btnGpZoneTerrain.add(btnZoneTerrain7);
				btnGpZoneTerrain.add(btnZoneTerrain8);
				btnGpZoneTerrain.add(btnZoneTerrain9);
				
				panel_4.add(btnZoneBut1);
				panel_4.add(btnZoneBut2);
				panel_4.add(btnZoneBut3);
				panel_4.add(btnZoneBut4);
				panel_4.add(btnZoneBut5);
				panel_4.add(btnZoneBut6);
				panel_4.add(btnZoneBut7);
				panel_4.add(btnZoneBut8);
				panel_4.add(btnZoneBut9);
				
				
				
				panel_4.add(btnZoneTerrain1);
				panel_4.add(btnZoneTerrain2);
				panel_4.add(btnZoneTerrain3);
				panel_4.add(btnZoneTerrain4);
				panel_4.add(btnZoneTerrain5);
				panel_4.add(btnZoneTerrain6);
				panel_4.add(btnZoneTerrain7);
				panel_4.add(btnZoneTerrain8);
				panel_4.add(btnZoneTerrain9);
				
				
				btnBut.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						int zoneB = 0,zoneT = 0;
						if(btnGpZoneBut.getSelection().equals(btnZoneBut1.getModel())){
							zoneB = 1;
						}
						if(btnGpZoneBut.getSelection().equals(btnZoneBut2.getModel())){
							zoneB = 2;
						}
						if(btnGpZoneBut.getSelection().equals(btnZoneBut3.getModel())){
							zoneB = 3;
						}
						if(btnGpZoneBut.getSelection().equals(btnZoneBut4.getModel())){
							zoneB = 4;
						}
						if(btnGpZoneBut.getSelection().equals(btnZoneBut5.getModel())){
							zoneB = 5;
						}
						if(btnGpZoneBut.getSelection().equals(btnZoneBut6.getModel())){
							zoneB = 6;
						}
						if(btnGpZoneBut.getSelection().equals(btnZoneBut7.getModel())){
							zoneB = 7;
						}
						if(btnGpZoneBut.getSelection().equals(btnZoneBut8.getModel())){
							zoneB = 8;
						}
						if(btnGpZoneBut.getSelection().equals(btnZoneBut9.getModel())){
							zoneB = 9;
						}
						if(btnGpZoneTerrain.getSelection().equals(btnZoneTerrain1.getModel())){
							zoneT = 1;
						}
						if(btnGpZoneTerrain.getSelection().equals(btnZoneTerrain2.getModel())){
							zoneT = 2;
						}
						if(btnGpZoneTerrain.getSelection().equals(btnZoneTerrain3.getModel())){
							zoneT = 3;
						}
						if(btnGpZoneTerrain.getSelection().equals(btnZoneTerrain4.getModel())){
							zoneT = 4;
						}
						if(btnGpZoneTerrain.getSelection().equals(btnZoneTerrain5.getModel())){
							zoneT = 5;
						}
						if(btnGpZoneTerrain.getSelection().equals(btnZoneTerrain6.getModel())){
							zoneT = 6;
						}
						if(btnGpZoneTerrain.getSelection().equals(btnZoneTerrain7.getModel())){
							zoneT = 7;
						}
						if(btnGpZoneTerrain.getSelection().equals(btnZoneTerrain8.getModel())){
							zoneT = 8;
						}
						if(btnGpZoneTerrain.getSelection().equals(btnZoneTerrain9.getModel())){
							zoneT = 9;
						}
						TribuneUtility.addScore(zoneT, zoneB);
						TribuneUtility.update();
					}
				});
			}
		});

		
	}

}

package client;

import hs.entity.Equipe;
import hs.entity.Gardien;
import hs.entity.MatchHockey;
import hs.entity.Record;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jboss.sasl.JBossSaslProvider;

import utilities.EquipeUtility;
import utilities.GardienUtility;
import utilities.MatchUtility;
import utilities.RecordUtility;

@SuppressWarnings("serial")
public class HockeyApplet extends JApplet {
	private JTextField passField;
	private JTextField loginField;
	private JPanel panel_wrapper;
	private JPanel panel_1;
	private JList<Equipe> listEquipe;
	static {
		Security.addProvider(new JBossSaslProvider());
	}

	/**
	 * Create the applet.
	 */
	public HockeyApplet() {
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

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
		panel_wrapper.add(panel_1, "name_174382287812009");

		JButton btnSelectionner = new JButton("Selectionner");
		panel_1.add(btnSelectionner);
		final JList<MatchHockey> listMatch = new JList<MatchHockey>(MatchUtility.getAll());
		listMatch.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_1.add(listMatch);

		listEquipe = new JList<Equipe>(EquipeUtility.getAll());
		listEquipe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_1.add(listEquipe);
		
		final JList<Gardien> listGardien = new JList<Gardien>(GardienUtility.getAll());
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
						MatchHockey selectedMatch = MatchUtility.getAll()[i];
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
						Equipe selectedMatch = EquipeUtility.getAll()[i];
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
				
				
				
				Record r = RecordUtility.getRecordByMatchGardien(match, gardien);
				System.out.println(r);
				if(r == null){
					r = new Record();
					r.setGardien(gardien);
					r.setMatch(match);
				}
				JPanel panel_2 = new JPanel();
				panel_wrapper.add(panel_2, "name_174382287812010");
				CardLayout cl = (CardLayout) panel_wrapper.getLayout();
				cl.next(panel_wrapper);				
				JLabel nomGardien = new JLabel(gardien.getSurnom()+"-"+gardien.getNum());
				
				panel_2.add(nomGardien);

			}
		});

		
	}

}

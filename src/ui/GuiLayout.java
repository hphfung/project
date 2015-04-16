package ui;

import domain.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiLayout extends JFrame {
	private static final long serialVersionUID = 1L;
	private IceCream newIceCream;
	private Flavour chocolate;
	private Flavour vanilla;
	private Decorator mAndM;
	private Decorator strawberry;
	
	public GuiLayout() {
		super("Point of Sale System");
		this.setLayout(new BorderLayout());

		newIceCream = new IceCream();
		chocolate = new Flavour("Chocolate", 30);
		vanilla = new Flavour("Vanilla", 20);
		mAndM = new Decorator("M&M", 5);
		strawberry = new Decorator("Strawberry", 4);

		JPanel panelNorth = new JPanel(new GridLayout(0,1));
		JPanel panelWest = new JPanel(new GridLayout(0,1));
		JPanel panelCenter = new JPanel(new GridLayout(0,1));
		JPanel panelEast = new JPanel(new GridLayout(0,1));
		JPanel panelSouth = new JPanel(new FlowLayout());

		JButton cmdNewIceCream = new JButton("New Ice Cream");
		JButton cmdSystemAdministrator = new JButton("System Administrator");
		JButton optChocolate = new JButton("Chocolate, $30");
		JButton optVanilla = new JButton("Vanilla, $20");
		JButton chkMAndM = new JButton("M&M, $5");
		JButton chkStrawberry = new JButton("Strawberry, $4");
		JLabel lblTotal = new JLabel("Total: " + String.valueOf(newIceCream.getPrice()));

		JRadioButton optFlavour = new JRadioButton("Flavour");
		JRadioButton optDecorator = new JRadioButton("Decorator");
		JButton cmdOK = new JButton("OK");
		JButton cmdCancel = new JButton("Cancel");

		JLabel lblName = new JLabel("Please enter the NAME of flavour or decorator:");
		JLabel lblPrice = new JLabel("Please enter the PRICE of flavour or decorator:");
		JTextField txtName = new JTextField(32);
		JTextField txtPrice = new JTextField(32);
		ButtonGroup grpGuiDialog = new ButtonGroup();
		grpGuiDialog.add(optFlavour);
		grpGuiDialog.add(optDecorator);
		
		panelNorth.add(new JLabel("Ice-Cream Point of Sale System:", SwingConstants.CENTER));
		panelNorth.add(new JLabel("(The price of chocolate has been amended from $20 to $30 to indicate the price change after the flavour changed.)", SwingConstants.CENTER));
		panelNorth.add(new JLabel("(Some buttons will be enabled after clicking the other buttons.)", SwingConstants.CENTER));
		panelSouth.add(lblTotal);
		
		panelEast.add(cmdNewIceCream);
		panelEast.add(cmdSystemAdministrator);
		panelEast.add(optFlavour);
		panelEast.add(optDecorator);
		panelEast.add(cmdOK);
		panelEast.add(cmdCancel);
		panelEast.add(lblName);
		panelEast.add(txtName);
		panelEast.add(lblPrice);
		panelEast.add(txtPrice);
		
		panelWest.add(new JLabel("ICE-CREAM Flavor", SwingConstants.CENTER));
		panelWest.add(optChocolate);
		panelWest.add(optVanilla);

		panelCenter.add(new JLabel("ICE-CREAM Decorator", SwingConstants.CENTER));
		panelCenter.add(chkMAndM);
		panelCenter.add(chkStrawberry);
		
		for (Component comWest: panelWest.getComponents()) {
			comWest.setEnabled(false);
		};
		for (Component comCenter: panelCenter.getComponents()) {
			comCenter.setEnabled(false);
		};
		for (Component comEast: panelEast.getComponents()) {
			comEast.setEnabled(false);
		};
		cmdNewIceCream.setEnabled(true);
		cmdSystemAdministrator.setEnabled(true);
				
		cmdNewIceCream.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent evtNewIceCream) {
					for (Component comWest: panelWest.getComponents()) {
						comWest.setEnabled(true);
					};
					for (Component comCenter: panelCenter.getComponents()) {
						comCenter.setEnabled(false);
					};
					cmdSystemAdministrator.setEnabled(true);
					newIceCream.setPrice(0);
					lblTotal.setText("Total: " + String.valueOf(newIceCream.getPrice()));
				}
			}
		);

		cmdSystemAdministrator.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent evtSystemAdministrator) {
					for (Component comWest: panelWest.getComponents()) {
						comWest.setEnabled(false);
					};
					for (Component comCenter: panelCenter.getComponents()) {
						comCenter.setEnabled(false);
					};
					cmdNewIceCream.setEnabled(false);
					cmdSystemAdministrator.setEnabled(false);
					optFlavour.setEnabled(true);
					optDecorator.setEnabled(true);
					cmdCancel.setEnabled(true);
				}
			}
		);

		optChocolate.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent evtChocolate) {
					for (Component comCenter: panelCenter.getComponents()) {
						comCenter.setEnabled(true);
					};
					newIceCream.changeFlavour(chocolate);
					lblTotal.setText(chocolate.getName() + " is chosen. Total: " + String.valueOf(newIceCream.getPrice()));
				}
			}
		);

		optVanilla.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent evtVanilla) {
					for (Component comCenter: panelCenter.getComponents()) {
						comCenter.setEnabled(true);
					};
					newIceCream.changeFlavour(vanilla);
					lblTotal.setText(vanilla.getName() + " is chosen. Total: " + String.valueOf(newIceCream.getPrice()));
				}
			}
		);

		chkMAndM.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent evtMAndM) {
					for (Component comWest: panelWest.getComponents()) {
						comWest.setEnabled(false);
					};
					newIceCream.addDecorator(mAndM);
					lblTotal.setText(mAndM.getName() + " is added. Total: " + String.valueOf(newIceCream.getPrice()));
				}
			}
		);

		chkStrawberry.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent evtStrawberry) {
					for (Component comWest: panelWest.getComponents()) {
						comWest.setEnabled(false);
					};
					newIceCream.addDecorator(strawberry);
					lblTotal.setText(strawberry.getName() + " is addted. Total: " + String.valueOf(newIceCream.getPrice()));
				}
			}
		);

		optFlavour.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evtFlavour) {
						for (Component comEast: panelEast.getComponents()) {
							comEast.setEnabled(true);
						};
					}
				}
			);
		
		optDecorator.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evtFlavour) {
						for (Component comEast: panelEast.getComponents()) {
							comEast.setEnabled(true);
						};
					}
				}
			);
		
		cmdOK.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evtOK) {
						String strName = txtName.getText();
						int intPrice = Integer.parseInt(txtPrice.getText());
						
						if (optFlavour.isSelected()) {
							Flavour newFlavour = new Flavour(strName,intPrice);
							JButton optNewFlavour = new JButton(newFlavour.getName() + ", $" + String.valueOf(newFlavour.getPrice()));
							panelWest.add(optNewFlavour);
							lblTotal.setText(newFlavour.getName() + " is added to the system menu. Price: " + String.valueOf(newFlavour.getPrice()));
							
							optNewFlavour.addActionListener(
									new ActionListener() {
										public void actionPerformed(ActionEvent evtNewFlavour) {
											newIceCream.changeFlavour(newFlavour);
											for (Component comCenter: panelCenter.getComponents()) {
												comCenter.setEnabled(true);
											};
											lblTotal.setText(newFlavour.getName() + " is chosen. Total: " + String.valueOf(newIceCream.getPrice()));
										}
									}
								);
						
						} else if (optDecorator.isSelected()) {
							Decorator newDecorator = new Decorator(strName,intPrice);
							JButton chkNewDecorator = new JButton(newDecorator.getName() + ", $" + String.valueOf(newDecorator.getPrice()));
							panelCenter.add(chkNewDecorator);
							lblTotal.setText(newDecorator.getName() + " is added to the system menu. Price: " + String.valueOf(newDecorator.getPrice()));
							
							chkNewDecorator.addActionListener(
									new ActionListener() {
										public void actionPerformed(ActionEvent evtNewDecorator) {
											newIceCream.addDecorator(newDecorator);
											for (Component comWest: panelWest.getComponents()) {
												comWest.setEnabled(false);
											};
											lblTotal.setText(newDecorator.getName() + " is added. Total: " + String.valueOf(newIceCream.getPrice()));
										}
									}
								);
							
						}
						
						revalidate();
						grpGuiDialog.clearSelection();
						txtName.setText("");
						txtPrice.setText("");
						for (Component comWest: panelWest.getComponents()) {
							comWest.setEnabled(false);
						};
						for (Component comCenter: panelCenter.getComponents()) {
							comCenter.setEnabled(false);
						};
						for (Component comEast: panelEast.getComponents()) {
							comEast.setEnabled(false);
						};
						cmdNewIceCream.setEnabled(true);
						cmdSystemAdministrator.setEnabled(true);
					}
				}
			);

			cmdCancel.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evtCancel) {
						grpGuiDialog.clearSelection();
						txtName.setText("");
						txtPrice.setText("");
						for (Component comEast: panelEast.getComponents()) {
							comEast.setEnabled(false);
						};
						cmdNewIceCream.setEnabled(true);
						cmdSystemAdministrator.setEnabled(true);
					}
				}
			);
		
		this.add(panelNorth, BorderLayout.PAGE_START);
		this.add(panelWest, BorderLayout.LINE_START);
		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelEast, BorderLayout.LINE_END);
		this.add(panelSouth, BorderLayout.PAGE_END);

		this.setSize(700, 600);
		this.setLocation(100, 100);
		this.setVisible(true);	
	}
}
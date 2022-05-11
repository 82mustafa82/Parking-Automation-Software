import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.wb.swt.Autopark;
import org.eclipse.wb.swt.Date;
import org.eclipse.wb.swt.ParkRecord;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.wb.swt.SubscribedVehicle;
import org.eclipse.wb.swt.Subscription;
import org.eclipse.wb.swt.Time;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.custom.CCombo;

public class Main {

	protected Shell shlAutopark;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text_11;
	private Text text_12;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlAutopark.open();
		shlAutopark.layout();
		while (!shlAutopark.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		Autopark ap = new Autopark(5, 30);
		shlAutopark = new Shell();
		shlAutopark.setSize(380, 380);
		shlAutopark.setText("AutoPark");
		
		Label lblNewLabel = new Label(shlAutopark, SWT.BORDER);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel.setBounds(10, 10, 100, 17);
		lblNewLabel.setText("New Subscription");
		
		Label label = new Label(shlAutopark, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 33, 167, 2);
		
		text = new Text(shlAutopark, SWT.BORDER);
		text.setBounds(10, 83, 40, 21);
		
		Label lblNewLabel_1 = new Label(shlAutopark, SWT.NONE);
		lblNewLabel_1.setBounds(10, 41, 66, 15);
		lblNewLabel_1.setText("Begin Date : ");
		
		Label lblNewLabel_2 = new Label(shlAutopark, SWT.NONE);
		lblNewLabel_2.setBounds(10, 62, 27, 15);
		lblNewLabel_2.setText("Day");
		
		Label lblNewLabel_3 = new Label(shlAutopark, SWT.NONE);
		lblNewLabel_3.setBounds(70, 62, 40, 15);
		lblNewLabel_3.setText("Month");
		
		Label lblNewLabel_4 = new Label(shlAutopark, SWT.NONE);
		lblNewLabel_4.setBounds(130, 62, 32, 15);
		lblNewLabel_4.setText("Year");
		
		text_1 = new Text(shlAutopark, SWT.BORDER);
		text_1.setBounds(70, 83, 40, 21);
		
		text_2 = new Text(shlAutopark, SWT.BORDER);
		text_2.setBounds(130, 83, 40, 21);
		
		Label lblEndDate = new Label(shlAutopark, SWT.NONE);
		lblEndDate.setText("End Date : ");
		lblEndDate.setBounds(10, 122, 66, 15);
		
		Label label_2 = new Label(shlAutopark, SWT.NONE);
		label_2.setText("Day");
		label_2.setBounds(10, 143, 27, 15);
		
		text_3 = new Text(shlAutopark, SWT.BORDER);
		text_3.setBounds(10, 164, 40, 21);
		
		text_4 = new Text(shlAutopark, SWT.BORDER);
		text_4.setBounds(70, 164, 40, 21);
		
		Label label_3 = new Label(shlAutopark, SWT.NONE);
		label_3.setText("Month");
		label_3.setBounds(70, 143, 40, 15);
		
		text_5 = new Text(shlAutopark, SWT.BORDER);
		text_5.setBounds(130, 164, 40, 21);
		
		Label label_4 = new Label(shlAutopark, SWT.NONE);
		label_4.setText("Year");
		label_4.setBounds(130, 143, 32, 15);
		
		Label lblNewLabel_5 = new Label(shlAutopark, SWT.NONE);
		lblNewLabel_5.setBounds(10, 205, 40, 15);
		lblNewLabel_5.setText("Plate :");
		
		text_6 = new Text(shlAutopark, SWT.BORDER);
		text_6.setBounds(56, 199, 114, 21);
		
		Button btnIsOfficial = new Button(shlAutopark, SWT.CHECK);
		btnIsOfficial.setBounds(239, 61, 93, 16);
		btnIsOfficial.setText("Is Official?");
		
		Combo combo = new Combo(shlAutopark, SWT.NONE);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int idx = combo.getSelectionIndex();
				String selectedValue = combo.getItem(idx);
				text_7.setText(selectedValue);
				text_10.setText(selectedValue);
				btnIsOfficial.setEnabled(false);
			}
		});
		combo.setBounds(10, 278, 91, 23);
		
		Combo combo_1 = new Combo(shlAutopark, SWT.NONE);
		combo_1.setBounds(189, 310, 91, 23);
		
		Button btnNewButton = new Button(shlAutopark, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
		@Override
		public void widgetSelected(SelectionEvent e) {
			try {
				if(Integer.parseInt(text.getText())>31 || Integer.parseInt(text.getText())<0){
					JOptionPane.showMessageDialog(null,"Baþlangýç günü hatalý girilmiþtir.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(Integer.parseInt(text_1.getText())>12 || Integer.parseInt(text_1.getText())<0){
					JOptionPane.showMessageDialog(null,"Baþlangýç ayý hatalý girilmiþtir.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(Integer.parseInt(text_2.getText())>2050 || Integer.parseInt(text_2.getText())<2000){
					JOptionPane.showMessageDialog(null,"Baþlangýç yýlý hatalý girilmiþtir.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(Integer.parseInt(text_3.getText())>31 || Integer.parseInt(text_3.getText())<0){
					JOptionPane.showMessageDialog(null,"Bitiþ günü hatalý girilmiþtir.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(Integer.parseInt(text_4.getText())>12 || Integer.parseInt(text_4.getText())<0){
					JOptionPane.showMessageDialog(null,"Bitiþ ayý hatalý girilmiþtir.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(Integer.parseInt(text_5.getText())>2050 || Integer.parseInt(text_5.getText())<2000){
					JOptionPane.showMessageDialog(null,"Bitiþ yýlý hatalý girilmiþtir.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(text_6.getText().length()<8) {
					JOptionPane.showMessageDialog(null,"Abonelik kaydý için plaka hatalý girilmiþtir.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					int beginDay = Integer.parseInt(text.getText());
					int beginMonth = Integer.parseInt(text_1.getText());
					int beginYear = Integer.parseInt(text_2.getText());
					int endDay = Integer.parseInt(text_3.getText());
					int endMonth = Integer.parseInt(text_4.getText());
					int endYear = Integer.parseInt(text_5.getText());
					String plateForSub = text_6.getText();		
					Subscription subscription = new Subscription(new Date(beginDay,beginMonth,beginYear),new Date(endDay,endMonth,endYear), plateForSub);
					ap.addVehicle(subscription.getvehicle());
					combo.removeAll();
					for(SubscribedVehicle sv : ap.getSubscribedVehicles())
						combo.add(sv.getPlate());
					JOptionPane.showMessageDialog(null,"Abonelik kaydý baþarýlý","Bilgi", JOptionPane.INFORMATION_MESSAGE);
					text.setText("");
					text_1.setText("");
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					text_5.setText("");
					text_6.setText("");
					btnIsOfficial.setEnabled(true);
					combo.deselectAll();
					combo_1.deselectAll();
					text_7.setText("");
					text_10.setText("");
				}
			}
			catch(Exception e1) {
				JOptionPane.showMessageDialog(null,"Lütfen girdiðiniz abonelik deðerleri kontrol ediniz!!!","Hata", JOptionPane.INFORMATION_MESSAGE);					
			}
		}
		});
		btnNewButton.setBounds(10, 226, 160, 25);
		btnNewButton.setText("Accept Subscription");
		
		Label label_1 = new Label(shlAutopark, SWT.SEPARATOR | SWT.VERTICAL);
		label_1.setBounds(176, 10, 7, 331);
		
		Label lblSubscriptions = new Label(shlAutopark, SWT.NONE);
		lblSubscriptions.setBounds(10, 257, 78, 15);
		lblSubscriptions.setText("Subscriptions");
		
		
		Button btnNewButton_1 = new Button(shlAutopark, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					int idx = combo.getSelectionIndex();
					String selectedValue = combo.getItem(idx);
					String value="";
					for(SubscribedVehicle sv : ap.getSubscribedVehicles()) {
						if(sv.getPlate().compareTo(selectedValue)==0) {
							value = sv.getPlate() + " nolu plakanýn güncel aboneliði : \n";
							value += "Baþlangýç tarihi : " + sv.getSubscription().getBegin().toString()+"\n";
							value += "Bitiþ tarihi : " + sv.getSubscription().getEnd().toString();
						}
					}
					JOptionPane.showMessageDialog(null,value,"Abonelik bilgi", JOptionPane.INFORMATION_MESSAGE);
					btnIsOfficial.setEnabled(true);
					combo.deselectAll();
					combo_1.deselectAll();
					text_7.setText("");
					text_10.setText("");
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Lütfen bir abonelik seçiniz!!!","Hata", JOptionPane.INFORMATION_MESSAGE);					
				}
			}
		});
		btnNewButton_1.setBounds(107, 277, 63, 25);
		btnNewButton_1.setText("Show");
		
		Label lblNewLabel_6 = new Label(shlAutopark, SWT.BORDER);
		lblNewLabel_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_6.setBounds(216, 10, 91, 17);
		lblNewLabel_6.setText("Vehicle Enters :");
		
		Label lblNewLabel_7 = new Label(shlAutopark, SWT.NONE);
		lblNewLabel_7.setBounds(193, 41, 40, 15);
		lblNewLabel_7.setText("Plate : ");
		
		Label label_5 = new Label(shlAutopark, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_5.setBounds(183, 33, 170, 2);
		
		text_7 = new Text(shlAutopark, SWT.BORDER);
		text_7.setBounds(239, 38, 114, 21);
		
		Label lblNewLabel_8 = new Label(shlAutopark, SWT.NONE);
		lblNewLabel_8.setBounds(189, 86, 40, 15);
		lblNewLabel_8.setText("Time : ");
		
		Label lblNewLabel_9 = new Label(shlAutopark, SWT.NONE);
		lblNewLabel_9.setBounds(189, 107, 32, 15);
		lblNewLabel_9.setText("hour");
		
		Label lblNewLabel_10 = new Label(shlAutopark, SWT.NONE);
		lblNewLabel_10.setBounds(235, 107, 40, 15);
		lblNewLabel_10.setText("minute");
		
		text_8 = new Text(shlAutopark, SWT.BORDER);
		text_8.setBounds(189, 122, 40, 21);
		
		text_9 = new Text(shlAutopark, SWT.BORDER);
		text_9.setBounds(235, 122, 40, 21);
		
		Label label_6 = new Label(shlAutopark, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_6.setBounds(183, 156, 170, 2);
		
		Label lblVehicleExits = new Label(shlAutopark, SWT.BORDER);
		lblVehicleExits.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblVehicleExits.setBounds(216, 164, 91, 17);
		lblVehicleExits.setText("Vehicle Exits : ");
		
		Label label_7 = new Label(shlAutopark, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_7.setBounds(183, 187, 170, 2);
		
		Label label_8 = new Label(shlAutopark, SWT.NONE);
		label_8.setText("Plate : ");
		label_8.setBounds(193, 202, 40, 15);
		
		text_10 = new Text(shlAutopark, SWT.BORDER);
		text_10.setBounds(239, 199, 114, 21);
		
		Label label_9 = new Label(shlAutopark, SWT.NONE);
		label_9.setText("Time : ");
		label_9.setBounds(189, 226, 40, 15);
		
		text_11 = new Text(shlAutopark, SWT.BORDER);
		text_11.setBounds(189, 262, 40, 21);
		
		Label label_10 = new Label(shlAutopark, SWT.NONE);
		label_10.setText("hour");
		label_10.setBounds(189, 247, 32, 15);
		
		Label label_11 = new Label(shlAutopark, SWT.NONE);
		label_11.setText("minute");
		label_11.setBounds(235, 247, 40, 15);
		
		text_12 = new Text(shlAutopark, SWT.BORDER);
		text_12.setBounds(235, 262, 40, 21);
		
		
		
		
		
		Button btnAccept = new Button(shlAutopark, SWT.NONE);
		btnAccept.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					if(Integer.parseInt(text_8.getText())>23 || Integer.parseInt(text_8.getText())<0){
						JOptionPane.showMessageDialog(null,"Giriþ saati hatalý girilmiþtir.","Hata", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(Integer.parseInt(text_9.getText())>59 || Integer.parseInt(text_9.getText())<0){
						JOptionPane.showMessageDialog(null,"Giriþ dakikasý hatalý girilmiþtir.","Hata", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(text_7.getText().length()<8) {
						JOptionPane.showMessageDialog(null,"Giriþ için plaka hatalý girilmiþtir.","Hata", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						int enterHour = Integer.parseInt(text_8.getText());
						int enterMinute = Integer.parseInt(text_9.getText());
						String plateForEnter = text_7.getText();		
						ap.vehicleEnters(plateForEnter, new Time(enterHour,enterMinute), btnIsOfficial.getSelection());
						combo_1.removeAll();
						for(ParkRecord pr : ap.getParkRecords())
							combo_1.add(pr.getVehicle().getPlate());
						JOptionPane.showMessageDialog(null,ap.getEnterInfo(),"Bilgi", JOptionPane.INFORMATION_MESSAGE);
						text_8.setText("");
						text_9.setText("");
						text_7.setText("");
						btnIsOfficial.setSelection(false);
						btnIsOfficial.setEnabled(true);
						combo.deselectAll();
						combo_1.deselectAll();
						text_7.setText("");
						text_10.setText("");
					}
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Lütfen girdiðiniz giriþ deðerlerini kontrol ediniz!!!","Hata", JOptionPane.INFORMATION_MESSAGE);	
				}
			}
		});
		btnAccept.setBounds(290, 117, 66, 25);
		btnAccept.setText("Accept");
		
		Button button = new Button(shlAutopark, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					if(Integer.parseInt(text_11.getText())>23 || Integer.parseInt(text_11.getText())<0){
						JOptionPane.showMessageDialog(null,"Çýkýþ saati hatalý girilmiþtir.","Hata", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(Integer.parseInt(text_12.getText())>59 || Integer.parseInt(text_12.getText())<0){
						JOptionPane.showMessageDialog(null,"Çýkýþ dakikasý hatalý girilmiþtir.","Hata", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(text_10.getText().length()<8) {
						JOptionPane.showMessageDialog(null,"Çýkýþ için plaka hatalý girilmiþtir.","Hata", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						int exitHour = Integer.parseInt(text_11.getText());
						int exitMinute = Integer.parseInt(text_12.getText());
						String plateForExit = text_10.getText();		
						ap.vehicleExits(plateForExit, new Time(exitHour,exitMinute));
						combo_1.removeAll();
						for(ParkRecord pr : ap.getParkRecords())
							combo_1.add(pr.getVehicle().getPlate());
						JOptionPane.showMessageDialog(null,ap.getExitInfo(),"Bilgi", JOptionPane.INFORMATION_MESSAGE);
						text_11.setText("");
						text_12.setText("");
						text_10.setText("");
						btnIsOfficial.setEnabled(true);
						combo.deselectAll();
						combo_1.deselectAll();
						text_7.setText("");
						text_10.setText("");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Lütfen girdiðiniz çýkýþ deðerlerini kontrol ediniz!!!","Hata", JOptionPane.INFORMATION_MESSAGE);	
				}
			}
		});
		button.setText("Accept");
		button.setBounds(290, 260, 66, 25);
		
		Label lblParkRecords = new Label(shlAutopark, SWT.NONE);
		lblParkRecords.setBounds(189, 289, 86, 15);
		lblParkRecords.setText("Park Records");
		
		
		
		Button btnShow = new Button(shlAutopark, SWT.NONE);
		btnShow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					int idx = combo_1.getSelectionIndex();
					String selectedValue = combo_1.getItem(idx);
					String value="";
					for(ParkRecord pr : ap.getParkRecords()) {
						if(pr.getVehicle().getPlate().compareTo(selectedValue)==0) {
							value = pr.getVehicle().getPlate() + " nolu plakanýn güncel park bilgisi : \n";
							value += "Giriþ saati : " + pr.getEnterTime().toString()+"\n";
							if(pr.getExitTime()==null) {
								value += "Araç henüz çýkmamýþtýr.";
							}
							else {
								value += "Çýkýþ saati : " + pr.getExitTime().toString();
							}
						}
					}
					JOptionPane.showMessageDialog(null,value,"Park bilgisi", JOptionPane.INFORMATION_MESSAGE);
					btnIsOfficial.setEnabled(true);
					combo.deselectAll();
					combo_1.deselectAll();
					text_7.setText("");
					text_10.setText("");
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Lütfen bir park kaydý seçiniz!!!","Hata", JOptionPane.INFORMATION_MESSAGE);					
				}
			}
		});
		btnShow.setBounds(290, 310, 66, 25);
		btnShow.setText("Show");
		
		
		
		
		shlAutopark.setTabList(new Control[]{text, text_1, text_2, text_3, text_4, text_5, text_6, btnNewButton, combo, btnNewButton_1, text_7, btnIsOfficial, text_8, text_9, btnAccept, text_10, text_11, text_12, button, combo_1, btnShow});

	}
}

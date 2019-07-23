package pkg.library;

import static pkg.employee.SearchEmployee.employee;

//import com.toedter.calendar.JCalendar;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import java.util.Date.L
// 
public class SearchBooks {

	// initializes the reference Array
	static ArrayList<BorrowedReferences> borrowedReferences = new ArrayList<BorrowedReferences>();
	static ArrayList<References> referenceArray = new ArrayList<References>();
	static int count = 0;
	static LocalDate now;

	public SearchBooks() {
		createReferenceGUI();
	}

	static void createReferenceGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Search Books");
		frame.setSize(500, 400);
		setBorder(new EmptyBorder(200, 200, 200, 200));
		setLayout(new GridBagLayout());

		// static adding of elements to the reference array (for testing
		// purposes)
		// referenceArray.add(new ACTIONReference("Minna no Nihongo", 1, "Chie
		// Imoto", 1, 1, "AWS Publication",
		// "ACTIONReference", true, 0, null, null));
		// referenceArray
		// .add(new FlashCards("Hiragana Flash Cards", "AWS Publication",
		// "FlashCards", true, 0, null, null));
		// referenceArray
		// .add(new Magazine("Programmer's Digest", "AWS Publication", 1, 1,
		// "Magazine", true, 0, null, null));
		// referenceArray.add(new VideoCD("Minna no Nihongo Listening
		// Exercises", 1250, "AWS Publication", "VideoCD", true,
		// 0, null, null));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// declares the output variables
		JButton search = new JButton("Search");
		JButton add = new JButton("Add Reference...");
		JButton submit = new JButton("Submit");
		JButton button = new JButton("Exit");
		ButtonGroup group = new ButtonGroup();
		JRadioButton book;
		JLabel label1 = new JLabel("Search Book: ");

		// creates module UI
		JTextArea area = new JTextArea();
		area.setEditable(true);
		area.setWrapStyleWord(true);
		area.addMouseListener(null);
		area.setPreferredSize(new Dimension(150, 30));

		// on click of submit button
		// submit.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// JDialog d = new JDialog(frame, "Message", true);
		// d.setSize(300, 250);
		// d.setLocationRelativeTo(frame);
		// d.setVisible(true);
		// }
		// });
		// arranges the search bar and search button
		Box searchBar = Box.createHorizontalBox();
		searchBar.add(label1, gbc);
		searchBar.add(area, gbc);
		searchBar.add(search, gbc);
		searchBar.add(add, gbc);

		// formats the references into a list-like display
		Box referenceList = Box.createVerticalBox();
		for (int i = 0; i < referenceArray.size(); i++) {
			book = new JRadioButton(referenceArray.get(i).getTitle());
			book.setActionCommand(referenceArray.get(i).getTitle());
			group.add(book);
			referenceList.add(book);
		}

		// group the submit and exit button
		Box action = Box.createHorizontalBox();
		action.add(submit);
		action.add(button);

		// displays the window elements
		frame.add(searchBar, BorderLayout.NORTH);
		frame.add(referenceList);
		frame.add(action, BorderLayout.SOUTH);
		frame.setSize(1000, 500);
		// frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		// on click of search button
		search.addActionListener(new ActionListener() {
			private JRadioButton bookResult;
			private ButtonGroup groupResult = new ButtonGroup();
			private Box referenceResultList = Box.createVerticalBox();

			public void actionPerformed(ActionEvent e) {
				frame.add(referenceResultList);
				referenceResultList.setVisible(false);
				String titleQuery = area.getText();
				int flag = 0;
				referenceResultList.removeAll();
				if (titleQuery.equals(null)) {
					referenceList.setVisible(true);
					referenceResultList.setVisible(false);
				} else {
					for (int i = 0; i < referenceArray.size(); i++) {
						if (referenceArray.get(i).getTitle().equals(titleQuery)) {
							bookResult = new JRadioButton(referenceArray.get(i).getTitle());
							bookResult.setActionCommand(referenceArray.get(i).getTitle());
							groupResult.add(bookResult);
							referenceResultList.add(bookResult);
							flag = 1;
						}
					}
					// if a match is not found
					if (flag == 0) {
						// show full list
						referenceList.setVisible(true);
						frame.revalidate();
						frame.repaint();
						// pop up display message
						JOptionPane.showMessageDialog(frame, "Item doesn't exist.", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						// shows the result of the search
						referenceList.setVisible(false);
						referenceResultList.setVisible(true);
						frame.revalidate();
						frame.repaint();
					}
				}
			}
		});

		// on click of submit button
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (group.getSelection() == null) {
					JOptionPane.showMessageDialog(frame, "No Item Selected.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String selectedItem = group.getSelection().getActionCommand();

					// print reference name to console
					System.out.println("\n************************\nReference Name : " + selectedItem);

					String type = "";
					boolean isAvailable = true;
					int allowableDays = 0;

					for (int i = 0; i < referenceArray.size(); i++) {
						if (referenceArray.get(i).getTitle().equals(selectedItem)) {
							type = referenceArray.get(i).getItemType();
							isAvailable = referenceArray.get(i).getAvailability();
							allowableDays = referenceArray.get(i).getMaxBorrowDays();
						}
					}

					System.out.println("The type is " + type + ". \nAvailability: " + isAvailable
							+ ".\nMaximum days of borrowing is :  " + allowableDays);

					Box fields = Box.createVerticalBox();

					// title variables
					Box forTitle = Box.createHorizontalBox();
					forTitle.createVerticalStrut(10);
					JLabel lblTitle = new JLabel("Title: ");
					JLabel title = new JLabel(selectedItem);

					// item type variables
					Box forType = Box.createHorizontalBox();
					JLabel lblType = new JLabel("Item Type: " + type);

					// borrower info variables
					Box forBorrower = Box.createHorizontalBox();

					JLabel lblBorrower = new JLabel("Borrower Name: ");
					JComboBox<String> cbxBorrower = new JComboBox<String>();

					// populate combo box with employee names
					for (int i = 0; i < employee.size(); i++) {
						cbxBorrower.addItem(employee.get(i).getName());

					}

					// availability variables
					Box forAvailability = Box.createHorizontalBox();
					JLabel lblAvailability = new JLabel("Availability: " + isAvailable);

					// action variables
					Box forAction = Box.createHorizontalBox();
					JButton confirm = new JButton("Confirm");

					// main dialog box creation
					JDialog d = new JDialog(frame, "Message");
					d.setLayout(new FlowLayout());
					d.setSize(300, 250);
					d.setLocationRelativeTo(frame);
					d.setVisible(true);

					// fields for title
					forTitle.add(lblTitle);
					forTitle.add(title);

					// fields for type
					forType.add(lblType);

					// fields for borrower
					forBorrower.add(lblBorrower);
					forBorrower.add(cbxBorrower);

					// fields for availability
					forAvailability.add(lblAvailability);

					// action field
					forAction.add(confirm);

					// arrange fields
					fields.add(forTitle);
					fields.add(forType);
					fields.add(forBorrower);
					fields.add(forAvailability);
					fields.add(forAction);

					// put fields in the dialog box
					d.add(fields);

					// on click of confirm button
					confirm.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (int i = 0; i < referenceArray.size(); i++) {
								if (referenceArray.get(i).getTitle().equals(selectedItem)) {
									// set book availability to false
									referenceArray.get(i).setAvailability(false);
									String type = referenceArray.get(i).getItemType();

									int addDays = 0;

									switch (type) {

									case "ACTION Reference":
										addDays = 150;

										break;
									case "Video CD":
										addDays = 2;

										break;
									case "FlashCards":
										addDays = 2;

										break;
									case "Magazine":
										addDays = 5;

										break;
									case "Other Materials":
										addDays = 3;

										break;

									}

									// Print transaction details to consolse
									int referenceNumber = referenceArray.get(i).getReferenceNumber();
									String bookName = referenceArray.get(i).getTitle();
									String borrower = cbxBorrower.getSelectedItem().toString();
									String itemType = referenceArray.get(i).itemType;
									LocalDate dateBorrowed = LocalDate.now();
									LocalDate dateToReturn = LocalDate.now().plusDays(addDays);

									// add to borrowed books arraylist
									borrowedReferences.add(new BorrowedReferences(referenceNumber, bookName, borrower,
											itemType, dateBorrowed, dateToReturn));
									// print borrow details in console

									System.out.println("Borrower: " + borrower);
									System.out.println("Date borrowed: " + dateBorrowed);
									System.out.println("Deadline of return: " + dateToReturn);
								}
							}

						}
					});
					group.clearSelection();
				}
			}
		});

		// adding books button
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Box fields = Box.createVerticalBox();

				// title variables
				Box forTitle = Box.createHorizontalBox();
				JLabel lblTitle = new JLabel("Title: ");
				JTextField refTitle = new JTextField("");

				// item type variables
				Box forType = Box.createHorizontalBox();
				JLabel lblType = new JLabel("Item Type: ");
				JComboBox<String> comboTypes = new JComboBox<String>();
				comboTypes.addItem("ACTION Reference");
				comboTypes.addItem("Video CD");
				comboTypes.addItem("Flash Cards");
				comboTypes.addItem("Magazine");
				comboTypes.addItem("Other Materials");

				// action variables
				Box forAction = Box.createHorizontalBox();
				JButton add = new JButton("Add");

				// main dialog box creation
				JDialog d = new JDialog(frame, "Borrow Reference");

				d.setSize(300, 250);
				d.setLocationRelativeTo(frame);
				d.setVisible(true);

				// fields for title
				forTitle.add(lblTitle);
				forTitle.add(refTitle);

				// fields for type
				forType.add(lblType);
				forType.add(comboTypes);

				// action field
				forAction.add(add);

				// arrange fields
				fields.add(forTitle);
				fields.add(forType);
				fields.add(forAction);

				// put fields in the dialog box
				d.add(fields);
				d.revalidate();

				// on click of Add button
				add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String type = comboTypes.getSelectedItem().toString();

						// determines selected item type
						switch (type) {
						case "ACTION Reference":
							// adds new material to the array
							referenceArray.add(new ACTIONReference(++count, 150, refTitle.getText(), 1, "Chie Imoto", 1,
									1, "AWS Publication", "ACTION Reference", true, null, null));
							JOptionPane.showMessageDialog(d, "New Action Reference Added.");
							break;
						case "Video CD":
							// adds new material to the array
							referenceArray.add(new VideoCD(++count, 2, refTitle.getText(), 1250, "AWS Publication",
									"Video CD", true, null, null));
							JOptionPane.showMessageDialog(d, "New Video CD Added.");
							break;
						case "Flash Cards":
							// adds new material to the array
							referenceArray.add(new FlashCards(++count, 2, refTitle.getText(), "AWS Publication",
									"FlashCards", true, null, null));
							JOptionPane.showMessageDialog(d, "New Flash Card Added.");
							break;
						case "Magazine":
							// adds new material to the array
							referenceArray.add(new Magazine(++count, 5, refTitle.getText(), "AWS Publication", 1, 1,
									"Magazine", true, null, null));
							JOptionPane.showMessageDialog(d, "New Magazine Added.");
							break;
						case "Other Materials":
							// adds new material to the array
							referenceArray.add(new OtherMaterials(++count, 3, refTitle.getText(), "AWS Publication", 1,
									"Other Materials", true, null, null));
							JOptionPane.showMessageDialog(d, "New Material Added.");
							break;
						}

						// System.out.println(referenceArray.size());
						// adds the new material to the button group
						JRadioButton newBook;
						newBook = new JRadioButton(referenceArray.get(referenceArray.size() - 1).getTitle());
						newBook.setActionCommand(referenceArray.get(referenceArray.size() - 1).getTitle());
						group.add(newBook);
						referenceList.add(newBook);
						referenceList.revalidate();
						referenceList.repaint();
						frame.add(referenceList);
						frame.revalidate();
						frame.repaint();
					}
				});
			}
		});
	}

	private void add(JLabel jLabel, GridBagConstraints gbc) {
		// TODO Auto-generated method stub

	}

	private static void setLayout(GridBagLayout gridBagLayout) {
		// TODO Auto-generated method stub

	}

	private static void setBorder(EmptyBorder emptyBorder) {
		// TODO Auto-generated method stub

	}

	protected static void add(JDialog jDialog) {
		// TODO Auto-generated method stub

	}

}

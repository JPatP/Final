/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package pkg.library;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Evil Genius
 */
public class BookManagement {
	static String bookname;
	int referenceNumber;
	String borrowerName;
	String itemType;
	LocalDate dateBorrowed;
	LocalDate dateToReturn;

	public BookManagement(int referenceNumber, String bookname, String borrowerName, String itemType,
			LocalDate dateBorrowed, LocalDate dateToReturn) {
		this.referenceNumber = referenceNumber;
		this.bookname = bookname;
		this.borrowerName = borrowerName;
		this.itemType = itemType;
		this.dateBorrowed = dateBorrowed;
		this.dateToReturn = dateToReturn;

	}

	public BookManagement() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame("Book Management");
				frame.setPreferredSize(new Dimension(1000, 560));
				frame.setBounds(500, 200, 300, 300);
				frame.add(new ReturnView());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}

		});
	}

	class ReturnView extends JPanel {

		public ReturnView() {
			JPanel panel = new JPanel();
			setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.BASELINE;
			gbc.weighty = 1;
			gbc.weightx = 0;
			gbc.gridx = 1;
			gbc.gridy = 2;
			add(new JLabel("<html><br><h1><strong>BOOK MANAGEMENT</strong></h1></html>"), gbc);
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.gridx = 1;

			for (int i = 0; i < BorrowedReferences.borrowedReferences.size(); i++) {
				JLabel label = new JLabel(BorrowedReferences.borrowedReferences.get(i).referenceNumber + " "+ BorrowedReferences.borrowedReferences.get(i).bookName + " "
						+ BorrowedReferences.borrowedReferences.get(i).borrowerName + " "
						+ BorrowedReferences.borrowedReferences.get(i).itemType + " "
						+ BorrowedReferences.borrowedReferences.get(i).dateBorrowed + " "
						+ BorrowedReferences.borrowedReferences.get(i).dateToReturn);
				JButton buttonb = new JButton("return");
				add(label);
				add(buttonb);
				System.out.println(BorrowedReferences.borrowedReferences.get(i).dateBorrowed);
				System.out.println(BorrowedReferences.borrowedReferences.get(i).dateToReturn);
				long diff = BorrowedReferences.borrowedReferences.get(i).dateBorrowed
						.compareTo(BorrowedReferences.borrowedReferences.get(i).dateToReturn);
				System.out.println(diff);
				buttonb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (diff < 0) {
							int ans = JOptionPane.showConfirmDialog(null, "Is the item lost?", null,
									JOptionPane.YES_NO_OPTION);
							if (ans == JOptionPane.NO_OPTION) {
								for (int i = 0; i < BorrowedReferences.borrowedReferences.size(); i++) {
									BorrowedReferences.borrowedReferences.remove(i);
									// BorrowedReferences.borrowedReferences.get(i).setAvailability(true);
								}
							} else {

								int getDays = 0;
								for (int i = 0; i < BorrowedReferences.borrowedReferences.size(); i++) {
									switch (BorrowedReferences.borrowedReferences.get(i).itemType) {

									case "ACTION Reference":
										getDays = 1000;

										break;
									case "Video CD":
										getDays = 300;

										break;
									case "FlashCards":
										getDays = 200;

										break;
									case "Magazine":
										getDays = 150;

										break;
									case "Other Materials":
										getDays = 300;

										break;
									}

									JDialog d = new JDialog();
									d.setLayout(new FlowLayout());
									d.setSize(300, 250);
									d.setLocationRelativeTo(d);
									d.setVisible(true);
									JLabel labeel = new JLabel("Total Penalty: ");
									double total = getDays - diff;
									JLabel newlabeel = new JLabel(String.valueOf(total));
									d.add(labeel);
									d.add(newlabeel);
									JButton buttonulit = new JButton("Delete");
									buttonulit.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											for (int i = 0; i < BorrowedReferences.borrowedReferences.size(); i++) {
												BorrowedReferences.borrowedReferences.remove(i);

												d.add(buttonulit);
											}
										}
									});

								}
							}
						}
					}
				});

			}
		}
	}
}

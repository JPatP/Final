package pkg.library;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import pkg.employee.SearchEmployee;

public class MainView {

    SearchEmployee employeeView = new SearchEmployee();
    JButton searchTraineeBtn;

    public MainView() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Home");
                frame.setBounds(500, 200, 300, 300);
                frame.add(new MenuPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
        employeeView.addEmployee();
    }

    public class MenuPane extends JPanel {

        public MenuPane() {
            setBorder(new EmptyBorder(200, 200, 200, 200));
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;

            add(new JLabel("<html><h1><strong><i>Welcome to AWS Library System</i></strong></h1><hr></html>"), gbc);

            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            searchTraineeBtn = new JButton("Search Trainee");

            searchTraineeBtn.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    new SearchEmployee().createGUI();

                }

            });
            JButton searchRefBtn = new JButton("Search Reference");
            searchRefBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new SearchBooks();
                }
            });
            JButton bookMngtBtn = new JButton("Book Management");
            JButton penaltyBtn = new JButton("Penalty");
            penaltyBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new Penalty();
                }
            });

            gbc.weighty = 1;
            add(searchTraineeBtn, gbc);
            add(searchRefBtn, gbc);
            add(bookMngtBtn, gbc);
            add(penaltyBtn, gbc);
        }
    }
}

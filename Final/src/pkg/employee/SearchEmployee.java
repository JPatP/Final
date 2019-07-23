package pkg.employee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SearchEmployee {

    DefaultTableModel model;
    JTable table;
    JFrame frameSearchEmployee;
    TableRowSorter sorter;
    static int count;
    public static ArrayList<EmployeeModel> employee = new ArrayList<EmployeeModel>();

    String[] columnNames = {"Employee No.", "Employee Type", "Name", "Contact No.", "Business Unit", "Total Penalty",
        "Items Borrowed"};

    // constructor
    public SearchEmployee() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frameSearchEmployee = new JFrame("View Employees");
        frameSearchEmployee.setSize(1000, 500);

        model = new DefaultTableModel(columnNames, 0) {
            public Class getColumnClass(int column) {
                Class returnValue;
                if ((column >= 0) && (column < getColumnCount())) {
                    returnValue = getValueAt(0, column).getClass();
                } else {
                    returnValue = Object.class;
                }
                return returnValue;
            }
        };
        table = new JTable(model);

    }

    // initializes 10 data for employees
    public void addEmployee() {
        employee.add(new Trainee(1, "Trainee", "Pat", "09060130867", "Dev B", 0, 0));
        employee.add(new Trainee(2, "Trainee", "Ken", "09060130867", "Dev C", 0, 0));
        employee.add(new Trainee(3, "Trainee", "Mariz", "09060130867", "Dev D", 0, 0));
        employee.add(new Trainee(4, "Trainee", "Jon", "09060130867", "Dev F", 0, 0));
        // Trainer
        employee.add(new Trainer(5, "Trainer", "Mary Ann Mateo", "09456634423", "ACTION", 0, 0));
        employee.add(new Trainer(6, "Trainer", "Chie Imoto", "09274450987", "ACTION", 0, 0));
        employee.add(new Trainer(7, "Trainer", "Masami Namita", "09172425587", "ACTION", 0, 0));
        // Engineer
        employee.add(new Engineer(8, "Engineer", "Shirley", "09456634423", "Dev 2", 0, 0));
        employee.add(new Engineer(9, "Engineer", "Glaiza", "09274450987", "Dev K", 0, 0));
        employee.add(new Engineer(10, "Engineer", "Gzelly Joy", "09172425587", "Dev A", 0, 0));
    }

    public void createGUI() {

        for (int i = 0; i < employee.size(); i++) {
            String number = String.valueOf(employee.get(i).getEmployeeNumber());
            String type = employee.get(i).getEmployeeType();
            String name = employee.get(i).getName();
            String contact = employee.get(i).getContactInfo();
            String bu = employee.get(i).getBusinessUnit();
            String penalty = String.valueOf(employee.get(i).getTotalPenalty());
            String borrowed = String.valueOf(employee.get(i).getItemsBorrowed());

            Object rows[] = {number, type, name, contact, bu, penalty, borrowed};
            model.addRow(rows);

        }

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);

        JScrollPane pane = new JScrollPane(table);

        JPanel panelSouth = new JPanel();
        panelSouth.setBackground(Color.red);
        panelSouth.setLayout(new BorderLayout());

        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Upper panel attributes
        JLabel jLabel = new JLabel("Search: ");

        JTextField jTextField = new JTextField("");
        jTextField.setPreferredSize(new Dimension(150, 30));

        JButton btn = new JButton("Search");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = jTextField.getText();
                if (text.length() == 0) {
                    sorter.setRowFilter(null);
                    JOptionPane.showMessageDialog(frameSearchEmployee, "Input something");
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter(text));
                    if (table.getRowCount() < 1) {
                        JOptionPane.showMessageDialog(frameSearchEmployee,
                                "No records found.\nCase sensitive input.\nCheck for unnecesary spaces in the search box");
                    }

                }
            }
        });
        // ADD
        JButton btnAdd = new JButton("Add User");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
            }
        });

        panelSouth.add(pane, BorderLayout.SOUTH);
        panelNorth.add(jLabel);
        panelNorth.add(jTextField);
        panelNorth.add(btn);
        panelNorth.add(btnAdd);

        frameSearchEmployee.add(panelSouth);
        frameSearchEmployee.setContentPane(panelSouth);
        frameSearchEmployee.setLocationRelativeTo(null);
        frameSearchEmployee.add(panelNorth);

        frameSearchEmployee.setVisible(true);

    }

    public void addEmp(String strEmpType, String strEmpName, String strEmpCnt, String strEmpBU,
            String strEmpPenalty, String strEmpBorrow) {
        count = employee.size();

        try {

            employee.add(new Trainee(++count, strEmpType, strEmpName, strEmpCnt, strEmpBU,
                    Integer.parseInt(strEmpPenalty), Integer.parseInt(strEmpBorrow)));

            JOptionPane.showMessageDialog(frameSearchEmployee, "Successfully added. \nTry to reopen this window to see updates.");

            model = new DefaultTableModel(columnNames, 0) {
                public Class getColumnClass(int column) {
                    Class returnValue;
                    if ((column >= 0) && (column < getColumnCount())) {
                        returnValue = getValueAt(0, column).getClass();
                    } else {
                        returnValue = Object.class;
                    }
                    return returnValue;
                }
            };
            table = new JTable(model);

            for (int i = 0; i < employee.size(); i++) {
                String number = String.valueOf(employee.get(i).getEmployeeNumber());
                String type = employee.get(i).getEmployeeType();
                String name = employee.get(i).getName();
                String contact = employee.get(i).getContactInfo();
                String bu = employee.get(i).getBusinessUnit();
                String penalty = String.valueOf(employee.get(i).getTotalPenalty());
                String borrowed = String.valueOf(employee.get(i).getItemsBorrowed());

                Object rows[] = {number, type, name, contact, bu, penalty, borrowed};
                model.addRow(rows);

            }

            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
            table.setRowSorter(sorter);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg.library;

import java.time.LocalDate;

/**
 *
 * @author Evil Genius
 */
public class BorrowedReferences extends SearchBooks {

    int referenceNumber;
    String bookName;
    String borrowerName;
    LocalDate dateBorrowed;
    LocalDate dateToReturn;

    public BorrowedReferences() {
    }

    public BorrowedReferences(int referenceNumber, String bookname, String borrowerName, LocalDate dateBorrowed, LocalDate dateToReturn) {
        this.referenceNumber = referenceNumber;
        this.bookName = bookname;
        this.borrowerName = borrowerName;
        this.dateBorrowed = dateBorrowed;
        this.dateToReturn = dateToReturn;
    }

    public static void main(String[] args) {
        // test data for arraylist - remove this later maris
        borrowedReferences.add(new BorrowedReferences(1, "PAttr", "Me", LocalDate.now(), LocalDate.now()));
        borrowedReferences.add(new BorrowedReferences(1, "PAttr", "Me", LocalDate.now(), LocalDate.now()));
        borrowedReferences.add(new BorrowedReferences(1, "PAttr", "Me", LocalDate.now(), LocalDate.now()));
        borrowedReferences.add(new BorrowedReferences(1, "PAttr", "Me", LocalDate.now(), LocalDate.now()));
        borrowedReferences.add(new BorrowedReferences(1, "PAttr", "Me", LocalDate.now(), LocalDate.now()));
        // tester loop for data
        for (int i = 0; i < borrowedReferences.size(); i++) {
            System.out.println(borrowedReferences.get(i).bookName + " " + borrowedReferences.get(i).referenceNumber
                    + " " + borrowedReferences.get(i).borrowerName + " " + borrowedReferences.get(i).dateBorrowed + " "
                    + borrowedReferences.get(i).dateToReturn);
        }

    }
}

package pkg.library;

import java.time.LocalDate;

public abstract class References {

	static int count;
	int referenceNumber;
	int maxBorrowDays;
	String referenceTitle;
	int daysBorrowed;
	boolean isAvailable;
	LocalDate dateBorrowed;
	LocalDate dateOfReturn;
	String itemType;

	public References(int referenceNumber, int maxBorrowDays, String referenceTitle, String itemType,
			boolean isAvailable, LocalDate dateBorrowed, LocalDate dateOfReturn) {
		count++;
		this.referenceNumber = count;
		this.maxBorrowDays = maxBorrowDays;
		this.referenceTitle = referenceTitle;
		this.itemType = itemType;
		this.isAvailable = isAvailable;
		this.dateBorrowed = dateBorrowed;
		this.dateOfReturn = dateOfReturn;
	}

	public int getReferenceNumber() {
		return this.referenceNumber;
	}

	public void returnReference() {

	}

	public String searchReference(String titleQuery) {
		return this.referenceTitle;
	}

	public void borrowReference() {

	}

	public boolean getAvailability() {
		return this.isAvailable;
	}

	public void setAvailability(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getMaxBorrowDays() {
		return this.maxBorrowDays;
	}

	public String getItemType() {
		return this.itemType;
	}

	public String getTitle() {
		return this.referenceTitle;
	}

	public void displayInfo() {
		System.out.println("Ref. No.       : " + this.referenceNumber);
		System.out.println("Title          : " + this.referenceTitle);
		System.out.println("Item Type      : " + this.itemType);
		System.out.println("Max Borrow Days: " + this.maxBorrowDays);
	}
}

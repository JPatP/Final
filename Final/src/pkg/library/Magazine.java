package pkg.library;

import java.time.LocalDate;
import java.util.Date;

public class Magazine extends References {

    private String author;
    private int volumeNo;
    private int issueNo;
    private static int penaltyFee = 20;
    private static int replacementFee = 150;

    public Magazine(int referenceNumber, int maxBorrowDays, String referenceTitle, String author, int volumeNo, int issueNo, String itemType, boolean isAvailable, LocalDate dateBorrowed, LocalDate dateReturned) {
        super(referenceNumber, maxBorrowDays, referenceTitle, itemType, isAvailable, dateBorrowed, dateReturned);
        this.author = author;
        this.volumeNo = volumeNo;
        this.issueNo = issueNo;
    }

    public int getPenaltyFee() {
        return this.penaltyFee;
    }

    public int getReplacementFee() {
        return this.replacementFee;
    }
}

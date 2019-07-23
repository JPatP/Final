package pkg.library;

import java.time.LocalDate;
import java.util.Date;
import static pkg.library.SearchBooks.count;

public class ACTIONReference extends References {

    private int version;
    private String author;
    private int volumeNo;
    private int issueNo;
    private String refPublisher;
    private static int penaltyFee = 10;
    private static int replacementFee = 1000;

    public ACTIONReference(int referenceNumber, int maxBorrowDays, String referenceTitle,
            int version, String author, int volumeNo, int issueNo, String refPublisher,
            String itemType, boolean isAvailable, LocalDate dateBorrowed,
            LocalDate dateReturned) {

        super(referenceNumber, maxBorrowDays, referenceTitle, itemType, isAvailable, dateBorrowed, dateReturned);
        this.version = version;
        this.author = author;
        this.volumeNo = volumeNo;
        this.issueNo = issueNo;
        this.refPublisher = refPublisher;
    }

    public int getPenaltyFee() {
        return this.penaltyFee;
    }

    public int getReplacementFee() {
        return this.replacementFee;
    }

    public int getMaxBorrowDays() {
        return this.maxBorrowDays;
    }
}

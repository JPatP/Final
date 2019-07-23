package pkg.library;

import java.time.LocalDate;
import java.util.Date;

public class OtherMaterials extends References {

    private String author;
    private int version;
    private static int penaltyFee = 20;
    private static int replacementFee = 300;

    public OtherMaterials(int referenceNumber, int maxBorrowDays, String referenceTitle, String author, int version, String itemType, boolean isAvailable, LocalDate dateBorrowed, LocalDate dateReturned) {
        super(referenceNumber, maxBorrowDays, referenceTitle, itemType, isAvailable, dateBorrowed, dateReturned);
        this.author = author;
        this.version = version;
    }

    public int getPenaltyFee() {
        return this.penaltyFee;
    }

    public int getReplacementFee() {
        return this.replacementFee;
    }
}

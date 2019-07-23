package pkg.library;

import java.time.LocalDate;
import java.util.Date;
import static pkg.library.SearchBooks.count;

public class VideoCD extends References {

    private int videoRunTime;
    private String videoPublisher;
    private static int penaltyFee = 50;
    private static int replacementFee = 300;

    public VideoCD(int referenceNumber, int maxBorrowDays, String referenceTitle, int videoRunTime,
            String videoPublisher, String itemType, boolean isAvailable, LocalDate dateBorrowed, LocalDate dateReturned) {
        super(referenceNumber, maxBorrowDays, referenceTitle, itemType, isAvailable, dateBorrowed, dateReturned);
        this.videoRunTime = videoRunTime;
        this.videoPublisher = videoPublisher;
    }

    public int getPenaltyFee() {
        return this.penaltyFee;
    }

    public int getReplacementFee() {
        return this.replacementFee;
    }
}

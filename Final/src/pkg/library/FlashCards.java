package pkg.library;

import java.time.LocalDate;
import java.util.Date;
import static pkg.library.SearchBooks.count;

public class FlashCards extends References {

    private String fCardsPublisher;
    private static int penaltyFee = 50;
    private static int replacementFee = 200;

    public FlashCards(int referenceNumber, int maxBorrowDays, String referenceTitle, String fCardsPublisher, String itemType, boolean isAvailable, LocalDate dateBorrowed, LocalDate dateReturned) {
        super(referenceNumber, maxBorrowDays, referenceTitle, itemType, isAvailable, dateBorrowed, dateReturned);
        this.fCardsPublisher = fCardsPublisher;
    }

    public int getPenaltyFee() {
        return this.penaltyFee;
    }

    public int getReplacementFee() {
        return this.replacementFee;
    }
}

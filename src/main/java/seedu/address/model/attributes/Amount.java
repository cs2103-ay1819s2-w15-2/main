package seedu.address.model.attributes;

import java.math.BigDecimal;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an amount in cents in the finance tracker.
 */
public class Amount {

    public static final String MESSAGE_CONSTRAINTS =
            "Amount should only contain numbers, reflect the value in cents and it should be at least 1 digit long.";
    public static final String VALIDATION_REGEX = "\\d{1,}";
    public final int value;

    /**
     * Constructs a {@code Amount}.
     *
     * @param amount A valid amount number.
     */
    public Amount(String amount) {
        requireNonNull(amount);
        checkArgument(isValidAmount(amount), MESSAGE_CONSTRAINTS);
        value = Integer.parseInt(amount);
    }

    /**
     * Returns true if a given string is a valid amount.
     */
    public static boolean isValidAmount(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * @return value of amount in dollars.
     */
    @Override
    public String toString() {
        BigDecimal valueInCents = new BigDecimal(value);
        BigDecimal valueInDollars = valueInCents.divide(new BigDecimal("100"));
        return valueInDollars.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Amount // instanceof handles nulls
                && value == ((Amount) other).value); // state check
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }

}

package seedu.address.model.expense;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.attributes.Category;
import seedu.address.model.attributes.Amount;
import seedu.address.model.attributes.Date;
import seedu.address.model.attributes.Name;

/**
 * Represents a Expense in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Expense {
    // Identity fields
    private final Name name;
    private final Amount amount;
    private final Date date;

    // Data fields
    private final Category category;
    private final String remarks;

    /**
     * Every field must be present and not null.
     */
    public Expense(Name name, Amount amount, Date date, Category category, String remarks) {
        requireAllNonNull(name, amount, date, category, remarks); // should we remove date and remarks?
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.remarks = remarks;
    }

    public Name getName() {
        return name;
    }

    public Amount getAmount() {
        return amount;
    }

    public Date getDate() { return date; }

    public Category getCategory() {
        return category;
    }

    public String getRemarks() { return remarks; }

//    /**
//     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
//     * if modification is attempted.
//     */
//    public Set<Tag> getTags() {
//        return Collections.unmodifiableSet(tags);
//    }

    /**
     * Returns true if both expenses of the same name have the same cost amount and date.
     * This defines a weaker notion of equality between two expenses.
     */
    public boolean isSameExpense(Expense otherExpense) {
        if (otherExpense == this) {
            return true;
        }

        return otherExpense != null
                && otherExpense.getName().equals(getName())
                && otherExpense.getAmount().equals(getAmount())
                && otherExpense.getDate().equals(getDate());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two expenses.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Expense)) {
            return false;
        }

        Expense otherExpense = (Expense) other;
        return otherExpense.getName().equals(getName())
                && otherExpense.getAmount().equals(getAmount())
                && otherExpense.getDate().equals(getDate())
                && otherExpense.getCategory().equals(getCategory())
                && otherExpense.getRemarks().equals(getRemarks());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, amount, date, category, remarks);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Amount: ")
                .append(getAmount())
                .append(" Name: ")
                .append(getName())
                .append(" Amount: ")
                .append(getAmount())
                .append(" Category: ")
                .append(getCategory())
                .append(" Remarks: ")
                .append(getRemarks());
        return builder.toString();
    }

}
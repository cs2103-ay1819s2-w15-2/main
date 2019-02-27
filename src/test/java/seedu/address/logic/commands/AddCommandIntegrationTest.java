package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.Before;
import org.junit.Test;

import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Expense;
import seedu.address.testutil.PersonBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;
    private CommandHistory commandHistory = new CommandHistory();

    @Before
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_newPerson_success() {
        Expense validExpense = new PersonBuilder().build();

        Model expectedModel = new ModelManager(model.getFinanceTracker(), new UserPrefs());
        expectedModel.addExpense(validExpense);
        expectedModel.commitFinanceTracker();

        assertCommandSuccess(new AddCommand(validExpense), model, commandHistory,
                String.format(AddCommand.MESSAGE_SUCCESS, validExpense), expectedModel);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Expense expenseInList = model.getFinanceTracker().getFinanceList().get(0);
        assertCommandFailure(new AddCommand(expenseInList), model, commandHistory,
                AddCommand.MESSAGE_DUPLICATE_PERSON);
    }

}

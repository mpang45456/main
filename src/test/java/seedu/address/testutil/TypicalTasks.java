package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;

import seedu.address.model.calender.Deadline;
import seedu.address.model.calender.Task;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalTasks {

    private static final String DATE_A = "20-04-2020";
    private static final String DATE_B = "21-04-2020";
    private static final String DATE_C = "21-04-2020";
    private static final String MISC_CATEGORY = "MISC";
    private static final String WORK_CATEGORY = "WORK";
    private static final String TEST_CATEGORY = "TEST";

    public static final Task DEADLINE_A_DATE_A = new Deadline("Test A with Date A", DATE_A, MISC_CATEGORY, "add");
    public static final Task DEADLINE_B_DATE_A = new Deadline("Test B with Date A", DATE_A, WORK_CATEGORY, "add");
    public static final Task DEADLINE_C_DATE_B = new Deadline("Test C with Date B", DATE_B, WORK_CATEGORY, "add");
    public static final Task DEADLINE_D_DATE_B = new Deadline("Test D with Date B", DATE_B, MISC_CATEGORY, "add");

    private TypicalTasks() {} // prevents instantiation


    public static ArrayList<Task> getTypicalTask() {

        return new ArrayList<>(Arrays.asList(
                DEADLINE_A_DATE_A, DEADLINE_B_DATE_A, DEADLINE_C_DATE_B, DEADLINE_D_DATE_B));

    }

}

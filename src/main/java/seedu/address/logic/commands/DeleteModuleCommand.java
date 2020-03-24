package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.nusmodule.ModuleCode;

/**
 * Deletes a NUS module identified using given module code from the module book.
 */
public class DeleteModuleCommand extends Command {

    public static final String COMMAND_WORD = "moduleDel";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Allows for deleting modules "
            + "Parameters: MODULE CODE "
            + "Example: " + COMMAND_WORD + " CS2103T ";

    public static final String MESSAGE_SUCCESS = "Module deleted";

    private final ModuleCode targetModuleCode;

    /**
     * Creates an AddModuleCommand to add the specified {@code NusModule}
     */
    public DeleteModuleCommand(ModuleCode moduleCode) {
        requireNonNull(moduleCode);
        targetModuleCode = moduleCode;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (!model.hasModule(targetModuleCode)) {
            throw new CommandException("module does not exist!");
        }

        model.deleteModule(targetModuleCode);
        return new CommandResult(String.format(MESSAGE_SUCCESS, targetModuleCode));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteModuleCommand // instanceof handles nulls
                && targetModuleCode.equals(((DeleteModuleCommand) other).targetModuleCode));
    }
}
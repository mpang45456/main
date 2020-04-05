package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddBookCommand;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.AddDeadlineCommand;
import seedu.address.logic.commands.AddToDoCommand;
import seedu.address.logic.commands.CalenderCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteTaskCommand;
import seedu.address.logic.commands.DiaryAddCommand;
import seedu.address.logic.commands.DiaryCommand;
import seedu.address.logic.commands.DiaryLogCommand;
import seedu.address.logic.commands.DoneCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.MajorCommand;
import seedu.address.logic.commands.ModPlanCommand;
import seedu.address.logic.commands.NotesCommand;
import seedu.address.logic.commands.NotesCreateCommand;
import seedu.address.logic.commands.NotesDeleteCommand;
import seedu.address.logic.commands.NotesListCommand;
import seedu.address.logic.commands.NotesOpenCommand;
import seedu.address.logic.commands.ProfileCommand;
import seedu.address.logic.commands.SearchCommand;
import seedu.address.logic.commands.findtaskscommand.FindTasksCommand;
import seedu.address.logic.commands.modulecommand.AddModuleCommand;
import seedu.address.logic.commands.modulecommand.CapCommand;
import seedu.address.logic.commands.modulecommand.DeleteModuleCommand;
import seedu.address.logic.commands.modulecommand.GradeCommand;
import seedu.address.logic.commands.modulecommand.ModuleTaskCommand;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {
        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case CalenderCommand.COMMAND_WORD:
            return new CalenderCommand();

        case AddBookCommand.COMMAND_WORD:
            return new AddBookCommand();

        case ProfileCommand.COMMAND_WORD:
            return new ProfileCommand();

        case DiaryCommand.COMMAND_WORD:
            return new DiaryCommand();

        case ModPlanCommand.COMMAND_WORD:
            return new ModPlanCommand();

        case NotesCommand.COMMAND_WORD:
            return new NotesCommand();

        case DiaryAddCommand.COMMAND_WORD:
            return new DiaryAddCommandParser().parse(arguments);

        case DiaryLogCommand.COMMAND_WORD:
            return new DiaryLogCommand();

        case SearchCommand.COMMAND_WORD:
            return new SearchCommandParser().parse(arguments);

        case AddModuleCommand.COMMAND_WORD:
            return new AddModuleCommandParser().parse(arguments);

        case GradeCommand.COMMAND_WORD:
            return new GradeCommandParser().parse(arguments);

        case DeleteModuleCommand.COMMAND_WORD:
            return new DeleteModuleCommandParser().parse(arguments);

        case CapCommand.COMMAND_WORD:
            return new CapCommand();

        case AddToDoCommand.COMMAND_WORD:
            return new AddToDoCommandParser().parse(arguments);

        case AddDeadlineCommand.COMMAND_WORD:
            return new AddDeadlineCommandParser().parse(arguments);

        case DeleteTaskCommand.COMMAND_WORD:
            return new DeleteTaskCommandParser().parse(arguments);

        case DoneCommand.COMMAND_WORD:
            return new DoneCommandParser().parse(arguments);

        case FindTasksCommand.COMMAND_WORD:
            return new FindTasksCommandParser().parse(arguments);

        case ModuleTaskCommand.COMMAND_WORD:
            return new ModuleTaskCommandParser().parse(arguments);

        case MajorCommand.COMMAND_WORD:
            return new MajorCommandParser().parse(arguments);

        case NotesListCommand.COMMAND_WORD:
            return new NotesListCommandParser().parse(arguments);

        case NotesCreateCommand.COMMAND_WORD:
            return new NotesCreateCommandParser().parse(arguments);

        case NotesOpenCommand.COMMAND_WORD:
            return new NotesOpenCommandParser().parse(arguments);

        case NotesDeleteCommand.COMMAND_WORD:
            return new NotesDeleteCommandParser().parse(arguments);


        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}

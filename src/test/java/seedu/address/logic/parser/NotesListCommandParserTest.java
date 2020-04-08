package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_FILE_PATH_WITH_PREFIX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PATH_WITH_PREFIX;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.NotesListCommand;
import seedu.address.model.notes.Notes;

public class NotesListCommandParserTest {

    private NotesListCommandParser parser = new NotesListCommandParser();
    private String validPath = "Desktop";
    private String validPathType = "abs";
    private Notes testNote = new Notes(validPath, validPathType);

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, NotesListCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsNotesListCommand() {
        NotesListCommand expectedNotesListCommand = new NotesListCommand(testNote);
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + VALID_PATH_WITH_PREFIX
                + VALID_FILE_PATH_WITH_PREFIX, expectedNotesListCommand);

    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, NotesListCommand.MESSAGE_USAGE);
        // No path type indicated
        assertParseFailure(parser, VALID_PATH_WITH_PREFIX,
                expectedMessage);

        // no file path indicated
        assertParseFailure(parser, VALID_FILE_PATH_WITH_PREFIX,
                expectedMessage);
    }

}

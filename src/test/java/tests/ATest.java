package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.letters.APage;

import java.util.List;

public class ATest extends BaseTest {

    @Test
    public void testAPageMostCommentedLanguage() {
        final int expectedMaxComment = 12;
        final String expectedLanguage = "Assembler (6510)";

        APage aPage = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickASubmenu();

        List<Integer> commentList = aPage
                .getColumnCommentList();

        int maxComment = aPage
                .getMaxList(commentList);

        Assert.assertEquals(maxComment, expectedMaxComment);

        int maxCommentIndex = aPage
                .clickASubmenu()
                .getColumnCommentList()
                .indexOf(aPage
                        .getSortedList(commentList)
                        .get(commentList.size() - 1));

        String languageName = aPage
                .clickASubmenu()
                .getNames()
                .get(maxCommentIndex);

        Assert.assertEquals(languageName, expectedLanguage);
    }
}

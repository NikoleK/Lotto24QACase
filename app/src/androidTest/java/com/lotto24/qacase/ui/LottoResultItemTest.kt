package com.lotto24.qacase.ui

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lotto24.qacase.helper.assertCircleKind
import com.lotto24.qacase.helper.setContentUnderTest
import com.lotto24.qacase.testdata.LottoTestData
import com.lotto24.qacase.ui.semantics.CircleKind
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LottoResultItemTest : BaseComposeUITest() {

    @get:Rule
    override val composeTestRule = createComposeRule()

    /**
     * Verifies that all basic data elements are displayed correctly for 6aus49 lottery.
     */
    @Test
    fun test6aus49_CorrectDataDisplay() {
        val lotto = LottoTestData.sixAus49()
        val expectedLastDrawDate = DateFormatter.format(lotto.lastDrawDate)
        val expectedNextDrawDate = DateFormatter.format(lotto.nextDrawDate)

        composeTestRule.setContentUnderTest(lotto)

        lottoResultItemPageObject.assertCardDisplayed(lotto.lottery)
        lottoResultItemPageObject.assertLotteryNameDisplayed(lotto.lottery)
        composeTestRule.onNodeWithText("Last Draw: $expectedLastDrawDate").assertIsDisplayed()
        composeTestRule.onNodeWithText("Next Draw: $expectedNextDrawDate").assertIsDisplayed()
    }

    /**
     * Ensures that 6aus49 results render correct amount and type of number circles.
     */
    @Test
    fun test6aus49_CorrectNumberRendering() {
        val lotto = LottoTestData.sixAus49()

        composeTestRule.setContentUnderTest(lotto)

        lottoResultItemPageObject.assertNumbersRowDisplayed(lotto.lottery)
        assert(lotto.numbers.size == 6)
        assert(lotto.superNumber.size == 1)

        lottoResultItemPageObject
            .findAllRegularNumbers(lotto.lottery)
            .assertCountEquals(6)
        lottoResultItemPageObject
            .findAllSuperNumbers(lotto.lottery)
            .assertCountEquals(1)
    }

    /**
     * Verifies that the super number circle has the correct semantics (SUPER kind) for 6aus49 lottery.
     */
    @Test
    fun test6aus49_SuperNumberHasCorrectSemantics() {
        val lotto = LottoTestData.sixAus49()

        composeTestRule.setContentUnderTest(lotto)

        val superCircle = composeTestRule.onNodeWithTag("super_number_6aus49_0")
        superCircle.assertIsDisplayed()

        composeTestRule
            .onNodeWithTag("super_number_6aus49_0_text")
            .assertExists()
            .assertTextEquals(lotto.superNumber.first().toString())
        composeTestRule.assertCircleKind("super_number_6aus49_0", CircleKind.SUPER)
    }

    /**
     * Ensures that numbers are rendered in the correct order for 6aus49 lottery.
     */
    @Test
    fun test6aus49_NumbersRenderedInCorrectOrder() {
        val lotto = LottoTestData.sixAus49(
            numbers = listOf(10, 32, 3, 40, 15, 6),
            superNumber = listOf(7)
        )

        composeTestRule.setContentUnderTest(lotto)

        lotto.numbers.forEachIndexed { index, expected ->
            composeTestRule
                .onNodeWithTag("regular_number_6aus49_${index}_text")
                .assertExists()
                .assertTextEquals(expected.toString())
        }

        lotto.superNumber.forEachIndexed { index, expected ->
            composeTestRule
                .onNodeWithTag("super_number_6aus49_${index}_text")
                .assertExists()
                .assertTextEquals(expected.toString())
        }
    }
}

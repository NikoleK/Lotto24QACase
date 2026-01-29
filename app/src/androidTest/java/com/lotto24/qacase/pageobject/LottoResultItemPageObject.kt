package com.lotto24.qacase.pageobject

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import java.util.Locale

class LottoResultItemPageObject(
    private val composeTestRule: ComposeContentTestRule
) {

    private fun tagName(name: String) = name.lowercase(Locale.ROOT)

    /**
     * Matches nodes whose TestTag starts with the given prefix.
     * Useful when tags are dynamic and contain indices.
     */
    private fun hasTestTagPrefix(prefix: String): SemanticsMatcher =
        SemanticsMatcher("has test tag starting with '$prefix'") { node ->
            val testTag = node.config.getOrNull(SemanticsProperties.TestTag)
            testTag?.startsWith(prefix) == true
        }

    private fun hasTestTagNotEndingWith(suffix: String): SemanticsMatcher =
        SemanticsMatcher("has test tag not ending with '$suffix'") { node ->
            val testTag = node.config.getOrNull(SemanticsProperties.TestTag)
            testTag?.endsWith(suffix) != true
        }

    fun findLottoCard(lotteryName: String): SemanticsNodeInteraction =
        composeTestRule.onNodeWithTag("lotto_result_card_${tagName(lotteryName)}")

    fun findLotteryName(lotteryName: String): SemanticsNodeInteraction =
        composeTestRule.onNodeWithTag("lotto_name_${tagName(lotteryName)}")

    fun findLastDrawDate(lotteryName: String): SemanticsNodeInteraction =
        composeTestRule.onNodeWithTag("last_draw_date_${tagName(lotteryName)}")

    fun findNextDrawDate(lotteryName: String): SemanticsNodeInteraction =
        composeTestRule.onNodeWithTag("next_draw_date_${tagName(lotteryName)}")

    fun findAllRegularNumbers(lotteryName: String): SemanticsNodeInteractionCollection {
        val prefix = "regular_number_${tagName(lotteryName)}_"
        return composeTestRule.onAllNodes(
            hasTestTagPrefix(prefix) and hasTestTagNotEndingWith("_text")
        )
    }

    fun findAllSuperNumbers(lotteryName: String): SemanticsNodeInteractionCollection {
        val prefix = "super_number_${tagName(lotteryName)}_"
        return composeTestRule.onAllNodes(
            hasTestTagPrefix(prefix) and hasTestTagNotEndingWith("_text")
        )
    }

    fun findNumbersRow(lotteryName: String): SemanticsNodeInteraction =
        composeTestRule.onNodeWithTag("numbers_row_${tagName(lotteryName)}")

    fun assertCardDisplayed(lotteryName: String) {
        findLottoCard(lotteryName).assertIsDisplayed()
    }

    fun assertLotteryNameDisplayed(lotteryName: String) {
        findLotteryName(lotteryName)
            .assertIsDisplayed()
            .assertTextEquals(lotteryName.uppercase())
    }

    fun assertLastDrawDateDisplayed(
        lotteryName: String,
        expectedFormattedDate: String
    ) {
        findLastDrawDate(lotteryName)
            .assertIsDisplayed()
            .assertTextEquals("Last Draw: $expectedFormattedDate")
    }

    fun assertNextDrawDateDisplayed(
        lotteryName: String,
        expectedFormattedDate: String
    ) {
        findNextDrawDate(lotteryName)
            .assertIsDisplayed()
            .assertTextEquals("Next Draw: $expectedFormattedDate")
    }

    fun assertRegularNumberCount(lotteryName: String, expectedCount: Int) {
        findAllRegularNumbers(lotteryName)
            .assertCountEquals(expectedCount)
    }

    fun assertSuperNumberCount(lotteryName: String, expectedCount: Int) {
        findAllSuperNumbers(lotteryName)
            .assertCountEquals(expectedCount)
    }

    fun assertNumbersRowDisplayed(lotteryName: String) {
        findNumbersRow(lotteryName).assertIsDisplayed()
    }
}
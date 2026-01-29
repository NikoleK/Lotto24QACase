package com.lotto24.qacase.helper

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import com.lotto24.qacase.domain.model.LottoDomain
import com.lotto24.qacase.ui.LottoResultItem
import com.lotto24.qacase.ui.semantics.CircleKind
import com.lotto24.qacase.ui.semantics.CircleKindKey
import com.lotto24.qacase.ui.theme.Lotto24QACaseTheme

fun ComposeContentTestRule.setContentUnderTest(lotto: LottoDomain) {
    setContent {
        Lotto24QACaseTheme {
            LottoResultItem(lotto = lotto)
        }
    }
    waitForIdle()
}

fun ComposeTestRule.assertCircleKind(tag: String, kind: CircleKind) {
    onNodeWithTag(tag).assert(SemanticsMatcher.expectValue(CircleKindKey, kind))
}

package com.lotto24.qacase.ui

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import com.lotto24.qacase.pageobject.LottoResultItemPageObject
import org.junit.After
import org.junit.Before
import org.junit.Rule

abstract class BaseComposeUITest {

    @get:Rule
    abstract val composeTestRule: ComposeContentTestRule

    protected lateinit var lottoResultItemPageObject: LottoResultItemPageObject

    @Before
    fun setup() {
        lottoResultItemPageObject = LottoResultItemPageObject(composeTestRule)
    }
}

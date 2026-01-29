package com.lotto24.qacase.ui.semantics

import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver

enum class CircleKind { REGULAR, SUPER }

val CircleKindKey = SemanticsPropertyKey<CircleKind>("CircleKind")
var SemanticsPropertyReceiver.circleKind by CircleKindKey

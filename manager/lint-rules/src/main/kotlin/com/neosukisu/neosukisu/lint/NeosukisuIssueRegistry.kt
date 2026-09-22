package com.neosukisu.neosukisu.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API

class NeosukisuIssueRegistry : IssueRegistry() {
    override val issues = listOf(SegmentedColumnScopeConditionDetector.ISSUE)
    override val api = CURRENT_API
}

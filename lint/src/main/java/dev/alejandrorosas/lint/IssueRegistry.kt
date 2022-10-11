package dev.alejandrorosas.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API

class IssueRegistry : IssueRegistry() {
    override val api = CURRENT_API
    override val issues = listOf(
        ComposableIncorrectPackageDetector.ISSUE,
    )
}

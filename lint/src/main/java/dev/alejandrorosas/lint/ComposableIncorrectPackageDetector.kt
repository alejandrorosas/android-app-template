package dev.alejandrorosas.lint

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import org.jetbrains.uast.UAnnotation
import org.jetbrains.uast.getContainingUFile
import org.jetbrains.uast.getIoFile

class ComposableIncorrectPackageDetector : Detector(), Detector.UastScanner {
    companion object {
        @JvmField
        val ISSUE = Issue.create(
            id = "ComposableIncorrectPackage",
            briefDescription = "Composable with invalid filename or package",
            explanation = "Lint that detects if a Composable annotation is located in a incorrect package or filename",
            category = Category.CORRECTNESS,
            severity = Severity.ERROR,
            implementation = Implementation(
                ComposableIncorrectPackageDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
                Scope.JAVA_FILE_SCOPE,
            ),
        )

        private const val COMPOSABLE = "androidx.compose.runtime.Composable"
        private val COMPOSE_EXCLUDED_PACKAGE_REGEX = "(^|.*\\.?)compose(\\..*|$)".toRegex()
        private val COMPOSE_EXCLUDED_FOLDER_REGEX = ".*U[Ii].kt$".toRegex()
    }

    override fun getApplicableUastTypes() = listOf(UAnnotation::class.java)

    override fun createUastHandler(context: JavaContext): UElementHandler = UnnamedInjectionDetectorHandler(context)

    private inner class UnnamedInjectionDetectorHandler constructor(
        private val context: JavaContext,
    ) : UElementHandler() {

        override fun visitAnnotation(node: UAnnotation) {
            if (node.qualifiedName != COMPOSABLE) return

            if (node.getContainingUFile()?.packageName?.matches(COMPOSE_EXCLUDED_PACKAGE_REGEX) != true &&
                node.getContainingUFile()?.getIoFile()?.name?.matches(COMPOSE_EXCLUDED_FOLDER_REGEX) != true) {
                context.report(
                    issue = ISSUE,
                    location = context.getLocation(node),
                    message = "Please place your composables under the `compose` package or add the suffix `Ui`on the filename",
                )
            }
        }
    }

}

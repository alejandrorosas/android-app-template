package dev.alejandrorosas.lint

import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.checks.infrastructure.TestFiles.kotlin
import com.android.tools.lint.checks.infrastructure.TestLintTask
import com.android.tools.lint.detector.api.Severity
import org.junit.Test

class ComposableIncorrectPackageDetectorTest {

    @Test
    fun correctFilename() {
        TestLintTask.lint()
            .files(
                kotlin(
                    "src/main/java/foo/FooUi.kt",
                    """
                    package foo

                    import androidx.compose.runtime.Composable

                    @Composable fun Foo() = Unit
                    """,
                ).indented(),
                composable,
            )
            .issues(ComposableIncorrectPackageDetector.ISSUE)
            .run()
            .expectClean()
    }

    @Test
    fun invalidFilenameAndPackage() {
        TestLintTask.lint()
            .files(
                kotlin(
                    "src/main/java/foo/Foo.kt",
                    """
                    package foo

                    import androidx.compose.runtime.Composable

                    @Composable fun Foo() = Unit
                    """,
                ).indented(),
                composable,
            )
            .issues(ComposableIncorrectPackageDetector.ISSUE)
            .run()
            .expectCount(1, Severity.ERROR)
    }

    @Test
    fun correctPackage() {
        TestLintTask.lint()
            .files(
                kotlin(
                    "src/main/java/foo/Foo.kt",
                    """
                    package foo.compose

                    import androidx.compose.runtime.Composable

                    @Composable fun Foo() = Unit
                    """,
                ).indented(),
                composable,
            )
            .issues(ComposableIncorrectPackageDetector.ISSUE)
            .run()
            .expectClean()
    }

    // Stubs:
    private val composable: TestFile = kotlin(
        """
            package androidx.compose.runtime

            @Retention(AnnotationRetention.BINARY)
            @Target(
                AnnotationTarget.FUNCTION,
                AnnotationTarget.TYPE,
                AnnotationTarget.TYPE_PARAMETER,
                AnnotationTarget.PROPERTY_GETTER
            )
            annotation class Composable
    """,
    ).indented()
}

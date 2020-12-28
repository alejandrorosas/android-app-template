package dev.alejandrorosas.featuretemplate.di

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import dev.alejandrorosas.featuretemplate.ui.FeatureTemplate
import dev.alejandrorosas.core.di.Navigation
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class FeatureTemplateModule {
    @Provides
    @IntoSet
    fun provideFeatureTemplateNavigation(): Navigation {
        return object : Navigation {
            override fun compose(
                navGraphBuilder: NavGraphBuilder,
                navController: NavController,
            ) {
                navGraphBuilder.composable("feature_template") {
                    FeatureTemplate(navController)
                }
            }
        }
    }

    @Provides
    @Named("hello")
    fun provideInitialCounter(): Int {
        return 5
    }
}

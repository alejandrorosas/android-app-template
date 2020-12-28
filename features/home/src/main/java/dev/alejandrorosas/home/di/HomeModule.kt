package dev.alejandrorosas.home.di

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import dev.alejandrorosas.core.di.INITIAL_ROUTE
import dev.alejandrorosas.core.di.Navigation
import dev.alejandrorosas.home.ui.Home
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class HomeModule {
    @Provides
    @Named(INITIAL_ROUTE)
    fun primeEmptyNavigationSet(): String = "home"

    @Provides
    @IntoSet
    fun provideHomeNavigation(): Navigation {
        return object : Navigation {
            override fun compose(
                navGraphBuilder: NavGraphBuilder,
                navController: NavController,
            ) {
                navGraphBuilder.composable("home") {
                    Home(navController)
                }
            }
        }
    }
}

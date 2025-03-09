package dev.alejandrorosas.home.di

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
    fun provideHomeNavigation() =
        Navigation { navController ->
            composable("home") {
                Home(navController)
            }
        }
}

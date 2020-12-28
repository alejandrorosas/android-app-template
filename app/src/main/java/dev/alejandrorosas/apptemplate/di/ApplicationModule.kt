package dev.alejandrorosas.apptemplate.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ElementsIntoSet
import dev.alejandrorosas.core.di.Navigation

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @ElementsIntoSet
    fun primeEmptyNavigationSet(): Set<Navigation> {
        return emptySet()
    }
}

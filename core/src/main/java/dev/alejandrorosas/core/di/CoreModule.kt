package dev.alejandrorosas.core.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

const val INITIAL_ROUTE = "home"

@Module
@InstallIn(SingletonComponent::class)
class CoreModule

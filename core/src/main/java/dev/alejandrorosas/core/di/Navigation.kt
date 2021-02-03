package dev.alejandrorosas.core.di

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface Navigation {
    fun compose(navGraphBuilder: NavGraphBuilder, navController: NavController)
}

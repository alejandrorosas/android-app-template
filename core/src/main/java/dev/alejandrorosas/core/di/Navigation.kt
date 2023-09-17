package dev.alejandrorosas.core.di

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

fun interface Navigation {
    fun prepare(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
    ) {
        navGraphBuilder.compose(navController)
    }

    fun NavGraphBuilder.compose(navController: NavController)
}

package dev.alejandrorosas.apptemplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.alejandrorosas.apptemplate.di.DaggerMainActivityComponent
import dev.alejandrorosas.core.di.coreComponent

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMainActivityComponent.builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }
}

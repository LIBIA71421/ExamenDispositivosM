package com.ucb.examendispositivosm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ucb.examendispositivosm.navigation.AppNavigation
import com.ucb.examendispositivosm.ui.theme.ExamenDispositivosMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamenDispositivosMTheme   {
                AppNavigation()
            }
        }
    }
}

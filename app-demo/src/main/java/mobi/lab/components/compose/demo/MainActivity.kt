package mobi.lab.components.compose.demo

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mobi.lab.components.compose.demo.button.ButtonDestination
import mobi.lab.components.compose.demo.color.ColorsDestination
import mobi.lab.components.compose.demo.progress.ProgressDestination
import mobi.lab.components.compose.demo.typography.TypographyDestination

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val navUp: () -> Unit = remember { { navController.navigateUp() } }
            NavHost(navController = navController, startDestination = NavDestination.ComponentList) {
                composable<NavDestination.ComponentList> {
                    ComponentListDestination(
                        onButtonsClicked = { navController.navigate(NavDestination.Button) },
                        onColorsClicked = { navController.navigate(NavDestination.Colors) },
                        onTypographyClicked = { navController.navigate(NavDestination.Typography) },
                        onProgressClicked = { navController.navigate(NavDestination.Progress) },
                        onToggleLightDarkModeClicked = ::toggleLightDarkMode
                    )
                }

                composable<NavDestination.Button> {
                    ButtonDestination(
                        onNavigateUp = navUp,
                        onToggleLightDarkModeClicked = ::toggleLightDarkMode,
                    )
                }
                composable<NavDestination.Colors> {
                    ColorsDestination(
                        navUp,
                        onToggleLightDarkModeClicked = ::toggleLightDarkMode,
                    )
                }
                composable<NavDestination.Typography> {
                    TypographyDestination(
                        navUp,
                        onToggleLightDarkModeClicked = ::toggleLightDarkMode,
                    )
                }
                composable<NavDestination.Progress> {
                    ProgressDestination(
                        navUp,
                        onToggleLightDarkModeClicked = ::toggleLightDarkMode,
                    )
                }
            }
        }
    }

    private fun toggleLightDarkMode() {
        val nightMode = if (isNightModeEnabled()) {
            AppCompatDelegate.MODE_NIGHT_NO
        } else {
            AppCompatDelegate.MODE_NIGHT_YES
        }
        AppCompatDelegate.setDefaultNightMode(nightMode)
    }

    private fun isNightModeEnabled(): Boolean {
        val uiMode: Int = resources?.configuration?.uiMode ?: return false
        return uiMode.and(Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
    }
}

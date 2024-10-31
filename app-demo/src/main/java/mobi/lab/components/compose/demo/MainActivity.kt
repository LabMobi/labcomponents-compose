package mobi.lab.components.compose.demo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mobi.lab.components.compose.demo.button.ButtonDestination
import mobi.lab.components.compose.demo.color.ColorsDestination
import mobi.lab.components.compose.demo.typography.TypographyDestination

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
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
                    )
                }

                composable<NavDestination.Button> { ButtonDestination(navUp) }
                composable<NavDestination.Colors> { ColorsDestination(navUp) }
                composable<NavDestination.Typography> { TypographyDestination(navUp) }
            }
        }
    }
}

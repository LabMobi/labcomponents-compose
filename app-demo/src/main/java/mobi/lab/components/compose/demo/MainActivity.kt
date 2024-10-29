package mobi.lab.components.compose.demo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mobi.lab.components.compose.demo.color.ColorsDestination
import mobi.lab.components.compose.demo.typography.TypographyDestination

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = NavDestination.ComponentList) {
                composable<NavDestination.ComponentList> {
                    ComponentListDestination(
                        onColorsClicked = { navController.navigate(NavDestination.Colors) },
                        onTypographyClicked = { navController.navigate(NavDestination.Typography) },
                    )
                }

                composable<NavDestination.Colors> { ColorsDestination { navController.navigateUp() } }
                composable<NavDestination.Typography> { TypographyDestination { navController.navigateUp() } }
            }
        }
    }
}

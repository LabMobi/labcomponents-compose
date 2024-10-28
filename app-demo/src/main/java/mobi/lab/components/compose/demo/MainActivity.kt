package mobi.lab.components.compose.demo

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mobi.lab.components.compose.demo.list.ComponentListScreen

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = NavDestination.ComponentList) {
                composable<NavDestination.ComponentList> {
                    ComponentListScreen()
                }
            }
        }
    }

    // TODO reimpl somehow?
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menu.add(0, MENU_ITEM_SWITCH_NIGHT_MODE, 0, "Switch UI mode")
//        // Uncomment this to open MaterialThemeActivity to validate components with a regular Material theme
//        menu.add(0, MENU_ITEM_SWITCH_MATERIAL_THEME, 1, "Open Material Activity")
//        return true
//    }

    // TODO reimpl?
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            MENU_ITEM_SWITCH_NIGHT_MODE -> {
//                toggleNightMode()
//                true
//            }
//            MENU_ITEM_SWITCH_MATERIAL_THEME -> {
//                startActivity(Intent(this, MaterialThemeActivity::class.java))
//                true
//            }
//            else -> {
//                super.onOptionsItemSelected(item)
//            }
//        }
//    }

    // TODO reuse
    private fun toggleNightMode() {
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

    companion object {
        private const val MENU_ITEM_SWITCH_NIGHT_MODE = 0
        private const val MENU_ITEM_SWITCH_MATERIAL_THEME = 1
    }
}

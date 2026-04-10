import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composenavigation.ui.Screen

@Composable
fun BottomNavBar(navController: NavHostController) {

    val items = listOf(
        Screen.Home,
        Screen.Search,
        Screen.Profile
    )

    NavigationBar {

        val currentDestination =
            navController.currentBackStackEntryAsState().value?.destination

        items.forEach { screen ->

            NavigationBarItem(
                selected = currentDestination?.route == screen.route,
                onClick = {
                    navController.navigate(screen.route) {

                        launchSingleTop = true
                        restoreState = true

                        popUpTo("home_graph") {
                            saveState = true
                        }
                    }
                },
                label = { Text(screen.route) },
                icon = {}
            )
        }
    }
}
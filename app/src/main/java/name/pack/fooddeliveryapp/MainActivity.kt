package name.pack.fooddeliveryapp

import DishListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import name.pack.fooddeliveryapp.ui.theme.FoodDeliveryAppTheme


@Composable
fun YourApp() {
    val navController = rememberNavController()
    FoodDeliveryAppTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorScheme.background
        ) {
            NavHost(
                navController = navController,
                startDestination = "login"
            ) {
                composable("login") {
                    LoginScreen(navController = navController)
                }
                composable("restaurantList"){
                    RestaurantListScreen(navController = navController)
                }
                // Define navigation destinations for each restaurant
                composable("dishList/{restaurantName}") { backStackEntry ->
                    val restaurantName = backStackEntry.arguments?.getString("restaurantName")
                    DishListScreen(navController = navController, restaurantName = restaurantName.orEmpty())
                }


            }
        }
    }
}

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YourApp()
        }
    }
}

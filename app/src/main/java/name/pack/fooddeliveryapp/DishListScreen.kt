import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import name.pack.fooddeliveryapp.R

@Composable
fun DishListScreen(navController: NavController, restaurantName: String) {
    val dishes = when (restaurantName) {
        "McDonald's" -> {
            listOf(
                Dish("McAloo Tikki", R.drawable.mcaloo_tikki, "52"),
                Dish("McSpicy Paneer", R.drawable.mcspicy_paneer, "180"),
                Dish("McVeggie", R.drawable.mcveggie, "106")
            )
        }
        "Domino's Pizza" -> {
            listOf(
                Dish("Margherita Pizza", R.drawable.margherita, "109"),
                Dish("Veg Extravaganza Pizza", R.drawable.veg_extravaganza, "319"),
                Dish("Peppy Paneer Pizza", R.drawable.peppy_paneer, "269")
            )
        }
        "Subway" -> {
            listOf(
                Dish("Veggie Delite", R.drawable.veggie_delight, "200"),
                Dish("Mexican Patty", R.drawable.mexican_patty, "250"),
                Dish("Hara Bhara Kebab", R.drawable.hara_bhara_kebab, "250")
            )
        }
        else -> emptyList()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        val backgroundResId = R.drawable.restaurant_background
        Image(
            painter = painterResource(id = backgroundResId),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Dish list
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(dishes) { dish ->
                DishCard(dish = dish)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

data class Dish(val name: String, val imageResId: Int, val price: String)

@Composable
fun DishCard(dish: Dish) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = dish.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .aspectRatio(1f)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = dish.name,
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "₹${dish.price}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(Color.Red)
                    ) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "ADD", color = Color.White)
                    }
                }
            }
        }
    }
}

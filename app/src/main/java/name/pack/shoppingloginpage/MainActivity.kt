package name.pack.shoppingloginpage

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import android.os.Bundle
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.text.TextStyle
import androidx.annotation.DrawableRes
import androidx.compose.foundation.shape.CircleShape
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.background(Color(0xFFE0E0E0)).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                simpleText()
                simpleTextField("User Name")
                simplePasswordField("Password")
                LoginPage()
            }
        }
    }
}

@Composable
fun simpleText() {
    Text(
        text = "Login Page",
        modifier = Modifier.padding(16.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun simpleTextField(label: String) {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { it -> text = it },
        label = { Text(text = label) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun simplePasswordField(label: String) {
    var password by remember { mutableStateOf("") }
    TextField(
        value = password,
        onValueChange = { it -> password = it },
        label = { Text(text = label) }
    )
}


@Composable
fun LoginPage(){
    var selectedWebsite by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            WebsiteLogo(
                R.drawable.amazon,
                "Amazon",
                selectedWebsite,
                onSelectWebsite = { selectedWebsite = "Amazon" }
            )
            WebsiteLogo(
                R.drawable.flipkart,
                "Flipkart",
                selectedWebsite,
                onSelectWebsite = { selectedWebsite = "Flipkart" }
            )
            WebsiteLogo(
                R.drawable.myntra,
                "Myntra",
                selectedWebsite,
                onSelectWebsite = { selectedWebsite = "Myntra" }
            )
            WebsiteLogo(
                R.drawable.jiomart,
                "JioMart",
                selectedWebsite,
                onSelectWebsite = { selectedWebsite = "JioMart" }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {
                if (selectedWebsite.isNotEmpty()) {
                    val url = when (selectedWebsite) {
                        "Amazon" -> "https://www.amazon.com"
                        "Flipkart" -> "https://www.flipkart.com"
                        "Myntra" -> "https://www.myntra.com"
                        "JioMart" -> "https://www.jiomart.com"
                        else -> ""
                    }

                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Login on Selected Website")
        }
    }


@Composable
fun WebsiteLogo(
    logoResId: Int,
    websiteName: String,
    selectedWebsite: String,
    onSelectWebsite: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .background(
                if (websiteName == selectedWebsite) {
                    MaterialTheme.colorScheme.primary
                } else {
                    Color.Transparent
                }
            )
            .clickable { onSelectWebsite() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = logoResId),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(60.dp)
                .scale(if (websiteName == selectedWebsite) 1.2f else 1f)
        )
    }
}

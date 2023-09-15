package name.pack.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                simpleText()
                simpleTextField("User Name")
                simplePasswordField("Password")
                simpleButton()
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
fun simpleButton() {
    Button(modifier = Modifier.padding(16.dp), onClick = { /*TODO: Handle login logic*/ }) {
        Text(text = "Submit")
    }
}

@Preview
@Composable
fun LoginPagePreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        simpleText()
        simpleTextField("User Name")
        simplePasswordField("Password")
        simpleButton()
    }
}

package com.example.contactapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.contactapp2.presentation.navigation.AppNavigation
import com.example.contactapp2.ui.theme.ContactApp2Theme

class MainActivity : ComponentActivity() {
   val ViewModel by viewModels<ContactAppViewModel> (
        factoryProducer = {
            object : ViewModelProvider.Factory
            {
                override fun <T : ViewModel> create(modelClass: Class<T>): T
                {
                    return ContactAppViewModel(this@MainActivity) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactApp2Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                  AppNavigation(viewModel = ViewModel )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)

@Composable
fun GreetingPreview() {
    ContactApp2Theme {
        Greeting("Android")
    }
}


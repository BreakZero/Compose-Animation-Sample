package org.easy.sample.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.easy.sample.animation.animation.MultipleValuesAnimationRoute
import org.easy.sample.animation.animation.ValueAnimationRoute
import org.easy.sample.animation.animation.VisibleAnimationRoute
import org.easy.sample.animation.routes.routes
import org.easy.sample.animation.ui.theme.ComposeAnimationSampleTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAnimationSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "index") {
                        composable("index") {
                            LazyColumn(
                                verticalArrangement = Arrangement.spacedBy(10.dp),
                                modifier = Modifier.fillMaxSize()
                            ) {
                                items(routes) { route ->
                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(48.dp),
                                        onClick = {
                                            navController.navigate(route.route)
                                        }) {
                                        Text(
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.fillMaxSize(),
                                            text = route.label
                                        )
                                    }
                                }
                            }
                        }
                        composable("value_animation") {
                            ValueAnimationRoute()
                        }
                        composable("visible_animation") {
                            VisibleAnimationRoute()
                        }
                        composable("multiple_value_animation") {
                            MultipleValuesAnimationRoute()
                        }
                    }
                }
            }
        }
    }
}


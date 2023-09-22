package com.example.lab1pt2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.sp
import com.example.lab1pt2.ui.theme.Lab1pt2Theme

/*
A simple Android app that present apple pie recipe. There
shall also be a button, and when clicked the recipe text will be invisible
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1pt2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray
                ) {
                    RecipeApp()
                }
            }
        }
    }
}

@Composable
fun RecipeApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Just An Apple Pie",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        )
        recipeButton()
    }
}

@Composable
fun recipeButton(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ){

        var isRecipeVisible by remember { mutableStateOf(true) }
        Button(onClick = {
            isRecipeVisible = !isRecipeVisible
        }) {
            Text(if (isRecipeVisible) "Hide Recipe" else "Show Recipe")
        }

        if (isRecipeVisible) {
            val ingredients = recipeText()
            for (ingredient in ingredients) {
                Text(text = ingredient)
            }
        }
        // Just attaching the images to the button,
        // this way they will follow the expanding text without me having to fiddle with stuff
        Row {
            images()
        }
    }
}

@Composable
fun images(){
    Image(
        painter = painterResource(R.drawable.pieimageone),
        contentDescription = "Image One",
        modifier = Modifier
            .height(160.dp)
            .width(160.dp)
    )
    Image(
        painter = painterResource(R.drawable.pieimagetwo),
        contentDescription = "Image Two",
        modifier = Modifier
            .height(160.dp)
            .width(160.dp)
    )
}

fun recipeText() : Array<String> {
    // making this an array to separate the ingredients into indexes
    val ingredients = arrayOf(
        "Dough for double-crust pie",
        "1/3 cup sugar",
        "1/3 cup packed brown sugar",
        "1/4 cup all-purpose flour",
        "1 teaspoon ground cinnamon",
        "1/4 teaspoon ground ginger",
        "1/4 teaspoon ground nutmeg",
        "6 to 7 cups thinly sliced peeled tart apples",
        "1 tablespoon lemon juice",
        "1 tablespoon butter",
        "1 large egg white",
        "Optional: Turbinado or coarse sugar, ground cinnamon, vanilla bean ice cream and caramel sauce"
    )
    return ingredients
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeApp() {
    Lab1pt2Theme {
        RecipeApp()
    }
}

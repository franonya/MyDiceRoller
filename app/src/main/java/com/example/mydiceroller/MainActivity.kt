package com.example.mydiceroller

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mydiceroller.ui.theme.MyDiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DiceApp()
                }
            }
        }
    }
}

@Composable
fun DiceApp() {
    var count by remember {
        mutableStateOf(1)
    }
    var num: Any by remember {
        mutableStateOf(1)
    }

    val imageResource=  when(num)
    {
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else->R.drawable.dice_6
    }
    Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally) {
        

    Image(painter = painterResource(imageResource), contentDescription ="" )
        Text(text = "$count",
                color= Color.Magenta,
                fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { num=(1..6).random()
    count= count+num as Int


        }) {
            Text(text = "Roll")
        }

    }


}

@Composable
public fun MyToast()
{
    val context = LocalContext.current
    Toast.makeText(context,"This a simple toast tutorial!", Toast.LENGTH_LONG).show()

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyDiceRollerTheme {
        DiceApp()
    }
}


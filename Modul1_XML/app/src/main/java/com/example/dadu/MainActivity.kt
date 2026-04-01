package com.example.dadu

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
// Import R ini sudah benar mengarah ke packagemu
import com.example.dadu.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerApp()
        }
    }
}

@Composable
fun DiceRollerApp() {
    // State untuk menyimpan nilai dadu (0 = kosong)
    var dice1Value by remember { mutableIntStateOf(0) }
    var dice2Value by remember { mutableIntStateOf(0) }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DiceImage(diceValue = dice1Value)
            DiceImage(diceValue = dice2Value)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            // Mengacak nilai dadu 1 s/d 6
            dice1Value = (1..6).random()
            dice2Value = (1..6).random()

            // Logika pengecekan nilai dadu
            if (dice1Value == dice2Value) {
                Toast.makeText(context, "Selamat, anda dapat dadu double!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Anda belum beruntung!", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Roll")
        }
    }
}

@Composable
fun DiceImage(diceValue: Int) {
    // Menentukan gambar berdasarkan nilai dadu
    val imageResource = when (diceValue) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> R.drawable.dice_0 // Tampilan awal dadu kosong
    }

    Image(
        painter = painterResource(id = imageResource),
        contentDescription = "Dadu $diceValue",
        modifier = Modifier.size(100.dp)
    )
}
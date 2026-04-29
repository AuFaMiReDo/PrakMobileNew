package com.example.hunternotesmodul3

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MonsterListScreen(monsters: List<Monster>, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "List Horizontal (LazyRow)",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 4.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            items(monsters) { monster ->
                Box(modifier = Modifier.width(320.dp)) {
                    MonsterItemCard(monster = monster, navController = navController)
                }
            }
        }

        Text(
            text = "List Vertical (LazyColumn)",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 4.dp)
        )

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(monsters) { monster ->
                MonsterItemCard(monster = monster, navController = navController)
            }
        }
    }
}

@Composable
fun MonsterItemCard(monster: Monster, navController: NavController) {
    val context = LocalContext.current

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            Image(
                painter = painterResource(id = monster.imageResId),
                contentDescription = "Gambar ${monster.name}",
                modifier = Modifier
                    .size(110.dp, 160.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = monster.name, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
                    Text(text = monster.species, style = MaterialTheme.typography.labelMedium)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    Text(text = "Desc: ", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodySmall)
                    Text(
                        text = monster.description,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(monster.wikiUrl))
                            context.startActivity(intent)
                        },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text("Wiki")
                    }

                    Button(
                        onClick = {
                            navController.navigate("detail/${monster.id}")
                        }
                    ) {
                        Text("Detail")
                    }
                }
            }
        }
    }
}
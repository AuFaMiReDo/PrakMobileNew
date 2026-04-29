package com.example.hunternotesmodul3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hunternotesmodul3.ui.theme.HunterNotesModul3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HunterNotesModul3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()
                    val viewModel: MonsterViewModel = viewModel()

                    NavHost(
                        navController = navController,
                        startDestination = "list",
                        modifier = Modifier.padding(innerPadding)
                    ) {

                        composable("list") {
                            MonsterListScreen(
                                monsters = viewModel.monsterList,
                                navController = navController
                            )
                        }

                        composable("detail/{monsterId}") { backStackEntry ->
                            val monsterId = backStackEntry.arguments?.getString("monsterId")?.toIntOrNull()
                            val selectedMonster = viewModel.monsterList.find { it.id == monsterId }

                            if (selectedMonster != null) {
                                MonsterDetailScreen(monster = selectedMonster)
                            }
                        }
                    }
                }
            }
        }
    }
}
package com.example.fitnesstest

import android.content.Context
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnesstest.model.Exercise
import com.example.fitnesstest.model.ExerciseListItemModel
import com.example.fitnesstest.model.ExercisePropertiesModel
import com.example.fitnesstest.model.WorkoutPlan
import com.example.fitnesstest.ui.theme.FitnessTestTheme
import com.example.fitnesstest.view.ExerciseList
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.json.Json
import org.intellij.lang.annotations.JdkConstants


class MainActivity : ComponentActivity() {
    @OptIn(InternalSerializationApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val jsonString = loadJsonFromAssets(this, "workouts.json")
        val workoutPlan = Json.decodeFromString<WorkoutPlan>(jsonString)

        enableEdgeToEdge()
        setContent {
            FitnessTestTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.Gray,
                                titleContentColor = Color.White,

                            ),
                            title = {
                                Text("My Workout")
                            }
                        )
                    },
                    modifier = Modifier.fillMaxSize(), ) { innerPadding ->
                   MainScreen(Modifier.padding(innerPadding),
                       workoutPlan =  workoutPlan)
                }
            }
        }
    }
}

fun loadJsonFromAssets(context: Context, filename: String): String {
    return context.assets.open(filename).bufferedReader().use { it.readText() }
}
@OptIn(InternalSerializationApi::class)
@Composable
fun MainScreen(modifier: Modifier,
               workoutPlan: WorkoutPlan) {

    MyWorkoutScreen(workoutPlan)

}

@OptIn(InternalSerializationApi::class)
@Composable
fun MyWorkoutScreen(workoutPlan: WorkoutPlan){
    Box (modifier = Modifier
        .fillMaxSize().padding(top = 70.dp).background(Color.Gray),
        contentAlignment = Alignment.Center
    ){
        Column {
            FilterSection(workoutPlan.workouts.size)
            WorkoutSummary()
            ExerciseList(getExercises(workoutPlan), listOf(ExercisePropertiesModel(
                R.drawable.thunder,
                "6 Exercises",
            ),ExercisePropertiesModel(
                R.drawable.clock,
                "53 Min",
            ),ExercisePropertiesModel(
                R.drawable.fire,
                "265 Cal",
            )))
        }
    }
}

@OptIn(InternalSerializationApi::class)
fun getExercises(workoutPlan: WorkoutPlan): List<Exercise>{
     val exercises :MutableList<Exercise> = mutableListOf<Exercise>()
    for (workout in workoutPlan.workouts)
        exercises.addAll(workout.workout)
    return exercises

}

@Composable
fun ExercisesScreen(){
    Box (modifier = Modifier
        .fillMaxSize().padding(horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Exercise Screen",
            style = MaterialTheme.typography.headlineLarge
        )
    }

}

@Composable
fun ProgressScreen(){
    Box (modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Progress Screen",
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Composable
fun SettingsScreen(){
    Box (modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Setting Screen",
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Composable
fun FilterSection(numberOfDays: Int) {
    Column(Modifier.padding(8.dp)) {
        Row(
            Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()).padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),

        ) {
            FilterChip("Muscles (16)")
            FilterChip("45–60 Min")
            FilterChip("Schedule")
            FilterChip("Goals")
            FilterChip("Equipment")
            FilterChip("Basic Exercises")
        }
        Spacer(Modifier.height(8.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()).padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            for (i in 1..numberOfDays)
            DayTab("Day $i", if(i%3 ==0) true else false)
        }
    }
}

@Composable
fun FilterChip(label: String) {
    Box(
      modifier = Modifier.border(width = 2.dp, color = Color.Black, shape = CircleShape)
          .padding(10.dp)
    ){
        Row (horizontalArrangement = Arrangement.spacedBy (10.dp)){
            Text(label, color = Color.White)
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null, tint = Color.Black)
        }
    }
}

@Composable
fun DayTab(day: String, selected: Boolean) {
    Box(
        modifier = Modifier.border(width = 1.dp, color = Color.Black, shape = CircleShape)
            .padding(10.dp)
    ){
        Row (modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy (10.dp)){
            Text(
                text = day,
                color = if (selected) Color.Blue else Color.White,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
            )
        }
    }

}

@Composable
fun WorkoutSummary() {
    Column(Modifier.padding(16.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text("Week 1/5 - Foundations", color = Color.Blue,
            textAlign = TextAlign.Center,

            fontSize = 12.sp)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("UPCOMING WORKOUT", fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.White)
            Spacer(Modifier.width(8.dp))
            Icon(imageVector = Icons.Default.Edit, contentDescription = null, tint = Color.Black)
        }
        Text("Push", color = Color.White)
    }
}
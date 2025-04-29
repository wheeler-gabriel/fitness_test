package com.example.fitnesstest.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.example.fitnesstest.R
import com.example.fitnesstest.model.Exercise
import com.example.fitnesstest.model.ExerciseListItemModel
import com.example.fitnesstest.model.ExercisePropertiesModel
import kotlinx.serialization.InternalSerializationApi


@OptIn(InternalSerializationApi::class)
@Composable
fun ExerciseList(
    list: List<Exercise>,
    propertiesList: List<ExercisePropertiesModel>
){
    val context = LocalContext.current

    Box (
        modifier = Modifier.fillMaxWidth().size(600.dp).padding(20.dp).clip(RoundedCornerShape(20.dp)).background(Color.DarkGray)

    ){
        Column (
            modifier = Modifier.align (Alignment.BottomCenter).padding(10.dp).verticalScroll(rememberScrollState())
        ){
            ExercisePropertiesList(propertiesList)
            for (item in list)
                ExerciseListItem(
                    title = item.exercise_name,
                    subtitle = item.assembleSubtitle(),
                    muscleGroupImage = context.resources.getIdentifier(item.muscle_group_image, "drawable", context.packageName),
                    exerciseImage = context.resources.getIdentifier(item.exercise_thumbnail, "drawable", context.packageName)
                )
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp))

        {
            Text("START WORKOUT", color = Color.Black)
        }


    }
}

@Composable
fun StartWorkoutButton(modifier: Modifier) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
        modifier = modifier

    ) {
        Text("START WORKOUT", color = Color.Black)
    }
}


package com.example.fitnesstest.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.fitnesstest.R
import com.example.fitnesstest.model.ExercisePropertiesModel


@Composable
fun ExercisePropertiesListItem(
    image: Int,text:String
){
    Row {
        Image(
            painter =  painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .size(20.dp)

        )
        Text(text)
    }
}


@Composable
fun ExercisePropertiesList(list: List<ExercisePropertiesModel>){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        for(item in list)
            ExercisePropertiesListItem(item.imageId, item.text)
    }
}
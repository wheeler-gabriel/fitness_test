package com.example.fitnesstest.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp




@Composable
fun ExerciseListItem(
    exerciseImage: Int,
    title: String,
    subtitle: String,
    muscleGroupImage: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(exerciseImage),
                    contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .size(70.dp,70.dp)

        )
//        Image(
//            imageVector = ImageVector.vectorResource(id = exerciseImage),
//            contentDescription = null,
//            modifier = Modifier
//                .size(48.dp)
//                .clip(RoundedCornerShape(8.dp))
//        )


        Spacer(modifier = Modifier.width(12.dp))

        // Title and subtitle
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

//        Image(
//            imageVector = ImageVector.vectorResource(id = muscleGroupImage),
//            contentDescription = null,
//            modifier = Modifier.size(32.dp)
//        )
        Image(
            painter = painterResource(muscleGroupImage),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(48.dp)

        )
   
    }
}
package com.example.fitnesstest.model

import kotlinx.serialization.Serializable


@Serializable
@kotlinx. serialization. InternalSerializationApi
data class WorkoutDay(
    val day: Int,
    val workout: List<Exercise>
)
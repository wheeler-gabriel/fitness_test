package com.example.fitnesstest.model

import kotlinx.serialization.Serializable


@Serializable
@kotlinx. serialization. InternalSerializationApi
data class WorkoutPlan(
    val workouts: List<WorkoutDay>
)

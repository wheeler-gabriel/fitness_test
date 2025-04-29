package com.example.fitnesstest.model
import kotlinx.serialization.Serializable

@Serializable
@kotlinx. serialization. InternalSerializationApi
data class Exercise(

    val exercise_id: Int,
    val exercise_name: String,
    val exercise_thumbnail: String,
    val muscle_group: String,
    val muscle_group_image: String,
    val amount_of_sets: Int,
    val rep_range: String,
    val weight_amount: String?){

    fun assembleSubtitle() : String{
        return "$amount_of_sets sets x $rep_range reps x $weight_amount lb"
    }
}
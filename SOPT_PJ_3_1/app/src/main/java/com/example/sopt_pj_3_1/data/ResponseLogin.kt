package com.example.sopt_pj_3_1.data

data class ResponseLogin (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : SomeData?
)

data class SomeData (
    val jwt : String
)
package com.example.sopt_pj_3_1.network

import com.example.sopt_pj_3_1.data.RequestLogin
import com.example.sopt_pj_3_1.data.RequestRegister
import com.example.sopt_pj_3_1.data.ResponseLogin
import com.example.sopt_pj_3_1.data.ResponseRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface {
    @POST("/user/signin")
    fun requestLogin(@Body body : RequestLogin) : Call<ResponseLogin>

    @POST("/user/signup")
    fun requestRegister(@Body body : RequestRegister) : Call<ResponseRegister>
}
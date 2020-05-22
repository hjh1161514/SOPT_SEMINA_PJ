package com.example.sopt_pj_3_1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sopt_pj_3_1.data.RequestRegister
import com.example.sopt_pj_3_1.data.ResponseRegister
import com.example.sopt_pj_3_1.network.RequestToServer
import kotlinx.android.synthetic.main.register_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterActivity : AppCompatActivity() {

    val requestToServer = RequestToServer //싱글톤 그대로 가져옴

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)

        btn_register.setOnClickListener{

            if(et_id.text.isNullOrBlank()||et_pw.text.isNullOrBlank()||et_pw_check.text.isNullOrBlank()
                ||et_name.text.isNullOrBlank()||et_email.text.isNullOrBlank()||et_phone.text.isNullOrBlank()){
                Toast.makeText(this@RegisterActivity, "입력칸이 비었습니다.", Toast.LENGTH_SHORT).show()
            }

            else if((et_pw.getText().toString())!=(et_pw_check.getText().toString())){ //비밀번호 일치 확인
                Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                et_pw.setText("")
                et_pw_check.setText("")
            }

            else{
                requestToServer.service.requestRegister(
                    RequestRegister(
                        id = et_id.text.toString(),
                        password = et_pw.text.toString(),
                        name = et_name.text.toString(),
                        email = et_email.text.toString(),
                        phone = et_phone.text.toString()
                    )
                ).enqueue(object : Callback<ResponseRegister> {
                        override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                             //통신 실패
                        }

                        override fun onResponse(
                            call: Call<ResponseRegister>,
                            response: Response<ResponseRegister>
                        ) {
                            //통신 성공
                            if(response.body()!!.success){
                                Toast.makeText(this@RegisterActivity, "회원가입 성공!", Toast.LENGTH_SHORT).show()
                                finish()
                            }
                            else if(response.body()!!.status==200){
                                Toast.makeText(this@RegisterActivity, "존재하는 ID입니다.", Toast.LENGTH_SHORT).show()
                            }else{
                                Toast.makeText(this@RegisterActivity, "데이터가 누락되었습니다.", Toast.LENGTH_SHORT).show()
                            }
                        }

                    })
            }
        }
    }

}
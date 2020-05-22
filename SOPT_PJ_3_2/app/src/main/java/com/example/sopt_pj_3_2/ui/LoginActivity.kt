package com.example.sopt_pj_3_2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sopt_pj_3_2.data.RequestLogin
import com.example.sopt_pj_3_2.data.ResponseLogin
import com.example.sopt_pj_3_2.network.RequestToServer
import com.example.sopt_pj_3_2.R
import kotlinx.android.synthetic.main.login_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private val  REQUEST_TEST = 1 //인수 추가

    val requestToServer = RequestToServer //싱글톤 그대로 가져옴

    override fun onCreate (savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        btn_login.setOnClickListener{
            if(et_email.text.isNullOrBlank()||et_pw.text.isNullOrBlank()){
                Toast.makeText(this,"아이디와 비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show()
            }else {
                //로그인 요청
                requestToServer.service.requestLogin(
                    RequestLogin(
                        id=et_email.text.toString(),
                        password = et_pw.text.toString()
                    ) //로그인 정보를 전달
                ).enqueue(object : Callback<ResponseLogin>{ //Callback 등록. Retrofit와 Callback을 import 해줘야 함
                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        //통신 실패

                    }

                    override fun onResponse(
                        call: Call<ResponseLogin>,
                        response: Response<ResponseLogin>
                    ) {
                        //통신 성공
                        if(response.isSuccessful) {//statusCode가 200~300 사이일 때. 응답 body 이용 가능
                            if(response.body()!!.success){ //ResponseLogin의 sucess가 true인 경우 -> 로그인
                                Toast.makeText(this@LoginActivity, "로그인 완료.", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }else{
                                Toast.makeText(this@LoginActivity, "아이디/비밀번호를 확인하세요!", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                })
            }
        }

        tv_register.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent,REQUEST_TEST) //Activity 호출
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) { //startActivityForResult 결과 확인
        //onActivityResult()는 Activity에 저장된 값을 돌려준다.
        // requestCode는 호출된 Activity에서 설정한 성공(RESULT_OK)/실패(RESULT_CANCEL) 값
        // 세번째 인수 Intent는 호출된 Activity에서 저장한 결과입니다.

        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==REQUEST_TEST){
            if (resultCode == RESULT_OK){
                et_email.setText(data?.getStringExtra("email"))
                et_pw.setText(data?.getStringExtra("password"))
            }
        }

    }
}
package com.example.sopt_pj_1_2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : AppCompatActivity() {
    private val  REQUEST_TEST = 1 //인수 추가

    override fun onCreate (savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        btn_login.setOnClickListener{
            Toast.makeText(this, "로그인 완료.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
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
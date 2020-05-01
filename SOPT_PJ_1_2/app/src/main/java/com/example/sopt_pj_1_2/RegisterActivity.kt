package com.example.sopt_pj_1_2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.register_activity.*


class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)

        btn_register.setOnClickListener{

            if((et_pw.getText().toString())!=(et_pw_check.getText().toString())){ //비밀번호 일치 확인
                Toast.makeText(this, "비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show()
                et_pw.setText("")
                et_pw_check.setText("")
            }

            else{ val intent = Intent()
            intent.putExtra("email", et_email.getText().toString()) //데이터 전달
            intent.putExtra("password", et_pw.getText().toString())

            setResult(RESULT_OK, intent) //결과 저장
            finish()
            }
        }
    }

}
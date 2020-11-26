/*
 * *
 *  * Created by Dimas Ridhoni on 11/26/20 3:31 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 11/26/20 11:30 AM
 *
 */

package com.dimasridhoni.tesalodokter.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dimasridhoni.tesalodokter.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    internal var sharedPreferences: SharedPreferences? =null
    internal val mypreferenceUser = "myprefUser"
    internal val userIdKey      = "userIdKey"
    internal val statusLoginKey = "statusLoginKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener(this)
        sharedPreferences = getSharedPreferences(mypreferenceUser, Context.MODE_PRIVATE)

        val statusLogin = sharedPreferences?.getBoolean(statusLoginKey, false)
        if (statusLogin == true) {
            val i = Intent(this@LoginActivity, MainActivity::class.java)
            // i.putExtra(MainActivity.EXTRA_TIPE, data.tipe)
            startActivity(i)
            finish()
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_login) {
            val inputEmail = et_email.text.toString().trim()
            val inputPassword = et_password.text.toString().trim()

            var isEmptyFields = false
            when {
                inputEmail.isEmpty() -> {
                    isEmptyFields = true
                    et_email.error = "Email tidak boleh kosong"
                }
                inputPassword.isEmpty() -> {
                    isEmptyFields = true
                    et_password.error = "Password tidak boleh kosong"
                }
            }

            if (!isEmptyFields) {
                var login : Boolean = cekUser(inputEmail, inputPassword)
                if (login) {

                    val editor = sharedPreferences!!.edit()
                    editor.putString(userIdKey, inputEmail)
                    editor.putBoolean(statusLoginKey, true)
                    editor.commit()


                    val i = Intent(this@LoginActivity, MainActivity::class.java)
                   // i.putExtra(MainActivity.EXTRA_TIPE, data.tipe)
                    startActivity(i)
                    finish()
                } else {
                    et_email.error = "Username / Password Salah"
                    et_password.error = "Username / Password Salah"
                }
            }



        }
    }

    private fun cekUser(email: String, password:String) : Boolean {
        if ((email.equals("dimasridhoni@gmail.com")) && (password.equals("123"))) {

            return true
        }
        else return false
    }
}
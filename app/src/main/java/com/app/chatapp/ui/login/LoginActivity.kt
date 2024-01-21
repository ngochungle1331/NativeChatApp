package com.app.chatapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.chatapp.databinding.ActivityLoginBinding
import com.app.chatapp.ui.home.HomeActivity
import com.app.chatapp.ui.register.RegisterActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        FirebaseApp.initializeApp(this@LoginActivity) // Initialize Firebase
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        firebaseAuth = FirebaseAuth.getInstance()
        setupEvents()
    }

    private fun setupEvents() {
//        binding.tvGoToRegister.setOnClickListener {
//            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
//        }
        binding.run {
            logsignup.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }

            logbutton.setOnClickListener {
                val email = editTexLogEmail.text.toString()
                val password = editTextLogPassword.text.toString()

                if ((TextUtils.isEmpty(email))) {
                    editTexLogEmail.error = "Enter the email"
                    return@setOnClickListener
                }
                if (TextUtils.isEmpty(password)) {
                    editTextLogPassword.error = "Enter the password"
                    return@setOnClickListener
                }
                if (isEmailValid(email)) {
                    editTexLogEmail.error = "Invalid email"
                    return@setOnClickListener
                }
                if (password.length < 6) {
                    editTextLogPassword.error = "Password must be at least 6 characters."
                    return@setOnClickListener
                }

                firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                        override fun onComplete(p0: Task<AuthResult>) {
                            if (p0.isSuccessful) {
                                try {
                                    val intent =
                                        Intent(this@LoginActivity, HomeActivity::class.java)
                                    startActivity(intent)
                                    finish()

                                } catch (e: Exception) {
                                    Toast.makeText(
                                        this@LoginActivity,
                                        "Login failed",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            } else {
                                Toast.makeText(
                                    this@LoginActivity,
                                    p0.exception?.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                    })

            }
        }
    }

    fun isEmailValid(email: CharSequence): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
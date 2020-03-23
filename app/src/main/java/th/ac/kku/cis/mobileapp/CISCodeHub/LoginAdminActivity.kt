package th.ac.kku.cis.mobileapp.CISCodeHub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_admin.*

class LoginAdminActivity : AppCompatActivity() {
    var mAuth: FirebaseAuth? = null
    private val TAG: String = "Login Admin Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_admin)

    mAuth = FirebaseAuth.getInstance()

    if (mAuth!!.currentUser != null){
        startActivity(Intent(this@LoginAdminActivity, AdminActivity::class.java))
        finish()
    }
        btn_signIn_admin.setOnClickListener{
        val email = editText_email_admin.text.toString().trim { it <=' '}
        val password= editText_password_admin.text.toString().trim { it <=' '}

        if (email.isEmpty()){
            Toast.makeText(this,"Please enter your email address.",Toast.LENGTH_LONG).show()
            Log.d(TAG, "Email was empty!")
            return@setOnClickListener

        }
        if (password.isEmpty()){
            Toast.makeText(this,"Please enter your password.",Toast.LENGTH_LONG).show()
            Log.d(TAG, "Password was empty!")
            return@setOnClickListener

        }

        mAuth!!.signInWithEmailAndPassword(email,password).addOnCompleteListener{task ->
            if (!task.isSuccessful){
                if(password.length < 6){
                    editText_email_admin.error = "Please check your password. Password must have minimum 6 characters."
                    Log.d(TAG,"Enter password less than 6 characters.")
                } else{
                    Toast.makeText(this,"Authentication Failed: "+task.exception,Toast.LENGTH_LONG).show()
                    Log.d(TAG,"Authentication Failed: "+task.exception)
                }

            }
            else {
                Toast.makeText(this,"Sign in Successfully!",Toast.LENGTH_LONG).show()
                Log.d(TAG,"Sign in Successfully!")
                startActivity(Intent(this@LoginAdminActivity, AdminActivity::class.java))
                finish()
            }
        }
    }
        btn_back_menu.setOnClickListener { onBackPressed() }
    }
}

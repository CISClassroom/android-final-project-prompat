package th.ac.kku.cis.mobileapp.CISCodeHub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? =null
    private val TAG: String = "Main Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       mAuth = FirebaseAuth.getInstance()

        if(mAuth!!.currentUser !=null){
            Log.d(TAG, "Continue with: "+mAuth!!.currentUser!!.email)
            startActivity(Intent(this@MainActivity, AdminActivity::class.java))
        }

        btn_go_admin.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginAdminActivity::class.java))
        }
        btn_to_html.setOnClickListener{ startActivity(Intent(this@MainActivity, HtmlActivity::class.java))}
        btn_to_java.setOnClickListener{ startActivity(Intent(this@MainActivity, JavaActivity::class.java))}
        btn_add_kotlin.setOnClickListener{ startActivity(Intent(this@MainActivity, KotlinActivity::class.java))}
        btn_add_python.setOnClickListener{ startActivity(Intent(this@MainActivity, PythonActivity::class.java))}
//        btn_question.setOnClickListener{ startActivity(Intent(this@MainActivity, RegisterActivity::class.java))}

}

}


package th.ac.kku.cis.mobileapp.CISCodeHub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_kotlin_add.*
import th.ac.kku.cis.mobileapp.CISCodeHub.Model.Course

class KotlinAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_add)

        save_add_kotlin.setOnClickListener {
            saveData()
        }
    }


    private fun saveData(){

        val topic   = editText_topic_kotlin.text.toString().trim()
        val subtopic = editText_sub_kotlin.text.toString().trim()
        val article = editText_content_kotlin.text.toString().trim()

        if (topic.isEmpty()){
            Toast.makeText(this,"Please enter your topic",Toast.LENGTH_LONG).show()
            return
        }
        if (subtopic.isEmpty()){
            Toast.makeText(this,"Please enter your Subtopic",Toast.LENGTH_LONG).show()
            return
        }
        if (article.isEmpty()){
            Toast.makeText(this,"Please enter your content",Toast.LENGTH_LONG).show()
            return
        }

        val myDataBase = FirebaseDatabase.getInstance().getReference("kotlin")
        val id = myDataBase.push().key
        val course = Course(topic,subtopic,article)
        if (id != null) {
            myDataBase.child(id).setValue(course).addOnCompleteListener{
                Toast.makeText(this,"Saved :) ",Toast.LENGTH_LONG).show()
            }
        }
    }

}

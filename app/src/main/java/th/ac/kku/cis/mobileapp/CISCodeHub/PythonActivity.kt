package th.ac.kku.cis.mobileapp.CISCodeHub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_python.*
import th.ac.kku.cis.mobileapp.CISCodeHub.Adapter.Adapter
import th.ac.kku.cis.mobileapp.CISCodeHub.Model.Show

class PythonActivity : AppCompatActivity() {

    private val TAG: String = "List Python"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_python)


        Firebase.database.reference.child("python").addValueEventListener(object :
            ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val listView: ListView = findViewById(R.id.listView_python)
                val code_list = mutableListOf<Show>()
                for(postSnapshot in dataSnapshot.children){

                    code_list.add(Show(postSnapshot.child("topic").getValue().toString()
                        ,postSnapshot.child("subtopic").getValue().toString()
                        ,postSnapshot.child("article").getValue().toString())
                    )

                }


                listView.adapter = Adapter(
                    this@PythonActivity,
                    R.layout.activity_pattern,
                    code_list

                )
                listView.setOnItemClickListener { parent, view, position, id ->
                    val selectedItem = parent.getItemAtPosition(position) as Show

                    val i = Intent(this@PythonActivity,Pattern2Activity::class.java)
                    i.putExtra("send_topic",selectedItem.topic)
                    i.putExtra("send_subtopic",selectedItem.subtopic)
                    i.putExtra("send_article",selectedItem.article)
                    startActivity(i)

                    //Toast.makeText(this@PythonActivity, selectedItem.topic, Toast.LENGTH_SHORT).show()
                }





            }
        }
        )


        btn_back_menu.setOnClickListener { onBackPressed()}
    }
}

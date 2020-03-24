package th.ac.kku.cis.mobileapp.CISCodeHub.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import th.ac.kku.cis.mobileapp.CISCodeHub.Model.Show
import th.ac.kku.cis.mobileapp.CISCodeHub.R

class Adapter (var mCtx: Context, var resource:Int, var item:List<Show>)
    : ArrayAdapter<Show>( mCtx , resource , item) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)

        val view: View = layoutInflater.inflate(resource,null)
        var tvTopic : TextView = view.findViewById(R.id.txt_Topic)
        var tvSubTopic : TextView = view.findViewById(R.id.txt_sub)

        var show: Show = item[position]
        tvTopic.text = show.topic
        tvSubTopic.text = show.subtopic
        return view
    }
}
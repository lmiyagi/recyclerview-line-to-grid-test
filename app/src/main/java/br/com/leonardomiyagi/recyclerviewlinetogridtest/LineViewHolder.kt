package br.com.leonardomiyagi.recyclerviewlinetogridtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by lmiyagi on 30/05/19.
 */
class LineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), BaseViewHolder {

    constructor(parent: ViewGroup) : this(LayoutInflater.from(parent.context).inflate(R.layout.list_item_line, parent, false))

    private val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
    private val subtitleTextView = itemView.findViewById<TextView>(R.id.subtitleTextView)

    override fun format(item: TestItem) {
        titleTextView.text = item.title
        subtitleTextView.text = item.subtitle
    }
}
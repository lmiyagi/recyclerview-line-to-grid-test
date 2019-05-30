package br.com.leonardomiyagi.recyclerviewlinetogridtest

import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by lmiyagi on 30/05/19.
 */
class DefaultAdapter(private val layoutManager: GridLayoutManager)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = ArrayList<TestItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ViewType.LINE.ordinal) {
            LineViewHolder(parent)
        } else {
            GridViewHolder(parent)
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is BaseViewHolder) {
            holder.format(items[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (layoutManager.spanCount) {
            1 -> ViewType.LINE.ordinal
            else -> ViewType.GRID.ordinal
        }
    }

    fun setItems(items: List<TestItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    private enum class ViewType { LINE, GRID }
}
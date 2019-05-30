package br.com.leonardomiyagi.recyclerviewlinetogridtest

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: DefaultAdapter
    private lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        setupItems()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.nav_change -> {
                if (layoutManager.spanCount == 1) {
                    layoutManager.spanCount = 3
                    item.setIcon(R.drawable.ic_grid_on)
                } else {
                    layoutManager.spanCount = 1
                    item.setIcon(R.drawable.ic_sort)
                }
                adapter.notifyItemRangeChanged(0, adapter.itemCount)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupRecyclerView() {
        layoutManager = GridLayoutManager(this, 3)

        adapter = DefaultAdapter(layoutManager)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }

    private fun setupItems() {
        val items = ArrayList<TestItem>()
        for (i in 1..20) {
            items.add(TestItem(
                    "Test $i",
                    "OAISJDOIAS FJOIASJF SAOIDJ OASIJD OASIJFOAIS FJoisjf OAISjf oASIjfO ASIjfOAIS fjOAISjf OAISfj OAISfj OASIfj AOSifjSAO Ifj AOISfjAOIsjfOAISJFOAIsj oiASJf OIASjf OIASfj AOISfj ASIf"
            ))
        }
        adapter.setItems(items)
    }
}

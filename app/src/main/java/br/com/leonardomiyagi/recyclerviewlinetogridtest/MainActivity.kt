package br.com.leonardomiyagi.recyclerviewlinetogridtest

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: DefaultAdapter
    private lateinit var layoutManager: GridLayoutManager
    private lateinit var dividerItemDecoration: DividerItemDecoration

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
                    recyclerView.removeItemDecoration(dividerItemDecoration)
                } else {
                    layoutManager.spanCount = 1
                    item.setIcon(R.drawable.ic_sort)
                    recyclerView.addItemDecoration(dividerItemDecoration)
                }
                adapter.notifyItemRangeChanged(0, adapter.itemCount)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupRecyclerView() {
        dividerItemDecoration = DividerItemDecoration(this, GridLayoutManager.VERTICAL)
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
                    generateSubtitle()
            ))
        }
        adapter.setItems(items)
    }

    private fun generateSubtitle(): String {
        val words = ArrayList<String>()
        words.add("something")
        words.add("maybe")
        words.add("yeah")
        words.add("lets")
        words.add("do")
        words.add("this")
        words.add("soy")
        words.add("el")
        words.add("fuego")
        words.add("interview")
        words.add("youtube")
        words.add("google")
        words.add("github")
        words.add("mafia")
        words.add("werewolf")
        words.add("justkiddingparty")
        words.add("mountain")
        words.add("everest")
        words.add("ground")
        words.add("sky")
        words.add("perplex")
        var subtitle = ""
        subtitle += "${words[Random().nextInt(words.size - 1)]}, "
        subtitle += "${words[Random().nextInt(words.size - 1)]}, "
        subtitle += "${words[Random().nextInt(words.size - 1)]}, "
        subtitle += "${words[Random().nextInt(words.size - 1)]}, "
        subtitle += "${words[Random().nextInt(words.size - 1)]}, "
        for (i in 1..Random().nextInt(15)) {
            subtitle += words[Random().nextInt(words.size - 1)]
            subtitle += ", "
        }
        subtitle += words[Random().nextInt(words.size - 1)]
        return subtitle
    }
}

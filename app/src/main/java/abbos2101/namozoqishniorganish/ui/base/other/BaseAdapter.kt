package abbos2101.namozoqishniorganish.ui.base.other

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<MODEL, VB : ViewBinding> :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    protected val list: ArrayList<MODEL> = arrayListOf()
    protected lateinit var binding: VB

    abstract fun itemBinding(model: MODEL, position: Int)
    abstract fun setViewBinding(inflater: LayoutInflater, parent: ViewGroup): VB

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(setViewBinding(inflater, parent))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]
        (holder as BaseAdapter<*, *>.ViewHolder).bind(model as Any, position)
        if (list.size - 1 == position)
            nextPage(position)
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(private val binding: VB) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Any, position: Int) {
            this@BaseAdapter.tmpBind(binding, model, position)
        }
    }

    open fun nextPage(position: Int) {}

    open fun addUniqueItem(item: MODEL) {
        if (isItemNotExist(item)) {
            list.add(item)
            notifyDataSetChanged()
        }
    }

    open fun addUniqueList(newList: ArrayList<MODEL>) {
        newList.forEach {
            if (isItemNotExist(it))
                list.add(it)
        }
        notifyDataSetChanged()
    }

    open fun addItem(item: MODEL) {
        list.add(item)
        notifyDataSetChanged()
    }

    open fun addList(newList: ArrayList<MODEL>) {
        newList.forEach {
            list.add(it)
        }
        notifyDataSetChanged()
    }

    open fun clearList() {
        list.clear()
        notifyDataSetChanged()
    }

    open fun setList(newList: ArrayList<MODEL>) {
        this.list.clear()
        addList(newList)
    }

    private fun isItemNotExist(item: MODEL): Boolean {
        list.forEach {
            if (it == item)
                return false
        }
        return true
    }

    private fun tmpBind(binding: VB, model: Any, position: Int) {
        this@BaseAdapter.binding = binding
        itemBinding(model as MODEL, position)
    }
}
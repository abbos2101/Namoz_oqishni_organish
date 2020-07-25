package abbos2101.namozoqishniorganish.ui.fragment.main.view

import abbos2101.mvvmdemo.common.setSrc
import abbos2101.namozoqishniorganish.databinding.ItemMainBinding
import abbos2101.namozoqishniorganish.module.jsonItems
import abbos2101.namozoqishniorganish.ui.base.other.BaseAdapter
import abbos2101.namozoqishniorganish.ui.fragment.main.presenter.MainPresenter
import android.view.LayoutInflater
import android.view.ViewGroup

class MainAdapter(private val presenter: MainPresenter) :
    BaseAdapter<jsonItems, ItemMainBinding>() {
    override fun itemBinding(model: jsonItems, position: Int) {
        binding.img.setSrc("file:///android_asset/${model.image}", 1)
        binding.tv.text = "${model.name}"
        binding.llRoot.setOnClickListener {
            presenter.itemClick(model)
        }
    }

    override fun setViewBinding(inflater: LayoutInflater, parent: ViewGroup) =
        ItemMainBinding.inflate(inflater, parent, false)
}
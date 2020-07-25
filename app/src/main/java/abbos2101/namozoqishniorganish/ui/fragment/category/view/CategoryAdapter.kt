package abbos2101.namozoqishniorganish.ui.fragment.category.view

import abbos2101.mvvmdemo.common.setSrc
import abbos2101.namozoqishniorganish.databinding.ItemCategoryBinding
import abbos2101.namozoqishniorganish.module.jsonSubItems
import abbos2101.namozoqishniorganish.ui.base.other.BaseAdapter
import abbos2101.namozoqishniorganish.ui.fragment.category.presenter.CategoryPresenter
import android.view.LayoutInflater
import android.view.ViewGroup

class CategoryAdapter(private val presenter: CategoryPresenter) :
    BaseAdapter<jsonSubItems, ItemCategoryBinding>() {
    override fun itemBinding(model: jsonSubItems, position: Int) {
        binding.img.setSrc("file:///android_asset/${model.image}", 1)
        binding.tv.text = "${model.name}"
        binding.llRoot.setOnClickListener {
            presenter.itemClick(model)
        }
    }

    override fun setViewBinding(inflater: LayoutInflater, parent: ViewGroup) =
        ItemCategoryBinding.inflate(inflater, parent, false)
}
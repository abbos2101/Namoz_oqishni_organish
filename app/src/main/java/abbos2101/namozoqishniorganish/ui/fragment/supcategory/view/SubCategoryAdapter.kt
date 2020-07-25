package abbos2101.namozoqishniorganish.ui.fragment.supcategory.view

import abbos2101.namozoqishniorganish.databinding.ItemSubCategoryBinding
import abbos2101.namozoqishniorganish.ui.base.other.BaseAdapter
import abbos2101.namozoqishniorganish.ui.fragment.supcategory.presenter.SubCategoryPresenter
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup

class SubCategoryAdapter(private val presenter: SubCategoryPresenter) :
    BaseAdapter<String, ItemSubCategoryBinding>() {
    override fun itemBinding(model: String, position: Int) {
        binding.tv.text = "${Html.fromHtml(model)}"
        binding.llRoot.setOnClickListener {
            presenter.itemClick(position)
        }
    }

    override fun setViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup
    ) = ItemSubCategoryBinding.inflate(inflater, parent, false)
}
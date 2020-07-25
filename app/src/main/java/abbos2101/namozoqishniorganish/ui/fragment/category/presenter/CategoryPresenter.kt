package abbos2101.namozoqishniorganish.ui.fragment.category.presenter

import abbos2101.example.terrabayt.ui.base.BasePresenter
import abbos2101.namozoqishniorganish.module.jsonSubItems
import abbos2101.namozoqishniorganish.ui.fragment.category.viewmodel.CategoryViewModel

class CategoryPresenter(private val viewModel: CategoryViewModel) : BasePresenter() {
    fun loadList(items: ArrayList<jsonSubItems>) {
        viewModel.setListValue(items)
    }

    fun itemClick(model: jsonSubItems) {
        viewModel.setSubItemValue(model)
    }
}
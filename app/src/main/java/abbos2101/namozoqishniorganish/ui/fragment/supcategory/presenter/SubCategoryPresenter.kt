package abbos2101.namozoqishniorganish.ui.fragment.supcategory.presenter

import abbos2101.example.terrabayt.ui.base.BasePresenter
import abbos2101.namozoqishniorganish.ui.fragment.supcategory.viewmodel.SubCategoryViewModel

class SubCategoryPresenter(private val viewModel: SubCategoryViewModel) : BasePresenter() {
    fun loadItems(list: ArrayList<String>) {
        viewModel.setListValue(list)
    }

    fun itemClick(position: Int) {
        viewModel.setPositionValue(position)
    }
}
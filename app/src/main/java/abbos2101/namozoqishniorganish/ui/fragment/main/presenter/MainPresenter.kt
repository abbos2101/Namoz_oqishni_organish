package abbos2101.namozoqishniorganish.ui.fragment.main.presenter

import abbos2101.example.terrabayt.ui.base.BasePresenter
import abbos2101.namozoqishniorganish.App
import abbos2101.namozoqishniorganish.module.jsonItems
import abbos2101.namozoqishniorganish.ui.fragment.main.viewmodel.MainViewModel

class MainPresenter(private val viewModel: MainViewModel) : BasePresenter() {
    fun loadList() {
        viewModel.setListValue(App.model.items)
    }

    fun itemClick(model: jsonItems) {
        viewModel.setCategoryValue(model)
    }
}
package abbos2101.namozoqishniorganish.ui.fragment.category.view

import abbos2101.mvvmdemo.common.fromJsonObject
import abbos2101.mvvmdemo.common.getViewModel
import abbos2101.mvvmdemo.common.lazyFast
import abbos2101.mvvmdemo.common.toJsonString
import abbos2101.namozoqishniorganish.databinding.FragmentCategoryBinding
import abbos2101.namozoqishniorganish.module.jsonItems
import abbos2101.namozoqishniorganish.module.jsonSubItems
import abbos2101.namozoqishniorganish.ui.base.fragment.BaseFragmentFull
import abbos2101.namozoqishniorganish.ui.fragment.category.presenter.CategoryPresenter
import abbos2101.namozoqishniorganish.ui.fragment.category.viewmodel.CategoryViewModel
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

class CategoryFragment :
    BaseFragmentFull<FragmentCategoryBinding, CategoryPresenter, CategoryViewModel>() {
    private val category by lazyFast { arguments?.getString("message") ?: "" }
    private val model: jsonItems? by lazyFast {
        if (category != "") category.fromJsonObject(
            jsonItems::class.java
        ) else null
    }
    private val adapter by lazyFast {
        CategoryAdapter(
            presenter
        )
    }

    override fun create() {
        init()
        initViewModel()
    }

    private fun init() {
        if (model != null) {
            (activity as AppCompatActivity).supportActionBar?.title = model?.name
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
            binding.rv.adapter = adapter
            presenter.loadList(model?.items ?: arrayListOf())
        }
    }

    private fun initViewModel() {
        viewModel.getList().observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                viewModel.setListValue(null)
            }
        })
        viewModel.getSubItem().observe(this, Observer {
            if (it != null) {
                setSubItem(it)
                viewModel.setSubItemValue(null)
            }
        })
    }

    private fun setSubItem(it: jsonSubItems?) {
        var action: NavDirections? = null
        if (it!!.items.size != 1)
            action = CategoryFragmentDirections.actionCategoryFragmentToSubCategoryFragment()
                .setMessage("${it.toJsonString()}")
        else
            action = CategoryFragmentDirections.actionCategoryFragmentToContentFragment()
                .setPosition(0)
                .setMessage("${it.toJsonString()}")
        findNavController().navigate(action)
    }

    override fun setViewBinding(inflater: LayoutInflater) =
        FragmentCategoryBinding.inflate(inflater)

    override fun setPresenter() =
        CategoryPresenter(
            viewModel
        )
    override fun setViewModel() = activity?.getViewModel(CategoryViewModel::class.java)!!
}
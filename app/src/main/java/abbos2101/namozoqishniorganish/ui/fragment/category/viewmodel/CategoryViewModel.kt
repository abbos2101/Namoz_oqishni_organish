package abbos2101.namozoqishniorganish.ui.fragment.category.viewmodel

import abbos2101.example.terrabayt.ui.base.BaseViewModel
import abbos2101.namozoqishniorganish.module.jsonSubItems
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CategoryViewModel : BaseViewModel() {
    private val _list: MutableLiveData<ArrayList<jsonSubItems>?> = MutableLiveData()
    private val _subItem: MutableLiveData<jsonSubItems?> = MutableLiveData()
    fun getList(): LiveData<ArrayList<jsonSubItems>?> = _list
    fun setListValue(value: ArrayList<jsonSubItems>?) {
        _list.value = value
    }

    fun getSubItem(): LiveData<jsonSubItems?> = _subItem
    fun setSubItemValue(value: jsonSubItems?) {
        _subItem.value = value
    }
}
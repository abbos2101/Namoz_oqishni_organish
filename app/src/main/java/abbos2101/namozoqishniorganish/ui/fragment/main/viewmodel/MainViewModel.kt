package abbos2101.namozoqishniorganish.ui.fragment.main.viewmodel

import abbos2101.example.terrabayt.ui.base.BaseViewModel
import abbos2101.namozoqishniorganish.module.jsonItems
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel : BaseViewModel() {
    private var _list: MutableLiveData<ArrayList<jsonItems>?> = MutableLiveData()
    private var _category: MutableLiveData<jsonItems?> = MutableLiveData()
    fun getList(): LiveData<ArrayList<jsonItems>?> = _list


    fun setListValue(value: ArrayList<jsonItems>?) {
        _list.value = value
    }

    fun getCategory(): LiveData<jsonItems?> = _category

    fun setCategoryValue(value: jsonItems?) {
        _category.value = value
    }
}
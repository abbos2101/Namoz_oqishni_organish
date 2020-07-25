package abbos2101.namozoqishniorganish.module

data class JsonModel(
    val items: ArrayList<jsonItems>
)

data class jsonItems(
    val name: String? = null,
    val image: String? = null,
    val items: ArrayList<jsonSubItems>
)

data class jsonSubItems(
    val name: String? = null,
    val image: String? = null,
    val items: ArrayList<String>
)
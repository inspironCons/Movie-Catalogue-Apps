package bajp.playground.moviecatalogueapp.data

data class GenresEntity(
    val id:Int?,
    val name:String?
){
    override fun toString(): String {
        return name?:""
    }
}
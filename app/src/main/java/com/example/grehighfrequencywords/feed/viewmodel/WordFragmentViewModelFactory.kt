import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.grehighfrequencywords.feed.data.MyRepository
import com.example.grehighfrequencywords.feed.viewmodel.WordFragmentViewModel

class WordFragmentViewModelFactory(private val myRepository: MyRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordFragmentViewModel::class.java)) {
            return WordFragmentViewModel(myRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

package by.hometrainng.mvvmkoinhw6.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.hometrainng.mvvmkoinhw6.databinding.FragmentBeerListBinding
import by.hometrainng.mvvmkoinhw6.repository.BeerRepository
import by.hometrainng.mvvmkoinhw6.room.AppDatabase
import by.hometrainng.mvvmkoinhw6.viewModels.ListViewModel

import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeerListFragment : Fragment() {

    private var _binding: FragmentBeerListBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val beerRepository by inject<BeerRepository>()
    private val appDatabase by inject<AppDatabase>()

    private val listViewModel by viewModel<ListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentBeerListBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
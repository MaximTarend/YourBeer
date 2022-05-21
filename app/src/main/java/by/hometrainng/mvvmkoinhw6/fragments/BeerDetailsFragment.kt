package by.hometrainng.mvvmkoinhw6.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.hometrainng.mvvmkoinhw6.databinding.FragmentBeerDetailsBinding
import by.hometrainng.mvvmkoinhw6.viewModels.DetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeerDetailsFragment: Fragment() {

    private var _binding: FragmentBeerDetailsBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val detailsViewModel by viewModel<DetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentBeerDetailsBinding.inflate(inflater, container, false)
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
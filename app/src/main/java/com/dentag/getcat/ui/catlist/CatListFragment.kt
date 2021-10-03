package com.dentag.getcat.ui.catlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.dentag.getcat.databinding.FragmentCatListBinding
import com.dentag.getcat.ui.Router
import kotlinx.coroutines.launch

class CatListFragment : Fragment() {
    private var _binding: FragmentCatListBinding? = null
    private val binding get() = _binding!!
    private val viewModel by lazy { ViewModelProvider(this).get(CatListViewModel::class.java) }
    private val onItemClickListener = object : OnItemClickListener {
        override fun onItemClick(url: String, view: View) {
            (requireActivity() as Router).goToCat(url, view)
        }
    }
    private val catAdapter by lazy { CatListAdapter(onItemClickListener) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCatListBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            mainRecyclerView.adapter = catAdapter.withLoadStateHeaderAndFooter(
                header = CatLoaderStateAdapter(),
                footer = CatLoaderStateAdapter()
            )
            mainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            catAdapter.addLoadStateListener { state ->
                with(binding) {
                    mainRecyclerView.isVisible = state.refresh != LoadState.Loading
                    fragmentCatProgressBar.isVisible = state.refresh == LoadState.Loading
                }
            }
            viewModel.pager.observe(viewLifecycleOwner) {
                lifecycleScope.launch {
                    catAdapter.submitData(it)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

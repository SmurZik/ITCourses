package com.smurzik.favorite.presentation

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.smurzik.core_ui.CourseAdapter
import com.smurzik.favorite.R
import com.smurzik.favorite.databinding.FavoriteFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private var _binding: FavoriteFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CourseAdapter

    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FavoriteFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CourseAdapter {
            // here we can implement logic to delete course from favorite fragment
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            VerticalSpaceItemDecoration(resources.getDimensionPixelSize(R.dimen.recycler_item_spacing))
        )

        viewModel.getFavorite()

        viewModel.courseListLiveData.observe(viewLifecycleOwner) {
            adapter.items = it
        }
    }
}

class VerticalSpaceItemDecoration(private val verticalSpaceHeight: Int) :
    RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.bottom = verticalSpaceHeight
    }
}
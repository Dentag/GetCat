package com.dentag.getcat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dentag.getcat.databinding.FragmentCatListBinding

class CatListFragment : Fragment() {
    private var _binding: FragmentCatListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCatListBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

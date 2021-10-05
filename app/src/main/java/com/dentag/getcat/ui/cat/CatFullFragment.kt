package com.dentag.getcat.ui.cat

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toBitmap
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.transition.TransitionInflater
import coil.load
import com.dentag.getcat.R
import com.dentag.getcat.databinding.FragmentCatFullBinding
import java.io.ByteArrayOutputStream

class CatFullFragment : Fragment() {
    private var _binding: FragmentCatFullBinding? = null
    private val binding get() = _binding!!
    private val viewModel by lazy { ViewModelProvider(this).get(CatFullViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)
        postponeEnterTransition()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCatFullBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageUrl =
            arguments?.getString(IMG_URL_EXTRA) ?: throw IllegalArgumentException("No url argument")
        binding.catFullIV.load(imageUrl) {
            target {
                startPostponedEnterTransition()
                binding.catFullIV.setImageDrawable(it)
            }
        }
        binding.fragmentCatDownloadBtn.setOnClickListener {
            val imageBitmap = binding.catFullIV.drawable.toBitmap()
            val bos = ByteArrayOutputStream()
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos)
            val imageByteArray = bos.toByteArray()
            viewModel.saveImage(imageByteArray)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val IMG_URL_EXTRA = "com.dentag.getcat.ui.IMG_URL_EXTRA"

        fun getInstance(url: String): CatFullFragment {
            return CatFullFragment().apply {
                arguments = bundleOf(
                    IMG_URL_EXTRA to url
                )
            }
        }
    }
}

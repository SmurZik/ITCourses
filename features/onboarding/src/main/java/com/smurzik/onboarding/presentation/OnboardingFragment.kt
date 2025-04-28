package com.smurzik.onboarding.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.smurzik.onboarding.databinding.OnboardingFragmentBinding
import eightbitlab.com.blurview.BlurView

class OnboardingFragment : Fragment() {

    private var _binding: OnboardingFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = OnboardingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBlur(binding.main, binding.tag1)
        setBlur(binding.main, binding.tag3)
        setBlur(binding.main, binding.tag4)
        setBlur(binding.main, binding.tag5)
        setBlur(binding.main, binding.tag6)
        setBlur(binding.main, binding.tag7)
        setBlur(binding.main, binding.tag8)
        setBlur(binding.main, binding.tag10)
        setBlur(binding.main, binding.tag11)
        setBlur(binding.main, binding.tag12)
        setBlur(binding.main, binding.tag13)
        setBlur(binding.main, binding.tag14)
        setBlur(binding.main, binding.tag16)
        setBlur(binding.main, binding.tag17)
    }

    private fun setBlur(root: ConstraintLayout, tag: BlurView) {
        tag.setupWith(root).setBlurRadius(10f)
        tag.outlineProvider = (ViewOutlineProvider.BACKGROUND)
        tag.clipToOutline = true
    }
}
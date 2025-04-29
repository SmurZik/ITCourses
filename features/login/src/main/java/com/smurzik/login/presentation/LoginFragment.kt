package com.smurzik.login.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.smurzik.login.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginViewModel: LoginViewModel by viewModels()

        binding.loginButton.setOnClickListener {
            loginViewModel.checkValidInputs(
                binding.emailEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }

        binding.vkButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/"))
            requireContext().startActivity(intent)
        }

        binding.okButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://ok.ru/"))
            requireContext().startActivity(intent)
        }

        loginViewModel.validInputsLiveData.observe(viewLifecycleOwner) {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
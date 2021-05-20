package com.example.mixer_logic_kt.Ui.Screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.mixer_logic_kt.databinding.FragmentGuestWebViewBinding


class GuestWebViewFragment : Fragment() {
    private var _binding: FragmentGuestWebViewBinding? = null
    private val binding get() =_binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentGuestWebViewBinding.inflate(inflater, container, false)
        val view = binding.root

        //declare webview domStorage
        val myWebView: WebView = binding.webView

        //enable javascript and domstorage
        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.domStorageEnabled = true

        myWebView.loadUrl("https://metropolia-mixer.herokuapp.com")

        // Force links and redirects to open in the WebView instead of in a browser
        myWebView.webViewClient = WebViewClient()


        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
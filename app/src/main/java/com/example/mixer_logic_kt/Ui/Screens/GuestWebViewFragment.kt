package com.example.mixer_logic_kt.Ui.Screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.mixer_logic_kt.databinding.FragmentGuestWebViewBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GuestWebViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GuestWebViewFragment : Fragment() {
    private var _binding: FragmentGuestWebViewBinding? = null
    private val binding get() =_binding!!

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*val myWebView: WebView = binding.webView
        myWebView.settings.javaScriptEnabled = true
        myWebView.loadUrl("https://mixerlogic.herokuapp.com")

        // Force links and redirects to open in the WebView instead of in a browser

        // Force links and redirects to open in the WebView instead of in a browser
        myWebView.webViewClient = WebViewClient()*/

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GuestWebViewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                GuestWebViewFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
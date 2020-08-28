package com.github.avereshchagin.clearprice.platform

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.avereshchagin.clearprice.R
import com.github.avereshchagin.clearprice.viewmodel.CartViewModel
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment : BaseFragment() {

    private lateinit var viewModel: CartViewModel

    override fun titleId() = R.string.fragment_cart_title

    override fun layoutId() = R.layout.fragment_cart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

        val viewModelFactory = ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CartViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setOnClickListener {
//            findNavController().navigate(R.id.action_PurchasesListFragment_to_AddPurchaseFragment)
        }

        val baseCurrency = view.findViewById<TextView>(R.id.base_currency)
        val cartCurrency = view.findViewById<Spinner>(R.id.spinner_cart_currency)
        cartCurrency.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
            }
        }

        viewModel.baseCurrency.observe(viewLifecycleOwner, Observer {
            baseCurrency.text = it
        })

        viewModel.availableCurrencies.observe(viewLifecycleOwner, Observer {
            val adapter = ArrayAdapter(requireContext(), R.layout.list_item_currency, it)
            cartCurrency.setAdapter(adapter)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_cart, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
//                findNavController().navigate(R.id.action_PurchasesListFragment_to_SettingsFragment)
                true
            }
            R.id.action_history -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

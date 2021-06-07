package com.nfach98.premierleague.ui.main.table

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfach98.premierleague.core.data.Resource
import com.nfach98.premierleague.core.ui.main.table.TableAdapter
import com.nfach98.premierleague.databinding.FragmentTableBinding
import com.nfach98.premierleague.ui.detail.club.ClubActivity
import org.koin.android.viewmodel.ext.android.viewModel

class TableFragment : Fragment() {

    private val tableViewModel: TableViewModel by viewModel()

    private var _binding: FragmentTableBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTableBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val tableAdapter = TableAdapter()
            tableAdapter.onItemClick = { team ->
                val intent = Intent(activity, ClubActivity::class.java)
                intent.putExtra(ClubActivity.EXTRA_ID, team.idTeam)
                startActivity(intent)
            }

            tableViewModel.table.observe(viewLifecycleOwner, { table ->
                if (table != null) {
                    when (table) {
//                        is Resource.Loading -> binding.loading.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.loading.visibility = View.GONE
                            tableAdapter.setData(table.data)
                        }
                        else -> binding.loading.visibility = View.VISIBLE
                        /* is Resource.Error -> {
                             binding.loading.visibility = View.GONE
                             binding.viewError.root.visibility = View.VISIBLE
                             binding.viewError.tvError.text = tourism.message ?: getString(R.string.something_wrong)
                         }*/
                    }
                }
            })

            with(binding.rvTable) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tableAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
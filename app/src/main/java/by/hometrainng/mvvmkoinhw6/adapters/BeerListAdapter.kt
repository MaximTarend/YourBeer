package by.hometrainng.mvvmkoinhw6.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import by.hometrainng.mvvmkoinhw6.databinding.ListItemBinding
import by.hometrainng.mvvmkoinhw6.model.Beer

class BeerListAdapter(
    context: Context,
    private val onClicked: (Beer) -> Unit
): ListAdapter<Beer, ItemViewHolder>(DIFF_UTIL) {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            binding = ListItemBinding.inflate(layoutInflater, parent, false),
            onClicked = onClicked
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val  DIFF_UTIL = object : DiffUtil.ItemCallback<Beer>() {
            override fun areItemsTheSame(oldItem: Beer, newItem: Beer): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Beer, newItem: Beer): Boolean {
                return oldItem.name == newItem.name && oldItem.imageURL == newItem.imageURL
            }

        }
    }
}

class ItemViewHolder(
    private val binding: ListItemBinding,
    private val onClicked: (Beer) -> Unit
): RecyclerView.ViewHolder(binding.root) {
    fun bind (item: Beer) {
        with(binding) {


            root.setOnClickListener {
                onClicked(item)
            }
        }
    }
}
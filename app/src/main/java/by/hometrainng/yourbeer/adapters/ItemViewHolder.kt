package by.hometrainng.yourbeer.adapters

import androidx.recyclerview.widget.RecyclerView
import by.hometrainng.yourbeer.domain.model.Beer
import by.hometrainng.yourbeer.databinding.ListItemBinding
import coil.load

class ItemViewHolder(
    private val binding: ListItemBinding,
    private val onClicked: (Beer) -> Unit
): RecyclerView.ViewHolder(binding.root) {
    fun bind (item: Beer) {
        with(binding) {
            image.load(item.imageURL)
            name.text = item.name

            root.setOnClickListener {
                onClicked(item)
            }
        }
    }
}
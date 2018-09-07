package guy.testanimation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemDataHolder> {

    List<Item> items;
    MainActivity activity;

    ItemAdapter(List<Item> items, MainActivity activity) {
        this.items = items;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ItemDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ItemDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemDataHolder holder, final int position) {
        holder.itemTitle.setText(items.get(position).getText());
        holder.itemTitle.setTransitionName(items.get(position).getText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.showItem(items.get(position), view.findViewById(R.id.item_title));
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemDataHolder extends RecyclerView.ViewHolder {

        TextView itemTitle;

        ItemDataHolder(View view) {
            super(view);
            this.itemTitle = view.findViewById(R.id.item_title);

        }
    }
}

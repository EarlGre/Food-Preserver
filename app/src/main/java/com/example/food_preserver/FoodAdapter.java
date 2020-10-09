package com.example.food_preserver;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

public class FoodAdapter extends FirestoreRecyclerAdapter<FoodItem, FoodAdapter.FoodHolder> {
    private OnItemClickListener listener;
    public FoodAdapter(@NonNull FirestoreRecyclerOptions<FoodItem> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull FoodHolder holder, int position, @NonNull FoodItem model) {
        holder.textViewTitle.setText(model.getTitle());
        holder.textViewPriority.setText(String.valueOf(model.getPriority()));
        Picasso.get().load(model.getPicture()).into(holder.myImageView);
    }
    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item,
                parent, false);
        return new FoodHolder(v);
    }
    class FoodHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewPriority;
        ImageView myImageView;
        public FoodHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);
            myImageView = itemView.findViewById(R.id.myImageView);

            // Onclick listener implementation for adapter
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(getSnapshots().getSnapshot(position), position);
                    }

                }
            });
        }
    }
    // methods for on click listener for adapter
    public interface OnItemClickListener {
        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }

    // methods for on click listener for adapter
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
//package com.example.androidfinalproject.CategoryRecyclerView;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
//
//    private List<String> categories;
//    private CategoryClickListener listener;
//
//    public CategoryAdapter(List<String> categories, CategoryClickListener listener) {
//        this.categories = categories;
//        this.listener = listener;
//    }
//
//    @NonNull
//    @Override
//    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R, parent, false);
//        return new CategoryViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
//        String category = categories.get(position);
//        holder.bind(category);
//    }
//
//    @Override
//    public int getItemCount() {
//        return categories.size();
//    }
//
//    class CategoryViewHolder extends RecyclerView.ViewHolder {
//
//        private Button categoryButton;
//
//        public CategoryViewHolder(@NonNull View itemView) {
//            super(itemView);
//            categoryButton = itemView.findViewById(R.id.category_button);
//            categoryButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String category = categories.get(getAdapterPosition());
//                    listener.onClick(category);
//                }
//            });
//        }
//
//        public void bind(String category) {
//            categoryButton.setText(category);
//        }
//    }
//}
//
//interface CategoryClickListener {
//    void onClick(String category);
//}
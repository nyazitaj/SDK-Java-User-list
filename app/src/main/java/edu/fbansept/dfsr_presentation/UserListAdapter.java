package edu.fbansept.dfsr_presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ProductViewHolder> {

    private ArrayList<User> userList;

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView itemUserName;
        TextView itemUserEmail;
        TextView itemUserPhone;
        TextView itemUserWebsite;
        TextView itemUserAddress;
        TextView itemUserCompany;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            itemUserName = itemView.findViewById(R.id.itemUserName);
            itemUserEmail = itemView.findViewById(R.id.itemUserEmail);
            itemUserPhone = itemView.findViewById(R.id.itemUserPhone);
            itemUserWebsite = itemView.findViewById(R.id.itemUserWebsite);
            itemUserAddress = itemView.findViewById(R.id.itemUserAddress);
            itemUserCompany = itemView.findViewById(R.id.itemUserCompany);
        }
    }

    public UserListAdapter(ArrayList<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_product,parent,false);

        ProductViewHolder viewHolder = new ProductViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.itemUserName.setText(userList.get(position).getName());
        holder.itemUserEmail.setText(userList.get(position).getEmail());
        holder.itemUserPhone.setText(userList.get(position).getPhone());
        holder.itemUserWebsite.setText(userList.get(position).getWebsite());
        holder.itemUserAddress.setText(userList.get(position).getAddress());
        holder.itemUserCompany.setText(userList.get(position).getCompany());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}

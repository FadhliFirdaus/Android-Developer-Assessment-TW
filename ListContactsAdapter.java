package com.example.interviewtesttrinitywizards;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListContactsAdapter extends RecyclerView.Adapter<ListContactsAdapter.ViewHolder> {

    private ArrayList<ContactsObject> contactsObjectArrayList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    Context context;

    // data is passed into the constructor
    ListContactsAdapter(Context context, ArrayList<ContactsObject> data) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.contactsObjectArrayList = data;

    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.contacts_list_view, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = contactsObjectArrayList.get(position).getFirstName() + " " + contactsObjectArrayList.get(position).getLastName();
        holder.myTextView.setText(animal);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return contactsObjectArrayList.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.contactsTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
            Intent myIntent = new Intent(context, SecondScreenActivity.class);
            ContactsObject tempObject = contactsObjectArrayList.get(getAdapterPosition());
            myIntent.putExtra("position", getAdapterPosition());
            myIntent.putExtra("firstName", tempObject.getFirstName());
            myIntent.putExtra("lastName", tempObject.getLastName());
            myIntent.putExtra("id", tempObject.getId());
            myIntent.putExtra("phone", tempObject.getPhonenNumber());
            myIntent.putExtra("email", tempObject.getEmail());

            view.getContext().startActivity(myIntent.addFlags(FLAG_ACTIVITY_NEW_TASK));
        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
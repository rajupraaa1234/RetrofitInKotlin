package com.example.retrofitinkotlin.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitinkotlin.R;
import com.example.retrofitinkotlin.User1;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    User1 arr[];

    public RecyclerViewAdapter(Context context, User1 arr[]) {
        this.context = context;
        this.arr = arr;
    }


   // Binds the given View to the position. The View can be a View previously retrieved via onCreateViewHolder it whould be iterate for all item
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.cart_item_layout,parent,false);
        return new ViewHolder(view);
    }


    //will be used to display items of the adapter using onBindViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User1 user=arr[position];
        if(user!=null && user.getId()!=null)
        holder.id.setText(String.valueOf(user.getId()));
        holder.employee_name.setText(String.valueOf(user.getPostId()));
        holder.employee_age.setText(user.getTitle());
        holder.employee_salary.setText(user.getBody());
    }


    @Override
    public int getItemCount() {
        return arr.length;
    }

  // it wholud be initialize the layout views so that we can access easly in onBindViewHolder method
    public class ViewHolder extends RecyclerView.ViewHolder {
      TextView id;
      TextView employee_name;
      TextView employee_age;
      TextView employee_salary;
      public ViewHolder(@NonNull View itemView){
          super(itemView);
          id=itemView.findViewById(R.id.id);
          employee_name=itemView.findViewById(R.id.name);
          employee_age=itemView.findViewById(R.id.age);
          employee_salary=itemView.findViewById(R.id.salary);
      }
    }
}

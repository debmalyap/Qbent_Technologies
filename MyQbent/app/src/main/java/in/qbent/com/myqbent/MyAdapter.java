package in.qbent.com.myqbent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{

    private List<MyData> listItems;
    private Context context;

    public MyAdapter(List<MyData> listItems, Context context)
    {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int i)
    {
        MyData listItem = listItems.get(i);
        viewHolder.textViewName.setText(listItem.getName());
        viewHolder.textViewAddr.setText(listItem.getAddress());
        viewHolder.textViewComp.setText(listItem.getCompany());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textViewName;
        public TextView textViewAddr;
        public TextView textViewComp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewAddr = (TextView) itemView.findViewById(R.id.textViewAddr);
            textViewComp = (TextView) itemView.findViewById(R.id.textViewComp);
        }
    }
}


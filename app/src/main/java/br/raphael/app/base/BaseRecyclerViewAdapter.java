package br.raphael.app.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseRecyclerViewAdapter<Model, Binding extends ViewDataBinding>
        extends RecyclerView.Adapter<BaseRecyclerViewAdapter<Model, Binding>.MyViewHolder> {

    private Context mContext;
    protected List<Model> mList;
    private LayoutInflater mLayoutInflater;

    public BaseRecyclerViewAdapter(Context context,@NonNull List<Model> list) {
        this.mList = list;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(getContext());
        }
        Binding binding = DataBindingUtil.inflate(mLayoutInflater,
                setLayoutResource(),
                viewGroup,
                false);

        return new MyViewHolder(binding);
    }

    public abstract int setLayoutResource();

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position){
        setViews(myViewHolder.binding, position);
    }

    public abstract void setViews(Binding binding, int position);

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public Model getItem(int position){
        return mList.get(position);
    }

    public List<Model> getItems(){
        return mList;
    }

    public void updateAllItems(@NonNull List<Model> newList){
        this.mList = newList;
        notifyDataSetChanged();
    }

    public void addItem(@NonNull Model item){
        mList.add(item);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        mList.remove(position);
        notifyDataSetChanged();
    }

    public void refresh(){
        notifyDataSetChanged();
    }

    public Context getContext(){
        return mContext;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Binding binding;

        public MyViewHolder(Binding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;

            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mListener != null)
                mListener.onItemClicked(view, getAdapterPosition());
        }
    }

    public RecyclerListener mListener;

    public void setListener(RecyclerListener listener){
        this.mListener = listener;
    }

    public interface RecyclerListener{
        void onItemClicked(View view, int position);
    }

}

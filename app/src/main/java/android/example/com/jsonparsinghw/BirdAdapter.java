package android.example.com.jsonparsinghw;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BirdAdapter extends RecyclerView.Adapter<BirdAdapter.BirdViewHolder> {
    List<Bird> birdList = new ArrayList<>();

    public BirdAdapter(List<Bird> birdList) {
        this.birdList = birdList;
    }

    @NonNull
    @Override
    public BirdViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.bird_list_view, viewGroup, false);
        return new BirdViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BirdViewHolder birdViewHolder, int i) {
        birdViewHolder.familyTv.setText(birdList.get(i).getFamily());
        birdViewHolder.membersTv.setText(birdList.get(i).getMembers());
    }

    @Override
    public int getItemCount() {
        return birdList.size();
    }

    public class BirdViewHolder extends RecyclerView.ViewHolder {
        private TextView familyTv;
        private TextView membersTv;

        public BirdViewHolder(@NonNull View itemView) {
            super(itemView);
            familyTv = itemView.findViewById(R.id.family_textview);
            membersTv = itemView.findViewById(R.id.members_textview);
        }
    }

}

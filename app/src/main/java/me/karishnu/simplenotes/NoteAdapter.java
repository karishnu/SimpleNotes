package me.karishnu.simplenotes;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.RealmBasedRecyclerViewAdapter;
import io.realm.RealmResults;
import io.realm.RealmViewHolder;

public class NoteAdapter extends RealmBasedRecyclerViewAdapter<Note, NoteAdapter.ViewHolder> {

    public NoteAdapter(Context context, RealmResults<Note> realmResults) {
        super(context, realmResults, true, false, null);
    }

    public class ViewHolder extends RealmViewHolder {

        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
        }
    }

    @Override
    public ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int viewType) {
        View v = inflater.inflate(R.layout.item_note, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindRealmViewHolder(ViewHolder viewHolder, int position) {
        final Note note = realmResults.get(position);
        viewHolder.textView.setText(note.getText());
    }
}
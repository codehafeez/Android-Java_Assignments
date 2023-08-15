package com.codehafeez.example;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
public class NoteAdapter extends ArrayAdapter<Note> {

    public NoteAdapter(Context context,ArrayList<Note> notes) {
        super(context, 0, notes);
    }

    public View getView(int position,View convertView, ViewGroup parent){
        if (convertView ==null){
            convertView =  ((Activity)getContext()).getLayoutInflater().inflate(R.layout.list_note,parent,false);
        }

        TextView note_id = (TextView) convertView.findViewById(R.id.note_id);
        TextView note_title = (TextView) convertView.findViewById(R.id.note_title);
        TextView note_description = (TextView) convertView.findViewById(R.id.note_description);

        Note note = getItem(position);
        note_id.setText(note.getDocId());
        note_title.setText(note.getTitle());
        note_description.setText(note.getDescription());
        return convertView;
    }
}
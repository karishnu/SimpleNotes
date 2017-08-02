package me.karishnu.simplenotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class CreateNoteActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        final Realm realm = Realm.getDefaultInstance();
        final Number currentIdNum = realm.where(Note.class).max("id");

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToSave = editText.getText().toString();

                Note note = new Note();
                note.setId(currentIdNum.intValue() + 1);
                note.setText(textToSave);

                realm.beginTransaction();
                realm.copyToRealm(note);
                realm.commitTransaction();

                finish();
            }
        });
    }
}

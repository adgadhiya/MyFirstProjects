package info.androidhive.slidingmenu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class clipboard_activity extends AppCompatActivity {

    Button copy,paste;
    EditText etcopy,etpaste;

    private ClipboardManager clipboardManager;
    private ClipData clipData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clipboard_activity);

         copy = (Button)findViewById(R.id.copy);
         paste=(Button)findViewById(R.id.paste);

        etcopy = (EditText)findViewById(R.id.etcopy);
        etpaste=(EditText)findViewById(R.id.etpaste);

        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        copy.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String text = etcopy.getText().toString();

                        clipData = ClipData.newPlainText("text",text);
                        clipboardManager.setPrimaryClip(clipData );

                        Toast.makeText(clipboard_activity.this,"Text Copied",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        paste.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clipData = clipboardManager.getPrimaryClip();
                        ClipData.Item item = clipData.getItemAt(0);

                        String text = item.getText().toString();
                        etpaste.setText(text);

                        Toast.makeText(clipboard_activity.this,"Text Pasted",Toast.LENGTH_SHORT).show();

                    }
                }
        );

    }
}

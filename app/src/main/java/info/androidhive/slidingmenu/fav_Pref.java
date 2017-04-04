package info.androidhive.slidingmenu;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Arrays;


public class fav_Pref extends AppCompatActivity implements View.OnClickListener  {


    private EditText url =null,hint=null;
    private Button save,clear;
    TableLayout myTableLayout;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav__pref);

        url = (EditText) findViewById(R.id.url);
        hint = (EditText) findViewById(R.id.hint);

        save = (Button) findViewById(R.id.save);
        clear = (Button) findViewById(R.id.clear);

        save.setOnClickListener(this);
        clear.setOnClickListener(this);

        sp = getSharedPreferences("serches", MODE_PRIVATE);

        myTableLayout = (TableLayout) findViewById(R.id.tablelayout);
        LoadButtons(null);
    }

    private void LoadButtons(String newString) {

        String[] list = sp.getAll().keySet().toArray(new String[0]);
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        if (newString != null) {
            makeListGUI(newString, Arrays.binarySearch(list, newString));
        } else {
            for (int i = 0; i < list.length; i++) {
                makeListGUI(list[i], i);
            }
        }
    }

    private void makeListGUI(String entries, int index) {

        LayoutInflater layoutInflater = getLayoutInflater();
        View v = layoutInflater.inflate(R.layout.new_list_view, null);

        Button edit = (Button) v.findViewById(R.id.edit);
        Button go = (Button) v.findViewById(R.id.go);

        edit.setOnClickListener(this);
        go.setOnClickListener(this);

        go.setText(entries);

        myTableLayout.addView(v, index);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.save:
                int urlString = url.getText().length();
                int hintString = hint.getText().length();

                if (urlString > 0 && hintString > 0) {
                    makeList(url.getText().toString(), hint.getText().toString());
                    url.setText("");
                    hint.setText("");
                    ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(hint.getWindowToken(), 0);
                } else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                    dialog.setMessage("Please Fill Both Fields");
                    dialog.setTitle("Info");
                    dialog.setPositiveButton("OK", null);

                    AlertDialog alertDialog = dialog.create();
                    alertDialog.show();
                }
                break;

            case R.id.clear:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setMessage("Are you sure to clear the list??");
                dialog.setTitle("Waring");
                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        myTableLayout.removeAllViews();

                        SharedPreferences.Editor editor = sp.edit();
                        editor.clear();
                        editor.apply();
                    }
                });
                dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                break;

            case R.id.edit:

                TableRow rowID = (TableRow) v.getParent();

                Button btn = (Button) rowID.findViewById(R.id.go);

                String s = btn.getText().toString();
                hint.setText(s);
                url.setText(sp.getString(s, null));

                break;

            case R.id.go:

                String url = ((Button) v).getText().toString();
                String finalurl = "https:" + sp.getString(url, "");

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(finalurl));
                startActivity(intent);

                break;
        }
    }

    private void makeList(String urlString, String hint) {

        String getString = sp.getString(hint, null);

        SharedPreferences.Editor editor = sp.edit();
        editor.putString(hint, urlString);
        editor.apply();

        if (getString == null) {
            LoadButtons(hint);
        }
    }
}
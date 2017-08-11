package com.applicationdev.a15017573.p12_mydatabook;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;

public class BioFragment extends Fragment {
    Button btnEdit;
    EditText editTextPassPhrase;
    TextView tvContent;
    //share preferences
    SharedPreferences prefs2;
    //DBHelper dbh = null;

    public BioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_bio, container, false);

        tvContent = (TextView) v.findViewById(R.id.tvContent);
        btnEdit = (Button) v.findViewById(R.id.btnEdit);
        // dbh = new DBHelper(getActivity());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set the dialog title
                final View editView = inflater.inflate(R.layout.fragment_bio, null);
                editTextPassPhrase = (EditText) editView.findViewById(R.id.editTextPassPhrase);
                editTextPassPhrase.setText(tvContent.getText());
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                //set title
                builder.setTitle("Edit Bio")
                        .setView(editView)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {


                                tvContent.setText(editTextPassPhrase.getText());
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return v;
    }
}
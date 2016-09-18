package com.example.gabekeyner.todolist20;


import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;


public class Fragment_DialogActivity extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final LayoutInflater inflater = getActivity().getLayoutInflater();

        final View view = inflater.inflate(R.layout.fragment_fragment__dialog, null);

        builder.setView(view);
        builder.setIcon(R.mipmap.ic_canvas);
        builder.setTitle("Add New Canvas");

        builder.setPositiveButton("Display", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int choice) {

                EditText editTitle, editDescription, editAuthor;

                editTitle = (EditText) view.findViewById(R.id.dialog_editTextTitle);
                editDescription = (EditText) view.findViewById(R.id.dialog_editTextDescription);
                editAuthor = (EditText) view.findViewById(R.id.dialog_editTextAuthor);

                /*databaseHelper.addInventory(
                    editTitle.getText().toString(),
                    editDescription.getText().toString(),
                    editAuthor.getText().toString());
                    */
                if (getActivity() instanceof MainActivity) ((MainActivity) getActivity()).populateView();

                Log.e("LOG", editTitle.getText().toString());
                Log.e("LOG", editDescription.getText().toString());

            }
        });

        builder.setNegativeButton("Discard", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int choice) {
                Fragment_DialogActivity.this.getDialog().cancel();
            }
        });


        return builder.create();
    }


}

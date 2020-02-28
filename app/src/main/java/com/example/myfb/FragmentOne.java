package com.example.myfb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfb.DataSourse.Database;

import static com.example.myfb.DataSourse.Database.DATABASE_NAME;
import static com.example.myfb.DataSourse.Database.DB_VERSION;


public class FragmentOne extends Fragment {

    Database databaseManager;
    EditText name_feild,age_feild,mark_feild;
    Button submit;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    public static FragmentOne newInstance(){

        FragmentOne fragmentOne = new FragmentOne();
        return fragmentOne;


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one,container,false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        databaseManager = new Database(getContext(),DATABASE_NAME,null,DB_VERSION);

        name_feild =(EditText) view.findViewById(R.id.txt_name);
        age_feild=(EditText)view.findViewById(R.id.txt_age);
        mark_feild=(EditText)view.findViewById(R.id.txt_marks);
        submit=(Button)view.findViewById(R.id.btn_submit);
        addData();


    }

    public void addData(){
        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean if_insert= databaseManager.insertDetails(name_feild.getText().toString(),age_feild.getText().toString(),mark_feild.getText().toString());
                        if (if_insert=true)
                            Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }


}
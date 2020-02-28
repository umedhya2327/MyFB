package com.example.myfb;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfb.DataSourse.Database;

import static com.example.myfb.DataSourse.Database.DATABASE_NAME;

public class FragmentThree extends Fragment {
    Database database;
    SearchView searchView;
    TextView name, age, mark;
    String result;

    public static FragmentThree newInstance() {
        FragmentThree fragmentThree = new FragmentThree();
        return fragmentThree;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        database = new Database(getContext(), DATABASE_NAME, null, 1);
        searchView = view.findViewById(R.id.searchView);
        name = view.findViewById(R.id.db_name);
        age = view.findViewById(R.id.db_age);
        mark = view.findViewById(R.id.db_mark);
        result = searchView.toString();

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor value = database.getDetails();

                if ((value.getCount()) == 0) {

                    return;
                }


                while (value.moveToNext()) {
                    if ((value.getString(1)) == (view.findViewById(R.id.searchView).toString())) {
                        name.setText(value.getString(1));
                        age.setText(value.getString(2));
                        mark.setText(value.getString(3));
                    }
                }
            }
        });


    }

}






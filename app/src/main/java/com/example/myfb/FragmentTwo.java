
package com.example.myfb;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfb.DataSourse.Database;

import static com.example.myfb.DataSourse.Database.DATABASE_NAME;


public class FragmentTwo extends Fragment{
    Database databaseManager;
    Button btn;

    public static FragmentTwo newInstance(){
        FragmentTwo fragmetTwo = new FragmentTwo();
        return fragmetTwo;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        databaseManager=new Database(getContext(),DATABASE_NAME,null,1);
        btn=(Button)view.findViewById(R.id.btn_view);

        retrieveAll();


    }
    public void retrieveAll(){
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor result=databaseManager.getDetails();
                        if (result.getCount()==0){
                            details("Error","Database Empty or Something Wrong!");
                            return;
                        }
                        StringBuffer buffer=new StringBuffer();
                        while (result.moveToNext()){
                            buffer.append("Index No :"+result.getString(0)+"\n");
                            buffer.append("Name  :"+result.getString(1)+"\n");
                            buffer.append("Age   :"+result.getString(2)+"\n");
                            buffer.append("Marks :"+result.getString(3)+"\n");
                        }

                        details("All Details",buffer.toString());
                    }
                }
        );
    }
    public  void details(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}

package cl.onecrowd.alfredo.aqualert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;
import java.util.ListIterator;

import cl.onecrowd.alfredo.aqualert.resource.dbFlow.MobUser;

public class DatabaseView_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_view_activity);

        TextView showData = (TextView) findViewById(R.id.showData_TextView);
        List<MobUser> UserList = SQLite.select().from(MobUser.class).queryList();

        String db_user_name;
        int db_user_id,db_user_age;

        for(MobUser mu : UserList){

            db_user_id = mu.getId();
            db_user_name = mu.getName();
            db_user_age = mu.getAge();

            showData.append("ID: "+db_user_id+" Name: "+db_user_name+" Age: "+db_user_age+"\n\n");

        }

    }
}

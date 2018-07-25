package cl.onecrowd.alfredo.aqualert.resource.dbFlow;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import cl.onecrowd.alfredo.aqualert.resource.dbFlow.MyDatabase;

@Table(database = MyDatabase.class)
public class MobUser extends BaseModel{

    @PrimaryKey(autoincrement = true)
    int id;

    @Column
    String name;

    @Column
    int age;

    public void insertData(String Name, int Age){
        this.name = Name;
        this.age = Age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

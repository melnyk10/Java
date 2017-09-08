package com.forest.guessthegame.service;

import android.content.Context;
import android.util.Log;

import com.forest.guessthegame.dbSQLite.impl.DataBase_SQLite;

import java.util.ArrayList;
import java.util.List;

public class DataBase_Service_impl {
    private Context context;
    private DataBase_SQLite dataBase_sqLite;

    public List<Short> listOfIds;
    private String answer = "";
    private short indexOfID = 0;

    public DataBase_Service_impl(Context context) {
        this.context = context;
        this.dataBase_sqLite = new DataBase_SQLite(context);
        //dataBase_sqLite.onUpgrade(dataBase_sqLite.getReadableDatabase(),1,1);
        this.listOfIds = dataBase_sqLite.getListIds();
    }


    public void getNewIndexForImg() {
        indexOfID = listOfIds.get(randomNameOfGame()); // random id from list
        answer = dataBase_sqLite.getEngName(indexOfID); // if get from DB need to add 1+randomNameOfGame()
        Log.e("index id", "index = " + indexOfID);
        Log.e("Answer", "answer = " + answer);
        Log.e("Size of list", "size = " +  getIdsListOfDB().size());
    }


    public String getAnswer() {
        return answer;
    }

    private short randomNameOfGame() {
        return (short) (Math.random() * (listOfIds.size())); // [0...21]
    }

    public void reset() {
        listOfIds = new ArrayList<>(dataBase_sqLite.getListIds());
    }

    public List<Short> getIdsListOfDB() {
        return listOfIds;
    }

    public String getNameOfPic() {
        return dataBase_sqLite.getJpgName(indexOfID);
    }

    public String getName() {
        return dataBase_sqLite.getEngName(indexOfID);
    }

    public String getName(short id) {
        return dataBase_sqLite.getEngName(id);
    }

    public short getID() {
        return indexOfID;
    }

    public short getYear() {
        return dataBase_sqLite.getYear(indexOfID);
    }

    public void setListOfIds(List<Short> listOfIds) {
        this.listOfIds = listOfIds;
    }

}
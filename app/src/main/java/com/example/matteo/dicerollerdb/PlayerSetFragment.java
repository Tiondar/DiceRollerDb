package com.example.matteo.dicerollerdb;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.sql.SQLException;


public class PlayerSetFragment extends Fragment {

    private static SQLiteDatabase db;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_player_set, container, false);



        //Create objects for editTexts

        final EditText editText_d4 = (EditText) v.findViewById(R.id.dQuattroEdt);
        final EditText editText_d6 = (EditText) v.findViewById(R.id.dSeiEdt);
        final EditText editText_d8 = (EditText) v.findViewById(R.id.dOttoEdt);
        final EditText editText_d10 = (EditText) v.findViewById(R.id.dDieciEdt);
        final EditText editText_d12 = (EditText) v.findViewById(R.id.dDodiciEdt);
        final EditText editText_d20 = (EditText) v.findViewById(R.id.dVentiEdt);
        final EditText editText_d100 = (EditText) v.findViewById(R.id.dCentoEdt);
        final EditText editModifier = (EditText) v.findViewById(R.id.modifierSet);
        Button buttonSave = (Button) v.findViewById(R.id.button_save);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PlayerSQLiteOpenHelper playerHelper = new PlayerSQLiteOpenHelper(getContext());
                playerHelper.getWritableDatabase();

                db = playerHelper.getWritableDatabase();


                Player player0 = new Player();

/*
                //backup of data from player0
                int oldd4Numb = 0;
                int oldd6Numb = 3;
                int oldd8Numb = 0;
                int oldd10Numb = 1;
                int oldd12Numb = 0;
                int oldd20Numb = 1;
                int oldd100Numb = 0;
                int oldModifier = 6;*/


                try {//try to pass data from EditTexts to DB

                    final ContentValues values = new ContentValues();

                    values.put(TableLook.TableLooker.PLAYERNAME, "player1");
                    //values.put(TableLook.TableLooker._ID, 1);

                    String d4Str = editText_d4.getEditableText().toString();
                    int d4Int = Integer.parseInt(d4Str);
                    player0.setD4Number(d4Int);
                    values.put(TableLook.TableLooker.D4NUMBER,player0.d4Number);

                    String d6Str = editText_d6.getEditableText().toString();
                    int d6Int = Integer.parseInt(d6Str);
                    player0.setD6Number(d6Int);
                    values.put(TableLook.TableLooker.D6NUMBER,player0.d6Number);

                    String d8Str = editText_d8.getEditableText().toString();
                    int d8Int = Integer.parseInt(d8Str);
                    player0.setD8Number(d8Int);
                    values.put(TableLook.TableLooker.D8NUMBER,player0.d8Number);

                    String d10Str = editText_d10.getEditableText().toString();
                    int d10Int = Integer.parseInt(d10Str);
                    player0.setD10Number(d10Int);
                    values.put(TableLook.TableLooker.D10NUMBER,player0.d10Number);

                    String d12Str = editText_d12.getEditableText().toString();
                    int d12Int = Integer.parseInt(d12Str);
                    player0.setD12Number(d12Int);
                    values.put(TableLook.TableLooker.D12NUMBER,player0.d12Number);

                    String d20Str = editText_d20.getEditableText().toString();
                    int d20Int = Integer.parseInt(d20Str);
                    player0.setD20Number(d20Int);
                    values.put(TableLook.TableLooker.D20NUMBER,player0.d20Number);

                    String d100Str = editText_d100.getEditableText().toString();
                    int d100Int = Integer.parseInt(d100Str);
                    player0.setD100Number(d100Int);
                    values.put(TableLook.TableLooker.D100NUMBER,player0.d100Number);

                    String modifierStr = editModifier.getEditableText().toString();
                    int modifierInt = Integer.parseInt(modifierStr);
                    player0.setModifierDb(modifierInt);
                    values.put(TableLook.TableLooker.MODIFIER,player0.modifierDb);



                    try{
                        String selection = "player = ?";
                        String[] selectionArgs = { String.valueOf("player1") };


                        db.update(
                                TableLook.TableLooker.TABLE_NAME,
                                values,
                                selection,
                                selectionArgs);

                    }catch (SQLiteException e){

                        db.insert(
                                TableLook.TableLooker.TABLE_NAME,
                                null,
                                values);


                    }



                    //Change Fragment

                } catch (NumberFormatException numbFormExcept) {//Done if user didn't input an integer number and parseInt failed

                    Toast.makeText(getContext(), "Invalid Input, use only INT", Toast.LENGTH_LONG);

                    //Set value to backup data
                  /*  player0.setD4Number(oldd4Numb);
                    player0.setD6Number(oldd6Numb);
                    player0.setD8Number(oldd8Numb);
                    player0.setD10Number(oldd10Numb);
                    player0.setD12Number(oldd12Numb);
                    player0.setD20Number(oldd20Numb);
                    player0.setD100Number(oldd100Numb);
                    player0.setModifierDb(oldModifier);
*/
                }

                RollerFragment rollerFragment = new RollerFragment();
                FragmentTransaction fragmentTransactionSet = getFragmentManager().beginTransaction().replace(R.id.mainLayout, rollerFragment).addToBackStack(null);
                fragmentTransactionSet.commit();




            }
        });


        return v;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        db.close();
    }
}

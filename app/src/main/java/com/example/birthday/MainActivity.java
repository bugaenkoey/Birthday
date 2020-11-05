package com.example.birthday;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.birthday.helper.DBHelper;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
//Birthday
    DBHelper dbHelper;
    String msg;
    String timeMsg;
    Boolean dark = true;
    String dateVent;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switchMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_find);
        setContentView(R.layout.activity_persones);
        // создаем объект для создания и управления версиями БД
        dbHelper = new DBHelper(this);
        ListView lvPersones = (ListView) this.findViewById(R.id.list_persones);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        switch (id) {
            case R.id.action_time: {
              timeMsg =  timeMsg();
            }
            break;
            case R.id.action_theme_dark: {
                switchDark();
            }
            break;

            case R.id.action_author: {
                author();
            }
            break;
            default:

        }
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

        return super.onOptionsItemSelected(item);

    }

    private String timeMsg() {
      //  public void datePick(View v) {

            Calendar C = Calendar.getInstance();
            final int[] year = {C.get(Calendar.YEAR)};
            final int[] month = {C.get(Calendar.MONTH)};
            final int[] day = {C.get(Calendar.DAY_OF_MONTH)};
            DatePickerDialog picker = new DatePickerDialog(this, null, year[0], month[0], day[0]) {
                @Override
                public void onDateChanged(DatePicker view, int _year, int _month, int _day) {
                    year[0] = _year;
                    month[0] = _month;
                    day[0] = _day;
                }
            };

            picker.setButton(DialogInterface.BUTTON_POSITIVE, "Выбрать", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                 String txt = ((day[0] < 10) ? "0" : "") + day[0] + "/" + ((month[0] < 9) ? "0" : "") + (month[0] + 1) + "/" + year[0];
                    Toast.makeText(MainActivity.this, "Выбранная	дата	дд/мм/гггг	:	" + txt, Toast.LENGTH_SHORT).show();
                    dateVent=txt;
                }
            });
            picker.setButton(DialogInterface.BUTTON_NEGATIVE, "Отменить", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Отменено", Toast.LENGTH_SHORT).show();
                }
            });
            picker.show();

return dateVent;
    }
    private void switchDark() {
        //       msg = "theme_dark";
        final AlertDialog themeDialog = new AlertDialog.Builder(MainActivity.this).create();
        //   themeDialog.setTitle("Выбор темы");
        //   themeDialog.setMessage("");
        themeDialog.setView(getLayoutInflater().inflate(R.layout.switch_dark, null));
        themeDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switchMenu = themeDialog.findViewById(R.id.switch_Dark);
                        dark = switchMenu.isChecked();//Состояние switch_Dark вкл выкл
                        msg = dark ? "Select Dark" : "Select No dark";

                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

        themeDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        themeDialog.create();
        themeDialog.show();
    }
    private void author() {

        msg = "author";
        AlertDialog aboutDialog = new AlertDialog.Builder(MainActivity.this).create();
        aboutDialog.setTitle("Разработчик программы");
        aboutDialog.setMessage("(c)2020 студент академии ШАГ\nБугаенко Евгений.");
        aboutDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }
        );
        aboutDialog.show();
    }

}
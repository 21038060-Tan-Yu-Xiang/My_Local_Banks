package sg.edu.rp.c346.id21038060.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String bankClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the Bank");
        menu.add(0,2,2,"Toggle Favourite");

        if (v == tvDBS){
            bankClicked = "DBS";
        }
        else if (v == tvOCBC){
            bankClicked = "OCBC";
        }
        else if (v == tvUOB){
            bankClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (bankClicked) {
            case "DBS":
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                    startActivity(intent);
                    return true; //menu item successfully handled
                } else if (item.getItemId() == 1) { //check whether the selected menu item ID is 1
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18001111111L));
                    startActivity((intentCall));
                    return true; //menu item successfully handled
                }
                else if (item.getItemId() == 2) { //check whether the selected menu item ID is 2
                    if (tvDBS.getCurrentTextColor() == -1){
                        tvDBS.setTextColor(Color.RED);
                    }
                    else {
                        tvDBS.setTextColor(Color.WHITE);
                    }
                    return true; //menu item successfully handled
                }
                break;
            case "OCBC":
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                    startActivity(intent);
                    return true; //menu item successfully handled
                } else if (item.getItemId() == 1) { //check whether the selected menu item ID is 1
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18003633333L));
                    startActivity((intentCall));
                    return true; //menu item successfully handled
                }
                else if (item.getItemId() == 2) { //check whether the selected menu item ID is 2
                    if (tvDBS.getCurrentTextColor() == -1){
                        tvDBS.setTextColor(Color.RED);
                    }
                    else {
                        tvDBS.setTextColor(Color.WHITE);
                    }
                    return true; //menu item successfully handled
                }
                break;
            case "UOB":
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                    startActivity(intent);
                    return true; //menu item successfully handled
                } else if (item.getItemId() == 1) { //check whether the selected menu item ID is 1
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18002222121L));
                    startActivity((intentCall));
                    return true; //menu item successfully handled
                }
                else if (item.getItemId() == 2) { //check whether the selected menu item ID is 2
                    if (tvDBS.getCurrentTextColor() == -1){
                        tvDBS.setTextColor(Color.RED);
                    }
                    else {
                        tvDBS.setTextColor(Color.WHITE);
                    }
                    return true; //menu item successfully handled
                }
                break;
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}
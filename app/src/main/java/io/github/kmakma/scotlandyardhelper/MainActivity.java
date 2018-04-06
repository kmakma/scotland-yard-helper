package io.github.kmakma.scotlandyardhelper;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnClickSelectTransportation(View view) {
        int id = view.getId();
        if (id == R.id.imageButton3 || id == R.id.imageButton8 || id == R.id.imageButton13 ||
            id == R.id.imageButton18 || id == R.id.imageButton24) {
            // TODO: 06.04.2018 open field number selector
        }
        alertDialogBuilderAndShow((ImageButton) view).show();
        // TODO: 05.04.2018 open selector for means of transportation


    }

    private AlertDialog alertDialogBuilderAndShow(final ImageButton imageButton) {
        CharSequence[] items = new CharSequence[]{"taxi", "bus", "underground", "black ticket"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select means of movement").setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int id;
                switch (which) {
                    case 0:
                        id = R.drawable.ic_taxi;
                        break;
                    case 1:
                        id = R.drawable.ic_bus;
                        break;
                    case 2:
                        id = R.drawable.ic_underground;
                        break;
                    case 3:
                        id = R.drawable.ic_black_ticket;
                        break;
                    default:
                        id = R.drawable.ic_blank;
                }
                imageButton.setImageResource(id);
            }
        });


        return builder.create();
        // TODO: 06.04.2018 file:///D:/Android/Sdk/docs/guide/topics/ui/dialogs.html#AlertDialog
    }

    public void btnClickCreateGraph(View view) {
//        TextView textView = findViewById(R.id.textView_graph);
//        textView.setText(String.format("%s %d", getString(R.string.textView_graph), ThreadLocalRandom.current()
// .nextInt(1000, 10000)));
    }
}

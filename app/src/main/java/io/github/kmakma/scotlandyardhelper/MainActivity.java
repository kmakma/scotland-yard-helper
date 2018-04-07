package io.github.kmakma.scotlandyardhelper;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import de.dikodam.skotlindyard.api.Move;

public class MainActivity extends AppCompatActivity {

    private SparseArray<Movement> movements;

    int[] imageButtonResIDs = new int[]{R.id.imageButton1, R.id.imageButton2, R.id.imageButton3, R.id.imageButton4,
            R.id.imageButton5, R.id.imageButton6, R.id.imageButton7, R.id.imageButton8, R.id.imageButton9,
            R.id.imageButton10, R.id.imageButton11, R.id.imageButton12, R.id.imageButton13, R.id.imageButton14,
            R.id.imageButton15, R.id.imageButton16, R.id.imageButton17, R.id.imageButton18, R.id.imageButton19,
            R.id.imageButton20, R.id.imageButton21, R.id.imageButton22, R.id.imageButton23, R.id.imageButton24};

    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // TODO: 07.04.2018 while creating graph and co DO loading animation
        setupMovementsArray();
    }

    private void setupMovementsArray() {
        movements = new SparseArray<>();

        for (int i = 1; i < 25; i++) {
            Movement movement = new Movement(i, imageButtonResIDs[i - 1]);
            movements.append(movement.getWhich(), movement);
            movements.append(movement.getImageButtonResID(), movement);
        }
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
        alertDialogBuilderAndShow(view.getId()).show();
        // TODO: 05.04.2018 open selector for means of transportation
    }

    private AlertDialog alertDialogBuilderAndShow(final int imageButtonResID) {
        // TODO: 07.04.2018 add a movement, place info into movement
        // FIXME: 07.04.2018 Database or DualKeyMap!!! two Keys one Value
        CharSequence[] items = new CharSequence[]{"taxi", "bus", "underground", "black ticket"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Select means of movement")
               .setNeutralButton("clear move", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       Movement movement = movements.get(imageButtonResID);
                       movement.setMove(null);
                       updateImageButtonOf(movement);
                   }
               })
               .setItems(items, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       Move moveType;
                       switch (which) {
                           case 0: // selected: taxi
                               moveType = Move.TAXI;
                               break;
                           case 1: // selected: bus
                               moveType = Move.BUS;
                               break;
                           case 2: // selected: underground
                               moveType = Move.UNDERGROUND;
                               break;
                           case 3: // selected: black ticket
                               moveType = Move.BLACK;
                               break;
                           default:
                               moveType = null;
                       }
                       Movement movement = movements.get(imageButtonResID);
                       movement.setMove(moveType);
                       updateImageButtonOf(movement);
                   }
               });
        return builder.create();
    }

    private void updateImageButtonOf(Movement movement) {
        // get ImageButton of movement
        ImageButton imageButton = findViewById(movement.getImageButtonResID());
        // update image
        int imageID;
        if (movement.getMove() != null) {
            switch (movement.getMove()) {
                case TAXI:
                    imageID = R.drawable.ic_taxi;
                    break;
                case BUS:
                    imageID = R.drawable.ic_bus;
                    break;
                case UNDERGROUND:
                    imageID = R.drawable.ic_underground;
                    break;
                case BLACK:
                    imageID = R.drawable.ic_black_ticket;
                    break;
                default:
                    imageID = R.drawable.ic_blank;
            }
        } else {
            imageID = R.drawable.ic_blank;
        }
        imageButton.setImageResource(imageID);
    }

    public void btnClickCreateGraph(View view) {
//        TextView textView = findViewById(R.id.textView_graph);
//        textView.setText(String.format("%s %d", getString(R.string.textView_graph), ThreadLocalRandom.current()
// .nextInt(1000, 10000)));
    }
}

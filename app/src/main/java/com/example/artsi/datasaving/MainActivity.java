package com.example.artsi.datasaving;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    EditText productInput;
    TextView productOutput;
    Button addButton, deleteButton;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productInput = (EditText) findViewById(R.id.input);
        productOutput = (TextView) findViewById(R.id.productOutput);
        addButton = (Button) findViewById(R.id.addButton);
        deleteButton = (Button)findViewById(R.id.deleteButton);

        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }
    public void addButtonClicked(View view){
        String product = productInput.getText().toString();
        Products p = new Products(product);
        dbHandler.addProduct(p);
        printDatabase();
    }
    public void deleteButtonClicked(View view){
        String inputText = productInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }
    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        productOutput.setText(dbString);
        productInput.setText("");
    }
}
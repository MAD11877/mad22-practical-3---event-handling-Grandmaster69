package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User u = new User("Gerald", "likes cats", 1, true);
        Button btn = findViewById(R.id.button);
        Button messagebtn = findViewById(R.id.button2);
        TextView t = findViewById(R.id.textView);
        Intent receive = getIntent();
        int m = receive.getIntExtra("random", -1);
        t.setText("MAD "+m);
        messagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(i);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if (u.Followed) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT);
                    toast.show();
                    btn.setText("UNFOLLOW");
                    u.Followed = false;
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT);
                    toast.show();
                    btn.setText("FOLLOW");
                    u.Followed = true;
                }
            }
        });
    }
}
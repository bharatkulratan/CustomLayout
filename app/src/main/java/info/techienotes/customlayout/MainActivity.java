package info.techienotes.customlayout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;

        CustomLayout layout = (CustomLayout)findViewById(R.id.custom_layout);
        Button [] button_list = new Button[4];

        for (int I=0; I<4; I++){
            //Created new button
            button_list[I] = new Button (mContext);
            button_list[I].setText("Button #" + I);

            //Adding button dynamically
            layout.addView(button_list[I]);

            button_list[I].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, " CustomLayout ", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

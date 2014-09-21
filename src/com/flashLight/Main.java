package com.flashLight;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {

	Button light;
	Camera camera;
	Parameters p;
	boolean isLightOff=true;
	
	@Override
	protected void onStop() {
		super.onStop();
 
		if (camera != null) {
			camera.release();
		}
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // to set all the variable
        light = (Button) findViewById(R.id.light);
        camera = Camera.open();
        p = camera.getParameters();
        
        
       
	        light.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					// TODO Auto-generated method stub
						
						if(isLightOff){
							isLightOff=false;
							light.setText("Off");
							p.setFlashMode(Parameters.FLASH_MODE_TORCH);
							camera.setParameters(p);
							camera.startPreview();
						}else{
							isLightOff=true;
							light.setText("On");
							p.setFlashMode(Parameters.FLASH_MODE_OFF);
							camera.setParameters(p);
							camera.startPreview();			
						}
				}
			});
					
					
		
    }
    	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}

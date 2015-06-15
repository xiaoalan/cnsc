package app.ui.activity;

import mobi.kuaidian.qunakao.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import app.ui.MainActivity;

public class LoginActivity extends Activity implements OnClickListener{
	private Button login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
	}

	private void initView() {
		login = (Button) findViewById(R.id.login_button);
		login.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.login_button:
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			finish();
			break;

		default:
			break;
		}
	}
	
	
	
}

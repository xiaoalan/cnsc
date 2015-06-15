package app.ui.activity.peixu;

import mobi.kuaidian.qunakao.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.VideoView;
import app.ui.BaseActivity;

public class ViedoAcitivity extends BaseActivity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viedo);
		VideoView vv = (VideoView)this.findViewById(R.id.video_view);
		String uri = "android.resource://" + getPackageName() + "/" + R.raw.a10001;
		vv.setVideoURI(Uri.parse(uri));
		vv.start();
		findViewById(R.id.title_back_button).setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.title_back_button:

			finish();
			break;

		default:
			break;
		}
	}
}

package app.ui.activity.peixu;

import mobi.kuaidian.qunakao.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;
import app.ui.BaseActivity;

public class ViedoAcitivity extends BaseActivity implements OnClickListener {
	VideoView vv;
	Button button;
	boolean play = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viedo);
		vv = (VideoView) this.findViewById(R.id.video_view);
		String uri = getIntent().getStringExtra("URI");
		int tag = getIntent().getIntExtra("TAG", -1);
		vv.setVideoURI(Uri.parse(uri));
		
		findViewById(R.id.title_back_button).setOnClickListener(this);
		button = (Button) findViewById(R.id.video_button);
		TextView abbrTV = (TextView) findViewById(R.id.video_title);
		button.setOnClickListener(this);
		TextView textView = (TextView)findViewById(R.id.title_title);
		switch (tag) {
		case 2:
			
			textView.setText("曲线行驶");
			abbrTV.setText("视频：曲线行驶");
			
			break;
		case 1:
			
			textView.setText("倒车入库");
			abbrTV.setText("视频：倒车入库");
			break;
		case 0:
			
			textView.setText("侧方停车");
			abbrTV.setText("视频：侧方停车");
			break;
		case 4:
			
			textView.setText("坡道定点");
			abbrTV.setText("正在练习：坡道定点");
			break;
		case 3:
			
			textView.setText("直角转弯");
			abbrTV.setText("视频：直角转弯");
			break;

		default:
			break;
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.title_back_button:

			finish();
			break;
		case R.id.video_button:
			if (!play) {
				play = true;
				button.setVisibility(View.GONE);
				vv.start();
			} else {
				play = false;
				button.setVisibility(View.VISIBLE);
				vv.stopPlayback();
			}

			break;

		default:
			break;
		}
	}

	@Override
	protected void onDestroy() {

		vv.stopPlayback();
		super.onDestroy();
	}
}

package app.ui.activity.peixu;

import mobi.kuaidian.qunakao.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.ui.BaseActivity;
import app.ui.TitleActivity;


public class SubjectOne extends BaseActivity implements OnClickListener{
	private RelativeLayout layout01,layout02,layout03,layout04,layout05,layout06;
	private boolean iszk = false;
	private ImageView zkimage;
	private int flag = 0;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_subject_one1);
	       
	        flag = getIntent().getIntExtra("TAG", flag);
	        initView();
	    }

	private void initView() {
		TextView textView1 = (TextView) findViewById(R.id.km_num_tv);
		TextView textView = (TextView) findViewById(R.id.title_title);
		zkimage = (ImageView) findViewById(R.id.km2_zk_button);
		zkimage.setOnClickListener(this);
		if(flag==1){
			textView.setText("科目一理论");
			textView1.setText("培训内容：科目一");
			
		}else if(flag==4){
			textView.setText("科目四安全文明");
			textView1.setText("培训内容：科目四");
		}
		// TODO Auto-generated method stub
		findViewById(R.id.layout_lx1).setOnClickListener(this);
		findViewById(R.id.layout_lx2).setOnClickListener(this);
		findViewById(R.id.layout_lx3).setOnClickListener(this);
		findViewById(R.id.layout_lx4).setOnClickListener(this);
		findViewById(R.id.layout_lx5).setOnClickListener(this);
		findViewById(R.id.layout_lx6).setOnClickListener(this);
		findViewById(R.id.title_back_button).setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.layout_lx1:
			
		case R.id.layout_lx2:
			
		case R.id.layout_lx3:
			
		case R.id.layout_lx4:
			
		case R.id.layout_lx5:
			
		case R.id.layout_lx6:
			Intent intent = new Intent(this, QuestionsActivity.class);
			intent.putExtra("TAG", flag);
			startActivity(intent);
			break;
		case R.id.title_back_button:
			
			finish();
			break;
		case R.id.km2_zk_button:
			if(!iszk){
				iszk = true;
				zkimage.setBackgroundResource(R.drawable.km2_ll_bh);
				findViewById(R.id.km2_ll_llzk).setVisibility(View.VISIBLE);
				
			}else{
				iszk = false;
				zkimage.setBackgroundResource(R.drawable.km2_ll_zk);
				findViewById(R.id.km2_ll_llzk).setVisibility(View.GONE);
			}
			
			break;
		default:
			break;
		}
	}
	 

}

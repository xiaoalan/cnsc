package app.ui.activity.peixu;

import mobi.kuaidian.qunakao.R;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.ui.BaseActivity;
import app.ui.TitleActivity;


public class QuestionsActivity extends BaseActivity implements OnClickListener{
	private RelativeLayout layout01,layout02,layout03,layout04,layout05,layout06;
	private RadioGroup radioGroup=null;
	private RadioButton radioButton1,radioButton2,radioButton3,radioButton4;
	private int flag = 0;
	private LinearLayout linearLayout;
	private TextView result,result1;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_questions);
	       
	        flag = getIntent().getIntExtra("TAG", flag);
	        initView();
	    }

	private void initView() {
		TextView textView = (TextView) findViewById(R.id.title_title);
		TextView questionsTv = (TextView) findViewById(R.id.questions_tv);
		if(flag==1){
			textView.setText("科目一理论");
			questionsTv.setText("科目一：顺序练习");
		}else if(flag==4){
			textView.setText("科目四安全文明");
			questionsTv.setText("科目四：顺序练习");
		}
		// TODO Auto-generated method stub
	
		findViewById(R.id.title_back_button).setOnClickListener(this);
		linearLayout = (LinearLayout) findViewById(R.id.questions_result_ll);
		result = (TextView) findViewById(R.id.questions_result);
		result1 = (TextView) findViewById(R.id.questions_result1);
		radioGroup = (RadioGroup) findViewById(R.id.select_group);
		radioGroup.setOnCheckedChangeListener(changeListener);
		
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
	OnCheckedChangeListener changeListener = new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			switch (checkedId) {
			case R.id.select_a:
				result.setText("正确答案是:B");
				result1.setVisibility(View.VISIBLE);
				linearLayout.setVisibility(View.VISIBLE);
				break;
			case R.id.select_b:
				result.setText("正确");
				result1.setVisibility(View.GONE);
				linearLayout.setVisibility(View.VISIBLE);
				break;
			case R.id.select_c:
				result.setText("正确答案是:B");
				result1.setVisibility(View.VISIBLE);
				linearLayout.setVisibility(View.VISIBLE);
				break;
			case R.id.select_d:
				result.setText("正确答案是:B");
				result1.setVisibility(View.VISIBLE);
				linearLayout.setVisibility(View.VISIBLE);
				break;

			default:
				break;
			}
		}
	};

}

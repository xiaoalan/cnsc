package app.ui.activity.peixu;

import java.util.ArrayList;
import java.util.List;

import mobi.kuaidian.qunakao.R;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import app.ui.BaseActivity;
import app.util.TypeIntent;

public class SubjectTwo extends BaseActivity implements OnClickListener {
	private TextView textView1, textView2, textView3;
	private View view1, view2, view3;// 需要滑动的页卡
	private ListView listView1, listView2;// 需要滑动的页卡
	private ViewPager viewPager;// viewpager
	private List<View> viewList;// 把需要滑动的页卡添加到这个list中
	private ImageView belowSlideImg, qxxs, dcrk, cftc, pddd, zjgw;
	private int offset = 0;// 动画图片偏移量
	private int currIndex = 0;// 当前页卡编号
	private int bmpW;// 动画图片宽度
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subject_two);
		initTextView();
		initView();

	}

	private void initView() {
		LayoutInflater lf = getLayoutInflater().from(this);
		view1 = lf.inflate(R.layout.view_xlc, null);
		view2 = lf.inflate(R.layout.view_xlc, null);
		view3 = lf.inflate(R.layout.view_xlc, null);
		viewList = new ArrayList<View>();
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);

		findViewById(R.id.title_back_button).setOnClickListener(this);
		viewPager = (ViewPager) findViewById(R.id.report_submit_viewpager);

		viewPager.setAdapter(new MyViewPagerAdapter());
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}

	private void initTextView() {
		textView1 = (TextView) findViewById(R.id.report_submit_text1);
		textView2 = (TextView) findViewById(R.id.report_submit_text2);
		textView3 = (TextView) findViewById(R.id.report_submit_text3);

		textView1.setOnClickListener(new MyOnClickListener(0));
		textView2.setOnClickListener(new MyOnClickListener(1));
		textView3.setOnClickListener(new MyOnClickListener(2));
		textView1.setSelected(true);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.title_back_button:

			finish();
			break;
		case R.id.xlc_sp_cftc:
			intent = new Intent(this, ViedoAcitivity.class);
			startActivity(intent);
			break;
		case R.id.xlc_sp_pddd:
			intent = new Intent(this, ViedoAcitivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

	/**
	 * 
	 * 头标点击监听
	 */
	private class MyOnClickListener implements OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}

		public void onClick(View v) {
			switch (index) {
			case 0:
				textView1.setSelected(true);
				textView2.setSelected(false);
				textView3.setSelected(false);

				break;
			case 1:
				textView1.setSelected(false);
				textView2.setSelected(true);
				textView3.setSelected(false);
				break;
			case 2:
				textView1.setSelected(false);
				textView2.setSelected(false);
				textView3.setSelected(true);
				break;

			default:
				break;
			}
			viewPager.setCurrentItem(index);
		}
	}

	/**
	 * 初始化动画，这个就是页卡滑动时，下面的横线也滑动的效果，在这里需要计算一些数据
	 */

	public class MyOnPageChangeListener implements OnPageChangeListener {

		public void onPageScrollStateChanged(int arg0) {

		}

		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		public void onPageSelected(int arg0) {

			currIndex = arg0;
			switch (arg0) {
			case 0:
				textView1.setSelected(true);
				textView2.setSelected(false);
				textView3.setSelected(false);

				break;
			case 1:
				textView1.setSelected(false);
				textView2.setSelected(true);
				textView3.setSelected(false);
				break;
			case 2:
				textView1.setSelected(false);
				textView2.setSelected(false);
				textView3.setSelected(true);
				break;

			default:
				break;
			}
		}
	}

	private class MyViewPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {

			return viewList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {

			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(viewList.get(position));

		}

		@Override
		public int getItemPosition(Object object) {

			return super.getItemPosition(object);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(viewList.get(position));

			return viewList.get(position);
		}
	}
}

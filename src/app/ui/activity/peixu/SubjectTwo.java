package app.ui.activity.peixu;

import java.util.ArrayList;
import java.util.List;

import mobi.kuaidian.qunakao.R;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
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
import app.bean.GJItemBean;
import app.ui.BaseActivity;
import app.ui.adapter.GJListAdapter;
import app.util.TypeIntent;

public class SubjectTwo extends BaseActivity implements OnClickListener {
	private TextView textView1, textView2, textView3;
	private TextView textView3d1, textView3d2, textView3d3,textView3d4,textView3d5;
	private View view1, view2, view3;// 需要滑动的页卡
	private ListView listView1, listView2;// 需要滑动的页卡
	private ViewPager viewPager;// viewpager
	private List<View> viewList;// 把需要滑动的页卡添加到这个list中
	private ImageView belowSlideImg, qxxs, dcrk, cftc, pddd, zjgw;
	private int offset = 0;// 动画图片偏移量
	private int currIndex = 0;// 当前页卡编号
	private int bmpW;// 动画图片宽度
	private Intent intent;
	private ImageView zkimage;
	private boolean iszk = false;
	private List<GJItemBean> beans;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subject_two);
		initTextView();
		initView();

	}

	private void initView() {
		int flag = getIntent().getIntExtra("TAG", 0);
		LayoutInflater lf = getLayoutInflater().from(this);
		view1 = lf.inflate(R.layout.view_xlc, null);
		view2 = lf.inflate(R.layout.view_xlgj, null);
		view3 = lf.inflate(R.layout.view_spjx, null);
		viewList = new ArrayList<View>();
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		TextView textView = (TextView) findViewById(R.id.title_title);
		TextView textView1 = (TextView) view1.findViewById(R.id.km_num_tv);
		TextView textView2 = (TextView) view1.findViewById(R.id.xlc_km_ttt);
		switch (flag) {
		case 1:
			textView.setText("");
			break;
		case 2:
			initData();
			textView.setText("科目二训练场");
			break;
		case 3:
			initData();
			textView.setText("科目三训练场");
			textView1.setText("培训内容：科目三");
			textView2.setText("科目三教学视频");
			break;
		case 4:
			textView.setText("");
			break;

		default:
			break;
		}
		
		
		zkimage = (ImageView) view1.findViewById(R.id.km2_zk_button);
		
		(view1.findViewById(R.id.km2_3d_tv1)).setOnClickListener(this);
		(view1.findViewById(R.id.km2_3d_tv2)).setOnClickListener(this);
		(view1.findViewById(R.id.km2_3d_tv3)).setOnClickListener(this);
		(view1.findViewById(R.id.km2_3d_tv4)).setOnClickListener(this);
		(view1.findViewById(R.id.km2_3d_tv5)).setOnClickListener(this);
		(view1.findViewById(R.id.km2_xlc_sp_01)).setOnClickListener(this);
		(view1.findViewById(R.id.km2_xlc_sp_02)).setOnClickListener(this);
		(view1.findViewById(R.id.km2_xlc_sp_03)).setOnClickListener(this);
		(view1.findViewById(R.id.km2_xlc_sp_04)).setOnClickListener(this);
		(view3.findViewById(R.id.km2_xlc_sp_01)).setOnClickListener(this);
		(view3.findViewById(R.id.km2_xlc_sp_02)).setOnClickListener(this);
		(view3.findViewById(R.id.km2_xlc_sp_03)).setOnClickListener(this);
		(view3.findViewById(R.id.km2_xlc_sp_04)).setOnClickListener(this);
		(view3.findViewById(R.id.km2_xlc_sp_05)).setOnClickListener(this);
		
		
		ListView listView = (ListView) view2.findViewById(R.id.xlgj_listview);
		listView.setAdapter(new GJListAdapter(this, beans));
		
		zkimage.setOnClickListener(this);
		findViewById(R.id.title_back_button).setOnClickListener(this);
		
		viewPager = (ViewPager) findViewById(R.id.report_submit_viewpager);

		viewPager.setAdapter(new MyViewPagerAdapter());
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}

	private void initData() {
		// TODO Auto-generated method stub
		beans = new ArrayList<GJItemBean>();
		GJItemBean bean1 = new GJItemBean(R.drawable.xlgj_qxxs,"曲线行驶","20150617 09:10:07");
		GJItemBean bean2 = new GJItemBean(R.drawable.xlgj_dcrk,"倒车入库","20150617 10:21:12");
		GJItemBean bean3 = new GJItemBean(R.drawable.xlgj_pddd,"坡道定点","20150617 10:42:00");
		GJItemBean bean4 = new GJItemBean(R.drawable.xlgj_cfdt,"侧方停车","20150617 14:11:46");
		GJItemBean bean5 = new GJItemBean(R.drawable.xlgj_zjzw,"直角转弯","20150617 15:23:02");
		beans.add(bean1);
		beans.add(bean2);
		beans.add(bean3);
		beans.add(bean4);
		beans.add(bean5);
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
	String uri;
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.km2_3d_tv1:
			intent = new Intent(this, AbbrActivity.class);
			intent.putExtra("TAG", 0);
			startActivity(intent);
			break;
		case R.id.km2_3d_tv2:
			intent = new Intent(this, AbbrActivity.class);
			intent.putExtra("TAG", 1);
			startActivity(intent);
			break;
		case R.id.km2_3d_tv3:
			
			intent = new Intent(this, AbbrActivity.class);
			intent.putExtra("TAG", 2);
			startActivity(intent);
			break;
		case R.id.km2_3d_tv4:
			intent = new Intent(this, AbbrActivity.class);
			intent.putExtra("TAG", 3);
			startActivity(intent);
			break;
		case R.id.km2_3d_tv5:
			intent = new Intent(this, AbbrActivity.class);
			intent.putExtra("TAG", 4);
			startActivity(intent);
			break;
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
		case R.id.km2_zk_button:
			if(!iszk){
				iszk = true;
				zkimage.setBackgroundResource(R.drawable.km2_ll_bh);
				view1.findViewById(R.id.km2_ll_llzk).setVisibility(View.VISIBLE);
				
			}else{
				iszk = false;
				zkimage.setBackgroundResource(R.drawable.km2_ll_zk);
				view1.findViewById(R.id.km2_ll_llzk).setVisibility(View.GONE);
			}
			
			break;

		case R.id.km2_xlc_sp_01:
			uri = "android.resource://" + getPackageName() + "/" + R.raw.a10002;
			intent = new Intent(this, ViedoAcitivity.class);
			intent.putExtra("URI", uri);
			intent.putExtra("TAG", 0);
			startActivity(intent);
			break;
		case R.id.km2_xlc_sp_02:
			uri = "android.resource://" + getPackageName() + "/" + R.raw.a10001;
			intent = new Intent(this, ViedoAcitivity.class);
			intent.putExtra("URI", uri);
			intent.putExtra("TAG", 1);
			startActivity(intent);
			
			break;
		case R.id.km2_xlc_sp_03:
			uri = "android.resource://" + getPackageName() + "/" + R.raw.a10004;
			intent = new Intent(this, ViedoAcitivity.class);
			intent.putExtra("URI", uri);
			intent.putExtra("TAG", 2);
			startActivity(intent);
			
			break;
		case R.id.km2_xlc_sp_04:
			uri = "android.resource://" + getPackageName() + "/" + R.raw.a10004;
			intent = new Intent(this, ViedoAcitivity.class);
			intent.putExtra("URI", uri);
			intent.putExtra("TAG", 3);
			startActivity(intent);
			
			break;
		case R.id.km2_xlc_sp_05:
			uri = "android.resource://" + getPackageName() + "/" + R.raw.a10003;
			intent = new Intent(this, ViedoAcitivity.class);
			intent.putExtra("URI", uri);
			intent.putExtra("TAG", 4);
			startActivity(intent);
			
			break;
		default:
			break;
		}
	}

	void openVideo(Uri uri){
		
		//调用系统自带的播放器
		Intent intent = new Intent(Intent.ACTION_VIEW);
		Log.v("URI:::::::::", uri.toString());
		intent.setDataAndType(uri, "video/mp4");
		startActivity(intent);
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

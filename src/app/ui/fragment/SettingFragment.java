package app.ui.fragment;

import mobi.kuaidian.qunakao.R;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import app.ui.BaseFragment;
import app.ui.activity.setting.AboutActivity;

public class SettingFragment extends BaseFragment implements OnClickListener {


	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.layout_about:
			startActivity(new Intent(getActivity(), AboutActivity.class));
			break;

		default:
			break;
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_setting, container, false);
	}


	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
//		view.findViewById(R.id.layout_about).setOnClickListener(this);
		
		setupViews(view);
	}
	
	
	  private void setupViews(View view) {

	        final StringBuffer buffer = new StringBuffer(getString(R.string.app_name));
	        PackageManager packageManager = getActivity().getPackageManager();
	        try {
	            PackageInfo packageInfo = packageManager.getPackageInfo(getActivity().getPackageName(), 0);
	            buffer.append(" V");
	            buffer.append(packageInfo.versionName);
	        } catch (NameNotFoundException e) {
	            e.printStackTrace();
	        }

	        final TextView appNameTextView = (TextView) view.findViewById(R.id.text_app_name);
	        appNameTextView.setText(buffer.toString());
	    }


}
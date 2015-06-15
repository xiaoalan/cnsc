package app.ui.fragment;

import mobi.kuaidian.qunakao.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import app.ui.BaseFragment;
import app.ui.activity.peixu.SubjectOne;
import app.ui.activity.peixu.SubjectTwo;

public class SessionFragment extends BaseFragment implements OnClickListener {

	private Intent intent;
	private ImageView xc,hc,gjc,mtc;
	private TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_session, container, false);
    }
    /* (non-Javadoc)
     * @see app.ui.BaseFragment#onViewCreated(android.view.View, android.os.Bundle)
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }
	private void initView(View view) {
		view.findViewById(R.id.px_gjc).setOnClickListener(this);
		view.findViewById(R.id.px_hc).setOnClickListener(this);
		view.findViewById(R.id.px_mtc).setOnClickListener(this);
		view.findViewById(R.id.px_xc).setOnClickListener(this);
		view.findViewById(R.id.kemu1).setOnClickListener(this);
		view.findViewById(R.id.kemu2).setOnClickListener(this);
		view.findViewById(R.id.kemu3).setOnClickListener(this);
		view.findViewById(R.id.kemu4).setOnClickListener(this);
		textView = (TextView) view.findViewById(R.id.px_tv);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.px_gjc:
			textView.setText("您学习类型是：公交车");
			break;
		case R.id.px_hc:
			textView.setText("您学习类型是：货车");
			break;
		case R.id.px_mtc:
			textView.setText("您学习类型是：摩托车");
			break;
		case R.id.px_xc:
			textView.setText("您学习类型是：小车");
			break;
		case R.id.kemu1:
			intent = new Intent(getActivity(), SubjectOne.class);
			intent.putExtra("TAG", 1);
			startActivity(intent);
			break;
		case R.id.kemu2:
			intent = new Intent(getActivity(), SubjectTwo.class);
			startActivity(intent);
			break;
		case R.id.kemu3:
			textView.setText("您学习类型是：小车");
			break;
		case R.id.kemu4:
			intent = new Intent(getActivity(), SubjectOne.class);
			intent.putExtra("TAG", 4);
			startActivity(intent);
			break;
		

		default:
			break;
		}
	}

}

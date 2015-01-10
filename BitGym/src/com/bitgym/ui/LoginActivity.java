package com.bitgym.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.bitgym.R;

public class LoginActivity extends BaseActivity implements OnClickListener {

	private EditText edtUsername;

	private EditText edtPasswd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		setContentView(R.layout.activity_login);


		findViewById(R.id.rootLayout).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
//				hideSoftKeyboard();
			}
		});

		edtUsername = (EditText) findViewById(R.id.edtUserName);
		edtPasswd = (EditText) findViewById(R.id.edtPassword);
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	public void login() {
	}

	private void gotoApp() {
		startActivity(new Intent(this, MainActivity.class));
		finish();
	}

	@Override
	public void onClick(View v) {
	}
}

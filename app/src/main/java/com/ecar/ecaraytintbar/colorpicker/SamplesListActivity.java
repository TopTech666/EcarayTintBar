/*
 * Copyright (C) 2013 readyState Software Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ecar.ecaraytintbar.colorpicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.readystatesoftware.systembartint.sample.R;

public class SamplesListActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				   startActivity(new Intent(SamplesListActivity.this,DefaultActivity.class));
				overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
			}
		});
		findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(SamplesListActivity.this,MatchActionBarActivity.class));
				overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);

			}
		});
		findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(SamplesListActivity.this,ColorActivity.class));
				overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);

			}
		});
	}


}

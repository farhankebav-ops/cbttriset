package com.cbt.exam.browser.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.cbt.exam.browser.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mimikridev.ads.banner.BannerAd;
import com.mimikridev.utilmanager.config.Statistik;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ActivityConfigConfirm extends BaseActivity {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f5077s = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MaterialRippleLayout f5078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f5079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f5080d;
    public TextView e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f5081f;
    public TextView g;
    public ImageView h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f5082i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView f5083n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f5084o;
    public ImageView p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CardView f5085q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public JSONObject f5086r;

    @Override // com.cbt.exam.browser.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_config_confirm);
        getWindow().addFlags(128);
        Statistik.sendData(this, "cbtexambrowser");
        this.f5124a.d();
        getOnBackPressedDispatcher().addCallback(this, new j(this, 1));
        this.f5079c = (TextView) findViewById(R.id.txt_nama_sekolah);
        this.f5080d = (TextView) findViewById(R.id.txt_nama_ujian);
        this.e = (TextView) findViewById(R.id.txt_url_ujian);
        this.f5081f = (TextView) findViewById(R.id.txt_message);
        this.g = (TextView) findViewById(R.id.txt_timer);
        this.h = (ImageView) findViewById(R.id.logo);
        this.f5082i = (ImageView) findViewById(R.id.img_customua);
        this.j = (ImageView) findViewById(R.id.img_timer);
        this.k = (ImageView) findViewById(R.id.img_tokenmasuk);
        this.l = (ImageView) findViewById(R.id.img_tokenkeluar);
        this.m = (ImageView) findViewById(R.id.img_linkkeluar);
        this.f5083n = (ImageView) findViewById(R.id.img_copypaste);
        this.f5084o = (ImageView) findViewById(R.id.img_screenshoot);
        this.p = (ImageView) findViewById(R.id.img_clearcache);
        this.f5085q = (CardView) findViewById(R.id.cd_msg);
        this.f5078b = (MaterialRippleLayout) findViewById(R.id.btn_enter);
        String stringExtra = getIntent().getStringExtra("config_json");
        if (stringExtra != null) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                this.f5086r = jSONObject;
                r(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(this, getString(R.string.txt_cbtfile_error_decrypt), 0).show();
                finish();
            }
        } else {
            Toast.makeText(this, getString(R.string.txt_cbtfile_error_decrypt), 0).show();
            finish();
        }
        this.f5078b.setOnClickListener(new o(this, 0));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        j0.a aVar;
        BannerAd bannerAd;
        super.onDestroy();
        if (!isFinishing() || (aVar = this.f5124a) == null || (bannerAd = aVar.f12051f) == null) {
            return;
        }
        bannerAd.destroyAndDetachBanner();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        Statistik.getData(this);
        j0.a aVar = this.f5124a;
        if (aVar != null) {
            aVar.h(this);
            this.f5124a.f();
        }
    }

    public final void q() {
        this.f5086r.optBoolean("token_masuk_status", false);
        String strOptString = this.f5086r.optString("token_masuk", "");
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.dg_token);
        dialog.setCancelable(true);
        Window window = dialog.getWindow();
        Objects.requireNonNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = -2;
        layoutParams.height = -2;
        dialog.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog, 2));
        TextView textView = (TextView) dialog.findViewById(R.id.txt_judul);
        TextView textView2 = (TextView) dialog.findViewById(R.id.txt_msg);
        TextInputEditText textInputEditText = (TextInputEditText) dialog.findViewById(R.id.input_token);
        TextInputLayout textInputLayout = (TextInputLayout) dialog.findViewById(R.id.lyt_input_token);
        textView.setText(getString(R.string.txt_token_judul_out));
        textView2.setText(getString(R.string.txt_token_msg));
        dialog.findViewById(R.id.bt_open).setOnClickListener(new p(this, textInputEditText, textInputLayout, strOptString, dialog, 0));
        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }

    public final void r(JSONObject jSONObject) {
        int i2;
        String strOptString = jSONObject.optString("nama_sekolah", "");
        String strOptString2 = jSONObject.optString("nama_ujian", "");
        String strOptString3 = jSONObject.optString("url", "");
        String strOptString4 = jSONObject.optString("logo", "");
        boolean zOptBoolean = jSONObject.optBoolean("custom_ua_status", false);
        jSONObject.optString("custom_ua", "");
        boolean zOptBoolean2 = jSONObject.optBoolean("timer_status", false);
        int iOptInt = jSONObject.optInt("timer", 0);
        boolean zOptBoolean3 = jSONObject.optBoolean("msg_status", false);
        String strOptString5 = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, "");
        boolean zOptBoolean4 = jSONObject.optBoolean("token_masuk_status", false);
        jSONObject.optString("token_masuk", "");
        boolean zOptBoolean5 = jSONObject.optBoolean("token_keluar_status", false);
        jSONObject.optString("token_keluar", "");
        boolean zOptBoolean6 = jSONObject.optBoolean("link_keluar_status", false);
        jSONObject.optString("link_keluar", "");
        boolean zOptBoolean7 = jSONObject.optBoolean("allow_copy_paste", false);
        boolean zOptBoolean8 = jSONObject.optBoolean("allow_screenshoot", false);
        boolean zOptBoolean9 = jSONObject.optBoolean("clear_cache", false);
        if (strOptString4.isEmpty()) {
            Glide.with((FragmentActivity) this).load(Integer.valueOf(R.drawable.icon)).into(this.h);
        } else {
            Glide.with((FragmentActivity) this).load(strOptString4).placeholder(R.drawable.icon).error(R.drawable.icon).into(this.h);
        }
        this.f5079c.setText(strOptString.isEmpty() ? getString(R.string.app_name) : strOptString);
        this.e.setText(strOptString3);
        if (strOptString2.isEmpty()) {
            i2 = 0;
            this.f5080d.setVisibility(8);
        } else {
            i2 = 0;
            this.f5080d.setVisibility(0);
            this.f5080d.setText(strOptString2);
        }
        if (!zOptBoolean2 || iOptInt <= 0) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(i2);
            this.g.setText(iOptInt + " " + getString(R.string.txt_scanqr_menit));
        }
        if (!zOptBoolean3 || strOptString5.isEmpty()) {
            this.f5085q.setVisibility(8);
        } else {
            this.f5085q.setVisibility(0);
            this.f5081f.setText(strOptString5);
        }
        ImageView imageView = this.f5082i;
        int i8 = R.drawable.ic_close;
        imageView.setImageResource(zOptBoolean ? R.drawable.ic_check : R.drawable.ic_close);
        this.j.setImageResource(zOptBoolean2 ? R.drawable.ic_check : R.drawable.ic_close);
        this.k.setImageResource(zOptBoolean4 ? R.drawable.ic_check : R.drawable.ic_close);
        this.l.setImageResource(zOptBoolean5 ? R.drawable.ic_check : R.drawable.ic_close);
        this.m.setImageResource(zOptBoolean6 ? R.drawable.ic_check : R.drawable.ic_close);
        this.f5083n.setImageResource(zOptBoolean7 ? R.drawable.ic_check : R.drawable.ic_close);
        this.f5084o.setImageResource(zOptBoolean8 ? R.drawable.ic_check : R.drawable.ic_close);
        ImageView imageView2 = this.p;
        if (zOptBoolean9) {
            i8 = R.drawable.ic_check;
        }
        imageView2.setImageResource(i8);
    }

    public final void s() {
        Intent intent = new Intent(this, (Class<?>) ActivityCbtBrowser.class);
        intent.putExtra("config_json", this.f5086r.toString());
        startActivity(intent);
        Statistik.getData(this);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }
}

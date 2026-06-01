package com.cbt.exam.browser.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.cbt.exam.browser.R;
import com.mimikridev.utilmanager.config.Statistik;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ActivityGenerateConfig extends BaseActivity {
    public static final /* synthetic */ int y = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MaterialRippleLayout f5103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f5104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f5105d;
    public TextView e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f5106f;
    public TextView g;
    public TextView h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f5107i;
    public TextView j;
    public TextView k;
    public ImageView l;
    public ImageView m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView f5108n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f5109o;
    public ImageView p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f5110q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f5111r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f5112s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ImageView f5113t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ActivityResultLauncher f5114u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f5115v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f5116w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CardView f5117x;

    @Override // com.cbt.exam.browser.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_generate_config);
        getWindow().addFlags(128);
        Statistik.sendData(this, "cbtexambrowser");
        this.f5124a.d();
        getOnBackPressedDispatcher().addCallback(this, new j(this, 3));
        this.f5114u = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new androidx.camera.core.impl.b(this, 9));
        Intent intent = getIntent();
        this.f5104c = (TextView) findViewById(R.id.txt_nama_sekolah);
        this.f5105d = (TextView) findViewById(R.id.txt_nama_ujian);
        this.e = (TextView) findViewById(R.id.txt_url_ujian);
        this.f5106f = (TextView) findViewById(R.id.txt_message);
        this.g = (TextView) findViewById(R.id.txt_customua);
        this.h = (TextView) findViewById(R.id.txt_timer);
        this.f5107i = (TextView) findViewById(R.id.txt_token_masuk);
        this.j = (TextView) findViewById(R.id.txt_token_keluar);
        this.k = (TextView) findViewById(R.id.txt_link_keluar);
        this.l = (ImageView) findViewById(R.id.logo);
        this.m = (ImageView) findViewById(R.id.img_customua);
        this.f5108n = (ImageView) findViewById(R.id.img_timer);
        this.f5109o = (ImageView) findViewById(R.id.img_tokenmasuk);
        this.p = (ImageView) findViewById(R.id.img_tokenkeluar);
        this.f5110q = (ImageView) findViewById(R.id.img_linkkeluar);
        this.f5111r = (ImageView) findViewById(R.id.img_copypaste);
        this.f5112s = (ImageView) findViewById(R.id.img_screenshoot);
        this.f5113t = (ImageView) findViewById(R.id.img_clearcache);
        this.f5117x = (CardView) findViewById(R.id.cd_msg);
        String stringExtra = intent.getStringExtra("nama_sekolah");
        if (stringExtra == null || stringExtra.isEmpty()) {
            this.f5104c.setText(getString(R.string.app_name));
        } else {
            this.f5104c.setText(intent.getStringExtra("nama_sekolah"));
        }
        String stringExtra2 = intent.getStringExtra("nama_ujian");
        if (stringExtra2 != null && !stringExtra2.isEmpty()) {
            this.f5105d.setVisibility(0);
            this.f5105d.setText(stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("url");
        if (stringExtra3 != null && !stringExtra3.isEmpty()) {
            this.e.setVisibility(0);
            this.e.setText(stringExtra3);
        }
        String stringExtra4 = intent.getStringExtra("message_text");
        if (stringExtra4 != null && !stringExtra4.isEmpty()) {
            this.f5117x.setVisibility(0);
            this.f5106f.setText(stringExtra4);
        }
        String stringExtra5 = intent.getStringExtra("customUA_text");
        if (stringExtra5 != null && !stringExtra5.isEmpty()) {
            this.g.setVisibility(0);
            this.g.setText(stringExtra5);
        }
        String stringExtra6 = intent.getStringExtra("timer_value");
        if (stringExtra6 != null && !stringExtra6.isEmpty()) {
            this.h.setVisibility(0);
            this.h.setText(stringExtra6);
        }
        String stringExtra7 = intent.getStringExtra("tokenMasuk_text");
        if (stringExtra7 != null && !stringExtra7.isEmpty()) {
            this.f5107i.setVisibility(0);
            this.f5107i.setText(stringExtra7);
        }
        String stringExtra8 = intent.getStringExtra("tokenKeluar_text");
        if (stringExtra8 != null && !stringExtra8.isEmpty()) {
            this.j.setVisibility(0);
            this.j.setText(stringExtra8);
        }
        String stringExtra9 = intent.getStringExtra("linkKeluar_text");
        if (stringExtra9 != null && !stringExtra9.isEmpty()) {
            this.k.setVisibility(0);
            this.k.setText(stringExtra9);
        }
        Statistik.getData(this);
        this.f5103b = (MaterialRippleLayout) findViewById(R.id.btn_generate_config);
        boolean booleanExtra = intent.getBooleanExtra("customUA_on", false);
        boolean booleanExtra2 = intent.getBooleanExtra("timer_on", false);
        boolean booleanExtra3 = intent.getBooleanExtra("tokenMasuk_on", false);
        boolean booleanExtra4 = intent.getBooleanExtra("tokenKeluar_on", false);
        boolean booleanExtra5 = intent.getBooleanExtra("linkKeluar_on", false);
        boolean booleanExtra6 = intent.getBooleanExtra("copyPaste_on", false);
        boolean booleanExtra7 = intent.getBooleanExtra("screenshoot_on", false);
        boolean booleanExtra8 = intent.getBooleanExtra("clearCache_on", false);
        String stringExtra10 = intent.getStringExtra("logo");
        if (stringExtra10.isEmpty()) {
            Glide.with((FragmentActivity) this).load(Integer.valueOf(R.drawable.icon)).into(this.l);
        } else {
            Glide.with((FragmentActivity) this).load(stringExtra10).placeholder(R.drawable.icon).error(R.drawable.icon).into(this.l);
        }
        ImageView imageView = this.m;
        int i2 = R.drawable.ic_close;
        imageView.setImageResource(booleanExtra ? R.drawable.ic_check : R.drawable.ic_close);
        this.f5108n.setImageResource(booleanExtra2 ? R.drawable.ic_check : R.drawable.ic_close);
        this.f5109o.setImageResource(booleanExtra3 ? R.drawable.ic_check : R.drawable.ic_close);
        this.p.setImageResource(booleanExtra4 ? R.drawable.ic_check : R.drawable.ic_close);
        this.f5110q.setImageResource(booleanExtra5 ? R.drawable.ic_check : R.drawable.ic_close);
        this.f5111r.setImageResource(booleanExtra6 ? R.drawable.ic_check : R.drawable.ic_close);
        this.f5112s.setImageResource(booleanExtra7 ? R.drawable.ic_check : R.drawable.ic_close);
        ImageView imageView2 = this.f5113t;
        if (booleanExtra8) {
            i2 = R.drawable.ic_check;
        }
        imageView2.setImageResource(i2);
        this.f5103b.setOnClickListener(new f(this, intent, 1));
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.ironsource.C2300e4;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcta extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final Context zza;
    private View zzb;

    private zzcta(Context context) {
        super(context);
        this.zza = context;
    }

    public static zzcta zza(Context context, View view, zzffu zzffuVar) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzcta zzctaVar = new zzcta(context);
        List list = zzffuVar.zzu;
        if (!list.isEmpty() && (resources = zzctaVar.zza.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            float f4 = ((zzffv) list.get(0)).zza;
            float f8 = displayMetrics.density;
            zzctaVar.setLayoutParams(new FrameLayout.LayoutParams((int) (f4 * f8), (int) (r4.zzb * f8)));
        }
        zzctaVar.zzb = view;
        zzctaVar.addView(view);
        com.google.android.gms.ads.internal.zzt.zzC();
        zzcci.zzb(zzctaVar, zzctaVar);
        com.google.android.gms.ads.internal.zzt.zzC();
        zzcci.zza(zzctaVar, zzctaVar);
        JSONObject jSONObject = zzffuVar.zzah;
        RelativeLayout relativeLayout = new RelativeLayout(zzctaVar.zza);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("header");
        if (jSONObjectOptJSONObject != null) {
            zzctaVar.zzb(jSONObjectOptJSONObject, relativeLayout, 10);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("footer");
        if (jSONObjectOptJSONObject2 != null) {
            zzctaVar.zzb(jSONObjectOptJSONObject2, relativeLayout, 12);
        }
        zzctaVar.addView(relativeLayout);
        return zzctaVar;
    }

    private final void zzb(JSONObject jSONObject, RelativeLayout relativeLayout, int i2) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setGravity(17);
        textView.setText(jSONObject.optString(C2300e4.h.K0, ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int iZzc = zzc(jSONObject.optDouble("padding", 0.0d));
        textView.setPadding(0, iZzc, 0, iZzc);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzc(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i2);
        relativeLayout.addView(textView, layoutParams);
    }

    private final int zzc(double d8) {
        com.google.android.gms.ads.internal.client.zzbb.zza();
        return com.google.android.gms.ads.internal.util.client.zzf.zzC(this.zza, (int) d8);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        getLocationInWindow(new int[2]);
        this.zzb.setY(-r0[1]);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        getLocationInWindow(new int[2]);
        this.zzb.setY(-r0[1]);
    }
}

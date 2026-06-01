package com.bytedance.sdk.openadsdk.component.reward.view;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.webkit.internal.b;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.widget.ea;
import com.bytedance.sdk.openadsdk.core.widget.zPa;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends com.bytedance.sdk.openadsdk.core.Cc.Cc {
    private boolean Cc;
    private zPa EO;
    private ea IlO;
    private TextView MY;
    private TextView tV;
    private com.bytedance.sdk.openadsdk.component.reward.IlO.IlO vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements com.bytedance.sdk.component.Cc.zPa {
        private final String EO;
        private final oeT IlO;
        private final String MY;
        private final WeakReference<ImageView> tV;

        public IlO(ImageView imageView, oeT oet, String str, String str2) {
            this.tV = new WeakReference<>(imageView);
            this.IlO = oet;
            this.MY = str;
            this.EO = str2;
        }

        @Override // com.bytedance.sdk.component.Cc.zPa
        public void IlO(com.bytedance.sdk.component.Cc.EV ev) {
            Object objMY = ev.MY();
            if (objMY != null) {
                ImageView imageView = this.tV.get();
                if (objMY instanceof Bitmap) {
                    if (imageView != null) {
                        imageView.setImageBitmap((Bitmap) objMY);
                    }
                } else if (objMY instanceof Drawable) {
                    if (Build.VERSION.SDK_INT >= 28 && b.y(objMY)) {
                        b.h(objMY).start();
                    }
                    if (imageView != null) {
                        imageView.setImageDrawable((Drawable) objMY);
                    }
                }
                com.bytedance.sdk.openadsdk.tV.EO.MY(this.IlO, this.EO, "load_vast_icon_success", (JSONObject) null);
            }
        }

        @Override // com.bytedance.sdk.component.Cc.zPa
        public void IlO(int i2, String str, @Nullable Throwable th) {
            IlO(i2, str, this.MY);
        }

        private void IlO(final int i2, final String str, final String str2) {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(new com.bytedance.sdk.component.lEW.lEW("load_vast_icon_fail") { // from class: com.bytedance.sdk.openadsdk.component.reward.view.EO.IlO.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("error_code", i2);
                        jSONObject.put("description", i2 + ":" + str);
                        jSONObject.put("url", str2);
                    } catch (Throwable unused) {
                    }
                    com.bytedance.sdk.openadsdk.tV.EO.MY(IlO.this.IlO, IlO.this.EO, "load_vast_icon_fail", jSONObject);
                }
            });
        }
    }

    public EO(@NonNull Context context) {
        super(context);
        setOrientation(1);
        setVisibility(8);
        setBackgroundColor(-1);
    }

    private void Cc() {
        Context context = getContext();
        setPadding(BS.MY(context, 16.0f), BS.MY(context, 16.0f), BS.MY(context, 16.0f), BS.MY(context, 24.0f));
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setOrientation(0);
        cc.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = BS.MY(context, 12.0f);
        addView(cc, layoutParams);
        zPa zpa = new zPa(context);
        this.EO = zpa;
        zpa.setBackgroundColor(0);
        this.EO.setId(com.bytedance.sdk.openadsdk.utils.zPa.MY);
        cc.addView(this.EO, new LinearLayout.LayoutParams(BS.MY(context, 48.0f), BS.MY(context, 48.0f)));
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc2 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = BS.MY(context, 12.0f);
        cc.addView(cc2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.tV = lew;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        lew.setEllipsize(truncateAt);
        this.tV.setGravity(16);
        this.tV.setSingleLine(true);
        this.tV.setTextSize(2, 17.0f);
        this.tV.setId(com.bytedance.sdk.openadsdk.utils.zPa.EO);
        this.tV.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        cc2.addView(this.tV, new LinearLayout.LayoutParams(-1, -2));
        ea eaVar = new ea(context);
        this.IlO = eaVar;
        eaVar.setId(com.bytedance.sdk.openadsdk.utils.zPa.Cc);
        cc2.addView(this.IlO, new LinearLayout.LayoutParams(-2, BS.MY(context, 14.0f)));
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew2 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.MY = lew2;
        lew2.setGravity(17);
        this.MY.setEllipsize(truncateAt);
        this.MY.setSingleLine(true);
        this.MY.setTextColor(-1);
        this.MY.setTextSize(2, 16.0f);
        this.MY.setId(520093705);
        this.MY.setBackground(IlO(context));
        this.MY.setText(this.vCE.MY.aa());
        addView(this.MY, new LinearLayout.LayoutParams(-1, BS.MY(context, 36.0f)));
    }

    private void EO() {
        this.Cc = true;
        if (this.vCE.fdM == 1) {
            Cc();
        } else {
            tV();
        }
        if (this.MY == null) {
            this.MY = (TextView) this.vCE.zLG.findViewById(520093705);
        }
        oeT oet = this.vCE.MY;
        TextView textView = this.MY;
        if (textView != null) {
            textView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.EO.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
                    int width = ((ViewGroup) EO.this.MY.getParent()).getWidth();
                    if (width > 0) {
                        EO.this.MY.setMaxWidth((int) (width * 0.45f));
                    }
                }
            });
            if (!oet.xJ()) {
                this.MY.setText(oet.zLG() == 3 ? getButtonTextForNewStyleBar() : oet.aa());
            } else if (oet.QfH() != null && TextUtils.isEmpty(oet.QfH().vCE())) {
                BS.IlO((View) this.MY, 8);
            }
        }
        if (this.EO != null && oet.HTA() != null && !TextUtils.isEmpty(oet.HTA().IlO())) {
            String strIlO = oet.HTA().IlO();
            if (oet.xJ()) {
                com.bytedance.sdk.openadsdk.DmF.tV.IlO(oet.HTA()).EO(1).IlO(new com.bytedance.sdk.openadsdk.DmF.MY(oet, oet.HTA().IlO(), new IlO(this.EO, oet, strIlO, this.vCE.Cc)));
                if (oet.QfH() != null && oet.QfH().MY() != null) {
                    oet.QfH().MY().MY(0L);
                }
            } else {
                com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO(oet.HTA(), this.EO, oet);
            }
        }
        TextView textView2 = this.tV;
        if (textView2 != null) {
            textView2.setText(oet.dm());
        }
        ea eaVar = this.IlO;
        if (eaVar != null) {
            BS.IlO((TextView) null, eaVar, oet);
        }
        if (this.vCE.fdM == 2 && oet.zLG() == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.MY.getLayoutParams();
            layoutParams.height = BS.MY(this.vCE.gQ, 55.0f);
            layoutParams.topMargin = BS.MY(this.vCE.gQ, 20.0f);
            this.MY.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams2.bottomMargin = BS.MY(this.vCE.gQ, 12.0f);
            setLayoutParams(layoutParams2);
        }
        MY();
    }

    private String getCnOrEnBtnText() {
        return this.vCE.MY.Jz() != 4 ? "View" : "Install";
    }

    private void tV() {
        setOrientation(0);
        setGravity(16);
        Context context = getContext();
        setPadding(BS.MY(context, 16.0f), BS.MY(context, 12.0f), BS.MY(context, 16.0f), BS.MY(context, 12.0f));
        zPa zpa = new zPa(context);
        this.EO = zpa;
        zpa.setBackgroundColor(0);
        this.EO.setId(com.bytedance.sdk.openadsdk.utils.zPa.MY);
        addView(this.EO, new LinearLayout.LayoutParams(BS.MY(context, 48.0f), BS.MY(context, 48.0f)));
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.leftMargin = BS.MY(context, 12.0f);
        layoutParams.weight = 1.0f;
        addView(cc, layoutParams);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.tV = lew;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        lew.setEllipsize(truncateAt);
        this.tV.setGravity(16);
        this.tV.setSingleLine(true);
        this.tV.setTextSize(2, 17.0f);
        this.tV.setId(com.bytedance.sdk.openadsdk.utils.zPa.EO);
        this.tV.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        cc.addView(this.tV, new LinearLayout.LayoutParams(-1, -2));
        ea eaVar = new ea(context);
        this.IlO = eaVar;
        eaVar.setId(com.bytedance.sdk.openadsdk.utils.zPa.Cc);
        cc.addView(this.IlO, new LinearLayout.LayoutParams(-2, BS.MY(context, 14.0f)));
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew2 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.MY = lew2;
        lew2.setGravity(17);
        this.MY.setEllipsize(truncateAt);
        this.MY.setSingleLine(true);
        this.MY.setTextColor(-1);
        this.MY.setTextSize(2, 16.0f);
        this.MY.setId(520093705);
        this.MY.setBackground(IlO(context));
        this.MY.setText(this.vCE.MY.aa());
        addView(this.MY, new LinearLayout.LayoutParams(BS.MY(context, 164.0f), BS.MY(context, 36.0f)));
    }

    public String getButtonTextForNewStyleBar() {
        boolean zEquals;
        String strAa;
        String strBc = zLG.Bc(this.vCE.gQ);
        if (strBc == null) {
            strBc = "";
        }
        try {
            zEquals = strBc.equals(Locale.ENGLISH.getLanguage());
        } catch (Throwable unused) {
            zEquals = false;
        }
        if (TextUtils.isEmpty(this.vCE.MY.aa())) {
            strAa = this.vCE.MY.Jz() != 4 ? "View" : "Install";
        } else {
            strAa = this.vCE.MY.aa();
            if (strAa == null || !zLG.vCE(strAa) || strAa.length() <= 2) {
                if (strAa != null && !zLG.vCE(strAa) && strAa.length() > 7 && zEquals) {
                    strAa = getCnOrEnBtnText();
                }
            } else if (zEquals) {
                strAa = getCnOrEnBtnText();
            }
        }
        if (zEquals && !zLG.vCE(strAa)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.MY.getLayoutParams();
            layoutParams.bottomMargin = BS.MY(this.vCE.gQ, 4.0f);
            this.MY.setLayoutParams(layoutParams);
        }
        return strAa;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 != 0 || this.Cc) {
            return;
        }
        EO();
    }

    public void IlO() {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
        Keyframe keyframeOfFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
        Keyframe keyframeOfFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("scaleX", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6), PropertyValuesHolder.ofKeyframe("scaleY", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6));
        objectAnimatorOfPropertyValuesHolder.setDuration(1000L);
        objectAnimatorOfPropertyValuesHolder.start();
    }

    public void MY() {
        com.bytedance.sdk.openadsdk.core.MY.Cc Cc = this.vCE.wPn.Cc();
        final com.bytedance.sdk.openadsdk.core.MY.MY myTV = this.vCE.wPn.tV();
        final oeT oet = this.vCE.MY;
        if (oet.BS() == null) {
            return;
        }
        if (oet.zLG() != 5 && this.MY != null) {
            if (oet.BS().Cc) {
                this.MY.setOnClickListener(Cc);
                this.MY.setOnTouchListener(Cc);
            } else {
                this.MY.setOnClickListener(myTV);
            }
        }
        if (oet.zLG() == 1) {
            if (!oet.BS().IlO) {
                BS.IlO((View) this, (View.OnClickListener) myTV, "TTBaseVideoActivity#mRlDownloadBar");
                this.tV.setOnClickListener(myTV);
                this.IlO.setOnClickListener(myTV);
                this.EO.setOnClickListener(myTV);
                return;
            }
            BS.IlO((View) this, (View.OnClickListener) Cc, "TTBaseVideoActivity#mRlDownloadBar");
            BS.IlO((View) this, (View.OnTouchListener) Cc, "TTBaseVideoActivity#mRlDownloadBar");
            this.tV.setOnClickListener(Cc);
            this.tV.setOnTouchListener(Cc);
            this.IlO.setOnClickListener(Cc);
            this.IlO.setOnTouchListener(Cc);
            this.EO.setOnClickListener(Cc);
            this.EO.setOnTouchListener(Cc);
            return;
        }
        if (oet.zLG() != 5) {
            if (!oet.BS().EO) {
                BS.IlO((View) this, (View.OnClickListener) myTV, "TTBaseVideoActivity#mRlDownloadBar");
                return;
            } else {
                BS.IlO((View) this, (View.OnClickListener) Cc, "TTBaseVideoActivity#mRlDownloadBar");
                BS.IlO((View) this, (View.OnTouchListener) Cc, "TTBaseVideoActivity#mRlDownloadBar");
                return;
            }
        }
        String str = "VAST_ICON";
        if (!oet.BS().Cc) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.EO.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    View.OnClickListener onClickListener2 = myTV;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(view);
                    }
                    if (view == null || !"VAST_ICON".equals(view.getTag(570425345))) {
                        if (oet.QfH() != null) {
                            oet.QfH().IlO().Bc(EO.this.vCE.vAh.EV());
                        }
                    } else {
                        if (oet.QfH() == null || oet.QfH().MY() == null) {
                            return;
                        }
                        oet.QfH().MY().IlO(EO.this.vCE.vAh.EV());
                    }
                }
            };
            TextView textView = this.MY;
            if (textView != null) {
                textView.setOnClickListener(onClickListener);
            }
            TextView textView2 = this.tV;
            if (textView2 != null && !TextUtils.isEmpty(textView2.getText())) {
                this.tV.setOnClickListener(onClickListener);
            }
            zPa zpa = this.EO;
            if (zpa != null) {
                zpa.setTag(570425345, "VAST_ICON");
                this.EO.setOnClickListener(myTV);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.MY.Bc bc = new com.bytedance.sdk.openadsdk.core.MY.Bc("VAST_ACTION_BUTTON", oet.QfH(), Cc) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.EO.2
        };
        com.bytedance.sdk.openadsdk.core.MY.Bc bc2 = new com.bytedance.sdk.openadsdk.core.MY.Bc(str, oet.QfH(), Cc) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.EO.3
        };
        TextView textView3 = this.MY;
        if (textView3 != null) {
            textView3.setOnClickListener(bc);
            this.MY.setOnTouchListener(bc);
        }
        zPa zpa2 = this.EO;
        if (zpa2 != null) {
            zpa2.setOnClickListener(bc2);
            this.EO.setOnTouchListener(bc2);
        }
        TextView textView4 = this.tV;
        if (textView4 == null || TextUtils.isEmpty(textView4.getText())) {
            return;
        }
        this.tV.setOnClickListener(bc);
        this.tV.setOnTouchListener(bc);
    }

    public void IlO(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        this.vCE = ilO;
        if (ilO.MY.zLG() == 1) {
            EO();
        }
    }

    private static Drawable IlO(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#1A73E8"));
        gradientDrawable.setCornerRadius(BS.MY(context, 18.0f));
        return gradientDrawable;
    }
}

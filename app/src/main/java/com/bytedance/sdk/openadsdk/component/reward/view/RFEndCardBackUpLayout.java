package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.vAh;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.ea;
import com.bytedance.sdk.openadsdk.core.widget.zPa;
import com.bytedance.sdk.openadsdk.utils.BS;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class RFEndCardBackUpLayout extends com.bytedance.sdk.openadsdk.core.Cc.EO {
    private static final String TAG = "TTAD.RFEndCardBackUpL";
    private com.bytedance.sdk.openadsdk.component.reward.IlO.IlO adContext;
    private PAGLogoView adLogo;
    private zPa ivIcon;
    private boolean mInit;
    private ea rbScore;
    private int shownAdCount;
    private com.bytedance.sdk.openadsdk.core.Cc.lEW tvDesc;
    private com.bytedance.sdk.openadsdk.core.Cc.lEW tvDownload;
    private TextView tvTitle;

    public RFEndCardBackUpLayout(Context context) {
        super(context);
        setVisibility(8);
        setId(com.bytedance.sdk.openadsdk.utils.zPa.uI);
    }

    private void bindDescData(com.bytedance.sdk.openadsdk.core.Cc.lEW lew, oeT oet) {
        if (lew == null) {
            return;
        }
        String strGm = oet.gm();
        if (TextUtils.isEmpty(strGm)) {
            return;
        }
        lew.setText(strGm);
    }

    private void bindIconData(com.bytedance.sdk.openadsdk.core.Cc.tV tVVar, oeT oet) {
        if (tVVar == null || oet.HTA() == null || TextUtils.isEmpty(oet.HTA().IlO())) {
            return;
        }
        com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO(oet.HTA(), tVVar, oet);
    }

    private void bindTitleData(TextView textView, oeT oet, String str) {
        if (textView != null) {
            if (oet.VH() == null || TextUtils.isEmpty(oet.VH().MY())) {
                textView.setText(str);
            } else {
                textView.setText(oet.VH().MY());
            }
        }
    }

    private void initData(oeT oet, com.bytedance.sdk.openadsdk.core.Cc.lEW lew) {
        setDownloadButtonData(lew, oet, -1);
        bindIconData(this.ivIcon, oet);
        ea eaVar = this.rbScore;
        if (eaVar != null) {
            BS.IlO((TextView) null, eaVar, oet);
            if (oet.VH() != null) {
                this.rbScore.setVisibility(0);
            }
        }
        if (this.tvTitle != null) {
            if (oet.VH() != null && !TextUtils.isEmpty(oet.VH().MY())) {
                this.tvTitle.setText(oet.VH().MY());
            } else if (TextUtils.isEmpty(oet.hL())) {
                this.tvTitle.setVisibility(8);
            } else {
                this.tvTitle.setText(oet.hL());
            }
        }
        if (this.tvDesc != null) {
            String strDm = oet.dm();
            if (TextUtils.isEmpty(strDm)) {
                this.tvDesc.setVisibility(8);
            } else {
                this.tvDesc.setText(strDm);
            }
        }
        this.adLogo.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.IlO(RFEndCardBackUpLayout.this.adContext.BS, RFEndCardBackUpLayout.this.adContext.MY, RFEndCardBackUpLayout.this.adContext.Cc);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void initOneSlotMultipleAdsLayout() {
        Context context = getContext();
        setBackgroundColor(Color.parseColor("#C2FFFFFF"));
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(BS.MY(context, 16.0f), 0, BS.MY(context, 16.0f), 0);
        layoutParams.gravity = 17;
        addView(cc, layoutParams);
        if (this.adContext.fdM == 2) {
            com.bytedance.sdk.openadsdk.core.Cc.Cc cc2 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
            cc2.setOrientation(0);
            cc.addView(cc2, new FrameLayout.LayoutParams(-1, -2));
            initOneSlotMultipleAdsLayoutLandscape(cc2, this.shownAdCount);
        } else if (this.shownAdCount == 2) {
            initOneSlotMultipleAdsLayoutForTwoAdVertical(cc);
        } else {
            initOneSlotMultipleAdsLayoutForThreeAdVertical(cc);
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.adContext;
        View viewCreatePAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(ilO.BS, ilO.MY);
        viewCreatePAGLogoViewByMaterial.setId(520093757);
        cc.addView(viewCreatePAGLogoViewByMaterial);
        viewCreatePAGLogoViewByMaterial.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTWebsiteActivity.IlO(RFEndCardBackUpLayout.this.adContext.BS, RFEndCardBackUpLayout.this.adContext.MY, RFEndCardBackUpLayout.this.adContext.Cc);
            }
        });
    }

    private void initOneSlotMultipleAdsLayoutForThreeAdVertical(com.bytedance.sdk.openadsdk.core.Cc.Cc cc) {
        oeT oet = this.adContext.MY;
        if (oet instanceof vAh) {
            List<oeT> listTV = ((vAh) oet).iuH().tV();
            for (int i2 = 0; i2 < listTV.size() && i2 < 3; i2++) {
                initSingleCardInThreeCardStyle(cc, listTV.get(i2), i2);
            }
        }
    }

    private void initOneSlotMultipleAdsLayoutForTwoAdVertical(com.bytedance.sdk.openadsdk.core.Cc.Cc cc) {
        oeT oet = this.adContext.MY;
        if (oet instanceof vAh) {
            List<oeT> listTV = ((vAh) oet).iuH().tV();
            for (int i2 = 0; i2 < listTV.size() && i2 < 2; i2++) {
                initSingleCardInTwoCardStyle(cc, listTV.get(i2), i2);
            }
        }
    }

    private void initOneSlotMultipleAdsLayoutLandscape(com.bytedance.sdk.openadsdk.core.Cc.Cc cc, int i2) {
        oeT oet = this.adContext.MY;
        if (oet instanceof vAh) {
            List<oeT> listTV = ((vAh) oet).iuH().tV();
            for (int i8 = 0; i8 < listTV.size() && i8 < i2 && i8 < 3; i8++) {
                initSingleCardInTwoCardStyleLandscape(cc, listTV.get(i8), i8, i2);
            }
        }
    }

    private void initSingleCardInThreeCardStyle(com.bytedance.sdk.openadsdk.core.Cc.Cc cc, oeT oet, int i2) {
        Context context = getContext();
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc2 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc2.setOrientation(1);
        cc2.setGravity(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, i2 > 0 ? BS.MY(context, 12.0f) : 0, 0, 0);
        cc2.setBackground(new IlO(context));
        cc.addView(cc2, layoutParams);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc3 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc3.setOrientation(0);
        cc3.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = BS.MY(context, 20.0f);
        layoutParams2.leftMargin = BS.MY(context, 17.0f);
        layoutParams2.rightMargin = BS.MY(context, 30.0f);
        cc2.addView(cc3, layoutParams2);
        zPa zpa = new zPa(context);
        cc3.addView(zpa, new FrameLayout.LayoutParams(BS.MY(context, 70.0f), BS.MY(context, 63.0f)));
        bindIconData(zpa, oet);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc4 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc4.setOrientation(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = BS.MY(context, 7.0f);
        cc3.addView(cc4, layoutParams3);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew.setSingleLine(true);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        lew.setEllipsize(truncateAt);
        lew.setTextSize(18.0f);
        lew.setTextColor(Color.parseColor("#161823"));
        lew.setGravity(GravityCompat.START);
        lew.setTypeface(null, 1);
        cc4.addView(lew, new FrameLayout.LayoutParams(-1, -2));
        bindTitleData(lew, oet, oet.hL());
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew2 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew2.setSingleLine(true);
        lew2.setEllipsize(truncateAt);
        lew2.setTextSize(16.0f);
        lew2.setTextColor(Color.parseColor("#80161823"));
        cc4.addView(lew2, new FrameLayout.LayoutParams(-1, -2));
        bindDescData(lew2, oet);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc5 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc5.setOrientation(0);
        cc5.setGravity(16);
        cc4.addView(cc5, new FrameLayout.LayoutParams(-2, -2));
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew3 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew3.setTextSize(16.0f);
        lew3.setTextColor(Color.parseColor("#80161823"));
        cc5.addView(lew3, new ViewGroup.LayoutParams(-2, -2));
        ea eaVar = new ea(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = BS.MY(context, 8.0f);
        cc5.addView(eaVar, layoutParams4);
        BS.IlO(lew3, eaVar, oet, 18);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew4 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew4.setGravity(17);
        lew4.setId(520093707);
        lew4.setText(pP.IlO(context, "tt_video_download_apk"));
        lew4.setTextColor(-1);
        lew4.setTextSize(2, 16.0f);
        lew4.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_reward_full_video_backup_btn_bg"));
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, BS.MY(context, 36.0f));
        layoutParams5.setMargins(BS.MY(context, 20.0f), BS.MY(context, 22.0f), BS.MY(context, 20.0f), BS.MY(context, 20.0f));
        cc2.addView(lew4, layoutParams5);
        setDownloadButtonData(lew4, oet, i2);
    }

    private void initSingleCardInTwoCardStyle(com.bytedance.sdk.openadsdk.core.Cc.Cc cc, oeT oet, int i2) {
        Context context = getContext();
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc2 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc2.setOrientation(1);
        cc2.setGravity(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, i2 > 0 ? BS.MY(context, 12.0f) : 0, 0, 0);
        cc2.setBackground(new IlO(context));
        cc.addView(cc2, layoutParams);
        zPa zpa = new zPa(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(BS.MY(context, 70.0f), BS.MY(context, 63.0f));
        layoutParams2.setMargins(0, BS.MY(context, 24.0f), 0, BS.MY(context, 12.0f));
        cc2.addView(zpa, layoutParams2);
        bindIconData(zpa, oet);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew.setSingleLine(true);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        lew.setEllipsize(truncateAt);
        lew.setTextSize(18.0f);
        lew.setTextColor(Color.parseColor("#161823"));
        lew.setGravity(17);
        lew.setTypeface(null, 1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(BS.MY(context, 56.0f), 0, BS.MY(context, 56.0f), 0);
        cc2.addView(lew, layoutParams3);
        bindTitleData(lew, oet, oet.hL());
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew2 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew2.setSingleLine(true);
        lew2.setEllipsize(truncateAt);
        lew2.setTextSize(16.0f);
        lew2.setTextColor(Color.parseColor("#80161823"));
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.setMargins(BS.MY(context, 56.0f), BS.MY(context, 4.0f), BS.MY(context, 56.0f), 0);
        cc2.addView(lew2, layoutParams4);
        bindDescData(lew2, oet);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc3 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc3.setOrientation(0);
        cc3.setGravity(16);
        cc2.addView(cc3, new FrameLayout.LayoutParams(-2, -2));
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew3 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew3.setTextSize(16.0f);
        lew3.setTextColor(Color.parseColor("#80161823"));
        cc3.addView(lew3, new ViewGroup.LayoutParams(-2, -2));
        ea eaVar = new ea(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = BS.MY(context, 8.0f);
        cc3.addView(eaVar, layoutParams5);
        BS.IlO(lew3, eaVar, oet, 18);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew4 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew4.setGravity(17);
        lew4.setId(520093707);
        lew4.setText(pP.IlO(context, "tt_video_download_apk"));
        lew4.setTextColor(-1);
        lew4.setTextSize(2, 16.0f);
        lew4.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_reward_full_video_backup_btn_bg"));
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, BS.MY(context, 36.0f));
        layoutParams6.setMargins(BS.MY(context, 20.0f), BS.MY(context, 36.0f), BS.MY(context, 20.0f), BS.MY(context, 20.0f));
        cc2.addView(lew4, layoutParams6);
        setDownloadButtonData(lew4, oet, i2);
    }

    private void initSingleCardInTwoCardStyleLandscape(com.bytedance.sdk.openadsdk.core.Cc.Cc cc, oeT oet, int i2, int i8) {
        Context context = getContext();
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc2 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc2.setOrientation(1);
        cc2.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        if (i2 > 0) {
            layoutParams.setMargins(BS.MY(context, 12.0f), 0, 0, 0);
        }
        cc2.setBackground(new IlO(context));
        cc.addView(cc2, layoutParams);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc3 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc3.setOrientation(0);
        cc3.setGravity(48);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = BS.MY(context, 20.0f);
        layoutParams2.leftMargin = BS.MY(context, 17.0f);
        layoutParams2.rightMargin = BS.MY(context, 30.0f);
        cc2.addView(cc3, layoutParams2);
        zPa zpa = new zPa(context);
        cc3.addView(zpa, new FrameLayout.LayoutParams(BS.MY(context, 44.0f), BS.MY(context, 44.0f)));
        bindIconData(zpa, oet);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc4 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc4.setOrientation(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = BS.MY(context, 7.0f);
        cc3.addView(cc4, layoutParams3);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew.setSingleLine(true);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        lew.setEllipsize(truncateAt);
        lew.setTextSize(18.0f);
        lew.setTextColor(Color.parseColor("#161823"));
        lew.setGravity(GravityCompat.START);
        lew.setTypeface(null, 1);
        cc4.addView(lew, new FrameLayout.LayoutParams(-1, -2));
        bindTitleData(lew, oet, oet.hL());
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc5 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc5.setOrientation(0);
        cc5.setGravity(16);
        cc4.addView(cc5, new FrameLayout.LayoutParams(-2, -2));
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew2 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew2.setTextSize(16.0f);
        lew2.setTextColor(Color.parseColor("#80161823"));
        cc5.addView(lew2, new ViewGroup.LayoutParams(-2, -2));
        ea eaVar = new ea(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = BS.MY(context, 8.0f);
        cc5.addView(eaVar, layoutParams4);
        BS.IlO(lew2, eaVar, oet, 18);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew3 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        if (i8 == 2) {
            lew3.setSingleLine(true);
        } else {
            lew3.setLines(2);
        }
        lew3.setEllipsize(truncateAt);
        lew3.setTextSize(16.0f);
        lew3.setTextColor(Color.parseColor("#80161823"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        int i9 = layoutParams2.leftMargin;
        layoutParams5.rightMargin = i9;
        layoutParams5.leftMargin = i9;
        layoutParams5.topMargin = BS.MY(context, 12.0f);
        cc2.addView(lew3, layoutParams5);
        bindDescData(lew3, oet);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew4 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew4.setGravity(17);
        lew4.setId(520093707);
        lew4.setText(pP.IlO(context, "tt_video_download_apk"));
        lew4.setTextColor(-1);
        lew4.setTextSize(2, 16.0f);
        lew4.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_reward_full_video_backup_btn_bg"));
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, BS.MY(context, 36.0f));
        layoutParams6.setMargins(BS.MY(context, 20.0f), BS.MY(context, 22.0f), BS.MY(context, 20.0f), BS.MY(context, 20.0f));
        cc2.addView(lew4, layoutParams6);
        setDownloadButtonData(lew4, oet, i2);
    }

    private void initViews() {
        com.bytedance.sdk.openadsdk.activity.vCE vce;
        if (this.mInit) {
            return;
        }
        this.mInit = true;
        if (this.adContext.MY.WIv() && (vce = this.adContext.ED) != null && vce.kBB() && this.shownAdCount > 1) {
            initOneSlotMultipleAdsLayout();
            return;
        }
        oeT oet = this.adContext.MY;
        if (oet.xJ()) {
            initViewsForVast();
        } else {
            initViewsDefault();
            initData(oet, this.tvDownload);
        }
    }

    private void initViewsDefault() {
        Context context = getContext();
        boolean z2 = this.adContext.MY.BES() == 1;
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setGravity(1);
        cc.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = z2 ? new FrameLayout.LayoutParams(-1, -2) : new FrameLayout.LayoutParams(BS.MY(context, 327.0f), -2);
        layoutParams.gravity = 17;
        int iMY = BS.MY(context, 24.0f);
        layoutParams.rightMargin = iMY;
        layoutParams.leftMargin = iMY;
        addView(cc, layoutParams);
        zPa zpa = new zPa(context);
        this.ivIcon = zpa;
        zpa.setBackgroundColor(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(BS.MY(context, 80.0f), BS.MY(context, 80.0f));
        layoutParams2.bottomMargin = BS.MY(context, 12.0f);
        cc.addView(this.ivIcon, layoutParams2);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.tvTitle = lew;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        lew.setEllipsize(truncateAt);
        this.tvTitle.setGravity(17);
        this.tvTitle.setMaxLines(2);
        this.tvTitle.setMaxWidth(BS.MY(context, 180.0f));
        this.tvTitle.setTextColor(-1);
        this.tvTitle.setTextSize(2, 24.0f);
        cc.addView(this.tvTitle, new LinearLayout.LayoutParams(-1, -2));
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew2 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.tvDesc = lew2;
        lew2.setEllipsize(truncateAt);
        this.tvDesc.setGravity(17);
        this.tvDesc.setMaxLines(2);
        this.tvDesc.setTextColor(Color.parseColor("#BFFFFFFF"));
        this.tvDesc.setTextSize(2, 16.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = BS.MY(context, 8.0f);
        cc.addView(this.tvDesc, layoutParams3);
        this.rbScore = new ea(context, true);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, BS.MY(context, 16.0f));
        layoutParams4.topMargin = BS.MY(context, 12.0f);
        this.rbScore.setVisibility(8);
        cc.addView(this.rbScore, layoutParams4);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew3 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.tvDownload = lew3;
        lew3.setId(520093707);
        this.tvDownload.setGravity(17);
        this.tvDownload.setText(pP.IlO(context, "tt_video_download_apk"));
        this.tvDownload.setTextColor(-1);
        this.tvDownload.setTextSize(2, 16.0f);
        this.tvDownload.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_reward_full_video_backup_btn_bg"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, BS.MY(context, 44.0f));
        layoutParams5.topMargin = BS.MY(context, 54.0f);
        cc.addView(this.tvDownload, layoutParams5);
        this.adLogo = PAGLogoView.createPAGLogoViewByMaterial(context, this.adContext.MY);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, BS.MY(context, 14.0f));
        layoutParams6.gravity = 8388691;
        layoutParams6.leftMargin = BS.MY(context, 18.0f);
        if (z2) {
            layoutParams6.bottomMargin = BS.MY(context, 61.0f);
        } else {
            layoutParams6.bottomMargin = BS.MY(context, 24.0f);
        }
        addView(this.adLogo, layoutParams6);
    }

    private void initViewsForVast() {
        Context context = getContext();
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        tVVar.setId(com.bytedance.sdk.openadsdk.utils.zPa.lEW);
        tVVar.setVisibility(8);
        addView(tVVar, new FrameLayout.LayoutParams(-1, -1));
        View vce = new com.bytedance.sdk.component.DmF.vCE(context, true);
        vce.setVisibility(8);
        vce.setId(com.bytedance.sdk.openadsdk.utils.zPa.DmF);
        addView(vce, new FrameLayout.LayoutParams(-1, -1));
    }

    private void setDownloadButtonData(com.bytedance.sdk.openadsdk.core.Cc.lEW lew, oeT oet, int i2) {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.adContext;
        com.bytedance.sdk.openadsdk.core.MY.Cc ccIlO = ilO.wPn.IlO(ilO, oet);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.adContext;
        ccIlO.IlO(com.bytedance.sdk.openadsdk.es.IlO.IlO.Bc.IlO(ilO2.BS, oet, ilO2.Cc));
        if (i2 != -1) {
            HashMap map = new HashMap();
            int i8 = i2 + 1;
            map.put("ad_show_order", Integer.valueOf(i8));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad_show_order", i8);
                map.put("pag_json_data", jSONObject.toString());
            } catch (Throwable unused) {
            }
            ccIlO.IlO(map);
        }
        lew.setOnClickListener(ccIlO);
        lew.setOnTouchListener(ccIlO);
        CharSequence charSequenceAa = oet.aa();
        if (TextUtils.isEmpty(charSequenceAa)) {
            return;
        }
        lew.setText(charSequenceAa);
    }

    public void init(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        this.adContext = ilO;
        if (ilO.MY.xJ()) {
            initViews();
        }
    }

    public void setShownAdCount(int i2) {
        this.shownAdCount = i2;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 0) {
            initViews();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class IlO extends Drawable {
        private final int EO;
        Path IlO = new Path();
        private final Drawable MY;

        public IlO(Context context) {
            this.MY = pP.EO(context, "tt_ad_bg_header_gradient");
            this.EO = BS.MY(context, 8.0f);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            canvas.clipPath(this.IlO);
            canvas.drawColor(-1);
            this.MY.draw(canvas);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int i2, int i8, int i9, int i10) {
            super.setBounds(i2, i8, i9, i10);
            float f4 = i9;
            this.MY.setBounds(i2, i8, i9, (int) (((1.0f * f4) / this.MY.getIntrinsicWidth()) * this.MY.getIntrinsicHeight()));
            this.IlO.reset();
            Path path = this.IlO;
            RectF rectF = new RectF(0.0f, 0.0f, f4, i10);
            int i11 = this.EO;
            path.addRoundRect(rectF, i11, i11, Path.Direction.CCW);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
        }
    }
}

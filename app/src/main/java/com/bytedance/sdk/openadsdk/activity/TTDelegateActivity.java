package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.ea;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.EO.Bc;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.tl;
import com.ironsource.Y1;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTDelegateActivity extends TTBaseActivity {
    private static final Map<String, Bc.IlO> EO = Collections.synchronizedMap(new HashMap());
    private Intent IlO;
    private tl MY;

    private void EO() {
        int intExtra = this.IlO.getIntExtra("type", 0);
        if (intExtra != 1) {
            if (intExtra != 6) {
                finish();
                return;
            }
            IlO(this.IlO.getStringExtra("ext_info"), this.IlO.getStringExtra("filter_words"), this.IlO.getStringExtra("closed_listener_key"), this.IlO.getStringExtra("creative_info"));
        }
    }

    private void MY() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!bWL.Cc()) {
            finish();
            return;
        }
        MY();
        this.IlO = getIntent();
        if (cl.IlO() == null) {
            cl.MY(this);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        tl tlVar = this.MY;
        if (tlVar != null) {
            tlVar.MY();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (cl.IlO() == null) {
            cl.MY(this);
        }
        setIntent(intent);
        this.IlO = intent;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        tl tlVar = this.MY;
        if ((tlVar == null || ((com.bytedance.sdk.openadsdk.EO.EO) tlVar).IlO == null || !((com.bytedance.sdk.openadsdk.EO.EO) tlVar).IlO.isShowing()) && this.IlO != null) {
            EO();
        }
    }

    public static void IlO(oeT oet, String str, Bc.IlO ilO) {
        if (oet == null) {
            return;
        }
        Intent intent = new Intent(cl.IlO(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 6);
        intent.putExtra("ext_info", oet.KT());
        intent.putExtra("filter_words", com.bytedance.sdk.openadsdk.tool.IlO.IlO(oet.cJK()));
        intent.putExtra("creative_info", oet.eDn().toString());
        intent.putExtra("closed_listener_key", str);
        if (ilO != null) {
            if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                DmF.MY().IlO(str, ilO);
            } else {
                EO.put(str, ilO);
            }
        }
        com.bytedance.sdk.component.utils.MY.IlO(cl.IlO(), intent, null);
    }

    public static void IlO(oeT oet, String str) {
        IlO(oet, str, null);
    }

    private void IlO(String str, String str2, final String str3, String str4) {
        TTDelegateActivity tTDelegateActivity;
        if (str2 == null || str == null || this.MY != null) {
            tTDelegateActivity = this;
        } else {
            tTDelegateActivity = this;
            com.bytedance.sdk.openadsdk.EO.EO eo = new com.bytedance.sdk.openadsdk.EO.EO(tTDelegateActivity, str, com.bytedance.sdk.openadsdk.tool.IlO.IlO(str2), str4, Y1.f7807d);
            tTDelegateActivity.MY = eo;
            eo.IlO(str3);
            tTDelegateActivity.MY.IlO(new tl.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.1
                @Override // com.bytedance.sdk.openadsdk.core.tl.IlO
                public void IlO(int i2, String str5) {
                    Bc.IlO ilOCc;
                    if (TTDelegateActivity.EO != null && TTDelegateActivity.EO.size() > 0 && !TextUtils.isEmpty(str3) && !com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                        Bc.IlO ilO = (Bc.IlO) TTDelegateActivity.EO.get(str3);
                        if (ilO != null) {
                            ilO.IlO();
                        }
                    } else if (!TextUtils.isEmpty(str3) && (ilOCc = DmF.MY().Cc(str3)) != null) {
                        ilOCc.IlO();
                        DmF.MY().vCE(str3);
                    }
                    TTDelegateActivity.this.IlO(str3);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.bytedance.sdk.openadsdk.core.tl.IlO
                public void IlO() {
                    if (!((com.bytedance.sdk.openadsdk.EO.EO) TTDelegateActivity.this.MY).EO()) {
                        TTDelegateActivity.this.IlO(str3);
                        TTDelegateActivity.this.finish();
                    }
                    ((com.bytedance.sdk.openadsdk.EO.EO) TTDelegateActivity.this.MY).IlO(false);
                }
            });
        }
        tl tlVar = tTDelegateActivity.MY;
        if (tlVar != null) {
            tlVar.IlO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(String str) {
        Map<String, Bc.IlO> map = EO;
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        map.remove(str);
        if (ea.tV()) {
            map.size();
        }
    }
}

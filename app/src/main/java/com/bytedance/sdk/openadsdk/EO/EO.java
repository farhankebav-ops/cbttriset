package com.bytedance.sdk.openadsdk.EO;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.EO.rp;
import com.bytedance.sdk.openadsdk.EO.tV;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.tl;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements tl {
    private tl.IlO Cc;
    private tV EO;
    public rp IlO;
    private final Context MY;
    private boolean tV;

    public EO(Context context, String str, List<FilterWord> list, String str2, String str3) {
        this.MY = context;
        IlO(str, list, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV() {
        Context context = this.MY;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing() || this.IlO.isShowing()) {
            return;
        }
        this.IlO.show();
    }

    private void IlO(String str, List<FilterWord> list, String str2, String str3) {
        this.EO = new tV(this.MY, str, list, str3);
        rp rpVar = new rp(this.MY, this.EO.getDislikeManager());
        this.IlO = rpVar;
        rpVar.IlO(str, str2);
        this.IlO.IlO(str3);
        this.IlO.IlO(new rp.IlO() { // from class: com.bytedance.sdk.openadsdk.EO.EO.1
            @Override // com.bytedance.sdk.openadsdk.EO.rp.IlO
            public void EO() {
                EO.this.IlO();
            }

            @Override // com.bytedance.sdk.openadsdk.EO.rp.IlO
            public void IlO() {
            }

            @Override // com.bytedance.sdk.openadsdk.EO.rp.IlO
            public void MY() {
                EO.this.IlO();
            }

            @Override // com.bytedance.sdk.openadsdk.EO.rp.IlO
            public void IlO(int i2, FilterWord filterWord, String str4) {
                EO.this.EO.onSuggestionSubmit(str4);
                EO.this.IlO();
            }
        });
        this.EO.IlO(new tV.IlO() { // from class: com.bytedance.sdk.openadsdk.EO.EO.2
            @Override // com.bytedance.sdk.openadsdk.EO.tV.IlO
            public void IlO() {
                EO.this.IlO(true);
                if (EO.this.EO != null && EO.this.EO.isShowing()) {
                    EO.this.EO.hide();
                }
                EO.this.tV();
            }

            @Override // com.bytedance.sdk.openadsdk.EO.tV.IlO
            public void MY() {
                try {
                    if (EO.this.Cc != null) {
                        EO.this.Cc.IlO();
                    }
                } catch (Throwable th) {
                    oeT.IlO("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.EO.tV.IlO
            public void IlO(int i2, FilterWord filterWord) {
                try {
                    if (!filterWord.hasSecondOptions() && EO.this.Cc != null) {
                        EO.this.Cc.IlO(i2, filterWord.getName());
                    }
                    filterWord.getName();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public boolean EO() {
        return this.tV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.tl
    public void MY() {
        tV tVVar = this.EO;
        if (tVVar != null) {
            tVVar.destroy();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.tl
    public void IlO() {
        Context context = this.MY;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing() || this.EO.isShowing()) {
            return;
        }
        this.EO.show();
    }

    @Override // com.bytedance.sdk.openadsdk.core.tl
    public void IlO(tl.IlO ilO) {
        this.Cc = ilO;
    }

    public void IlO(String str) {
        tV tVVar = this.EO;
        if (tVVar != null) {
            tVVar.IlO(str);
        }
    }

    public void IlO(boolean z2) {
        this.tV = z2;
    }
}

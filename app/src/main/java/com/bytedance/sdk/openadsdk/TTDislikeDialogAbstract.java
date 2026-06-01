package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.EO.NV;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TTDislikeDialogAbstract extends Dialog implements NV.MY {
    private String Cc;
    protected final NV EO;
    protected String IlO;
    protected List<FilterWord> MY;
    private View tV;

    public TTDislikeDialogAbstract(@NonNull Context context) {
        super(context);
        NV nv = new NV();
        this.EO = nv;
        nv.IlO(this);
    }

    public void destroy() {
        NV nv = this.EO;
        if (nv != null) {
            nv.IlO();
        }
    }

    public NV getDislikeManager() {
        return this.EO;
    }

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract View getLayoutView();

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.tV = getLayoutView();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        View view = this.tV;
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        setContentView(view, layoutParams);
    }

    public void onSuggestionSubmit(String str) {
        NV nv = this.EO;
        if (nv != null) {
            nv.EO(str);
        }
    }

    public void setMaterialMeta(String str, List<FilterWord> list) {
        this.IlO = str;
        this.MY = list;
        this.EO.IlO(str);
        this.EO.IlO(this.MY);
    }

    public TTDislikeDialogAbstract(@NonNull Context context, int i2, String str) {
        super(context, i2);
        this.Cc = str;
        NV nv = new NV();
        this.EO = nv;
        nv.IlO(this);
    }
}

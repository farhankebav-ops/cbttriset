package com.bytedance.sdk.openadsdk.EO;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.utils.BS;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends TTDislikeDialogAbstract {
    private String Cc;
    private IlO tV;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO();

        void IlO(int i2, FilterWord filterWord);

        void MY();
    }

    public tV(Context context, String str, List<FilterWord> list, String str2) {
        super(context, pP.vCE(context, "tt_dislikeDialog"), str2);
        this.IlO = str;
        this.MY = list;
    }

    private void MY() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.sdk.openadsdk.EO.tV.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (tV.this.tV != null) {
                    IlO unused = tV.this.tV;
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.EO.tV.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (tV.this.tV != null) {
                    tV.this.tV.MY();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public ViewGroup.LayoutParams getLayoutParams() {
        return new ViewGroup.LayoutParams(BS.EO(getContext()) - 120, -2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public View getLayoutView() {
        return new DmF(getContext(), this.EO, this.MY);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract, android.app.Dialog
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            IlO();
            MY();
            setMaterialMeta(this.IlO, this.MY);
        } catch (Throwable unused) {
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (WindowManager.BadTokenException unused) {
        }
    }

    public void IlO(IlO ilO) {
        this.tV = ilO;
    }

    public void IlO(String str) {
        this.Cc = str;
    }

    @Override // com.bytedance.sdk.openadsdk.EO.NV.MY
    public void IlO(int i2) {
        FilterWord filterWordMY;
        if (NV.EO == i2) {
            dismiss();
            return;
        }
        if (NV.Cc == i2) {
            IlO ilO = this.tV;
            if (ilO != null) {
                ilO.IlO();
                return;
            }
            return;
        }
        if (NV.MY != i2 || (filterWordMY = this.EO.MY()) == null || NV.IlO.equals(filterWordMY)) {
            return;
        }
        IlO ilO2 = this.tV;
        if (ilO2 != null) {
            try {
                ilO2.IlO(0, filterWordMY);
            } catch (Throwable unused) {
            }
        }
        dismiss();
    }

    private void IlO() {
        Window window = getWindow();
        if (window == null || window.getAttributes() == null) {
            return;
        }
        window.getAttributes().windowAnimations = 0;
    }
}

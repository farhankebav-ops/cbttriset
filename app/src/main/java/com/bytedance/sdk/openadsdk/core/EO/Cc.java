package com.bytedance.sdk.openadsdk.core.EO;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.EO.vCE;
import com.bytedance.sdk.openadsdk.core.model.AXM;
import com.bytedance.sdk.openadsdk.utils.BS;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    private final View.OnAttachStateChangeListener Bc;
    private AXM IlO;
    private vCE MY;
    private final vCE.IlO lEW;
    private final vCE.MY vCE;
    private List<IlO> EO = new ArrayList();
    private final String tV = "BannerSwiperManager";
    private int Cc = -1;

    public Cc(AXM axm, Context context, int i2, int i8) {
        vCE.MY my = new vCE.MY() { // from class: com.bytedance.sdk.openadsdk.core.EO.Cc.1
            @Override // com.bytedance.sdk.openadsdk.core.EO.vCE.MY
            public void IlO(boolean z2) {
                try {
                    if (z2) {
                        Cc.this.tV();
                    } else {
                        Cc.this.EO();
                    }
                } catch (Throwable unused) {
                }
            }
        };
        this.vCE = my;
        View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.EO.Cc.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                Cc.this.Cc();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (Cc.this.EO != null && !Cc.this.EO.isEmpty()) {
                    for (int i9 = 0; i9 < Cc.this.EO.size(); i9++) {
                        ((IlO) Cc.this.EO.get(i9)).vCE();
                    }
                }
                Cc.this.Cc = -1;
                if (Cc.this.MY != null) {
                    Cc.this.MY.tV();
                }
            }
        };
        this.Bc = onAttachStateChangeListener;
        vCE.IlO ilO = new vCE.IlO() { // from class: com.bytedance.sdk.openadsdk.core.EO.Cc.3
            @Override // com.bytedance.sdk.openadsdk.core.EO.vCE.IlO
            public void IlO(boolean z2) {
                if (z2) {
                    Cc.this.tV();
                } else {
                    Cc.this.EO();
                }
            }
        };
        this.lEW = ilO;
        this.IlO = axm;
        vCE vce = new vCE(context);
        this.MY = vce;
        vce.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.MY.setSwiperWindowFocusChangedListener(my);
        this.MY.setSwiperVisibleChangeListener(ilO);
        IlO(context, i2, i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void Cc() {
        if (this.IlO == null) {
            this.IlO = new AXM();
        }
        this.MY.IlO(TextUtils.equals(this.IlO.IlO(), "vertical") ? 1 : 0).IlO("dot").EO(false).tV(this.IlO.tV() == 1).IlO(this.IlO.MY() == 1).EO(this.IlO.DmF()).Cc(this.IlO.NV() == 1).tV(this.IlO.lEW()).MY(this.IlO.EO() == 1).lEW(this.IlO.Cc()).DmF(this.IlO.vCE()).Bc(this.IlO.Bc());
        this.MY.setOnPageChangeListener(new com.bytedance.adsdk.ugeno.vCE.EO() { // from class: com.bytedance.sdk.openadsdk.core.EO.Cc.4
            @Override // com.bytedance.adsdk.ugeno.vCE.EO
            public void IlO(boolean z2, int i2, float f4, int i8) {
            }

            @Override // com.bytedance.adsdk.ugeno.vCE.EO
            public void IlO(boolean z2, int i2, int i8, boolean z7, boolean z8) {
                Cc.this.EO(i2);
                Cc.this.Cc = i2;
                Cc.this.IlO(i2);
                Cc.this.MY(i2);
            }

            @Override // com.bytedance.adsdk.ugeno.vCE.EO
            public void IlO(boolean z2, int i2) {
                if (i2 == 1 || i2 == 2) {
                    Cc.this.MY(-1);
                } else if (i2 == 0) {
                    Cc cc = Cc.this;
                    cc.IlO(cc.Cc);
                }
            }
        });
        MY(this.EO);
        this.MY.EO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO() {
        vCE vce;
        AXM axm = this.IlO;
        if (axm != null && axm.MY() == 1 && (vce = this.MY) != null) {
            vce.vCE();
        }
        if (this.Cc >= 0) {
            MY(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV() {
        vCE vce;
        AXM axm = this.IlO;
        if (axm != null && axm.MY() == 1 && (vce = this.MY) != null) {
            vce.Cc();
        }
        int i2 = this.Cc;
        if (i2 >= 0) {
            IlO(i2);
            MY(this.Cc);
        }
    }

    public void IlO(Context context, float f4, float f8) {
        int iMY = BS.MY(context, f4);
        int iMY2 = BS.MY(context, f8);
        ViewGroup.LayoutParams layoutParams = this.MY.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(iMY, iMY2);
        }
        layoutParams.width = iMY;
        layoutParams.height = iMY2;
        this.MY.setLayoutParams(layoutParams);
    }

    public void MY(int i2) {
        IlO ilO;
        for (int i8 = 0; i8 < this.EO.size(); i8++) {
            try {
                if (i8 != i2 && (ilO = this.EO.get(i8)) != null) {
                    ilO.DmF();
                }
            } catch (Throwable th) {
                th.getMessage();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO(int i2) {
        IlO ilO;
        try {
            int i8 = this.Cc;
            if (i8 != -1 && i8 != i2 && (ilO = this.EO.get(i8)) != null) {
                ilO.tV();
                ilO.lEW();
            }
            IlO ilO2 = this.EO.get(i2);
            if (ilO2 != null) {
                ilO2.Cc();
            }
        } catch (Throwable unused) {
        }
    }

    private void MY(List<IlO> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.MY.IlO(list.get(i2).IlO());
        }
    }

    public void IlO(List<IlO> list) {
        this.EO = list;
    }

    public View MY() {
        return this.MY;
    }

    public void IlO(final int i2) {
        IlO ilO;
        try {
            final int size = this.EO.size();
            if (i2 < size && (ilO = this.EO.get(i2)) != null) {
                ilO.IlO(new com.bytedance.sdk.openadsdk.IlO.IlO.MY() { // from class: com.bytedance.sdk.openadsdk.core.EO.Cc.5
                    @Override // com.bytedance.sdk.openadsdk.IlO.IlO.MY
                    public void IlO() {
                        int i8 = i2 + 1;
                        if (i8 >= size) {
                            return;
                        }
                        Cc.this.IlO(i8);
                    }
                });
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void IlO() {
        if (this.MY != null) {
            try {
                List<IlO> list = this.EO;
                if (list != null && !list.isEmpty()) {
                    for (int i2 = 0; i2 < this.EO.size(); i2++) {
                        this.EO.get(i2).Bc();
                    }
                }
                this.Cc = -1;
                this.MY.tV();
                this.MY.setSwiperWindowFocusChangedListener(null);
                this.MY.setSwiperVisibleChangeListener(null);
                this.MY.removeOnAttachStateChangeListener(this.Bc);
                this.MY = null;
            } catch (Throwable unused) {
            }
        }
    }
}

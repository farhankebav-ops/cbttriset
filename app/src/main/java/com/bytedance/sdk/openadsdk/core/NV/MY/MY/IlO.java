package com.bytedance.sdk.openadsdk.core.NV.MY.MY;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.adsdk.ugeno.MY.EO;
import com.bytedance.adsdk.ugeno.tV;
import com.bytedance.adsdk.ugeno.yoga.MY.EO;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends FrameLayout {
    private final C0095IlO EO;
    private final RecyclerView IlO;
    private final List<EO> MY;
    private tV tV;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY extends RecyclerView.ViewHolder {
        private final ViewGroup IlO;

        public MY(@NonNull View view) {
            super(view);
            this.IlO = (ViewGroup) view;
        }

        public void IlO(EO eo) {
            View viewEV = eo.EV();
            ViewParent parent = viewEV.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(viewEV);
            }
            this.IlO.removeAllViews();
            this.IlO.addView(viewEV, new EO.IlO(eo.nvX(), eo.YA()));
        }
    }

    public IlO(@NonNull Context context) {
        super(context);
        this.MY = new CopyOnWriteArrayList();
        C0095IlO c0095IlO = new C0095IlO();
        this.EO = c0095IlO;
        RecyclerView recyclerView = new RecyclerView(context);
        this.IlO = recyclerView;
        addView(recyclerView);
        recyclerView.setAdapter(c0095IlO);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        tV tVVar = this.tV;
        if (tVVar != null) {
            tVVar.Bc();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tV tVVar = this.tV;
        if (tVVar != null) {
            tVVar.lEW();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        tV tVVar = this.tV;
        if (tVVar != null) {
            tVVar.vCE();
        }
        super.onLayout(z2, i2, i8, i9, i10);
        tV tVVar2 = this.tV;
        if (tVVar2 != null) {
            tVVar2.IlO(i2, i8, i9, i10);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        tV tVVar = this.tV;
        if (tVVar != null) {
            int[] iArrIlO = tVVar.IlO(i2, i8);
            super.onMeasure(iArrIlO[0], iArrIlO[1]);
        } else {
            super.onMeasure(i2, i8);
        }
        tV tVVar2 = this.tV;
        if (tVVar2 != null) {
            tVVar2.Cc();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        tV tVVar = this.tV;
        if (tVVar != null) {
            tVVar.MY(i2, i8, i9, i10);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
    }

    public void setOrientation(int i2) {
        if (i2 == 1) {
            this.IlO.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        } else {
            this.IlO.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
    }

    public void IlO(com.bytedance.adsdk.ugeno.MY.EO<View> eo) {
        if (eo == null) {
            return;
        }
        this.MY.add(eo);
        C0095IlO c0095IlO = this.EO;
        if (c0095IlO != null) {
            c0095IlO.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.NV.MY.MY.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class C0095IlO extends RecyclerView.Adapter<MY> {
        private C0095IlO() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public MY onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            com.bytedance.adsdk.ugeno.yoga.MY.EO eo = new com.bytedance.adsdk.ugeno.yoga.MY.EO(viewGroup.getContext());
            com.bytedance.adsdk.ugeno.MY.EO eo2 = (com.bytedance.adsdk.ugeno.MY.EO) IlO.this.MY.get(i2);
            eo.setLayoutParams(new ViewGroup.LayoutParams(eo2.nvX(), eo2.YA()));
            return new MY(eo);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return IlO.this.MY.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull MY my, int i2) {
            my.IlO((com.bytedance.adsdk.ugeno.MY.EO) IlO.this.MY.get(i2));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            return i2;
        }
    }

    public void IlO(tV tVVar) {
        this.tV = tVVar;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.NV.MY.MY.MY my) {
        ViewGroup.LayoutParams layoutParams = this.IlO.getLayoutParams();
        layoutParams.width = my.nvX();
        layoutParams.height = my.YA();
        this.IlO.setLayoutParams(layoutParams);
    }
}

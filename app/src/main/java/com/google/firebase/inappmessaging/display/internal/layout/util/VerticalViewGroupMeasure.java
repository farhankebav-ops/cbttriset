package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.View;
import com.google.firebase.inappmessaging.display.internal.Logging;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class VerticalViewGroupMeasure {
    private int h;
    private List<ViewMeasure> vms;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f5617w;

    public VerticalViewGroupMeasure(int i2, int i8) {
        this.vms = new ArrayList();
        this.f5617w = i2;
        this.h = i8;
    }

    public void add(View view, boolean z2) {
        ViewMeasure viewMeasure = new ViewMeasure(view, z2);
        viewMeasure.setMaxDimens(this.f5617w, this.h);
        this.vms.add(viewMeasure);
    }

    public void allocateSpace(int i2) {
        float f4;
        ArrayList arrayList = new ArrayList();
        for (ViewMeasure viewMeasure : this.vms) {
            if (viewMeasure.isFlex()) {
                arrayList.add(viewMeasure);
            }
        }
        Collections.sort(arrayList, new Comparator<ViewMeasure>() { // from class: com.google.firebase.inappmessaging.display.internal.layout.util.VerticalViewGroupMeasure.1
            @Override // java.util.Comparator
            public int compare(ViewMeasure viewMeasure2, ViewMeasure viewMeasure3) {
                if (viewMeasure2.getDesiredHeight() > viewMeasure3.getDesiredHeight()) {
                    return -1;
                }
                return viewMeasure2.getDesiredHeight() < viewMeasure3.getDesiredHeight() ? 1 : 0;
            }
        });
        int size = arrayList.size();
        int i8 = 0;
        int desiredHeight = 0;
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            desiredHeight += ((ViewMeasure) obj).getDesiredHeight();
        }
        if (arrayList.size() >= 6) {
            throw new IllegalStateException("VerticalViewGroupMeasure only supports up to 5 children");
        }
        float f8 = 1.0f - ((r1 - 1) * 0.2f);
        Logging.logdPair("VVGM (minFrac, maxFrac)", 0.2f, f8);
        int size2 = arrayList.size();
        float f9 = 0.0f;
        while (i8 < size2) {
            Object obj2 = arrayList.get(i8);
            i8++;
            ViewMeasure viewMeasure2 = (ViewMeasure) obj2;
            float desiredHeight2 = viewMeasure2.getDesiredHeight() / desiredHeight;
            if (desiredHeight2 > f8) {
                f9 += desiredHeight2 - f8;
                f4 = f8;
            } else {
                f4 = desiredHeight2;
            }
            if (desiredHeight2 < 0.2f) {
                float fMin = Math.min(0.2f - desiredHeight2, f9);
                f9 -= fMin;
                f4 = desiredHeight2 + fMin;
            }
            Logging.logdPair("\t(desired, granted)", desiredHeight2, f4);
            viewMeasure2.setMaxDimens(this.f5617w, (int) (f4 * i2));
        }
    }

    public int getTotalFixedHeight() {
        int desiredHeight = 0;
        for (ViewMeasure viewMeasure : this.vms) {
            if (!viewMeasure.isFlex()) {
                desiredHeight = viewMeasure.getDesiredHeight() + desiredHeight;
            }
        }
        return desiredHeight;
    }

    public int getTotalHeight() {
        Iterator<ViewMeasure> it = this.vms.iterator();
        int desiredHeight = 0;
        while (it.hasNext()) {
            desiredHeight += it.next().getDesiredHeight();
        }
        return desiredHeight;
    }

    public List<ViewMeasure> getViews() {
        return this.vms;
    }

    public void reset(int i2, int i8) {
        this.f5617w = i2;
        this.h = i8;
        this.vms = new ArrayList();
    }

    public VerticalViewGroupMeasure() {
        this.vms = new ArrayList();
        this.f5617w = 0;
        this.h = 0;
    }
}

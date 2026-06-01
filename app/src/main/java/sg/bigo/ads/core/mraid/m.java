package sg.bigo.ads.core.mraid;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<Rect> f17242a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f17245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f17246b;

        public a(int i2, int i8) {
            this.f17245a = i2;
            this.f17246b = i8;
        }

        public final boolean a(a aVar) {
            return this.f17245a <= aVar.f17246b && this.f17246b >= aVar.f17245a;
        }

        public final String toString() {
            return androidx.camera.core.processing.util.a.i("Range: ", this.f17245a, " - ", this.f17246b);
        }
    }

    public m(List<Rect> list, int[] iArr) {
        List<Integer> listA = a(list);
        this.f17242a = new ArrayList();
        int i2 = 0;
        while (i2 < listA.size() - 1) {
            int iIntValue = listA.get(i2).intValue();
            i2++;
            int iIntValue2 = listA.get(i2).intValue();
            if (iIntValue < iIntValue2) {
                a aVar = new a(iIntValue, iIntValue2);
                this.f17242a.addAll(b(aVar, a(aVar, list)));
            }
        }
        Collections.sort(this.f17242a, new Comparator<Rect>() { // from class: sg.bigo.ads.core.mraid.m.1
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Rect rect, Rect rect2) {
                Rect rect3 = rect;
                Rect rect4 = rect2;
                return (rect3.height() * rect3.width()) - (rect4.height() * rect4.width());
            }
        });
        Iterator<Rect> it = this.f17242a.iterator();
        while (it.hasNext()) {
            it.next().offset(-iArr[0], -iArr[1]);
        }
    }

    private static List<Rect> b(a aVar, List<a> list) {
        ArrayList arrayList = new ArrayList();
        for (a aVar2 : list) {
            arrayList.add(new Rect(aVar.f17245a, aVar2.f17245a, aVar.f17246b, aVar2.f17246b));
        }
        return arrayList;
    }

    public final float a() {
        float fHeight = 0.0f;
        for (Rect rect : this.f17242a) {
            fHeight += rect.height() * rect.width();
        }
        return fHeight;
    }

    private List<Integer> a(List<Rect> list) {
        ArrayList arrayList = new ArrayList();
        for (Rect rect : list) {
            arrayList.add(Integer.valueOf(rect.left));
            arrayList.add(Integer.valueOf(rect.right));
        }
        Collections.sort(arrayList, new Comparator<Integer>() { // from class: sg.bigo.ads.core.mraid.m.2
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Integer num, Integer num2) {
                return num.intValue() - num2.intValue();
            }
        });
        return arrayList;
    }

    private static List<a> a(List<a> list, a aVar) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            a aVar2 = list.get(i2);
            if (!aVar.a(aVar2)) {
                arrayList.add(aVar2);
            } else if (aVar.a(aVar2)) {
                int i8 = aVar.f17245a;
                int i9 = aVar2.f17245a;
                if (i8 >= i9) {
                    i8 = i9;
                }
                int i10 = aVar.f17246b;
                int i11 = aVar2.f17246b;
                if (i10 <= i11) {
                    i10 = i11;
                }
                aVar = new a(i8, i10);
            }
        }
        arrayList.add(aVar);
        return arrayList;
    }

    private static List<a> a(a aVar, List<Rect> list) {
        List<a> arrayList = new ArrayList<>();
        for (Rect rect : list) {
            if (aVar.f17245a < rect.right && aVar.f17246b > rect.left) {
                arrayList = a(arrayList, new a(rect.top, rect.bottom));
            }
        }
        return arrayList;
    }
}

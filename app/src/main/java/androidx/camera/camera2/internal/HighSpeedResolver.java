package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import android.util.Size;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.internal.utils.SizeUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class HighSpeedResolver {
    public static final Companion Companion = new Companion(null);
    public static final Range<Integer> DEFAULT_FPS = new Range<>(120, 120);
    private static final String TAG = "HighSpeedResolver";
    private final CameraCharacteristicsCompat characteristics;
    private final q5.f isHighSpeedSupported$delegate;
    private final q5.f maxSize$delegate;
    private final q5.f supportedSizes$delegate;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final boolean isHighSpeedOn(Collection<? extends AttachedSurfaceInfo> attachedSurfaces, Collection<? extends UseCaseConfig<?>> newUseCaseConfigs) {
            int i2;
            boolean z2;
            kotlin.jvm.internal.k.e(attachedSurfaces, "attachedSurfaces");
            kotlin.jvm.internal.k.e(newUseCaseConfigs, "newUseCaseConfigs");
            ArrayList arrayList = new ArrayList(r5.n.L0(attachedSurfaces, 10));
            Iterator<T> it = attachedSurfaces.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((AttachedSurfaceInfo) it.next()).getSessionType()));
            }
            ArrayList arrayList2 = new ArrayList(r5.n.L0(newUseCaseConfigs, 10));
            Iterator<T> it2 = newUseCaseConfigs.iterator();
            while (true) {
                i2 = 0;
                if (!it2.hasNext()) {
                    break;
                }
                arrayList2.add(Integer.valueOf(((UseCaseConfig) it2.next()).getSessionType(0)));
            }
            ArrayList arrayListF1 = r5.l.f1(arrayList2, arrayList);
            if (arrayListF1.isEmpty()) {
                z2 = false;
            } else {
                int size = arrayListF1.size();
                int i8 = 0;
                while (i8 < size) {
                    Object obj = arrayListF1.get(i8);
                    i8++;
                    if (((Number) obj).intValue() == 1) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
            }
            if (z2 && !arrayListF1.isEmpty()) {
                int size2 = arrayListF1.size();
                while (i2 < size2) {
                    Object obj2 = arrayListF1.get(i2);
                    i2++;
                    if (((Number) obj2).intValue() != 1) {
                        throw new IllegalArgumentException("All sessionTypes should be high-speed when any of them is high-speed");
                    }
                }
            }
            return z2;
        }

        private Companion() {
        }
    }

    public HighSpeedResolver(CameraCharacteristicsCompat characteristics) {
        kotlin.jvm.internal.k.e(characteristics, "characteristics");
        this.characteristics = characteristics;
        final int i2 = 0;
        this.isHighSpeedSupported$delegate = n7.b.C(new e6.a(this) { // from class: androidx.camera.camera2.internal.r0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ HighSpeedResolver f3514b;

            {
                this.f3514b = this;
            }

            @Override // e6.a
            public final Object invoke() {
                switch (i2) {
                    case 0:
                        return Boolean.valueOf(HighSpeedResolver.isHighSpeedSupported_delegate$lambda$1(this.f3514b));
                    case 1:
                        return HighSpeedResolver.maxSize_delegate$lambda$4(this.f3514b);
                    default:
                        return HighSpeedResolver.supportedSizes_delegate$lambda$5(this.f3514b);
                }
            }
        });
        final int i8 = 1;
        this.maxSize$delegate = n7.b.C(new e6.a(this) { // from class: androidx.camera.camera2.internal.r0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ HighSpeedResolver f3514b;

            {
                this.f3514b = this;
            }

            @Override // e6.a
            public final Object invoke() {
                switch (i8) {
                    case 0:
                        return Boolean.valueOf(HighSpeedResolver.isHighSpeedSupported_delegate$lambda$1(this.f3514b));
                    case 1:
                        return HighSpeedResolver.maxSize_delegate$lambda$4(this.f3514b);
                    default:
                        return HighSpeedResolver.supportedSizes_delegate$lambda$5(this.f3514b);
                }
            }
        });
        final int i9 = 2;
        this.supportedSizes$delegate = n7.b.C(new e6.a(this) { // from class: androidx.camera.camera2.internal.r0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ HighSpeedResolver f3514b;

            {
                this.f3514b = this;
            }

            @Override // e6.a
            public final Object invoke() {
                switch (i9) {
                    case 0:
                        return Boolean.valueOf(HighSpeedResolver.isHighSpeedSupported_delegate$lambda$1(this.f3514b));
                    case 1:
                        return HighSpeedResolver.maxSize_delegate$lambda$4(this.f3514b);
                    default:
                        return HighSpeedResolver.supportedSizes_delegate$lambda$5(this.f3514b);
                }
            }
        });
    }

    private final <T> List<T> findCommonElements(List<? extends List<? extends T>> list) {
        if (list.isEmpty()) {
            return r5.r.f13638a;
        }
        ArrayList arrayListO1 = r5.l.o1((Collection) r5.l.X0(list));
        Iterator<T> it = r5.l.V0(list).iterator();
        while (it.hasNext()) {
            arrayListO1.retainAll((List) it.next());
        }
        return arrayListO1;
    }

    private final List<Range<Integer>> getHighSpeedVideoFpsRangesFor(Size size) {
        Object objM;
        try {
            objM = this.characteristics.getStreamConfigurationMapCompat().getHighSpeedVideoFpsRangesFor(size);
        } catch (Throwable th) {
            objM = r2.q.M(th);
        }
        if (objM instanceof q5.j) {
            objM = null;
        }
        Range[] rangeArr = (Range[]) objM;
        return rangeArr != null ? r5.l.n1(r5.j.n0(rangeArr)) : r5.r.f13638a;
    }

    private final List<Size> getSupportedSizes() {
        return (List) this.supportedSizes$delegate.getValue();
    }

    public static final boolean isHighSpeedOn(Collection<? extends AttachedSurfaceInfo> collection, Collection<? extends UseCaseConfig<?>> collection2) {
        return Companion.isHighSpeedOn(collection, collection2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isHighSpeedSupported_delegate$lambda$1(HighSpeedResolver highSpeedResolver) {
        int[] iArr = (int[]) highSpeedResolver.characteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i2 : iArr) {
                if (i2 == 9) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Size maxSize_delegate$lambda$4(HighSpeedResolver highSpeedResolver) {
        List<Size> supportedSizes = highSpeedResolver.getSupportedSizes();
        if (supportedSizes.isEmpty()) {
            supportedSizes = null;
        }
        if (supportedSizes == null) {
            return null;
        }
        Iterator<T> it = supportedSizes.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            int area = SizeUtil.getArea((Size) next);
            do {
                Object next2 = it.next();
                int area2 = SizeUtil.getArea((Size) next2);
                if (area < area2) {
                    next = next2;
                    area = area2;
                }
            } while (it.hasNext());
        }
        return (Size) next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List supportedSizes_delegate$lambda$5(HighSpeedResolver highSpeedResolver) {
        Size[] highSpeedVideoSizes = highSpeedResolver.characteristics.getStreamConfigurationMapCompat().getHighSpeedVideoSizes();
        return highSpeedVideoSizes != null ? r5.j.n0(highSpeedVideoSizes) : r5.r.f13638a;
    }

    public final <T> Map<T, List<Size>> filterCommonSupportedSizes(Map<T, ? extends List<Size>> sizesMap) {
        kotlin.jvm.internal.k.e(sizesMap, "sizesMap");
        List<T> listFindCommonElements = findCommonElements(r5.l.n1(sizesMap.values()));
        ArrayList arrayList = new ArrayList();
        for (T t3 : listFindCommonElements) {
            if (getSupportedSizes().contains((Size) t3)) {
                arrayList.add(t3);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(r5.x.d0(sizesMap.size()));
        Iterator<T> it = sizesMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            List list = (List) entry.getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (arrayList.contains((Size) obj)) {
                    arrayList2.add(obj);
                }
            }
            linkedHashMap.put(key, arrayList2);
        }
        return linkedHashMap;
    }

    public final Range<Integer>[] getFrameRateRangesFor(List<Size> surfaceSizes) {
        kotlin.jvm.internal.k.e(surfaceSizes, "surfaceSizes");
        int size = surfaceSizes.size();
        if (1 > size || size >= 3 || r5.l.U0(surfaceSizes).size() != 1) {
            return null;
        }
        List<Range<Integer>> highSpeedVideoFpsRangesFor = getHighSpeedVideoFpsRangesFor(surfaceSizes.get(0));
        if (highSpeedVideoFpsRangesFor.isEmpty()) {
            highSpeedVideoFpsRangesFor = null;
        }
        if (highSpeedVideoFpsRangesFor == null) {
            return null;
        }
        if (surfaceSizes.size() == 2) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : highSpeedVideoFpsRangesFor) {
                Range range = (Range) obj;
                if (kotlin.jvm.internal.k.a(range.getLower(), range.getUpper())) {
                    arrayList.add(obj);
                }
            }
            highSpeedVideoFpsRangesFor = arrayList;
        }
        return (Range[]) highSpeedVideoFpsRangesFor.toArray(new Range[0]);
    }

    public final int getMaxFrameRate(Size size) {
        kotlin.jvm.internal.k.e(size, "size");
        List<Range<Integer>> highSpeedVideoFpsRangesFor = getHighSpeedVideoFpsRangesFor(size);
        if (highSpeedVideoFpsRangesFor.isEmpty()) {
            highSpeedVideoFpsRangesFor = null;
        }
        if (highSpeedVideoFpsRangesFor == null) {
            Logger.w(TAG, "No supported high speed  fps for " + size);
            return 0;
        }
        Iterator<T> it = highSpeedVideoFpsRangesFor.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Integer num = (Integer) ((Range) it.next()).getUpper();
        while (it.hasNext()) {
            Integer num2 = (Integer) ((Range) it.next()).getUpper();
            if (num.compareTo(num2) < 0) {
                num = num2;
            }
        }
        kotlin.jvm.internal.k.d(num, "maxOf(...)");
        return num.intValue();
    }

    public final Size getMaxSize() {
        return (Size) this.maxSize$delegate.getValue();
    }

    public final List<List<Size>> getSizeArrangements(List<? extends List<Size>> sizesList) {
        kotlin.jvm.internal.k.e(sizesList, "sizesList");
        if (sizesList.isEmpty()) {
            return r5.r.f13638a;
        }
        List<Size> listFindCommonElements = findCommonElements(sizesList);
        ArrayList arrayList = new ArrayList(r5.n.L0(listFindCommonElements, 10));
        for (Size size : listFindCommonElements) {
            int size2 = sizesList.size();
            ArrayList arrayList2 = new ArrayList(size2);
            for (int i2 = 0; i2 < size2; i2++) {
                arrayList2.add(size);
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    public final boolean isHighSpeedSupported() {
        return ((Boolean) this.isHighSpeedSupported$delegate.getValue()).booleanValue();
    }
}

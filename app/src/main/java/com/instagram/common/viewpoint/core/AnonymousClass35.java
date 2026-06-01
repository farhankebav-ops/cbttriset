package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.35, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnonymousClass35 {
    public static byte[] A0R;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public HashMap<C2120oH, C2115oC> A0G;
    public HashSet<Integer> A0H;
    public List<String> A0I;
    public List<String> A0J;
    public List<String> A0K;

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D56211926, support language flag in video track")
    public List<String> A0L;
    public List<String> A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;

    static {
        A0P();
    }

    public static String A0H(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0R, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 34);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0P() {
        A0R = new byte[]{63, 61, 44, 40, 53, 51, 50, 53, 50, 59};
    }

    @Deprecated
    public AnonymousClass35() {
        this.A06 = Integer.MAX_VALUE;
        this.A05 = Integer.MAX_VALUE;
        this.A04 = Integer.MAX_VALUE;
        this.A03 = Integer.MAX_VALUE;
        this.A0F = Integer.MAX_VALUE;
        this.A0E = Integer.MAX_VALUE;
        this.A0Q = true;
        this.A0M = MetaExoPlayerCustomizedCollections.A01();
        this.A0D = 0;
        this.A0L = MetaExoPlayerCustomizedCollections.A01();
        this.A0I = MetaExoPlayerCustomizedCollections.A01();
        this.A0B = 0;
        this.A02 = Integer.MAX_VALUE;
        this.A01 = Integer.MAX_VALUE;
        this.A0J = MetaExoPlayerCustomizedCollections.A01();
        this.A0K = MetaExoPlayerCustomizedCollections.A01();
        this.A0C = 0;
        this.A00 = 0;
        this.A0P = false;
        this.A0O = false;
        this.A0N = false;
        this.A0G = new HashMap<>();
        this.A0H = new HashSet<>();
    }

    public AnonymousClass35(Context context) {
        this();
        A0n(context);
        A0o(context, true);
    }

    public AnonymousClass35(Bundle bundle) {
        List listA01;
        this.A06 = bundle.getInt(C2113oA.A0e, C2113oA.A0U.A06);
        this.A05 = bundle.getInt(C2113oA.A0d, C2113oA.A0U.A05);
        this.A04 = bundle.getInt(C2113oA.A0c, C2113oA.A0U.A04);
        this.A03 = bundle.getInt(C2113oA.A0b, C2113oA.A0U.A03);
        this.A0A = bundle.getInt(C2113oA.A0i, C2113oA.A0U.A0A);
        this.A09 = bundle.getInt(C2113oA.A0h, C2113oA.A0U.A09);
        this.A08 = bundle.getInt(C2113oA.A0n(), C2113oA.A0U.A08);
        this.A07 = bundle.getInt(C2113oA.A0f, C2113oA.A0U.A07);
        this.A0F = bundle.getInt(C2113oA.A0v, C2113oA.A0U.A0F);
        this.A0E = bundle.getInt(C2113oA.A0t, C2113oA.A0U.A0E);
        this.A0Q = bundle.getBoolean(C2113oA.A0u, C2113oA.A0U.A0Q);
        this.A0M = AbstractC0621Am.A07((String[]) AbstractC1811j1.A00(bundle.getStringArray(C2113oA.A0p), new String[0]));
        this.A0D = bundle.getInt(C2113oA.A0q, C2113oA.A0U.A0D);
        String[] preferredVideoLanguages1 = (String[]) AbstractC1811j1.A00(bundle.getStringArray(C2113oA.A0o), new String[0]);
        this.A0L = A0G(preferredVideoLanguages1);
        String[] preferredVideoLanguages12 = new String[0];
        this.A0I = A0G((String[]) AbstractC1811j1.A00(bundle.getStringArray(C2113oA.A0j), preferredVideoLanguages12));
        this.A0B = bundle.getInt(C2113oA.A0l, C2113oA.A0U.A0B);
        this.A02 = bundle.getInt(C2113oA.A0a, C2113oA.A0U.A02);
        this.A01 = bundle.getInt(C2113oA.A0Z, C2113oA.A0U.A01);
        String[] preferredVideoLanguages13 = new String[0];
        this.A0J = AbstractC0621Am.A07((String[]) AbstractC1811j1.A00(bundle.getStringArray(C2113oA.A0k), preferredVideoLanguages13));
        String[] preferredVideoLanguages14 = new String[0];
        this.A0K = A0G((String[]) AbstractC1811j1.A00(bundle.getStringArray(C2113oA.A0m), preferredVideoLanguages14));
        this.A0C = bundle.getInt(C2113oA.A0n, C2113oA.A0U.A0C);
        this.A00 = bundle.getInt(C2113oA.A0e(), C2113oA.A0U.A00);
        this.A0P = bundle.getBoolean(C2113oA.A0s, C2113oA.A0U.A0P);
        this.A0O = bundle.getBoolean(C2113oA.A0X, C2113oA.A0U.A0O);
        this.A0N = bundle.getBoolean(C2113oA.A0W, C2113oA.A0U.A0N);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(C2113oA.A0r);
        if (parcelableArrayList == null) {
            listA01 = MetaExoPlayerCustomizedCollections.A01();
        } else {
            listA01 = C3S.A01(C2115oC.A02, parcelableArrayList);
        }
        this.A0G = new HashMap<>();
        for (int i2 = 0; i2 < listA01.size(); i2++) {
            C2115oC c2115oC = (C2115oC) listA01.get(i2);
            this.A0G.put(c2115oC.A00, c2115oC);
        }
        int[] iArr = (int[]) AbstractC1811j1.A00(bundle.getIntArray(C2113oA.A0V), new int[0]);
        this.A0H = new HashSet<>();
        for (int i8 : iArr) {
            this.A0H.add(Integer.valueOf(i8));
        }
    }

    public AnonymousClass35(C2113oA c2113oA) {
        A0R(c2113oA);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1h != com.google.common.collect.ImmutableList$Builder<java.lang.String> */
    public static AbstractC0621Am<String> A0G(String[] strArr) {
        C03971h c03971hA01 = AbstractC0621Am.A01();
        for (String str : (String[]) C3M.A01(strArr)) {
            c03971hA01.A04(AbstractC04664a.A0k((String) C3M.A01(str)));
        }
        return c03971hA01.A05();
    }

    private void A0Q(Context context) {
        CaptioningManager captioningManager;
        if ((AbstractC04664a.A02 < 23 && Looper.myLooper() == null) || (captioningManager = (CaptioningManager) context.getSystemService(A0H(0, 10, 126))) == null || !captioningManager.isEnabled()) {
            return;
        }
        this.A0C = 1088;
        Locale locale = captioningManager.getLocale();
        if (locale != null) {
            this.A0K = AbstractC0621Am.A04(AbstractC04664a.A0o(locale));
        }
    }

    @EnsuresNonNull({"preferredVideoMimeTypes", "preferredAudioLanguages", "preferredAudioMimeTypes", "preferredTextLanguages", "overrides", "disabledTrackTypes"})
    private void A0R(C2113oA c2113oA) {
        this.A06 = c2113oA.A06;
        this.A05 = c2113oA.A05;
        this.A04 = c2113oA.A04;
        this.A03 = c2113oA.A03;
        this.A0A = c2113oA.A0A;
        this.A09 = c2113oA.A09;
        this.A08 = c2113oA.A08;
        this.A07 = c2113oA.A07;
        this.A0F = c2113oA.A0F;
        this.A0E = c2113oA.A0E;
        this.A0Q = c2113oA.A0Q;
        this.A0M = c2113oA.A0M;
        this.A0D = c2113oA.A0D;
        this.A0L = c2113oA.A0L;
        this.A0I = c2113oA.A0I;
        this.A0B = c2113oA.A0B;
        this.A02 = c2113oA.A02;
        this.A01 = c2113oA.A01;
        this.A0J = c2113oA.A0J;
        this.A0K = c2113oA.A0K;
        this.A0C = c2113oA.A0C;
        this.A00 = c2113oA.A00;
        this.A0P = c2113oA.A0P;
        this.A0O = c2113oA.A0O;
        this.A0N = c2113oA.A0N;
        this.A0H = new HashSet<>(c2113oA.A0H);
        this.A0G = new HashMap<>(c2113oA.A0G);
    }

    public AnonymousClass35 A0W(C2113oA c2113oA) {
        A0R(c2113oA);
        return this;
    }

    public AnonymousClass35 A0m(int i2, int i8, boolean z2) {
        this.A0F = i2;
        this.A0E = i8;
        this.A0Q = z2;
        return this;
    }

    public AnonymousClass35 A0n(Context context) {
        if (AbstractC04664a.A02 >= 19) {
            A0Q(context);
        }
        return this;
    }

    public AnonymousClass35 A0o(Context context, boolean z2) {
        Point viewportSize = AbstractC04664a.A0W(context);
        return A0m(viewportSize.x, viewportSize.y, z2);
    }

    public C2113oA A0p() {
        return new C2113oA(this);
    }
}

package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.ads.Ad;
import com.facebook.ads.AdSettings;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.internal.api.AdNativeComponentView;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeAdImageApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1020Qc implements Ad, NativeAdBaseApi, Repairable, InterfaceC1143Ux {
    public static SF A0k;
    public static byte[] A0l;
    public static String[] A0m = {"0QrYY16WpsBKaBkyPEA33iBIoR05UhVT", "YnnsFrkLVth43aFbA8XanJ7Af1ELV", "Oxqa2FUUnPLQ7GUfsty3Y0efzjvyqNtk", "SIKP4BEcnF1kam64buW5uj4ZKlEjFxDR", "vEVPI6RQ4lovzpZyrpWOxFDddvUHwWNp", "NGWOmnzpb", "djSS0JJWnZq1rlBsvyeXY9GnDKzed", "NhvbMWoFDj5W6o0bWnGe4dztWB8buZER"};
    public static final String A0n;
    public static final WeakHashMap<View, WeakReference<C1020Qc>> A0o;
    public long A00;
    public Drawable A01;
    public View.OnTouchListener A02;
    public View A03;
    public View A04;
    public View A05;
    public View A06;
    public NativeAdLayout A07;
    public EnumC0919Mc A08;
    public C1762iC A09;
    public C05406w A0A;
    public C1717hK A0B;
    public SL A0C;
    public TF A0D;
    public EnumC1131Ul A0E;
    public ViewOnClickListenerC1050Rg A0F;
    public QQ A0G;
    public C1137Ur A0H;
    public EnumC1138Us A0I;
    public V6 A0J;
    public YX A0K;
    public C1259Zm A0L;
    public C1388bt A0M;
    public C1453cw A0N;
    public AbstractC1549eW A0O;
    public AbstractC1549eW A0P;
    public C1550eX A0Q;
    public C1550eX A0R;
    public String A0S;
    public String A0T;
    public WeakReference<C1637fx> A0U;
    public WeakReference<AbstractC1549eW> A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public C1773iN A0a;
    public final SF A0b;
    public final C1477dL A0c;
    public final InterfaceC1134Uo A0d;
    public final C1145Uz A0e;
    public final XH A0f;
    public final String A0g;
    public final String A0h;
    public final List<View> A0i;
    public volatile boolean A0j;

    public static String A0W(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0l, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 112);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0e() {
        A0l = new byte[]{-32, 26, 38, 31, 30, -17, -17, 29, 32, -19, -12, 34, -15, -25, 26, -27, 25, 25, -28, 21, -22, -74, -70, -30, -78, -30, -78, -25, -29, 38, 73, 5, 83, 84, 89, 5, 81, 84, 70, 73, 74, 73, -25, 10, -6, 11, 19, 22, 18, 7, 26, 11, -58, -51, -53, 25, -51, -58, 15, 25, -58, 20, 21, 26, -58, 7, -58, 20, 7, 26, 15, 28, 11, -58, 7, 10, -33, -37, -38, 14, -3, 2, -2, 7, -4, -2, -25, -2, 13, 16, 8, 11, 4, -27, 0, 8, 11, 4, 3, -65, 19, 14, -65, 11, 14, 0, 3, -65, -20, 4, 3, 8, 0, -51, -16, 11, 19, 22, 15, 14, -54, 30, 25, -54, 25, 12, 30, 11, 19, 24, -54, 30, 15, 23, 26, 22, 11, 30, 15, -54, -13, -18, -54, 16, 28, 25, 23, -54, 12, 19, 14, -54, 26, 11, 35, 22, 25, 11, 14, -54, -47, -49, 29, -47, -23, 14, 20, 5, 18, 14, 1, 12, -64, 5, 18, 18, 15, 18, -50, -86, 30, 67, 75, 54, 65, 62, 57, -11, 72, 58, 73, -11, 68, 59, -11, 56, 65, 62, 56, 64, 54, 55, 65, 58, -11, 75, 62, 58, 76, 72, 0, 24, 23, 28, 20, 9, 28, 24, 42, -45, 25, 34, 37, -45, 28, 22, 34, 33, -45, 28, 38, -45, 28, 38, -45, 32, 28, 38, 38, 28, 33, 26, -31, 29, 53, 52, 57, 49, 38, 57, 53, 71, -16, 57, 67, -16, 61, 57, 67, 67, 57, 62, 55, -2, 51, 91, 89, 90, 6, 86, 88, 85, 92, 79, 74, 75, 6, 71, 6, 60, 79, 75, 93, 35, 54, 73, 62, 75, 58, -11, 22, 57, -11, 76, 54, 72, -11, 54, 65, 71, 58, 54, 57, 78, -11, 71, 58, 60, 62, 72, 73, 58, 71, 58, 57, -11, 76, 62, 73, 61, -11, 54, -11, 43, 62, 58, 76, 3, -11, 22, 74, 73, 68, -11, 74, 67, 71, 58, 60, 62, 72, 73, 58, 71, 62, 67, 60, -11, 54, 67, 57, -11, 69, 71, 68, 56, 58, 58, 57, 62, 67, 60, 3, -55, -36, -17, -28, -15, -32, -101, -36, -33, -101, -33, -32, -18, -17, -19, -22, -12, -32, -33, -39, -20, -1, -12, 1, -16, -85, -20, -17, -85, -9, -6, -20, -17, -85, -3, -16, -4, 0, -16, -2, -1, -16, -17, -22, -3, -7, 11, -76, -11, 0, 6, -7, -11, -8, 13, -76, 6, -7, -5, -3, 7, 8, -7, 6, -7, -8, -76, 11, -3, 8, -4, -76, -11, -76, -30, -11, 8, -3, 10, -7, -43, -8, -62, -76, -43, 9, 8, 3, -76, 9, 2, 6, -7, -5, -3, 7, 8, -7, 6, -3, 2, -5, -76, -11, 2, -8, -76, 4, 6, 3, -9, -7, -7, -8, -3, 2, -5, -62, -1, 18, 14, 32, -55, 23, 24, 29, -55, 27, 14, 16, 18, 28, 29, 14, 27, 14, 13, -55, 32, 18, 29, 17, -55, 29, 17, 18, 28, -55, -9, 10, 29, 18, 31, 14, -22, 13, 46, 49, -19, 58, 50, 49, 54, 46, -19, 65, 70, 61, 50, -19, 54, 64, -19, 59, 60, 65, -19, 64, 66, 61, 61, 60, 63, 65, 50, 49, -5, 54, 69, 62, 51, 52, 66, 67, 65, 62, 72, 81, 84, 70, 73, 38, 73, 69, 72, 58, 61, 26, 61, 1, 2, -7, 60, 58, 69, 69, 62, 61, -7, 70, 72, 75, 62, -7, 77, 65, 58, 71, -7, 72, 71, 60, 62, -27, -40, -21, -32, -19, -36};
        String[] strArr = A0m;
        if (strArr[6].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A0m[3] = "WbNUBB1XQVUYjPuN5kyqwH0pcEyoS9gz";
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 24 out of bounds for length 17
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0332 A[LOOP:0: B:109:0x032c->B:111:0x0332, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x025e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0g(android.view.View r13, android.view.View r14, java.util.List<android.view.View> r15, boolean r16) {
        /*
            Method dump skipped, instruction units count: 1208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1020Qc.A0g(android.view.View, android.view.View, java.util.List, boolean):void");
    }

    static {
        A0e();
        A0n = C1020Qc.class.getSimpleName();
        A0o = new WeakHashMap<>();
    }

    public C1020Qc(Context context, String str, InterfaceC1134Uo interfaceC1134Uo, boolean z2) {
        this.A0h = UUID.randomUUID().toString();
        this.A0J = V6.A06;
        this.A0E = EnumC1131Ul.A04;
        this.A08 = EnumC0919Mc.A03;
        this.A0U = new WeakReference<>(null);
        this.A0i = new ArrayList();
        this.A0f = new XH();
        this.A0Z = false;
        this.A0Y = false;
        this.A00 = -1L;
        if (context instanceof C1477dL) {
            this.A0c = (C1477dL) context;
        } else if (!z2) {
            this.A0c = RB.A04(context);
        } else {
            this.A0c = RB.A03(context);
        }
        this.A0c.A0O(this);
        this.A0g = str;
        this.A0d = interfaceC1134Uo;
        if (A0k != null) {
            this.A0b = A0k;
        } else {
            this.A0b = new SF(this.A0c);
        }
        this.A05 = new View(context);
        this.A0e = new C1145Uz(this.A0c, this);
    }

    public C1020Qc(C1020Qc c1020Qc) {
        this((Context) c1020Qc.A0c, (String) null, c1020Qc.A0d, true);
        this.A0D = c1020Qc.A0D;
        this.A0a = c1020Qc.A0a;
        this.A0B = c1020Qc.A0B;
        this.A0j = true;
        this.A05 = new View(this.A0c);
    }

    public C1020Qc(C1477dL c1477dL, C1773iN c1773iN, TF tf, InterfaceC1134Uo interfaceC1134Uo) {
        this((Context) c1477dL, (String) null, interfaceC1134Uo, true);
        this.A0a = c1773iN;
        this.A0D = tf;
        this.A0j = true;
        this.A05 = new View(c1477dL);
    }

    public C1020Qc(C1477dL c1477dL, C1773iN c1773iN, TF tf, InterfaceC1134Uo interfaceC1134Uo, C1717hK c1717hK) {
        this(c1477dL, c1773iN, tf, interfaceC1134Uo);
        this.A0B = c1717hK;
    }

    private int A00() {
        if (this.A0D != null) {
            return this.A0D.A04();
        }
        if (this.A0A == null || this.A0A.A0J() == null) {
            return 1;
        }
        TF tfA0J = this.A0A.A0J();
        String[] strArr = A0m;
        String str = strArr[6];
        String str2 = strArr[1];
        int length = str.length();
        int viewabilityThreshold = str2.length();
        if (length != viewabilityThreshold) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0m;
        strArr2[2] = "P5kYLn6xwAUrjDfDuw88TuaVt88D3vtD";
        strArr2[7] = "ZJzVQNISDO4cH7XUZ38T2d7bCdM1k8uN";
        return tfA0J.A04();
    }

    private int A01() {
        if (this.A0D != null) {
            return this.A0D.A07();
        }
        if (this.A0a != null) {
            return this.A0a.A0C();
        }
        if (this.A0A != null && this.A0A.A0J() != null) {
            return this.A0A.A0J().A07();
        }
        return 0;
    }

    private int A02() {
        if (this.A0D != null) {
            return this.A0D.A08();
        }
        if (this.A0a != null) {
            return this.A0a.A0D();
        }
        if (this.A0A != null && this.A0A.A0J() != null) {
            return this.A0A.A0J().A08();
        }
        return 1000;
    }

    private int A03() {
        if (this.A0D != null) {
            return this.A0D.A09();
        }
        C05406w c05406w = this.A0A;
        if (A0m[3].charAt(5) != 'B') {
            throw new RuntimeException();
        }
        A0m[5] = "Xt";
        if (c05406w == null || this.A0A.A0J() == null) {
            return 0;
        }
        return this.A0A.A0J().A09();
    }

    public static Drawable A05(C1477dL c1477dL, Bitmap bitmap, boolean z2, String str) {
        BitmapDrawable bitmapDrawableA00;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(c1477dL.getResources(), bitmap);
        if (z2 && (bitmapDrawableA00 = AbstractC1452cv.A00(c1477dL, str)) != null) {
            Drawable iconViewDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawableA00});
            return iconViewDrawable;
        }
        return bitmapDrawable;
    }

    public static NativeAdBase A0A(Context context, String str, String str2) throws V2 {
        V6 v6A00 = VB.A00(str2);
        if (v6A00 != null) {
            V6 template = V6.A05;
            if (v6A00 == template) {
                return new NativeBannerAd(context, str);
            }
            V6 template2 = V6.A06;
            if (v6A00 == template2) {
                return new NativeAd(context, str);
            }
            throw new V2(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0W(42, 34, 54), v6A00));
        }
        throw new V2(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0W(114, 50, 58), str2));
    }

    private final C1773iN A0C() {
        C1773iN c1773iN = this.A0a;
        if (c1773iN != null && c1773iN.A0R()) {
            return c1773iN;
        }
        return null;
    }

    private C1761iB A0F() {
        return A0G(false);
    }

    private C1761iB A0G(boolean z2) {
        if (this.A0a != null) {
            C1773iN c1773iN = this.A0a;
            if (A0m[3].charAt(5) == 'B') {
                String[] strArr = A0m;
                strArr[0] = "rkQiEYXoMEhriwkmxTS9YqbekXjRctvV";
                strArr[4] = "aQIgqL6bCxVEsMgFZvYj1f08oAvgjHgO";
                if (c1773iN.A0R()) {
                    if (z2) {
                        C1773iN c1773iN2 = this.A0a;
                        if (A0m[3].charAt(5) == 'B') {
                            A0m[3] = "EWl26Bqfon8mX0lHHC6z05409Pwx5AXq";
                            c1773iN2.A0I();
                        }
                    }
                    return this.A0a.A0E();
                }
            }
            throw new RuntimeException();
        }
        return new C1761iB();
    }

    public static S3 A0K() {
        return new S3();
    }

    public static C1020Qc A0L(NativeAdBaseApi nativeAdBaseApi) {
        if (nativeAdBaseApi instanceof Proxy) {
            return (C1020Qc) ((C1039Qv) Proxy.getInvocationHandler(nativeAdBaseApi)).A04();
        }
        return (C1020Qc) nativeAdBaseApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* JADX INFO: renamed from: A0M, reason: merged with bridge method [inline-methods] */
    public final C1135Up getAdChoicesIcon() {
        return A0F().A0D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* JADX INFO: renamed from: A0O, reason: merged with bridge method [inline-methods] */
    public final C1136Uq getAdStarRating() {
        return A0F().A0G();
    }

    private AdPlacementType A0R() {
        if (this.A0J == V6.A06) {
            return AdPlacementType.NATIVE;
        }
        return AdPlacementType.NATIVE_BANNER;
    }

    private void A0a() {
        for (View view : this.A0i) {
            view.setOnClickListener(null);
            if (A0m[3].charAt(5) != 'B') {
                throw new RuntimeException();
            }
            A0m[3] = "reBfvBMaH6BqwlxZ2WqAQZq3knZpIvyz";
            view.setOnTouchListener(null);
            view.setOnLongClickListener(null);
        }
        this.A0i.clear();
    }

    private void A0b() {
        if (!TextUtils.isEmpty(getAdChoicesLinkUrl())) {
            WN.A0O(new WN(), this.A0c, WQ.A00(getAdChoicesLinkUrl()), A1C());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0c() {
        this.A0f.A05();
        this.A0e.A05();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0d() {
        if (this.A0Q != null) {
            this.A0Q.A0V();
            this.A0c.A0F().AC0();
            this.A0Q = null;
        }
    }

    public static void A0f(Drawable drawable, ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        if (A0m[3].charAt(5) != 'B') {
            throw new RuntimeException();
        }
        String[] strArr = A0m;
        strArr[6] = "LXDT52DRzEPuIKBbeK5QN38hLQjcy";
        strArr[1] = "Z1aNossC2MxjaxQyIIrn4vHalGw3J";
        imageView.setBackground(null);
    }

    private void A0h(FrameLayout frameLayout, String str) {
        if (this.A0N != null) {
            frameLayout.removeView(this.A0N);
        }
        this.A0N = AbstractC1452cv.A01(RB.A03(this.A0c), str);
        if (this.A0N != null) {
            frameLayout.addView(this.A0N, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(this.A0N);
        }
    }

    private void A0i(C1773iN c1773iN, boolean z2) {
        if (c1773iN == null) {
            return;
        }
        boolean zEquals = this.A0E.equals(EnumC1131Ul.A04);
        String strA0W = A0W(596, 6, 7);
        if (zEquals) {
            C1761iB c1761iBA0E = c1773iN.A0E();
            String clientToken = c1773iN.A7G();
            if (!TextUtils.isEmpty(clientToken)) {
                this.A0b.A0e(new C1120Ua(clientToken, this.A0c.A0A()));
            }
            C1135Up c1135UpA0F = c1761iBA0E.A0F();
            String[] strArr = A0m;
            if (strArr[2].charAt(3) == strArr[7].charAt(3)) {
                throw new RuntimeException();
            }
            A0m[3] = "olK6BBrMvSH2F6L4J2jXYHYWLLMocGr7";
            if (c1135UpA0F != null) {
                SD sd = new SD(c1761iBA0E.A0F().getUrl(), c1761iBA0E.A0F().getHeight(), c1761iBA0E.A0F().getWidth(), c1773iN.A0G(), A0W(596, 6, 7));
                sd.A01 = this.A0C;
                this.A0b.A0W();
                this.A0b.A0c(sd);
            }
            if (!this.A0J.equals(V6.A05)) {
                if (c1761iBA0E.A0E() != null) {
                    this.A0b.A0c(new SD(c1761iBA0E.A0E().getUrl(), c1761iBA0E.A0E().getHeight(), c1761iBA0E.A0E().getWidth(), c1773iN.A0G(), A0W(596, 6, 7)));
                }
                if (c1773iN.A0H() != null) {
                    for (C1020Qc c1020Qc : c1773iN.A0H()) {
                        if (c1020Qc.getAdCoverImage() != null) {
                            this.A0b.A0c(new SD(c1020Qc.getAdCoverImage().getUrl(), c1020Qc.getAdCoverImage().getHeight(), c1020Qc.getAdCoverImage().getWidth(), c1773iN.A0G(), A0W(596, 6, 7)));
                        }
                    }
                }
                String strA0b = c1761iBA0E.A0b();
                if (!TextUtils.isEmpty(strA0b)) {
                    this.A0b.A0b(new SB(strA0b, c1773iN.A0G(), A0W(596, 6, 7), c1761iBA0E.A0A()));
                }
            }
            AbstractC1752hy abstractC1752hyA0C = c1761iBA0E.A0C();
            if (abstractC1752hyA0C != null && abstractC1752hyA0C.A1Y()) {
                SB sb = new SB(abstractC1752hyA0C.A0s(), abstractC1752hyA0C.A17(), strA0W);
                sb.A04 = true;
                sb.A03 = A0W(0, 5, 66);
                this.A0b.A0Y(sb);
            }
        }
        this.A0b.A0X(new T7(this, c1773iN, z2), new S8(c1773iN.A0G(), strA0W));
    }

    private void A0j(InterfaceC0921Me interfaceC0921Me) {
        if (this.A0a == null) {
            return;
        }
        this.A0a.A0K(interfaceC0921Me);
    }

    public static void A0k(NativeAdImageApi nativeAdImageApi, ImageView imageView, C1477dL c1477dL) {
        if (nativeAdImageApi != null && imageView != null) {
            new KZ(imageView, c1477dL).A05(nativeAdImageApi.getHeight(), nativeAdImageApi.getWidth()).A07(nativeAdImageApi.getUrl());
        }
    }

    private final void A0n(QQ qq) {
        this.A0G = qq;
    }

    private final void A0o(String str) {
        this.A0S = str;
    }

    private void A0p(List<View> list, View view) {
        if (this.A0d != null && this.A0d.AJD(view)) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                A0p(list, viewGroup.getChildAt(i2));
            }
            return;
        }
        list.add(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0q() {
        return A19() == EnumC1140Uu.A05 || A19() == EnumC1140Uu.A03;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0r() {
        return A0F().A0e();
    }

    public final long A0y() {
        return this.A00;
    }

    public final C1773iN A0z() {
        return this.A0a;
    }

    public final AbstractC1752hy A10() {
        return A0F().A0C();
    }

    public final SF A11() {
        return this.A0b;
    }

    public final C1477dL A12() {
        return this.A0c;
    }

    public final ViewOnClickListenerC1050Rg A13() {
        return this.A0F;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* JADX INFO: renamed from: A14, reason: merged with bridge method [inline-methods] */
    public final C1135Up getAdCoverImage() {
        return A0F().A0E();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* JADX INFO: renamed from: A15, reason: merged with bridge method [inline-methods] */
    public final C1135Up getAdIcon() {
        return A0F().A0F();
    }

    public final QQ A16() {
        return this.A0G;
    }

    public final C1137Ur A17() {
        return this.A0H;
    }

    public final EnumC1138Us A18() {
        return this.A0I;
    }

    public final EnumC1140Uu A19() {
        return A0F().A0H();
    }

    public final XH A1A() {
        return this.A0f;
    }

    public final C1550eX A1B() {
        return this.A0R;
    }

    public final String A1C() {
        if (this.A0a == null || !isAdLoaded()) {
            return null;
        }
        return this.A0a.A7G();
    }

    public final String A1D() {
        return this.A0T;
    }

    public final String A1E() {
        return A0G(true).A0N();
    }

    public final String A1F() {
        return A0G(true).A0O();
    }

    public final String A1G() {
        return A0F().A0a();
    }

    public final String A1H() {
        if (this.A0a == null || TextUtils.isEmpty(this.A0a.A0E().A0b())) {
            return null;
        }
        return this.A0b.A0T(this.A0a.A0E().A0b());
    }

    public final List<C1020Qc> A1I() {
        if (this.A0a == null || !isAdLoaded()) {
            return null;
        }
        return this.A0a.A0H();
    }

    public final void A1J() {
        if (!O3.A00(this.A0c.A02()).A0O(this.A0c, false)) {
            A0b();
            if (A0m[5].length() == 3) {
                throw new RuntimeException();
            }
            A0m[3] = "yREZ0BSYt8CSunaR9f1myx0zIAs3a5bO";
            return;
        }
        AbstractC1224Yd abstractC1224YdA01 = AbstractC1225Ye.A01(this.A0c, this.A0c.A0A(), A1C(), this.A07);
        if (abstractC1224YdA01 == null) {
            A0b();
        } else {
            ((C1620fg) this.A07.getNativeAdLayoutApi()).A03(abstractC1224YdA01);
            abstractC1224YdA01.A0M();
        }
    }

    public final void A1K(Drawable drawable) {
        this.A01 = drawable;
        A1f(drawable != null, true);
    }

    public final void A1L(View view) {
        this.A0i.add(view);
        view.setOnClickListener(this.A0F);
        view.setOnTouchListener(this.A0F);
        if (U7.A1B(view.getContext())) {
            view.setOnLongClickListener(this.A0F);
        }
    }

    public final void A1M(View view, ImageView imageView) {
        ArrayList arrayList = new ArrayList();
        A0p(arrayList, view);
        A0g(view, imageView, arrayList, true);
    }

    public final void A1N(View view, ImageView imageView, List<View> clickableViews) {
        A0g(view, imageView, clickableViews, true);
    }

    public final void A1O(View view, AdNativeComponentView adNativeComponentView) {
        ArrayList arrayList = new ArrayList();
        A0p(arrayList, view);
        A0g(view, adNativeComponentView, arrayList, false);
    }

    public final void A1P(View view, AdNativeComponentView adNativeComponentView, List<View> clickableViews) {
        A0g(view, adNativeComponentView, clickableViews, false);
    }

    public final void A1Q(View view, AdNativeComponentView adNativeComponentView, List<View> clickableViews, boolean z2) {
        A0g(view, adNativeComponentView, clickableViews, z2);
    }

    public final void A1R(View view, AdNativeComponentView adNativeComponentView, boolean z2) {
        List<View> clickableViews = new ArrayList<>();
        A0p(clickableViews, view);
        A0g(view, adNativeComponentView, clickableViews, z2);
    }

    public final void A1S(MediaView mediaView) {
        if (mediaView != null) {
            this.A0Y = true;
        }
    }

    public final void A1T(MediaView mediaView) {
        if (mediaView != null) {
            this.A0Z = true;
        }
    }

    public final void A1U(NativeAdBase nativeAdBase, NativeAdListener nativeAdListener) {
        if (nativeAdListener == null) {
            return;
        }
        A0n(new C6I(nativeAdListener, nativeAdBase));
    }

    public final void A1V(NativeAdLayout nativeAdLayout) {
        this.A07 = nativeAdLayout;
    }

    public final void A1W(C1773iN c1773iN) {
        A0i(c1773iN, true);
        if (this.A0G != null && c1773iN.A0H() != null) {
            T9 t9 = new T9(this);
            for (C1020Qc c1020Qc : c1773iN.A0H()) {
                if (A0m[3].charAt(5) != 'B') {
                    throw new RuntimeException();
                }
                String[] strArr = A0m;
                strArr[0] = "7JUEXy8BV6wMe69mvRG8Hisl1h58kfsH";
                strArr[4] = "Ag7M0cktqfZPxcWhbEyn8XCMGlxm5ALn";
                c1020Qc.A0j(t9);
            }
        }
    }

    public final void A1X(C1637fx c1637fx) {
        this.A0U = new WeakReference<>(c1637fx);
    }

    public final void A1Y(EnumC1131Ul enumC1131Ul, String str, SL sl) {
        if (str == null) {
            this.A0c.A0F().A3I();
        } else {
            this.A0c.A0F().A3H();
        }
        this.A00 = System.currentTimeMillis();
        boolean z2 = this.A0j;
        String[] strArr = A0m;
        if (strArr[0].charAt(21) != strArr[4].charAt(21)) {
            String[] strArr2 = A0m;
            strArr2[0] = "knecuAJjZigTf7VsFCGhTGCW7dxKplKn";
            strArr2[4] = "uRrNlLGUJL1gxvEKewtOLFu1Ztix0dl1";
            if (z2) {
                AdSettings.IntegrationErrorMode integrationErrorModeA00 = NW.A00(this.A0c);
                String strA0W = A0W(566, 30, 105);
                AdSettings.IntegrationErrorMode integrationErrorMode = AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE;
                if (!integrationErrorMode.equals(integrationErrorModeA00)) {
                    V1 v12 = new V1(AdErrorType.LOAD_AD_CALLED_MORE_THAN_ONCE, A0W(566, 30, 105));
                    A12().A0F().A3F(XG.A01(this.A00), v12.A03().getErrorCode(), v12.A04());
                    if (this.A0G != null) {
                        this.A0G.ADB(v12);
                    } else {
                        Log.e(A0W(76, 17, 41), strA0W);
                    }
                    C1091Sw c1091Sw = new C1091Sw(strA0W);
                    A12().A08().AAy(A0W(550, 3, 101), AbstractC1090Sv.A0c, c1091Sw);
                } else {
                    throw new C0943Nb(strA0W);
                }
            }
            this.A0j = true;
            this.A0E = enumC1131Ul;
            if (enumC1131Ul.equals(EnumC1131Ul.A05)) {
                EnumC0919Mc enumC0919Mc = EnumC0919Mc.A05;
                if (A0m[3].charAt(5) == 'B') {
                    A0m[3] = "N11XMBa1eBkGGouoRChlRsXEwEtHvHDZ";
                    this.A08 = enumC0919Mc;
                }
            }
            this.A0C = sl;
            NT nt = new NT(this.A0g, this.A0J, A0R(), null, 1, new C1709hB());
            nt.A05(enumC1131Ul);
            nt.A06(this.A0S);
            nt.A07(this.A0T);
            this.A0A = new C05406w(this.A0c, nt);
            this.A0A.A0S(new TA(this));
            this.A0A.A0W(str);
            return;
        }
        throw new RuntimeException();
    }

    public final void A1Z(C1137Ur c1137Ur) {
        this.A0H = c1137Ur;
    }

    public final void A1a(EnumC1138Us enumC1138Us) {
        this.A0I = enumC1138Us;
    }

    public final void A1b(V6 v62) {
        if (!A0r()) {
            if (V6.A05.equals(v62)) {
                this.A0c.A0F().A3L(AdPlacementType.NATIVE_BANNER.toString(), this.A0g);
            } else {
                this.A0c.A0F().A3L(AdPlacementType.NATIVE.toString(), this.A0g);
            }
        }
        this.A0J = v62;
    }

    public final void A1c(AbstractC1549eW abstractC1549eW) {
        this.A0V = new WeakReference<>(abstractC1549eW);
    }

    public final void A1d(boolean z2) {
        this.A0W = z2;
    }

    public final void A1e(boolean z2) {
        this.A0X = z2;
    }

    public final void A1f(boolean z2, boolean z7) {
        String strA0W;
        if (z2) {
            if (this.A0E.equals(EnumC1131Ul.A05)) {
                boolean zA0r = A0r();
                if (A0m[3].charAt(5) != 'B') {
                    throw new RuntimeException();
                }
                String[] strArr = A0m;
                strArr[6] = "maLBxQjysuwmJ75m3YPaJDHU5JlBu";
                strArr[1] = "hXXEi4DazsshJWFEyRiAh7tUxgC1d";
                if (!zA0r && this.A0G != null) {
                    this.A0G.AEB();
                }
            }
            if (this.A0R != null) {
                this.A0R.A0U();
                this.A0e.A09();
                return;
            }
            return;
        }
        if (this.A0R != null) {
            C1773iN adapter = A0z();
            if (adapter != null) {
                strA0W = adapter.A0G();
            } else if (A0m[5].length() != 3) {
                String[] strArr2 = A0m;
                strArr2[2] = "2ETmOz1YodPf8MKRGGB9YcIoy7FDTpAq";
                strArr2[7] = "k5VZ8yDbY0Zqj8FxkeEerY08JJe7M6tR";
                strA0W = A0W(0, 0, Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
            } else {
                String[] strArr3 = A0m;
                strArr3[0] = "JjUCnZOckAfeDcKZajvIf0dyi7sruRRg";
                strArr3[4] = "GlO3j5qd4HFQ8L5mPWBpkp3onxgG8Q98";
                strA0W = A0W(0, 0, Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
            }
            this.A0e.A0C(this.A0c, strA0W);
            this.A0R.A0V();
        }
        if (this.A0G != null && z7) {
            V1 v1A01 = V1.A01(AdErrorType.BROKEN_MEDIA_ERROR, A0W(93, 21, 47));
            A12().A0F().A3F(XG.A01(this.A00), v1A01.A03().getErrorCode(), v1A01.A04());
            this.A0G.ADB(v1A01);
        }
    }

    public final boolean A1g() {
        return this.A07 == null;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1143Ux
    public final int A7V() {
        View view = this.A06;
        if (view instanceof AdNativeComponentView) {
            View videoView = ((AdNativeComponentView) view).getAdContentsView();
            if (videoView instanceof C1490dY) {
                return ((C1490dY) videoView).getCurrentPosition();
            }
            return -1;
        }
        return -1;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final NativeAdBase.NativeAdLoadConfigBuilder buildLoadAdConfig(NativeAdBase nativeAdBase) {
        return new C1141Uv(this, nativeAdBase);
    }

    @Override // com.facebook.ads.Ad
    public final void destroy() {
        VF.A05(A0W(553, 7, 95), A0W(363, 19, 11), A0W(13, 8, 68));
        if (U7.A1u(this.A0c)) {
            A12().A0B().AJj(this.A03);
        }
        if (!A0r()) {
            this.A0c.A0F().A3M();
        }
        if (this.A0A != null) {
            this.A0A.A0Y(true);
            this.A0A.A0K();
            this.A0A = null;
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void downloadMedia() {
        if (this.A0E.equals(EnumC1131Ul.A05)) {
            this.A08 = EnumC0919Mc.A04;
        }
        this.A0E = EnumC1131Ul.A04;
        A0i(this.A0a, false);
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdBodyText() {
        return A0G(true).A0I();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdCallToAction() {
        return A0G(true).A0W();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdChoicesImageUrl() {
        if (getAdChoicesIcon() == null) {
            return null;
        }
        return getAdChoicesIcon().getUrl();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdChoicesLinkUrl() {
        return A0F().A0J();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdChoicesText() {
        return A0F().A0K();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdHeadline() {
        return A0G(true).A0L();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdLinkDescription() {
        return A0G(true).A0M();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdSocialContext() {
        return A0G(true).A0Q();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdTranslation() {
        return A0G(true).A0T();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdUntrimmedBodyText() {
        return A0G(true).A0U();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdvertiserName() {
        return A0G(true).A0V();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final float getAspectRatio() {
        C1135Up nativeAdImage;
        if (this.A0a == null || (nativeAdImage = this.A0a.A0E().A0E()) == null) {
            return 0.0f;
        }
        int width = nativeAdImage.getWidth();
        int height = nativeAdImage.getHeight();
        if (height <= 0) {
            return 0.0f;
        }
        float f4 = width;
        float f8 = height;
        String[] strArr = A0m;
        if (strArr[0].charAt(21) == strArr[4].charAt(21)) {
            throw new RuntimeException();
        }
        A0m[3] = "OUTl4BjdLTzCi4kmpI6eA9pKBM08eKMp";
        return f4 / f8;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getId() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0h;
    }

    @Override // com.facebook.ads.Ad
    public final String getPlacementId() {
        return this.A0g;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final Drawable getPreloadedIconViewDrawable() {
        C1135Up c1135UpA0F;
        Bitmap bitmapA0N;
        C1773iN adapter = this.A0a;
        if (adapter != null && (c1135UpA0F = A0F().A0F()) != null && (bitmapA0N = this.A0b.A0N(c1135UpA0F.getUrl())) != null) {
            return A05(A12(), bitmapA0N, A1g(), A1D());
        }
        return null;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getPromotedTranslation() {
        return A0G(true).A0P();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getSponsoredTranslation() {
        return A0G(true).A0R();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final boolean hasCallToAction() {
        return this.A0a != null && this.A0a.A0Q();
    }

    @Override // com.facebook.ads.Ad
    public final boolean isAdInvalidated() {
        boolean zA0A = true;
        if (this.A0A != null) {
            C05406w c05406w = this.A0A;
            String[] strArr = A0m;
            if (strArr[6].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0m;
            strArr2[2] = "gqyuy6F7WThaJUOfAsIyr4sziGGBhw0f";
            strArr2[7] = "L6lbko7Rv34huPFym8TvMBezY1vQkdWf";
            zA0A = c05406w.A0Z();
        } else if (this.A0B != null) {
            zA0A = this.A0B.A0A();
        }
        this.A0c.A0F().A5X(zA0A);
        return zA0A;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final boolean isAdLoaded() {
        return this.A0a != null && this.A0a.A0R();
    }

    @Override // com.facebook.ads.Ad
    public final void loadAd() {
        VF.A05(A0W(560, 6, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), A0W(382, 24, 27), A0W(5, 8, 76));
        A1Y(EnumC1131Ul.A00(NativeAdBase.MediaCacheFlag.ALL), null, new SL(false, -1, -1));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void loadAd(NativeAdBase.NativeLoadAdConfig nativeLoadAdConfig) {
        VF.A05(A0W(560, 6, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), A0W(382, 24, 27), A0W(21, 8, 17));
        ((C1141Uv) nativeLoadAdConfig).A00();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void onCtaBroadcast() {
        if (this.A05 != null) {
            this.A05.performClick();
        }
    }

    @Override // com.facebook.ads.internal.context.Repairable
    public final void repair(Throwable th) {
        if (this.A04 != null) {
            this.A04.post(new TB(this));
        }
        String str = A0W(164, 16, 48) + X7.A03(this.A0c, th);
        A12().A0F().A3F(XG.A01(this.A00), 2001, str);
        if (this.A0G != null) {
            this.A0G.ADB(new V1(2001, str));
        }
    }

    @Override // com.facebook.ads.Ad
    public final void setExtraHints(ExtraHints extraHints) {
        if (extraHints == null) {
            return;
        }
        A0o(extraHints.getHints());
        this.A0T = extraHints.getMediationData();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.A02 = onTouchListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void unregisterView() {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1020Qc.unregisterView():void");
    }
}

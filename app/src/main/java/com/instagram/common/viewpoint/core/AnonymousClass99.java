package com.instagram.common.viewpoint.core;

import android.net.Uri;
import com.facebook.ads.androidx.media3.extractor.ExtractorsFactory;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.99, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass99 {
    public static byte[] A08;
    public static String[] A09 = {"634gowWrnODsCbHJW3RM2adSB8UjvpNK", "SJrAWOr70TCHX", "EwIuJu9eGNp0k", "E6EVZDT", "sHeITXs", "FXQ6HdUX", "YL7g5rxYaYN1DF5ZV43is2fGGs0zV37S", "j2oNEgxbTlE4krYsb5twTfwtoUHd8Sk9"};
    public InterfaceC0658Ca A02;
    public String A05;
    public final InterfaceC04884w A06;
    public final Object A07;
    public C9U A01 = C9R.A01();
    public InterfaceC0713Ed A03 = new C1959le();
    public int A00 = 1048576;

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "https://github.com/androidx/media/pull/1754")
    public InterfaceC1830jM<InterfaceExecutorC0735Ez> A04 = new InterfaceC1830jM() { // from class: com.facebook.ads.redexgen.X.mH
        @Override // com.instagram.common.viewpoint.core.InterfaceC1830jM
        public final Object get() {
            return AnonymousClass99.A01();
        }
    };

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A09[7].charAt(23) != 't') {
                throw new RuntimeException();
            }
            A09[4] = "2gbF6ls";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 26);
            i10++;
        }
    }

    public static void A03() {
        A08 = new byte[]{20, 35, 35, 62, 35, 113, 56, 63, 34, 37, 48, 63, 37, 56, 48, 37, 56, 63, 54, 113, 21, 52, 55, 48, 36, 61, 37, 20, 41, 37, 35, 48, 50, 37, 62, 35, 34, 23, 48, 50, 37, 62, 35, 40, 106, 102, 100, 39, 111, 104, 106, 108, 107, 102, 102, 98, 39, 104, 109, 122, 39, 104, 103, 109, 123, 102, 96, 109, 113, 39, 100, 108, 109, 96, 104, 58, 39, 108, 113, 125, 123, 104, 106, 125, 102, 123, 39, 77, 108, 111, 104, 124, 101, 125, 76, 113, 125, 123, 104, 106, 125, 102, 123, 122, 79, 104, 106, 125, 102, 123, 112};
    }

    static {
        A03();
    }

    public AnonymousClass99(InterfaceC04884w interfaceC04884w) {
        this.A06 = interfaceC04884w;
    }

    public static /* synthetic */ C2007mR A00(InterfaceC0763Gb interfaceC0763Gb, C05567m c05567m) {
        return new C2007mR(interfaceC0763Gb);
    }

    public static /* synthetic */ InterfaceExecutorC0735Ez A01() {
        return null;
    }

    @MetaExoPlayerCustomization("Custom reflection logic to avoid loading DefaultExtractorsFactory")
    public final AnonymousClass98 A04(Uri uri) {
        String strA02 = A02(0, 44, 75);
        if (this.A02 == null) {
            try {
                Constructor<? extends ExtractorsFactory> constructor = Class.forName(A02(44, 67, 19)).asSubclass(InterfaceC0763Gb.class).getConstructor(new Class[0]);
                final InterfaceC0763Gb interfaceC0763Gb = (InterfaceC0763Gb) constructor.newInstance(new Object[0]);
                this.A02 = new InterfaceC0658Ca() { // from class: com.facebook.ads.redexgen.X.mI
                    @Override // com.instagram.common.viewpoint.core.InterfaceC0658Ca
                    public final InterfaceC0659Cb A5P(C05567m c05567m) {
                        return AnonymousClass99.A00(interfaceC0763Gb, c05567m);
                    }
                };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(strA02, e);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException(strA02, e4);
            } catch (InstantiationException e8) {
                throw new RuntimeException(strA02, e8);
            } catch (NoSuchMethodException e9) {
                throw new RuntimeException(strA02, e9);
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(strA02, e10);
            }
        }
        return new AnonymousClass98(new C2I().A00(uri).A02(this.A05).A01(this.A07).A05(), this.A06, this.A02, this.A01, this.A03, this.A00, null);
    }
}

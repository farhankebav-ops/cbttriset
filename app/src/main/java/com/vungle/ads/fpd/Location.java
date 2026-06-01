package com.vungle.ads.fpd;

import b7.c;
import b7.h;
import d7.g;
import e7.d;
import f7.l0;
import f7.m1;
import f7.q1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class Location {
    public static final Companion Companion = new Companion(null);
    private String country;
    private Integer dma;
    private String regionState;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return Location$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Location() {
    }

    public static final void write$Self(Location self, d output, g serialDesc) {
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.country != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, q1.f11501a, self.country);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.regionState != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, q1.f11501a, self.regionState);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.dma == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, l0.f11478a, self.dma);
    }

    public final Location setCountry(String country) {
        k.e(country, "country");
        this.country = country;
        return this;
    }

    public final Location setDma(int i2) {
        this.dma = Integer.valueOf(i2);
        return this;
    }

    public final Location setRegionState(String regionState) {
        k.e(regionState, "regionState");
        this.regionState = regionState;
        return this;
    }

    public /* synthetic */ Location(int i2, String str, String str2, Integer num, m1 m1Var) {
        if ((i2 & 1) == 0) {
            this.country = null;
        } else {
            this.country = str;
        }
        if ((i2 & 2) == 0) {
            this.regionState = null;
        } else {
            this.regionState = str2;
        }
        if ((i2 & 4) == 0) {
            this.dma = null;
        } else {
            this.dma = num;
        }
    }

    private static /* synthetic */ void getCountry$annotations() {
    }

    private static /* synthetic */ void getDma$annotations() {
    }

    private static /* synthetic */ void getRegionState$annotations() {
    }
}

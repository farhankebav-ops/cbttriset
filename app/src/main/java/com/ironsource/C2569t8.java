package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.t8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2569t8 {

    /* JADX INFO: renamed from: com.ironsource.t8$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum a {
        None,
        Device,
        Controller
    }

    /* JADX INFO: renamed from: com.ironsource.t8$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum b {
        None,
        Loading,
        Loaded,
        Ready,
        Failed
    }

    /* JADX INFO: renamed from: com.ironsource.t8$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum c {
        Web,
        Native,
        None
    }

    /* JADX INFO: renamed from: com.ironsource.t8$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum d {
        MODE_0(0),
        MODE_1(1),
        MODE_2(2),
        MODE_3(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f10295a;

        d(int i2) {
            this.f10295a = i2;
        }

        public int b() {
            return this.f10295a;
        }
    }

    /* JADX INFO: renamed from: com.ironsource.t8$e */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum e {
        Banner,
        Interstitial,
        RewardedVideo,
        NativeAd,
        None
    }
}

package com.unity3d.services.ads.gmascar.managers;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum ScarBiddingManagerType {
    DISABLED("dis"),
    EAGER("eag");

    private final String name;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Constants {
        private static final String DIS = "dis";
        private static final String EAG = "eag";

        private Constants() {
        }
    }

    ScarBiddingManagerType(String str) {
        this.name = str;
    }

    public static ScarBiddingManagerType fromName(String str) {
        int iHashCode = str.hashCode();
        if (iHashCode == 99470) {
            str.equals("dis");
        } else if (iHashCode == 100171 && str.equals("eag")) {
            return EAGER;
        }
        return DISABLED;
    }

    public String getName() {
        return this.name;
    }
}

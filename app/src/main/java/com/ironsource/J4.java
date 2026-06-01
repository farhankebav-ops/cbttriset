package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class J4 implements Le<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6999b;

    public J4(String encryptedResponse, String descriptionKey) {
        kotlin.jvm.internal.k.e(encryptedResponse, "encryptedResponse");
        kotlin.jvm.internal.k.e(descriptionKey, "descriptionKey");
        this.f6998a = encryptedResponse;
        this.f6999b = descriptionKey;
    }

    @Override // com.ironsource.Le
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String a() {
        String strB = L9.b(this.f6999b, this.f6998a);
        if (strB == null || strB.length() == 0) {
            throw new IllegalArgumentException("Decryption failed");
        }
        return strB;
    }
}

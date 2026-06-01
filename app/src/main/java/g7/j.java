package g7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11616d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f11617f;
    public final boolean g;
    public final a h;

    public j(boolean z2, boolean z7, boolean z8, boolean z9, String prettyPrintIndent, String classDiscriminator, boolean z10, a classDiscriminatorMode) {
        kotlin.jvm.internal.k.e(prettyPrintIndent, "prettyPrintIndent");
        kotlin.jvm.internal.k.e(classDiscriminator, "classDiscriminator");
        kotlin.jvm.internal.k.e(classDiscriminatorMode, "classDiscriminatorMode");
        this.f11613a = z2;
        this.f11614b = z7;
        this.f11615c = z8;
        this.f11616d = z9;
        this.e = prettyPrintIndent;
        this.f11617f = classDiscriminator;
        this.g = z10;
        this.h = classDiscriminatorMode;
    }

    public final String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f11613a + ", ignoreUnknownKeys=" + this.f11614b + ", isLenient=false, allowStructuredMapKeys=" + this.f11615c + ", prettyPrint=false, explicitNulls=" + this.f11616d + ", prettyPrintIndent='" + this.e + "', coerceInputValues=false, useArrayPolymorphism=false, classDiscriminator='" + this.f11617f + "', allowSpecialFloatingPointValues=false, useAlternativeNames=" + this.g + ", namingStrategy=null, decodeEnumsCaseInsensitive=false, allowTrailingComma=false, allowComments=false, classDiscriminatorMode=" + this.h + ')';
    }
}

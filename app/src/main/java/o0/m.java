package o0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f13151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13154d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f13155f;
    public final String g;
    public final String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f13156i;
    public final String j;
    public final String k;
    public final String l;

    public m(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f13151a = num;
        this.f13152b = str;
        this.f13153c = str2;
        this.f13154d = str3;
        this.e = str4;
        this.f13155f = str5;
        this.g = str6;
        this.h = str7;
        this.f13156i = str8;
        this.j = str9;
        this.k = str10;
        this.l = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            Integer num = this.f13151a;
            if (num != null ? num.equals(((m) aVar).f13151a) : ((m) aVar).f13151a == null) {
                String str = this.f13152b;
                if (str != null ? str.equals(((m) aVar).f13152b) : ((m) aVar).f13152b == null) {
                    String str2 = this.f13153c;
                    if (str2 != null ? str2.equals(((m) aVar).f13153c) : ((m) aVar).f13153c == null) {
                        String str3 = this.f13154d;
                        if (str3 != null ? str3.equals(((m) aVar).f13154d) : ((m) aVar).f13154d == null) {
                            String str4 = this.e;
                            if (str4 != null ? str4.equals(((m) aVar).e) : ((m) aVar).e == null) {
                                String str5 = this.f13155f;
                                if (str5 != null ? str5.equals(((m) aVar).f13155f) : ((m) aVar).f13155f == null) {
                                    String str6 = this.g;
                                    if (str6 != null ? str6.equals(((m) aVar).g) : ((m) aVar).g == null) {
                                        String str7 = this.h;
                                        if (str7 != null ? str7.equals(((m) aVar).h) : ((m) aVar).h == null) {
                                            String str8 = this.f13156i;
                                            if (str8 != null ? str8.equals(((m) aVar).f13156i) : ((m) aVar).f13156i == null) {
                                                String str9 = this.j;
                                                if (str9 != null ? str9.equals(((m) aVar).j) : ((m) aVar).j == null) {
                                                    String str10 = this.k;
                                                    if (str10 != null ? str10.equals(((m) aVar).k) : ((m) aVar).k == null) {
                                                        String str11 = this.l;
                                                        if (str11 != null ? str11.equals(((m) aVar).l) : ((m) aVar).l == null) {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.f13151a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f13152b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f13153c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f13154d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f13155f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.f13156i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.l;
        return (str11 != null ? str11.hashCode() : 0) ^ iHashCode11;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.f13151a);
        sb.append(", model=");
        sb.append(this.f13152b);
        sb.append(", hardware=");
        sb.append(this.f13153c);
        sb.append(", device=");
        sb.append(this.f13154d);
        sb.append(", product=");
        sb.append(this.e);
        sb.append(", osBuild=");
        sb.append(this.f13155f);
        sb.append(", manufacturer=");
        sb.append(this.g);
        sb.append(", fingerprint=");
        sb.append(this.h);
        sb.append(", locale=");
        sb.append(this.f13156i);
        sb.append(", country=");
        sb.append(this.j);
        sb.append(", mccMnc=");
        sb.append(this.k);
        sb.append(", applicationBuild=");
        return a1.a.r(sb, this.l, "}");
    }
}

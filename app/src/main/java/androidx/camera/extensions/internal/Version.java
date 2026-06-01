package androidx.camera.extensions.internal;

import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Version implements Comparable<Version> {
    public static final Version VERSION_1_0 = create(1, 0, 0, "");
    public static final Version VERSION_1_1 = create(1, 1, 0, "");
    public static final Version VERSION_1_2 = create(1, 2, 0, "");
    public static final Version VERSION_1_3 = create(1, 3, 0, "");
    public static final Version VERSION_1_4 = create(1, 4, 0, "");
    public static final Version VERSION_1_5 = create(1, 5, 0, "");
    private static final Pattern VERSION_STRING_PATTERN = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:\\-(.+))?");

    public static Version create(int i2, int i8, int i9, String str) {
        return new AutoValue_Version(i2, i8, i9, str);
    }

    private static BigInteger createBigInteger(Version version) {
        return BigInteger.valueOf(version.getMajor()).shiftLeft(32).or(BigInteger.valueOf(version.getMinor())).shiftLeft(32).or(BigInteger.valueOf(version.getPatch()));
    }

    public static Version parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = VERSION_STRING_PATTERN.matcher(str);
        if (matcher.matches()) {
            return create(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), matcher.group(4) != null ? matcher.group(4) : "");
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        return Integer.valueOf(getMajor()).equals(Integer.valueOf(version.getMajor())) && Integer.valueOf(getMinor()).equals(Integer.valueOf(version.getMinor())) && Integer.valueOf(getPatch()).equals(Integer.valueOf(version.getPatch()));
    }

    public abstract String getDescription();

    public abstract int getMajor();

    public abstract int getMinor();

    public abstract int getPatch();

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(getMajor()), Integer.valueOf(getMinor()), Integer.valueOf(getPatch()));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(getMajor() + "." + getMinor() + "." + getPatch());
        if (!TextUtils.isEmpty(getDescription())) {
            sb.append("-" + getDescription());
        }
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(Version version) {
        return createBigInteger(this).compareTo(createBigInteger(version));
    }

    public int compareTo(int i2) {
        return compareTo(i2, 0);
    }

    public int compareTo(int i2, int i8) {
        if (getMajor() == i2) {
            return Integer.compare(getMinor(), i8);
        }
        return Integer.compare(getMajor(), i2);
    }
}

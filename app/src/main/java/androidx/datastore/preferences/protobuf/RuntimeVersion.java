package androidx.datastore.preferences.protobuf;

import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class RuntimeVersion {
    public static final RuntimeDomain DOMAIN;
    public static final int MAJOR = 4;
    public static final int MINOR = 28;
    public static final RuntimeDomain OSS_DOMAIN;
    public static final int OSS_MAJOR = 4;
    public static final int OSS_MINOR = 28;
    public static final int OSS_PATCH = 2;
    public static final String OSS_SUFFIX = "";
    public static final int PATCH = 2;
    public static final String SUFFIX = "";
    private static final String VERSION_STRING;
    private static final Logger logger;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ProtobufRuntimeVersionException extends RuntimeException {
        public ProtobufRuntimeVersionException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum RuntimeDomain {
        GOOGLE_INTERNAL,
        PUBLIC
    }

    static {
        RuntimeDomain runtimeDomain = RuntimeDomain.PUBLIC;
        OSS_DOMAIN = runtimeDomain;
        DOMAIN = runtimeDomain;
        VERSION_STRING = versionString(4, 28, 2, "");
        logger = Logger.getLogger(RuntimeVersion.class.getName());
    }

    private RuntimeVersion() {
    }

    private static boolean checkDisabled() {
        String str = System.getenv("TEMORARILY_DISABLE_PROTOBUF_VERSION_CHECK");
        return str != null && str.equals(com.ironsource.mediationsdk.metadata.a.g);
    }

    public static void validateProtobufGencodeVersion(RuntimeDomain runtimeDomain, int i2, int i8, int i9, String str, String str2) {
        if (checkDisabled()) {
            return;
        }
        validateProtobufGencodeVersionImpl(runtimeDomain, i2, i8, i9, str, str2);
    }

    private static void validateProtobufGencodeVersionImpl(RuntimeDomain runtimeDomain, int i2, int i8, int i9, String str, String str2) {
        if (checkDisabled()) {
            return;
        }
        String strVersionString = versionString(i2, i8, i9, str);
        if (i2 < 0 || i8 < 0 || i9 < 0) {
            throw new ProtobufRuntimeVersionException(a1.a.l("Invalid gencode version: ", strVersionString));
        }
        RuntimeDomain runtimeDomain2 = DOMAIN;
        if (runtimeDomain != runtimeDomain2) {
            throw new ProtobufRuntimeVersionException("Detected mismatched Protobuf Gencode/Runtime domains when loading " + str2 + ": gencode " + runtimeDomain + ", runtime " + runtimeDomain2 + ". Cross-domain usage of Protobuf is not supported.");
        }
        if (i2 != 4) {
            if (i2 != 3) {
                throw new ProtobufRuntimeVersionException(a1.a.r(a1.a.z("Detected mismatched Protobuf Gencode/Runtime major versions when loading ", str2, ": gencode ", strVersionString, ", runtime "), VERSION_STRING, ". Same major version is required."));
            }
            Logger logger2 = logger;
            StringBuilder sbZ = a1.a.z(" Protobuf gencode version ", strVersionString, " is exactly one major version older than the runtime version ", VERSION_STRING, " at ");
            sbZ.append(str2);
            sbZ.append(". Please update the gencode to avoid compatibility violations in the next runtime release.");
            logger2.warning(sbZ.toString());
        }
        if (28 < i8 || (i8 == 28 && 2 < i9)) {
            throw new ProtobufRuntimeVersionException(a1.a.r(a1.a.z("Detected incompatible Protobuf Gencode/Runtime versions when loading ", str2, ": gencode ", strVersionString, ", runtime "), VERSION_STRING, ". Runtime version cannot be older than the linked gencode version."));
        }
        if (28 > i8 || 2 > i9) {
            Logger logger3 = logger;
            StringBuilder sbZ2 = a1.a.z(" Protobuf gencode version ", strVersionString, " is older than the runtime version ", VERSION_STRING, " at ");
            sbZ2.append(str2);
            sbZ2.append(". Please avoid checked-in Protobuf gencode that can be obsolete.");
            logger3.warning(sbZ2.toString());
        }
        if (str.equals("")) {
            return;
        }
        throw new ProtobufRuntimeVersionException(a1.a.r(a1.a.z("Detected mismatched Protobuf Gencode/Runtime version suffixes when loading ", str2, ": gencode ", strVersionString, ", runtime "), VERSION_STRING, ". Version suffixes must be the same."));
    }

    private static String versionString(int i2, int i8, int i9, String str) {
        return String.format("%d.%d.%d%s", Integer.valueOf(i2), Integer.valueOf(i8), Integer.valueOf(i9), str);
    }
}

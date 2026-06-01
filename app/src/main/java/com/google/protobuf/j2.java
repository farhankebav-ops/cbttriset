package com.google.protobuf;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class j2 {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements k2 {
        final /* synthetic */ ByteString val$input;

        public a(ByteString byteString) {
            this.val$input = byteString;
        }

        @Override // com.google.protobuf.k2
        public byte byteAt(int i2) {
            return this.val$input.byteAt(i2);
        }

        @Override // com.google.protobuf.k2
        public int size() {
            return this.val$input.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements k2 {
        final /* synthetic */ byte[] val$input;

        public b(byte[] bArr) {
            this.val$input = bArr;
        }

        @Override // com.google.protobuf.k2
        public byte byteAt(int i2) {
            return this.val$input[i2];
        }

        @Override // com.google.protobuf.k2
        public int size() {
            return this.val$input.length;
        }
    }

    private j2() {
    }

    public static String escapeBytes(k2 k2Var) {
        StringBuilder sb = new StringBuilder(k2Var.size());
        for (int i2 = 0; i2 < k2Var.size(); i2++) {
            byte bByteAt = k2Var.byteAt(i2);
            if (bByteAt == 34) {
                sb.append("\\\"");
            } else if (bByteAt == 39) {
                sb.append("\\'");
            } else if (bByteAt != 92) {
                switch (bByteAt) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bByteAt < 32 || bByteAt > 126) {
                            sb.append('\\');
                            sb.append((char) (((bByteAt >>> 6) & 3) + 48));
                            sb.append((char) (((bByteAt >>> 3) & 7) + 48));
                            sb.append((char) ((bByteAt & 7) + 48));
                        } else {
                            sb.append((char) bByteAt);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static String escapeDoubleQuotesAndBackslashes(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    public static String escapeText(String str) {
        return escapeBytes(ByteString.copyFromUtf8(str));
    }

    public static String escapeBytes(ByteString byteString) {
        return escapeBytes(new a(byteString));
    }

    public static String escapeBytes(byte[] bArr) {
        return escapeBytes(new b(bArr));
    }
}

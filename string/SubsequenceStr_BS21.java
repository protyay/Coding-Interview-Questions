public class SubsequenceStr_BS21 {
    // SDE problem
    public boolean solve(String s1, String s2) {
        if (s1.isEmpty())
            return true;
        if (s2.isEmpty())
            return s1.isEmpty();

        char[] strA = s1.toCharArray();
        char[] strB = s2.toCharArray();
        int subSeqIdx = 0;
        for (int i = 0; i < strB.length; i++) {
            if (subSeqIdx == strA.length)
                break;
            if (strA[subSeqIdx] == strB[i]) {
                ++subSeqIdx;
            }
        }
        return subSeqIdx == strA.length;
    }
}
